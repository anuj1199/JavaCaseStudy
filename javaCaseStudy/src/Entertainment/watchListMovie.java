package Entertainment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class watchListMovie {
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
			e.printStackTrace();
		}
	}
	
	public void displaymovie() throws SQLException{
		try { 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/entertainment?characterEncoding=latin1", "root", "password");
			Statement stmt =con.createStatement();
		    ResultSet rs=stmt.executeQuery("select * from wlm");
		  
		  while(rs.next())
		  {
			  System.out.println("Movie Id: "+rs.getInt(1)+ " Movie Name: " + rs.getString(2) + " Movie Genre: " + rs.getString(3));
			  
		  }
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}
	}
	
	public void insertmovie(int id) throws SQLException{
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/entertainment?characterEncoding=latin1", "root", "password");
		    Statement stmt =con.createStatement();
		    PreparedStatement st=con.prepareStatement("insert into wlm(id, name, genre) select m_id, m_name, m_genre from movie where m_id=?");
		    st.setInt(1, id);
		    int count=st.executeUpdate();  
		    System.out.println(count+"row/s affected");
		    
		}
		
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
	}
	
	public void deletemovie(int id, String name) throws SQLException{
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/entertainment?characterEncoding=latin1", "root", "password");
		    Statement stmt =con.createStatement();
		    
		    PreparedStatement deleteEmp = con.prepareStatement("delete from wlm where id=? and name=?");
		    deleteEmp.setInt(1,id);
		    deleteEmp.setString(2,name);
		    int count=deleteEmp.executeUpdate();
		    System.out.println(count+"row/s affected");
		}
		
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
		
	}
}
