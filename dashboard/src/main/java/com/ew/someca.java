package com.ew;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.mail.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class someca {
	
	  @RequestMapping(value="/hello", method = RequestMethod.GET)
	  public String printHello(Model model) throws ClassNotFoundException, SQLException
	{
System.out.println("dgcsuchdu");
		  
		  
		Class.forName("com.mysql.jdbc.Driver");
	
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","");
	Statement st = conn.createStatement();
	ResultSet rs  = st.executeQuery("select * from test.shirts");
	rs.next();
	System.out.println(rs.getString(1));
	return null;
	}

}
