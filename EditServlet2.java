
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditServlet2 extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("i");
		//int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		
		Emp e=new Emp();
		e.setId(sid);
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setmobile(mobile);
                
		int status=EmpDao.update(e);
		if(status>0){
			out.print("record updated");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}



        