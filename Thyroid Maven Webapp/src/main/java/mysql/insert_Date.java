package mysql;
/**
 * 这个类是插入数据的
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;


public class insert_Date {
	public static void main(String[] args) {
		Connection con =null;
		/*try { //这个是插入用户的
			//创建连接con
			con=mysql.getConnection();
			String sql="insert into users(name,password,sex,account,head,mobile,email,birt,set_time)values(?,?,?,?,?,?,?,?,?)";
			//发送SQL语句到数据库，创建执行计划，返回执行计划ps
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			//传参
			ps.setString(1,"wang");
			ps.setString(2,"wang");
			ps.setString(3, "男");
			ps.setString(4, "");
			ps.setString(5, "");
			ps.setString(6, "18000000000");
			ps.setString(7, "lisan@lisan.com");
			ps.setString(8, "1965-10-03");
			ps.setDate(9, new Date(1000000000009l));
			//执行语句
			ps.executeUpdate();
			System.out.println("完成");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			mysql.close(con);
		}*/
		
		try { //这个是插入图片的
			//创建连接con
			con=mysql.getConnection();
			String sql="insert into images(name,path,part,descr,result,inst,user,set_time)values(?,?,?,?,?,?,?,?)";
			//发送SQL语句到数据库，创建执行计划，返回执行计划ps
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			//传参
			ps.setString(1,"16.jpg");
			ps.setString(2,"Thyroid_images");
			ps.setString(3, "甲状腺");
			ps.setString(4, "形状规则");
			ps.setString(5, "良甲状腺结节");
			ps.setString(6, "患者上传");
			ps.setString(7, "wang");
			ps.setDate(8, new Date(10000000000l));
			//执行语句
			ps.executeUpdate();
			System.out.println("完成");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			mysql.close(con);
		}
	}
}
