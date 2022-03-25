package com.technocis.library.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.technocis.library.DAO.SupplierDAO;
import com.technocis.library.model.Author;
import com.technocis.library.model.Supplier;

public class SupplierDAOImpl implements SupplierDAO {
	
	static String SelectQuery="select name,phone,address,mail_id,password from supplier where supplier_id=?";
			  static String SelectAllQuery="select name,phone,address,mail_id,password from supplier ";
			  static String addQuery="insert into supplier(name,phone,address,mail_id,password)values(?,?,?,?,?)";
			  static String updateQuery="update supplier set (name=?,phone=?,address=?,mail_id=?,password=?)where supplier_id=?";
			  static String deleteQuery="delete from supplier where supplier_id=?" ;
			  
			  public Supplier getSupplier(int id){
			  Connection con=null;
			  PreparedStatement pstmt=null;
			  ResultSet rs=null;
			  Supplier supplier =null;
			  try{
			        con=ConnectionUtil.getDBconnect();
					pstmt=con.prepareStatement(SelectQuery);
					pstmt.setInt(1,id);
					rs=pstmt.executeQuery();
					if(rs.next()){
					  supplier =new Supplier(id,rs.getString(1),rs.getLong(2),rs.getString(3),rs.getString(4),rs.getString(5));
					}	
			  }catch(Exception e){
			  
			  e.printStackTrace();
			  }finally {
					try {
						if (pstmt != null) {
							rs.close();
							pstmt.close();
							con.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			  return supplier;
			  }
			  
				public List<Supplier> getAllSupplier()
				{Connection con=null;
			  PreparedStatement pstmt=null;
			  ResultSet rs=null;
			  List<Supplier> supplierList=new ArrayList<Supplier>();
			  try{
			        con=ConnectionUtil.getDBconnect();
					pstmt=con.prepareStatement(SelectAllQuery);
					rs=pstmt.executeQuery();
					while(rs.next()){
					  supplierList.add(new Supplier(rs.getInt(1),rs.getString(2),rs.getLong(3),rs.getString(4),rs.getString(5),rs.getString(6)));
					}	
			  }catch(Exception e){
			  
			  e.printStackTrace();
			  }finally {
					try {
						if (pstmt != null) {
							rs.close();
							pstmt.close();
							con.close();
						}
					} catch (SQLException e) {

						e.printStackTrace();
					}
				
				}
			  return supplierList;
				}
				public Supplier addSupplier(Supplier supplier){
				Connection con=null;
			  PreparedStatement pstmt=null;
			  try{
			        con=ConnectionUtil.getDBconnect();
					pstmt=con.prepareStatement(addQuery);
					pstmt.setString(1,supplier.getName());
					pstmt.setLong(2,supplier.getPhone());
					pstmt.setString(3,supplier.getAddress());
					pstmt.setString(4,supplier.getMail_Id());
					pstmt.setString(5,supplier.getPassword());
					int res=pstmt.executeUpdate();
					if(res>0){
					return supplier;
					}	
			  }catch(Exception e){
			  
			  e.printStackTrace();
			  }finally {
					try {
						if (pstmt != null) {
							pstmt.close();
							con.close();
						}
					} catch (SQLException e) {

						e.printStackTrace();
					}
				}
			  return null;
				}
				public Supplier updateSupplier(int id,Supplier supplier){
				Connection con=null;
			  PreparedStatement pstmt=null;
			 
			  try{
			        con=ConnectionUtil.getDBconnect();
					pstmt=con.prepareStatement(addQuery);
					pstmt.setString(1,supplier.getName());
					pstmt.setLong(2,supplier.getPhone());
					pstmt.setString(3,supplier.getAddress());
					pstmt.setString(4,supplier.getMail_Id());
					pstmt.setString(5,supplier.getPassword());
					pstmt.setInt(6,id);
					int res=pstmt.executeUpdate();
					if(res>0){
					return supplier;
					}
				
			  }catch(Exception e){
			  
			  e.printStackTrace();
			  }finally {
					try {
						if (pstmt != null) {
							pstmt.close();
							con.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			  return null;
				}
				public Supplier deleteSupplier(int id){
				Connection con=null;
			  PreparedStatement pstmt=null;
			Supplier supplier=getSupplier(id);
			  try{
			        con=ConnectionUtil.getDBconnect();
			        pstmt=con.prepareStatement(deleteQuery);
					pstmt.setInt(1,id);
					int res=pstmt.executeUpdate();
					if(res>0){
					return supplier;
					}
				
			  }catch(Exception e){
			  
			  e.printStackTrace();
			  }finally {
					try {
						if (pstmt != null) {
							pstmt.close();
							con.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			  return null;
				}		
				
}
