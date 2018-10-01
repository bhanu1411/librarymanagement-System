package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='addbook.html'>Add New books</a>");
		out.println("<h1>books List</h1>");
		
		List<Emp1> list=EmpDao1.getAllEmployees();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Author_name</th><th>Publisher_name</th><th>quantity</th><th>Edit</th><th>Delete</th></tr>");
		for(Emp1 e:list){
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getAuthor_name()+"</td><td>"+e.getPublisher_name()+"</td><td>"+e.getquantity()+"</td><td><a href='EditServlet5?data="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet2?data="+e.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
