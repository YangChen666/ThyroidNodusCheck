package entity;
/**
 * �û�ʵ��
 */
import java.io.Serializable;
import java.util.Date;

public class Users implements Serializable {
	
		//id
		private Integer id;
		//�û���
		private String name;
		//����
		private String password;
		//�Ա�
		private String sex;
		//�˺�
		private String account;
		//ͷ��
		private String head;
		//�绰
		private String mobile;
		//����
		private String email;
		//����
		private String birt;
		//ע��ʱ��
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
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getAccount() {
			return account;
		}
		public void setAccount(String account) {
			this.account = account;
		}
		public String getHead() {
			return head;
		}
		public void setHead(String head) {
			this.head = head;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getBirt() {
			return birt;
		}
		public void setBirt(String birt) {
			this.birt = birt;
		}
		public String getSet_time() {
			return set_time;
		}
		public void setSet_time(String set_time) {
			this.set_time = set_time;
		}
}
