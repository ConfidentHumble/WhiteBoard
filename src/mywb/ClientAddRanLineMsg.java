package mywb;
/**
 * 
 * To do: 客户端添加随机曲线消息
 * Describe: 客户端记录用户鼠标移动轨迹上的点的集合，这些点组成点对，这些信息被封装在ClientAddRanLineMsg信息中，
 * 发送给服务端
 * @Name NetTesk
 * @author ZhouYi
 * @date 2019年5月13日 下午4:48:13
 */

public class ClientAddRanLineMsg implements Serializable{
	// element对象保存了随机曲线的相关信息，包括一系列点对坐标
	RanLineObj element;
	public ClientAddRanLineMsg(RanLineObj line) {
		this.element = line;
	}
	// 返回曲线信息
	public RanLineObj getLine() {
		return element;
	}
}
