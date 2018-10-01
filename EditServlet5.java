/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author db2admin
 */
public class EditServlet5 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update books</h1>");
		String sid=request.getParameter("data");
		//int id=Integer.parseInt(sid);
		
		Emp1 e=EmpDao1.getEmployeeById(sid);
		
		out.print("<form action='EditServlet6' method='post'>");
		out.print("<table>");
		out.print("<tr><td> Id: </td><td><input type='text' name='id' value='"+e.getId()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
		out.print("<tr><td>Author_name:</td><td><input type='password' name='a_name' value='"+e.getAuthor_name()+"'/></td></tr>");
		out.print("<tr><td>Publisher_name:</td><td><input type='email' name='p_name' value='"+e.getPublisher_name()+"'/></td></tr>");
		out.print("<tr><td>quantity:</td><td> <input type='text' name='quantity' value='"+e.getquantity()+"'/></td></tr>");
		//out.print("<select name='ntry' style='width:150px'>");
		//out.print("<option>India</option>");
		//out.print("<option>USA</option>");
		//out.print("<option>UK</option>");
		//out.print("<option>Other</option>");
		//out.print("</select>");
		//out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();   
    }

    
}
