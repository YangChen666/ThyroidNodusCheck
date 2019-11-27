package mysql;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
/**
 * ��װ�����������ݿ������        ����ϵͳ�õ������
 * ���ӳذ�����ݿ����� ���ӹ�������
 * ����ǲ�����
 * 
 * @author hcx
 *
 */
public class mysqlTool {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	private static int initialSize;
	private static int maxActive;
	private static BasicDataSource ds;
	//���ӳ�ֻ��Ҫһ�����ɣ�������getConnection()��������д
	//��̬������Ҫ��̬������ʼ��
	static{
		//�������ӳ�
		ds=new BasicDataSource();
		//���ļ����ò���
		Properties pp=new Properties();
		try{
			InputStream is=mysqlTool.class.getClassLoader().getResourceAsStream("db.properties");
			pp.load(is);
			driver=pp.getProperty("jdbc.driver");
			url=pp.getProperty("jdbc.url");
			username=pp.getProperty("jdbc.username");
			password=pp.getProperty("jdbc.password");
			initialSize=Integer.parseInt(pp.getProperty("initialSize"));
			maxActive=Integer.parseInt(pp.getProperty("maxActive"));
			is.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		//��ʼ�����ӳ�
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setInitialSize(initialSize);
		ds.setMaxActive(maxActive);
	}
	/**
	 * ���������л�ȡ���ӳ��е�����
	 */
	public static Connection getConnection(){
		try{
			Connection con=ds.getConnection();
			return con;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	/**
	 * �ر����ӣ������ӻ������ӳ�
	 * @param con
	 */
	public static void close(Connection con){
		if(con!=null){
			try {
				//�黹�����ӳ�
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
