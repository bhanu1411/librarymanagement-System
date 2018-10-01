package newpackage;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class login extends HttpServlet { 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name=request.getParameter("name");
pw.println(name);
String pword=request.getParameter("pword");
pw.println(pword+"<br>");
if(name.equals("bhanu123")&&pword.equals("123"))
{
	response.sendRedirect("adminsection.html");
}
else
{
	response.sendRedirect("login.html");
}
try{
	Class.forName("com.ibm.db2.jcc.DB2Driver");
			pw.print("driver connected");
			Connection con=DriverManager.getConnection("jdbc:db2://localhost:50000/student","db2admin","123");
			PreparedStatement ps=con.prepareStatement("insert into login1 values(?,?)");
			pw.print("query executed");                
			        ps.setString(1,name);
			        ps.setString(2,pword);
			        ps.executeUpdate();
			                pw.print("data saved succesfully");
			            }
			catch(Exception e)
			{
			    e.printStackTrace();
			}            
}
    }
