package sinhvien.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sinhvien.entity.SinhVien;
import sinhvien.utlis.ConnectionFactory;

public class SinhVienDAO {

		private Connection connection;

		private Statement statement;
		private PreparedStatement preparedStatement;

		public SinhVienDAO() {
			super();
		}

		public List<SinhVien> getAllSinhVien() {
			String query = "SELECT * FROM thongtin";

			List<SinhVien> list = new ArrayList<SinhVien>();
			SinhVien sinhVien = null;

			try {
				connection = ConnectionFactory.getInstance().getConnection();
				statement = connection.createStatement();

				ResultSet rs = statement.executeQuery(query);
				while (rs.next()) {
					sinhVien = new SinhVien(rs.getString("hoTen"), rs.getInt("namSinh"), rs.getInt("id"), rs.getString("avatar"));
					list.add(sinhVien);
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					if (statement != null)
						statement.close();
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return list;
		}

		public void addNewSinhVien(String hoTen,int namSinh,int id, String avatar) {
			String query = "INSERT INTO thongtin(hoTen,namSinh,id,avatar) VALUES(?,?,?,?)";
			try {	
				connection = ConnectionFactory.getInstance().getConnection();
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1,hoTen);
				preparedStatement.setInt(2,namSinh);
				preparedStatement.setInt(3,id);
				preparedStatement.setString(4,avatar);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					if (statement != null)
						statement.close();
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		
		public void updateSinhVien(SinhVien sv) {
			String query = "update thongtin set hoTen=?, namSinh=?, avatar=? where id=?";
			try {
				connection = ConnectionFactory.getInstance().getConnection();
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, sv.getHoTen());
				preparedStatement.setInt(2, sv.getNamSinh());
				preparedStatement.setString(3, sv.getAvatar());
				preparedStatement.setInt(4, sv.getiD());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					if (statement != null)
						statement.close();
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		
		public void deleteSinhVien(int id3) {
			String query = "delete from thongtin where id=?";
			try {
				connection = ConnectionFactory.getInstance().getConnection();
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, id3);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					if (statement != null)
						statement.close();
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		public  SinhVien select(int id) {
			SinhVien account = null;
			String query = "select * from thongtin where id=?";
			try {
			
				connection = ConnectionFactory.getInstance().getConnection();
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				ResultSet rs = preparedStatement.executeQuery();
				if(rs.next()) {
					account = new SinhVien();
					account.setHoTen(rs.getString("hoTen"));
					account.setNamSinh(rs.getInt("namSinh"));
					account.setiD(rs.getInt("id"));
					account.setAvatar(rs.getString("avatar"));
				
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return account;
		
	}
		 public  List<SinhVien> getRecords(int start,int total){  
		        List<SinhVien> list=new ArrayList<SinhVien>();  
		        try{  
		        	connection = ConnectionFactory.getInstance().getConnection();
		            preparedStatement=connection.prepareStatement("select * from thongtin limit "+((start-1)*total)+","+total);  
		            ResultSet rs=preparedStatement.executeQuery();  
		            while(rs.next()){  
		            	SinhVien sv=new SinhVien();  
		                sv.setiD(rs.getInt("id"));  
		                sv.setHoTen(rs.getString("hoTen"));  
		                sv.setNamSinh(rs.getInt("namSinh")); 
		                sv.setAvatar(rs.getString("avatar")); 
		                list.add(sv);  
		            }  
		       
		        }catch(Exception e){
		        	System.out.println(e);
		        	}  
		        return list;  
		    }  
		 
		 public   int countSinhVien(){  
			int count = 0 ;
		       
		        String query = "SELECT COUNT(*) FROM thongtin";
				try {
					
					connection = ConnectionFactory.getInstance().getConnection();
					preparedStatement = connection.prepareStatement(query);  
					 
				 ResultSet rs = preparedStatement.executeQuery(); 
				 while(rs.next()) {
					 count = rs.getInt("COUNT(*)");
				 }
		        }catch(Exception e){System.out.println(e);}  
		        return count;   
		    }

		public List<SinhVien> selectRandom(String index, String result) {
			// TODO Auto-generated method stub
			List<SinhVien> list=new ArrayList<SinhVien>();  
	        try{  
	        	connection = ConnectionFactory.getInstance().getConnection();
	            preparedStatement=connection.prepareStatement("SELECT * FROM thongtin WHERE "+index+" like '%"+result+"%'" ); 
	            
	            ResultSet rs=preparedStatement.executeQuery();  
	            while(rs.next()){  
	            	SinhVien sv=new SinhVien();  
	                sv.setiD(rs.getInt("id"));  
	                sv.setHoTen(rs.getString("hoTen"));  
	                sv.setNamSinh(rs.getInt("namSinh"));
	                sv.setAvatar(rs.getString("avatar"));
	                list.add(sv);  
	            }  
	       
	        }catch(Exception e){
	        	System.out.println(e);
	        	}  
	        return list;  
	    }

		 
			
		

		
}

