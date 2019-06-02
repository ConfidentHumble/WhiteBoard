package mywb;
/**
 * 
 * To do: 客户端添加基本图形消息
 * Describe: 客户端用户选择了添加图形种类和边框颜色，以及填充颜色后，添加基本图形的消息被封装在ClientAddObjMsg信息中，
 * 发送给服务端
 * @Name NetTesk
 * @author ZhouYi
 * @date 2019年5月13日 下午4:49:04
 */

public class ClientAddObjMsg implements IMessage{
	// obj对象是客户端所添加的基本图形对象
	// 该对象封装了图形的位置、大小、颜色及填充状态
	Object obj;
	public ClientAddObjMsg(Object obj) {
		this.obj = obj;
	}
	public Object getObj() {
		return obj;
	}
}
