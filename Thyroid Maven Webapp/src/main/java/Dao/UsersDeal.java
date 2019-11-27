package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.Admins;
import entity.Img;
import entity.Users;
import mysql.mysqlTool;

/**
 * Users ���߼�ҵ����
 * @author hcx
 *
 */

public class UsersDeal {
	
	//����Users��������
	//��ѯ����--�����û���              //��ѯһ������
	public Users findUsers_name(String name) {
		Connection con=null;
		try {
			con=mysqlTool.getConnection();
			String sql="select * from users where name=?";
			PreparedStatement ps=con.prepareStatement(sql);
			//�������
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			//�ɲ�������ݷ�װ��һ��ʵ����
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
			throw new RuntimeException("�������ݿ�ʧ��---���ݻ����û�����ѯһ������Ա����");
		}finally{
			mysqlTool.close(con);
		}
		return null;
	}
	
	
	
	//����һ������///ע��
		public void insert_user(Users user){
			Connection con =null;
			try { //����ǲ���ͼƬ��
				//��������con
				System.out.println("ִ������");
				con=mysqlTool.getConnection();
				String sql="insert into users(name,password,sex,account,head,mobile,email,birt,set_time)values(?,?,?,?,?,?,?,?,?)";
				//����SQL��䵽���ݿ⣬����ִ�мƻ�������ִ�мƻ�ps
				PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
				//����
				ps.setString(1,user.getName());
				ps.setString(2,user.getPassword());
				ps.setString(3,user.getSex());
				ps.setString(4,user.getAccount());
				ps.setString(5,user.getHead());
				ps.setString(6,user.getMobile());
				ps.setString(7,user.getEmail());
				ps.setString(8,user.getBirt());
				ps.setString(9,user.getSet_time());
				//ִ�����
				ps.executeUpdate();
				System.out.println("���");
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				mysqlTool.close(con);
			}
		}
		
		
		
		//��ѯһ������--�����û���
		public Users findOne_Name(String name){
			Connection con=null;
			try {
				con=mysqlTool.getConnection();
				String sql="select * from users where name=?";
				PreparedStatement stm=con.prepareStatement(sql);
				stm.setString(1, name);//�����ʺô���ֵ
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
					//System.out.println("�޸�chen");
				}
				System.out.println("chaxinyonghu:");
				return user;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("��ѯʧ��",e);
			}finally{
				mysqlTool.close(con);
			}
		}
}
