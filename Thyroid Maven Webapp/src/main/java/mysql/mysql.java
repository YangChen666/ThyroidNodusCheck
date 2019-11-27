package mysql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * ��װ�������ݿ����ӵĹ��̣������û�в����ġ�   ����ϵͳ�õ��ǲ����ģ�
 * @author hcx
 *
 */
public class mysql {
	//���⼸������д���ļ���
//	static String url="jdbc:mysql://localhost:3306/java_jdbc_mysql";
//	static String root="root";
//	static String password="z1053244894";
	static String url=null;
	static String root=null;
	static String password=null;
	static String driver=null;
	
	static {
		try {
		//��ʼ����̬����
		//����Properties��ȡ�����ļ����������ļ��в�����Ӧ�Ĳ���
		Properties pp=new Properties();
		InputStream in =mysql.class.getClassLoader().getResourceAsStream("db.properties");
			pp.load(in);
			driver=pp.getProperty("jdbc.driver");
			url=pp.getProperty("jdbc.url");
			root=pp.getProperty("jdbc.username");
			password=pp.getProperty("jdbc.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��װ�������ݿ����ӵĹ���
	 * �����ݿ�����
	 */
	public static Connection getConnection(){
		try{
			//��������
			Class.forName(driver);
			//�������ݿ�
			Connection con=DriverManager.getConnection(url,root,password);
			//�����������ݿ�Ķ���
			return con;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);//throw Ҳ��һ�����أ�ֻ�����Ǹ�����
		}
	}
	/**
	 * �ر����ݿ������,��װ���ӵĹرչ���
	 * @param con
	 */
	public static void close(Connection con){
		if(con!=null){
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
