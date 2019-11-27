package Dao;
/**
 * Img ��ҵ�����߼���
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
	
	
	//����һ������
	public void insert_img(Img image){
		//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//Date��ʽתΪ�ַ���
		Connection con =null;
		try { //����ǲ���ͼƬ��
			//��������con
			System.out.println("ִ������");
			con=mysqlTool.getConnection();
			String sql="insert into img(name,path,part,descr,result,inst,user,set_time)values(?,?,?,?,?,?,?,?)";
			//����SQL��䵽���ݿ⣬����ִ�мƻ�������ִ�мƻ�ps
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			//����
			ps.setString(1,image.getName());
			ps.setString(2,image.getPath());
			ps.setString(3,image.getPart());
			ps.setString(4,image.getDescr());
			ps.setString(5,image.getResult());
			ps.setString(6,image.getInst());
			ps.setString(7,image.getUser());
			ps.setString(8,image.getSet_time());
			//ִ�����
			ps.executeUpdate();
			System.out.println("���");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			mysqlTool.close(con);
		}
	}
	
	
	
	
	//����ͼ��ID ����һ������
	public Img findOne_Id(int id){
		Connection con=null;
		try {
			con=mysqlTool.getConnection();
			String sql="select * from img where id=?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setInt(1, id);//�����ʺô���ֵ
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
				//System.out.println("�޸�chen");
			}
			return image;
		} catch (Exception e) {
			//һ�㲶���쳣֮��Ĳ���
			//1.��¼��־
			e.printStackTrace();
			//�׳��쳣
			throw new RuntimeException("��ѯʧ��",e);
		}finally{
			mysqlTool.close(con);
		}
	}
	
	
	
	//����һ������
	public void update_image(Img image){
		Connection con =null;
		try { 
			//��������con
			con=mysqlTool.getConnection();
			String sql="update img set name=?,part=?,descr=?,result=?,inst=? where id=?";
			//����SQL��䵽���ݿ⣬����ִ�мƻ�������ִ�мƻ�ps
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			//����
			ps.setString(1,image.getName());
			ps.setString(2,image.getPart());
			ps.setString(3,image.getDescr());
			ps.setString(4,image.getResult());
			ps.setString(5,image.getInst());
			ps.setInt(6, image.getId());
			//ִ�����
			ps.executeUpdate();//executeUpdate()
			System.out.println("�޸����ݳɹ�");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			mysqlTool.close(con);
		}
	}
		
		
		//��ѯ����--�����ϴ��û�����ѯ��������
		public List<Img> find_user(String name){
			Connection con1=null;
			try {
				con1=mysqlTool.getConnection();
				String sql="select * from img where user=?";
				PreparedStatement stm=con1.prepareStatement(sql);
				stm.setString(1, name);;//�����ʺô���ֵ
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
				//һ�㲶���쳣֮��Ĳ���
				//1.��¼��־
				e.printStackTrace();
				//�׳��쳣
				throw new RuntimeException("��ѯʧ��",e);
			}finally{
				mysqlTool.close(con1);
			}
		}
		
		
		
		//��ѯ��������
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
						//һ�㲶���쳣֮��Ĳ���
						//1.��¼��־
						e.printStackTrace();
						//�׳��쳣
						throw new RuntimeException("��ѯʧ��",e);
					}finally{
						mysqlTool.close(con);
					}
				}
				
				
				
				//ɾ��һ������    id
				public void delete_image(int id){
					Connection con =null;
					try { 
						//��������con
						con=mysqlTool.getConnection();
						String sql="delete from img where id=?";
						//����SQL��䵽���ݿ⣬����ִ�мƻ�������ִ�мƻ�ps
						PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
						//����
						ps.setInt(1, id);
						//ִ�����
						ps.executeUpdate();//executeUpdate()
						System.out.println("�޸����ݳɹ�");
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						mysqlTool.close(con);
					}
				}
}
