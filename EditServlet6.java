
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditServlet6 extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		//int id=Integer.parseInt(sid);
		String na=request.getParameter("name");
		String a_n=request.getParameter("a_name");
		String p_n=request.getParameter("p_name");
		String quan=request.getParameter("quantity");
		
		Emp1 e=new Emp1();
		e.setId(sid);
		e.setName(na);
		e.setAuthor_name(a_n);
		e.setPublisher_name(p_n);
		e.setquantity(quan);
                
		int status=EmpDao1.update(e);
		if(status>0){
			out.print("record updated");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}



        