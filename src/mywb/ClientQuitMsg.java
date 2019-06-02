package mywb;
/**
 * 
 * To do: 当用户关闭窗口后，客户端向服务器发送ClientQuitMsg消息
 * 服务器接收到ClientQuitMsg消息后，先将客户端对应的socket链接关闭，
 * 然后从socket池中删除对应的socket链接
 * @Name NetTesk
 * @author ZhouYi
 * @date 2019年5月20日 下午4:00:33
 */

public class ClientQuitMsg implements IMessage{
	// 记录退出用户的姓名
	private String name;
	// 获取姓名
	public String getName() {
		return name;
	}
	// 设置姓名
	public void setName(String name) {
		this.name = name;
	}
}
