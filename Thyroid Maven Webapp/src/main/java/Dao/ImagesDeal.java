package Dao;
/**
 * Image ��ҵ�����߼���
 */
/*
 * ��Ϊ�ñ���ҽԺ��Ŀ���ģ����Բ������ɾ����ֻ�ܲ�ѯ����ˣ�����ֻд��ѯ����
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
	
	
	//��ѯ�û�Ϊ���ߵ�����     radio=="a"
		public List<Images> findAll_users(String name){
			Connection con=null;
			try {
				con=mysqlTool.getConnection();
				String sql="select * from images where user=?";
				PreparedStatement stm=con.prepareStatement(sql);
				stm.setString(1,name);//�����ʺô���ֵ
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
				//һ�㲶���쳣֮��Ĳ���
				//1.��¼��־
				e.printStackTrace();
				//�׳��쳣
				throw new RuntimeException("��ѯʧ��",e);
			}finally{
				mysqlTool.close(con);
			}
		}
	
	
	//��ѯ�û�Ϊ���ߵ�����     radio=="b"
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
				//һ�㲶���쳣֮��Ĳ���
				//1.��¼��־
				e.printStackTrace();
				//�׳��쳣
				throw new RuntimeException("��ѯʧ��",e);
			}finally{
				mysqlTool.close(con);
			}
		}
		
		
		
		//����ͼ��ID ����һ������
				public Images findOne_Id(int id){
					Connection con=null;
					try {
						con=mysqlTool.getConnection();
						String sql="select * from images where id=?";
						PreparedStatement stm=con.prepareStatement(sql);
						stm.setInt(1, id);//�����ʺô���ֵ
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
				
				
				
				//����ͼ������  ����һ������
				public Images findOne_Name(String name){
					Connection con=null;
					try {
						con=mysqlTool.getConnection();
						String sql="select * from images where name=?";
						PreparedStatement stm=con.prepareStatement(sql);
						stm.setString(1, name);//�����ʺô���ֵ
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
							System.out.println("�޸�chen");
						}
						System.out.println(image.getName());
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
				public void insert_image(Images image){
					//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//Date��ʽתΪ�ַ���
					Connection con =null;
					try { //����ǲ���ͼƬ��
						//��������con
						con=mysqlTool.getConnection();
						String sql="insert into images(name,path,part,descr,result,inst,user,set_time)values(?,?,?,?,?,?,?,?)";
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
						System.out.println(e);
					}finally{
						mysqlTool.close(con);
					}
				}
				
				
				
				//����һ������
				public void update_image(Images image){
					Connection con =null;
					try { 
						//��������con
						con=mysqlTool.getConnection();
						String sql="update images set name=?,part=?,descr=?,result=?,inst=? where id=?";
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
				
				
				//ɾ��һ������    id
				public void delete_image(int id){
					Connection con =null;
					try { 
						//��������con
						con=mysqlTool.getConnection();
						String sql="delete from images where id=?";
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
	
	
	
	
	
	
	
	/*////
	 * public List<Images> findAll() {  //�ò�ѯ�����飺1.����ֻ���Լ��ģ�2.����Ա���Բ����еġ�
		//��ȡ���ݿ�����
		Connection con=null;
		try {
			con=mysqlTool.getConnection();
			//��ȡsession
			HttpSession session=req.getSession();
			//��֧
			
			if(session.getAttribute("radio").toString()=="a"){
				String sql="select * from images where name=?";
				PreparedStatement stm=con.prepareStatement(sql);
				//String name=session.getAttribute("userName").toString();
				stm.setString(1,session.getAttribute("userName").toString());//�����ʺô���ֵ
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
			//һ�㲶���쳣֮��Ĳ���
			//1.��¼��־
			e.printStackTrace();
			//�׳��쳣
			throw new RuntimeException("��ѯ�ʷ�ʧ��",e);
		}finally{
			mysqlTool.close(con);
		}
		
	}

	
	
	
	
	
	
	//����һ������
	public void insert_img(Img image){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//Date��ʽתΪ�ַ���
		Connection con =null;
		try { //����ǲ���ͼƬ��
			//��������con
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
			ps.setString(9,sdf.format(image.getSet_time()));
			//ִ�����
			ps.executeUpdate();
			System.out.println("���");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			mysqlTool.close(con);
		}
	}
	
	*/
}
