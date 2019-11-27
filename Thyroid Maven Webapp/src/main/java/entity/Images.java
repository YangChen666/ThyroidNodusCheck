package entity;
/**
 * 图片实体（医院）
 */
import java.io.Serializable;
import java.util.Date;

public class Images implements Serializable {
	
	//id
	private Integer id;
	//图片名
	private String name;
	//存放路径
	private String path;
	//部位信息
	private String part;
	//图片描述
	private String descr;
	//结果
	private String result;
	//说明
	private String inst;
	//上传用户名
	private String user;
	//上传时间
	private String set_time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getInst() {
		return inst;
	}
	public void setInst(String inst) {
		this.inst = inst;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSet_time() {
		return set_time;
	}
	public void setSet_time(String time) {
		this.set_time = set_time;
	}
}
