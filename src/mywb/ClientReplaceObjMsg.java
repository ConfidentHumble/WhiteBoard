package mywb;
import java.io.Serializable;
/**
 * 
 * To do: 客户端移动图形消息
 * Describe: 客户端通过鼠标选中需要移动的图形对象，然后拖动鼠标移动图形
 * 当图形对象被定位后，客户端向服务器发送ClientReplaceObjMsg消息
 * 服务端收到ClientReplaceObjMsg消息后，会广播给所有客户
 * @Name NetTesk
 * @author ZhouYi
 * @date 2019年5月13日 下午5:09:41
 */

public class ClientReplaceObjMsg implements IMessage{
	// 移动之前，对象的位置信息
	Object id;
	// 移动之后，对象的位置信息
	Object object;
	public ClientReplaceObjMsg(Object object, Object id) {
		this.object = object;
		this.id = id;
	}
	public Object getId() {
		return id;
	}
	public Object getElement() {
		return object;
	}
}
