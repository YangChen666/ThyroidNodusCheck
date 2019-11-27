package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.Admins;
import entity.Img;
import entity.Users;
import mysql.mysqlTool;

/**
 * Users 的逻辑业务类
 * @author hcx
 *
 */

public class UsersDeal {
	
	//返回Users对象数据
	//查询数据--根据用户名              //查询一条数据
	public Users findUsers_name(String name) {
		Connection con=null;
		try {
			con=mysqlTool.getConnection();
			String sql="select * from users where name=?";
			PreparedStatement ps=con.prepareStatement(sql);
			//添加数据
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			//吧查出的数据封装成一个实体类
			if(rs.next()){
				Users user=new Users();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setAccount(rs.getString("account"));
				user.setHead(rs.getString("head"));
				user.setMobile(rs.getString("mobile"));
				user.setEmail(rs.getString("email"));
				user.setBirt(rs.getString("birt"));
				user.setSet_time(rs.getString("set_time"));
				return user;
			}
		} catch (Exception e) {
			throw new RuntimeException("连接数据库失败---根据患者用户名查询一条管理员数据");
		}finally{
			mysqlTool.close(con);
		}
		return null;
	}
	
	
	
	//出入一条数据///注册
		public void insert_user(Users user){
			Connection con =null;
			try { //这个是插入图片的
				//创建连接con
				System.out.println("执行了吗？");
				con=mysqlTool.getConnection();
				String sql="insert into users(name,password,sex,account,head,mobile,email,birt,set_time)values(?,?,?,?,?,?,?,?,?)";
				//发送SQL语句到数据库，创建执行计划，返回执行计划ps
				PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
				//传参
				ps.setString(1,user.getName());
				ps.setString(2,user.getPassword());
				ps.setString(3,user.getSex());
				ps.setString(4,user.getAccount());
				ps.setString(5,user.getHead());
				ps.setString(6,user.getMobile());
				ps.setString(7,user.getEmail());
				ps.setString(8,user.getBirt());
				ps.setString(9,user.getSet_time());
				//执行语句
				ps.executeUpdate();
				System.out.println("完成");
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				mysqlTool.close(con);
			}
		}
		
		
		
		//查询一条数据--根据用户名
		public Users findOne_Name(String name){
			Connection con=null;
			try {
				con=mysqlTool.getConnection();
				String sql="select * from users where name=?";
				PreparedStatement stm=con.prepareStatement(sql);
				stm.setString(1, name);//设置问好处的值
				ResultSet rs=stm.executeQuery();
				Users user=new Users();
				while(rs.next()){
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					user.setSex(rs.getString("sex"));
					user.setAccount(rs.getString("account"));
					user.setHead(rs.getString("head"));
					user.setMobile(rs.getString("mobile"));
					user.setEmail(rs.getString("email"));
					user.setBirt(rs.getString("birt"));
					user.setSet_time(rs.getString("set_time"));
					//System.out.println("修改chen");
				}
				System.out.println("chaxinyonghu:");
				return user;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("查询失败",e);
			}finally{
				mysqlTool.close(con);
			}
		}
}
