package entity;
/**
 * ͼƬʵ�壨ҽԺ��
 */
import java.io.Serializable;
import java.util.Date;

public class Images implements Serializable {
	
	//id
	private Integer id;
	//ͼƬ��
	private String name;
	//���·��
	private String path;
	//��λ��Ϣ
	private String part;
	//ͼƬ����
	private String descr;
	//���
	private String result;
	//˵��
	private String inst;
	//�ϴ��û���
	private String user;
	//�ϴ�ʱ��
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
