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

public class SaveServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String i=request.getParameter("id");
		String n=request.getParameter("name");
		String a=request.getParameter("a_name");
		String p=request.getParameter("p_name");
		String q=request.getParameter("quantity");
		out.print("value fetch");
		Emp1 e=new Emp1();
		e.setId(i);
                e.setName(n);
		e.setAuthor_name(a);
		e.setPublisher_name(p);
		e.setquantity(q);
out.print("v");		
		int status=EmpDao1.save(e);
                out.print("value ");
		if(status>0){
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("addbook.html").include(request, response);
		}else{
			out.println("Sorry! unable to save record");
		}
		
		out.close();   
    }

    

}
