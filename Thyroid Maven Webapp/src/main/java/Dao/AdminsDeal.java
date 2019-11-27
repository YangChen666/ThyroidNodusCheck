package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.Admins;
import mysql.mysqlTool;

/**
 * Admins 的逻辑业务类
 * @author hcx
 *
 */

public class AdminsDeal {
	
	//返回Admins对象数据
	//查询数据--根据用户名              //查询一条数据
	public Admins findAdmins_name(String name) {
		Connection con=null;
		try {
			con=mysqlTool.getConnection();
			String sql="select * from admins where name=?";
			PreparedStatement ps=con.prepareStatement(sql);
			//添加数据
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			//吧查出的数据封装成一个实体类
			if(rs.next()){
				Admins admin=new Admins();
				admin.setId(rs.getInt("id"));
				admin.setName(rs.getString("name"));
				admin.setPassword(rs.getString("password"));
				admin.setSex(rs.getString("sex"));
				admin.setHead(rs.getString("head"));
				admin.setMobile(rs.getString("mobile"));
				admin.setEmail(rs.getString("email"));
				admin.setBirt(rs.getString("birt"));
				admin.setSet_time(rs.getString("set_time"));
				return admin;
			}
		} catch (Exception e) {
			throw new RuntimeException("连接数据库失败---根据管理者用户名查询一条管理员数据");
		}finally{
			mysqlTool.close(con);
		}
		return null;
	}
}
