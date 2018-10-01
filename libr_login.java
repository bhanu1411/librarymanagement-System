/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class libr_login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
 	        String email=request.getParameter("email");
                String password=request.getParameter("password");
                
            try{
        Class.forName("com.ibm.db2.jcc.DB2Driver");
        Connection conn=DriverManager.getConnection("jdbc:db2://localhost:50000/student","db2admin","123");
        pw.print("drivers connected");
       PreparedStatement ps=conn.prepareStatement("Select * from add1 where Email=? and Password=?");
       pw.print("drivers connected 1");
                   ps.setString(4,email);
                   ps.setString(3,password);
       ResultSet rs=ps.executeQuery();
       pw.print("drivers connected 2");
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }                                   
        }
}