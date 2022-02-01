package Entertainment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class watchListSerie {

	public int id;
	public String name;
	public String genre;
	
	Connection con=null;
	public void connect()throws Exception
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/entertainment?characterEncoding=latin1", "root", "password");
		} 
		catch (SQLException e) 
		{
			System.out.println("Wrong Connection....");
		}
	}
	
	public void displayserie() throws SQLException{
		try { 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/entertainment?characterEncoding=latin1", "root", "password");
			Statement stmt =con.createStatement();
		    ResultSet rs=stmt.executeQuery("select * from wls");
		  
		  while(rs.next())
		  {
			  System.out.println("Serie Id: "+rs.getInt(1)+ " Serie Name: " + rs.getString(2) + " Serie Genre: " + rs.getString(3));
			  
		  }
		}
		catch(Exception e1)
		{
			System.out.println("Exception Caught....");
			
		}
	}
	
	public void insertserie(int id) throws SQLException{
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/entertainment?characterEncoding=latin1", "root", "password");
		    Statement stmt =con.createStatement();
		    PreparedStatement st=con.prepareStatement("insert into wls(id, name, genre) select s_id, s_name, s_genre from movie where s_id=?");
		    st.setInt(1, id);
		    int count=st.executeUpdate();  
		    System.out.println(count+"row/s affected");
		    
		}
		
		catch(Exception e1)
		{
			System.out.println("Wrong Input....");
			
		}		
	}
	
	public void deleteserie(int id) throws SQLException{
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/entertainment?characterEncoding=latin1", "root", "password");
		    Statement stmt =con.createStatement();
		    
		    PreparedStatement deleteEmp = con.prepareStatement("delete from wls where id=?");
		    deleteEmp.setInt(1,id);
		    int count=deleteEmp.executeUpdate();
		    System.out.println(count+"row/s affected");
		}
		
		catch(Exception e1)
		{
			System.out.println("Wrong Input....");
			
		}		
		
	}
}
