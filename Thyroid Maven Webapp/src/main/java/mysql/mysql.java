package mysql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * 封装创建数据库连接的过程，这个是没有并发的。   （本系统用的是并发的）
 * @author hcx
 *
 */
public class mysql {
	//把这几个参数写到文件里
//	static String url="jdbc:mysql://localhost:3306/java_jdbc_mysql";
//	static String root="root";
//	static String password="z1053244894";
	static String url=null;
	static String root=null;
	static String password=null;
	static String driver=null;
	
	static {
		try {
		//初始化静态属性
		//利用Properties读取配置文件，从配置文件中查找相应的参数
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
	 * 封装创建数据库连接的过程
	 * 简化数据库连接
	 */
	public static Connection getConnection(){
		try{
			//加载驱动
			Class.forName(driver);
			//连接数据库
			Connection con=DriverManager.getConnection(url,root,password);
			//返回链接数据库的对象
			return con;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);//throw 也是一个返回，只不过是个错误
		}
	}
	/**
	 * 关闭数据库的连接,封装复杂的关闭过程
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
