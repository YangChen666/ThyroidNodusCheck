package Dao;
/**
 * Image 的业务了逻辑类
 */
/*
 * 因为该表是医院里的库里的，所以不能添加删除，只能查询，因此，该类只写查询即可
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Images;
import entity.Img;
import mysql.mysqlTool;



public class ImagesDeal {
	
	
	//查询用户为患者的数据     radio=="a"
		public List<Images> findAll_users(String name){
			Connection con=null;
			try {
				con=mysqlTool.getConnection();
				String sql="select * from images where user=?";
				PreparedStatement stm=con.prepareStatement(sql);
				stm.setString(1,name);//设置问好处的值
				ResultSet rs=stm.executeQuery();
				List<Images> list=new ArrayList<Images>();
				while(rs.next()){
					Images image=new Images();
					image.setId(rs.getInt("id"));
					image.setName(rs.getString("name"));
					image.setPath(rs.getString("path"));
					image.setPart(rs.getString("part"));
					image.setDescr(rs.getString("descr"));
					image.setResult(rs.getString("result"));
					image.setInst(rs.getString("inst"));
					image.setUser(rs.getString("user"));
					image.setSet_time(rs.getString("set_time"));
					list.add(image);
					//System.out.println(image.getSet_time());
				}
				return list;
			} catch (Exception e) {
				//一般捕获到异常之后的操作
				//1.记录日志
				e.printStackTrace();
				//抛出异常
				throw new RuntimeException("查询失败",e);
			}finally{
				mysqlTool.close(con);
			}
		}
	
	
	//查询用户为患者的数据     radio=="b"
		public List<Images> findAll_admins(){
			Connection con=null;
			try {
				con=mysqlTool.getConnection();
				String sql="select * from images;";
				Statement smt=con.createStatement();
				ResultSet rs=smt.executeQuery(sql);
				List<Images> list=new ArrayList<Images>();
				while(rs.next()){
					Images image=new Images();
					image.setId(rs.getInt("id"));
					image.setName(rs.getString("name"));
					image.setPath(rs.getString("path"));
					image.setPart(rs.getString("part"));
					image.setDescr(rs.getString("descr"));
					image.setResult(rs.getString("result"));
					image.setInst(rs.getString("inst"));
					image.setUser(rs.getString("user"));
					image.setSet_time(rs.getString("set_time"));
					list.add(image);	
				}
				return list;
			} catch (Exception e) {
				//一般捕获到异常之后的操作
				//1.记录日志
				e.printStackTrace();
				//抛出异常
				throw new RuntimeException("查询失败",e);
			}finally{
				mysqlTool.close(con);
			}
		}
		
		
		
		//根据图像ID 查找一条数据
				public Images findOne_Id(int id){
					Connection con=null;
					try {
						con=mysqlTool.getConnection();
						String sql="select * from images where id=?";
						PreparedStatement stm=con.prepareStatement(sql);
						stm.setInt(1, id);//设置问好处的值
						ResultSet rs=stm.executeQuery();
						Images image=new Images();
						while(rs.next()){
							image.setId(rs.getInt("id"));
							image.setName(rs.getString("name"));
							image.setPath(rs.getString("path"));
							image.setPart(rs.getString("part"));
							image.setDescr(rs.getString("descr"));
							image.setResult(rs.getString("result"));
							image.setInst(rs.getString("inst"));
							image.setUser(rs.getString("user"));
							image.setSet_time(rs.getString("set_time"));
							//System.out.println("修改chen");
						}
						return image;
					} catch (Exception e) {
						//一般捕获到异常之后的操作
						//1.记录日志
						e.printStackTrace();
						//抛出异常
						throw new RuntimeException("查询失败",e);
					}finally{
						mysqlTool.close(con);
					}
				}
				
				
				
				//根据图像名称  查找一条数据
				public Images findOne_Name(String name){
					Connection con=null;
					try {
						con=mysqlTool.getConnection();
						String sql="select * from images where name=?";
						PreparedStatement stm=con.prepareStatement(sql);
						stm.setString(1, name);//设置问好处的值
						ResultSet rs=stm.executeQuery();
						Images image=new Images();
						while(rs.next()){
							image.setId(rs.getInt("id"));
							image.setName(rs.getString("name"));
							image.setPath(rs.getString("path"));
							image.setPart(rs.getString("part"));
							image.setDescr(rs.getString("descr"));
							image.setResult(rs.getString("result"));
							image.setInst(rs.getString("inst"));
							image.setUser(rs.getString("user"));
							image.setSet_time(rs.getString("set_time"));
							System.out.println("修改chen");
						}
						System.out.println(image.getName());
						return image;
					} catch (Exception e) {
						//一般捕获到异常之后的操作
						//1.记录日志
						e.printStackTrace();
						//抛出异常
						throw new RuntimeException("查询失败",e);
					}finally{
						mysqlTool.close(con);
					}
				}
				
				
				
				//插入一条数据
				public void insert_image(Images image){
					//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//Date格式转为字符串
					Connection con =null;
					try { //这个是插入图片的
						//创建连接con
						con=mysqlTool.getConnection();
						String sql="insert into images(name,path,part,descr,result,inst,user,set_time)values(?,?,?,?,?,?,?,?)";
						//发送SQL语句到数据库，创建执行计划，返回执行计划ps
						PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
						//传参
						ps.setString(1,image.getName());
						ps.setString(2,image.getPath());
						ps.setString(3,image.getPart());
						ps.setString(4,image.getDescr());
						ps.setString(5,image.getResult());
						ps.setString(6,image.getInst());
						ps.setString(7,image.getUser());
						ps.setString(8,image.getSet_time());
						//执行语句
						ps.executeUpdate();
						System.out.println("完成");
					} catch (Exception e) {
						System.out.println(e);
					}finally{
						mysqlTool.close(con);
					}
				}
				
				
				
				//更改一条数据
				public void update_image(Images image){
					Connection con =null;
					try { 
						//创建连接con
						con=mysqlTool.getConnection();
						String sql="update images set name=?,part=?,descr=?,result=?,inst=? where id=?";
						//发送SQL语句到数据库，创建执行计划，返回执行计划ps
						PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
						//传参
						ps.setString(1,image.getName());
						ps.setString(2,image.getPart());
						ps.setString(3,image.getDescr());
						ps.setString(4,image.getResult());
						ps.setString(5,image.getInst());
						ps.setInt(6, image.getId());
						//执行语句
						ps.executeUpdate();//executeUpdate()
						System.out.println("修改数据成功");
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						mysqlTool.close(con);
					}
				}
				
				
				//删除一条数据    id
				public void delete_image(int id){
					Connection con =null;
					try { 
						//创建连接con
						con=mysqlTool.getConnection();
						String sql="delete from images where id=?";
						//发送SQL语句到数据库，创建执行计划，返回执行计划ps
						PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
						//传参
						ps.setInt(1, id);
						//执行语句
						ps.executeUpdate();//executeUpdate()
						System.out.println("修改数据成功");
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						mysqlTool.close(con);
					}
				}
	
	
	
	
	
	
	
	/*////
	 * public List<Images> findAll() {  //该查询分两组：1.患者只查自己的；2.管理员可以查所有的。
		//获取数据库连接
		Connection con=null;
		try {
			con=mysqlTool.getConnection();
			//获取session
			HttpSession session=req.getSession();
			//分支
			
			if(session.getAttribute("radio").toString()=="a"){
				String sql="select * from images where name=?";
				PreparedStatement stm=con.prepareStatement(sql);
				//String name=session.getAttribute("userName").toString();
				stm.setString(1,session.getAttribute("userName").toString());//设置问好处的值
				ResultSet rs=stm.executeQuery(sql);
				List<Images> list=new ArrayList<Images>();
				while(rs.next()){
					Images image=new Images();
					image.setId(rs.getInt("id"));
					image.setName(rs.getString("name"));
					image.setPath(rs.getString("path"));
					image.setPart(rs.getString("part"));
					image.setDescr(rs.getString("descr"));
					image.setResult(rs.getString("result"));
					image.setInst(rs.getString("inst"));
					image.setUser(rs.getString("user"));
					image.setSet_time(rs.getString("set_time"));
					list.add(image);
					
				}
				return list;
			}else if(session.getAttribute("radio").toString()=="b"){
				String sql="select * from images";
				Statement smt=con.createStatement();
				ResultSet rs=smt.executeQuery(sql);
				List<Images> list=new ArrayList<Images>();
				while(rs.next()){
					Images image=new Images();
					image.setId(rs.getInt("id"));
					image.setName(rs.getString("name"));
					image.setPath(rs.getString("path"));
					image.setPart(rs.getString("part"));
					image.setDescr(rs.getString("descr"));
					image.setResult(rs.getString("result"));
					image.setInst(rs.getString("inst"));
					image.setUser(rs.getString("user"));
					image.setSet_time(rs.getString("set_time"));
					list.add(image);
					return list;
				}
			}else{
				
			}
			

		} catch (Exception e) {
			//一般捕获到异常之后的操作
			//1.记录日志
			e.printStackTrace();
			//抛出异常
			throw new RuntimeException("查询资费失败",e);
		}finally{
			mysqlTool.close(con);
		}
		
	}

	
	
	
	
	
	
	//插入一条数据
	public void insert_img(Img image){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//Date格式转为字符串
		Connection con =null;
		try { //这个是插入图片的
			//创建连接con
			con=mysqlTool.getConnection();
			String sql="insert into img(name,path,part,descr,result,inst,user,set_time)values(?,?,?,?,?,?,?,?)";
			//发送SQL语句到数据库，创建执行计划，返回执行计划ps
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			//传参
			ps.setString(1,image.getName());
			ps.setString(2,image.getPath());
			ps.setString(3,image.getPart());
			ps.setString(4,image.getDescr());
			ps.setString(5,image.getResult());
			ps.setString(6,image.getInst());
			ps.setString(7,image.getUser());
			ps.setString(9,sdf.format(image.getSet_time()));
			//执行语句
			ps.executeUpdate();
			System.out.println("完成");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			mysqlTool.close(con);
		}
	}
	
	*/
}
