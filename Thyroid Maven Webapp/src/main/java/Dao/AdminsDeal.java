package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.Admins;
import mysql.mysqlTool;

/**
 * Admins ���߼�ҵ����
 * @author hcx
 *
 */

public class AdminsDeal {
	
	//����Admins��������
	//��ѯ����--�����û���              //��ѯһ������
	public Admins findAdmins_name(String name) {
		Connection con=null;
		try {
			con=mysqlTool.getConnection();
			String sql="select * from admins where name=?";
			PreparedStatement ps=con.prepareStatement(sql);
			//�������
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			//�ɲ�������ݷ�װ��һ��ʵ����
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
			throw new RuntimeException("�������ݿ�ʧ��---���ݹ������û�����ѯһ������Ա����");
		}finally{
			mysqlTool.close(con);
		}
		return null;
	}
}
