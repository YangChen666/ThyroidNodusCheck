package mysql;
/**
 * ������ǲ������ݵ�
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;


public class insert_Date {
	public static void main(String[] args) {
		Connection con =null;
		/*try { //����ǲ����û���
			//��������con
			con=mysql.getConnection();
			String sql="insert into users(name,password,sex,account,head,mobile,email,birt,set_time)values(?,?,?,?,?,?,?,?,?)";
			//����SQL��䵽���ݿ⣬����ִ�мƻ�������ִ�мƻ�ps
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			//����
			ps.setString(1,"wang");
			ps.setString(2,"wang");
			ps.setString(3, "��");
			ps.setString(4, "");
			ps.setString(5, "");
			ps.setString(6, "18000000000");
			ps.setString(7, "lisan@lisan.com");
			ps.setString(8, "1965-10-03");
			ps.setDate(9, new Date(1000000000009l));
			//ִ�����
			ps.executeUpdate();
			System.out.println("���");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			mysql.close(con);
		}*/
		
		try { //����ǲ���ͼƬ��
			//��������con
			con=mysql.getConnection();
			String sql="insert into images(name,path,part,descr,result,inst,user,set_time)values(?,?,?,?,?,?,?,?)";
			//����SQL��䵽���ݿ⣬����ִ�мƻ�������ִ�мƻ�ps
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			//����
			ps.setString(1,"16.jpg");
			ps.setString(2,"Thyroid_images");
			ps.setString(3, "��״��");
			ps.setString(4, "��״����");
			ps.setString(5, "����״�ٽ��");
			ps.setString(6, "�����ϴ�");
			ps.setString(7, "wang");
			ps.setDate(8, new Date(10000000000l));
			//ִ�����
			ps.executeUpdate();
			System.out.println("���");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			mysql.close(con);
		}
	}
}
