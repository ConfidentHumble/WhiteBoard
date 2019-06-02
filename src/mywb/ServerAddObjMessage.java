package mywb;
/**
 * 
 * To do: 接收到客户端发送的ClientAddObjMsg消息后，服务器端从ClientAddObjMsg中解析出
 * 新加的图形对象，将该对象封装到ServerAddObjMessage消息中，再将ServerAddObjMessage
 * 消息广播到所有用户
 * @Name NetTesk
 * @author ZhouYi
 * @date 2019年5月20日 下午4:09:11
 */

public class ServerAddObjMessage implements IMessage{
	Object id;
	Object object;
	public ServerAddObjMessage(Object id, Object element) {
		this.id = id;
		this.object = element;
	}
	public Object getID() {
		return id;
	}
	public Object getElement() {
		return object;
	}
}
