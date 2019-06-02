package mywb;
import java.io.*;
import java.net.*;
import java.util.*;

public class WhiteBoardServer extends Thread{
	// 服务器端监听端口号
	public static int port = 1234;
	// 服务器保存的所有白板图形对象
	static PaintedObjects paintedObjects = new PaintedObjects();
	// 服务器保存的随机曲线对象
	static Vector rlineVector = new Vector();
	// 服务器保存的客户端输出流
	static Vector streamVector = new Vector();
	Socket socket;
	// 接受来自客户端的连接
	public WhiteBoardServer(Socket socket) {
		System.out.println("Accepted from " + socket.getInetAddress() + ".");
		this.socket = socket;
	}
	public void run() {
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(
					new BufferedOutputStream(socket.getOutputStream()));
			outputStream.flush();
			ObjectInputStream inputStream = new ObjectInputStream(
					new BufferedInputStream(socket.getInputStream()));
			handle(inputStream, outputStream);	
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			System.out.println("从 " + socket.getInetAddress() + " 断开");
			try {
				socket.close();
			}catch(IOException ignored) {
			}
		}
	}
	// 处理客户端登录消息
	void handle(ObjectInputStream inputStream, ObjectOutputStream outputStream)throws
	IOException, ClassNotFoundException{
		try {
			synchronized (streamVector) {
				// 建立客户端通信流
				streamVector.addElement(outputStream);
				outputStream.writeObject(new LoginManage((PaintedObjects)paintedObjects.clone(), 
														 (Vector)rlineVector.clone(), 
														 streamVector.indexOf(outputStream)));
				System.out.println("发送LoginMessage消息");
				outputStream.flush();
			}
			handleMessage(inputStream);
		}finally {
			streamVector.removeElement(outputStream);
		}
	}
	// 处理各种消息
	void handleMessage(ObjectInputStream inputStream)throws IOException,
	ClassNotFoundException{
		while(true) {
			Object message = inputStream.readObject();
			if(message instanceof IMessage) {
				// 处理所有对基本图形进行操作的消息
				message = (IMessage)message;
				if(message instanceof ClientAddObjMsg) {
					// 如果接收到客户端添加基本图形消息
					Object obj = ((ClientAddObjMsg)message).getObj();
					synchronized (streamVector) {
						// 将添加对象加入到白板已有对象的类中
						Object id = paintedObjects.add(obj);
						// 通知所有客户添加图形对象
						notifyAll(new ServerAddObjMessage(id, obj));
					}
				}else if(message instanceof ClientReplaceObjMsg) {
					Object oldId = ((ClientReplaceObjMsg)message).getId();
					if(oldId != null) {
						
					}
				}
			}
		}
	}
}
