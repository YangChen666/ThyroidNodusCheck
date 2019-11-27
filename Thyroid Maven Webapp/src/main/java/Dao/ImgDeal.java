package Dao;
/**
 * Img 的业务了逻辑类
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


public class ImgDeal {
	
	
	//插入一条数据
	public void insert_img(Img image){
		//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//Date格式转为字符串
		Connection con =null;
		try { //这个是插入图片的
			//创建连接con
			System.out.println("执行了吗？");
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
			ps.setString(8,image.getSet_time());
			//执行语句
			ps.executeUpdate();
			System.out.println("完成");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			mysqlTool.close(con);
		}
	}
	
	
	
	
	//根据图像ID 查找一条数据
	public Img findOne_Id(int id){
		Connection con=null;
		try {
			con=mysqlTool.getConnection();
			String sql="select * from img where id=?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setInt(1, id);//设置问好处的值
			ResultSet rs=stm.executeQuery();
			Img image=new Img();
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
	
	
	
	//更改一条数据
	public void update_image(Img image){
		Connection con =null;
		try { 
			//创建连接con
			con=mysqlTool.getConnection();
			String sql="update img set name=?,part=?,descr=?,result=?,inst=? where id=?";
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
		
		
		//查询数据--根据上传用户名查询（多条）
		public List<Img> find_user(String name){
			Connection con1=null;
			try {
				con1=mysqlTool.getConnection();
				String sql="select * from img where user=?";
				PreparedStatement stm=con1.prepareStatement(sql);
				stm.setString(1, name);;//设置问好处的值
				ResultSet rs=stm.executeQuery();
				List<Img> list=new ArrayList<Img>();
				while(rs.next()){
					Img img=new Img();
					img.setId(rs.getInt("id"));
					img.setName(rs.getString("name"));
					img.setPath(rs.getString("path"));
					img.setPart(rs.getString("part"));
					img.setDescr(rs.getString("descr"));
					img.setResult(rs.getString("result"));
					img.setInst(rs.getString("inst"));
					img.setUser(rs.getString("user"));
					img.setSet_time(rs.getString("set_time"));
					list.add(img);	
				}
				return list;
			} catch (Exception e) {
				//一般捕获到异常之后的操作
				//1.记录日志
				e.printStackTrace();
				//抛出异常
				throw new RuntimeException("查询失败",e);
			}finally{
				mysqlTool.close(con1);
			}
		}
		
		
		
		//查询所有数据
				public List<Img> findAll(){
					Connection con=null;
					try {
						con=mysqlTool.getConnection();
						String sql="select * from img;";
						Statement smt=con.createStatement();
						ResultSet rs=smt.executeQuery(sql);
						List<Img> list=new ArrayList<Img>();
						while(rs.next()){
							Img image=new Img();
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
				
				
				
				//删除一条数据    id
				public void delete_image(int id){
					Connection con =null;
					try { 
						//创建连接con
						con=mysqlTool.getConnection();
						String sql="delete from img where id=?";
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
}
