package newpackage;
import java.util.*;
import java.sql.*;

public class EmpDao1 {

	public static Connection getConnection()
        {
		Connection con=null;
		try
                {
                    System.out.print("started");
			Class.forName("com.ibm.db2.jcc.DB2Driver");
                        System.out.print("driver fetch");
			 con=DriverManager.getConnection("jdbc:db2://localhost:50000/student","db2admin","123");
                
                System.out.print("connected");
                }
		
                catch(Exception e)
                {
                    System.out.println(e);
                                  }
		return con;
        }
      public static int save(Emp1 e)
        {
		int status=0;
		try{
			Connection connn=EmpDao1.getConnection();
                        System.out.print("1");
			PreparedStatement ps=connn.prepareStatement("insert into add2 values (?,?,?,?,?)");
                        System.out.print("2");
			ps.setString(1,e.getId());
                        ps.setString(2,e.getName());
			ps.setString(3,e.getAuthor_name());
			ps.setString(4,e.getPublisher_name());
			ps.setString(5,e.getquantity());
                        System.out.print("3");
			
			status=ps.executeUpdate();
			System.out.print("4 updated");
			connn.close();
		}
                catch(Exception ex){
ex.printStackTrace();
}
		
		return status;
	}

        public static int delete(String id){
		int status=0;
		try{
			Connection con=EmpDao1.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from add2 where id=?");
			ps.setString(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}

	

	


	public static int update(Emp1 e){
		int status=0;
		try{
			Connection con=EmpDao1.getConnection();
			PreparedStatement ps=con.prepareStatement("update add2 set name=?,author_name=?,publisher_name=?,quantity=? where id=?");
          
                        ps.setString(1,e.getName());
			ps.setString(2,e.getAuthor_name());
			ps.setString(3,e.getPublisher_name());
			ps.setString(4,e.getquantity());
                        ps.setString(5,e.getId());
			
			
			status=ps.executeUpdate();
			
			con.close();
		}
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
		
		return status;
	}

	public static Emp1 getEmployeeById(String id){
		Emp1 e=new Emp1();
		
		try{
			Connection con=EmpDao1.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from add2 where id=?");
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setId(rs.getString(1));
				e.setName(rs.getString(2));
				e.setAuthor_name(rs.getString(3));
				e.setPublisher_name(rs.getString(4));
				e.setquantity(rs.getString(5));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();
                
                }
		
		return e;
	}
	public static List<Emp1> getAllEmployees(){
		List<Emp1> list=new ArrayList<Emp1>();
		
		try{
			Connection con=EmpDao1.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from add2");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Emp1 e=new Emp1();
				e.setId(rs.getString(1));
				e.setName(rs.getString(2));
				e.setAuthor_name(rs.getString(3));
				e.setPublisher_name(rs.getString(4));
				e.setquantity(rs.getString(5));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}

}