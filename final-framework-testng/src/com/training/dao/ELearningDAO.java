package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mysql.jdbc.PreparedStatement;
import com.training.bean.LoginBean;
import com.training.bean.RegisterBean;
import com.training.connection.GetConnection;
import com.training.pom.RegisterPOM;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class ELearningDAO {
	
	Properties properties; 
	
	public ELearningDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertRegisterIntoDB(String email, String firstName, String lastName, String comments) {
		Connection con= null ;
		try {
			con = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails());
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO register (email, firstName, lastName, comments) VALUES('"+email+"','"+firstName+"','"+lastName+"','"+comments+"');");
			stmt.close();
			con.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<RegisterBean> getRegisterDetails() {
		Connection con= null ;
		RegisterBean registerBean = new RegisterBean();
		List<RegisterBean> rBeanList = new ArrayList<RegisterBean>();
		try {
			con = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails());
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("select * from register");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
			
			registerBean.setEmail(rs.getString(1));
			registerBean.setfName(rs.getString(2));
			registerBean.setlName(rs.getString(3));
			registerBean.setComments(rs.getString(4));
			rBeanList.add(registerBean);
			}
			
			stmt.close();
			con.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rBeanList;
	}
	
	public List<LoginBean> getLogins(){
		String sql = properties.getProperty("get.logins"); 
		
		GetConnection gc  = new GetConnection(); 
		List<LoginBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<LoginBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				LoginBean temp = new LoginBean(); 
				temp.setUserName(gc.rs1.getString(1));
				temp.setPassword(gc.rs1.getString(2));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	public static void main(String[] args) {
//		new ELearningDAO().getLogins().forEach(System.out :: println);
		new ELearningDAO().insertRegisterIntoDB("ramesh", "ramesh", "kumar", "successful");
	}
	
	
}
