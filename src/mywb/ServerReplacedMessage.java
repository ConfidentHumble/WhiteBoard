package mywb;
/**
 * 
 * To do:接收客户端发来的ClientReplaceObjMsg消息，并封装到ServerReplacedMessage
 * 消息中，然后广播到所有客户端
 * @Name NetTesk
 * @author ZhouYi
 * @date 2019年5月20日 下午4:18:52
 */

public class ServerReplacedMessage implements IMessage{
	// 移动之前的图形对象
	Object oldId;
	Object id;
	// 移动之后的图形对象
	Object object;
	public ServerReplacedMessage(Object oldId, Object id, Object element) {
		this.oldId = oldId;
		this.id = id;
		this.object = element;
	}
	public Object getOldID() {
		return oldId;
	}
	public Object getID() {
		return id;
	}
	public Object getObject() {
		return object;
	}
}
