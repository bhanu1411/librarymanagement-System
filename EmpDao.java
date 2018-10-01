package newpackage;
import java.util.*;
import java.sql.*;

public class EmpDao {

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
      public static int save(Emp e)
        {
		int status=0;
		try{
			Connection connn=EmpDao.getConnection();
                        System.out.print("1");
			PreparedStatement ps=connn.prepareStatement("insert into add1 values (?,?,?,?,?)");
                        System.out.print("2");
			ps.setString(1,e.getId());
                        ps.setString(2,e.getName());
			ps.setString(3,e.getPassword());
			ps.setString(4,e.getEmail());
			ps.setString(5,e.getmobile());
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
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from add1 where id=?");
			ps.setString(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}

	

	


	public static int update(Emp e){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update add1 set name=?,password=?,email=?,mobile=? where id=?");
          
                        ps.setString(1,e.getName());
			ps.setString(2,e.getPassword());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getmobile());
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

	public static Emp getEmployeeById(String id){
		Emp e=new Emp();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from add1 where id=?");
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setId(rs.getString(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setmobile(rs.getString(5));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();
                
                }
		
		return e;
	}
	public static List<Emp> getAllEmployees(){
		List<Emp> list=new ArrayList<Emp>();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from add1");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Emp e=new Emp();
				e.setId(rs.getString(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setmobile(rs.getString(5));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}

}