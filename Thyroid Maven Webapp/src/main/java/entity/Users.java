package entity;
/**
 * 用户实体
 */
import java.io.Serializable;
import java.util.Date;

public class Users implements Serializable {
	
		//id
		private Integer id;
		//用户名
		private String name;
		//密码
		private String password;
		//性别
		private String sex;
		//账号
		private String account;
		//头像
		private String head;
		//电话
		private String mobile;
		//邮箱
		private String email;
		//生日
		private String birt;
		//注册时间
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
