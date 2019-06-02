package mywb;
import java.util.*;
/**
 * 
 * To do: 用户登录消息函数
 * Describe: 用户登录成功后，会建立与服务器的socket连接，并通过该socket向服务器发送LoginManage消息。
 * 服务器收到LoginManage消息后，会将服务器保存的白板内容信息封装到LoginManage中，发送回客户端，
 * 客户端的监听进程收到服务器端发送的LoginManage后，解析出白板内容信息，并将信息显示在本地白板上
 * @Name NetTesk
 * @author ZhouYi
 * @date 2019年5月13日 下午4:52:24
 */

public class LoginManage implements IMessage{
	// 存放网络白板的基本图形对象
	PaintedObjects paintedOjbs;
	int id;
	// 存放网络白板随机曲线对象
	// 其中曲线有很多条线段组成 每条线段可以分解为起点和终点点对信息
	// 因此randLineVector容器中存放都是点对坐标信息
	Vector randLineVector;
	public LoginManage(PaintedObjects list, Vector randLines, int id) {
		this.paintedOjbs = list;
		this.randLineVector = randLines;
		this.id = id;
	}
	// 获得白板基本图形对象
	public PaintedObjects getList() {
		return paintedOjbs;
	}
	public Vector getRlines() {
		return randLineVector;
	}
	public int getId() {
		return id;
	}
}
