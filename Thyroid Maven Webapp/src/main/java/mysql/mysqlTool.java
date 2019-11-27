package mysql;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
/**
 * 封装并发访问数据库的连接        （本系统用的这个）
 * 连接池版的数据库连接 连接管理工具类
 * 这个是并发的
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
	//连接池只需要一个即可，所以在getConnection()方法外面写
	//静态变量需要静态块来初始化
	static{
		//创建连接池
		ds=new BasicDataSource();
		//读文件配置参数
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
		//初始化连接池
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setInitialSize(initialSize);
		ds.setMaxActive(maxActive);
	}
	/**
	 * 在其他类中获取连接池中的连接
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
	 * 关闭连接，把连接还给连接池
	 * @param con
	 */
	public static void close(Connection con){
		if(con!=null){
			try {
				//归还给连接池
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
