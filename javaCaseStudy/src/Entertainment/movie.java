package Entertainment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class movie {
	public int m_id;
	public String m_name;
	public String m_genre;
	public String platform;
	public String productionhouse;
	
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
		    ResultSet rs=stmt.executeQuery("select * from movie");
		  
		  while(rs.next())
		  {
			  System.out.println("Movie Id: "+rs.getInt(1)+ " Movie Name: " + rs.getString(2) + " Movie Genre: " + rs.getString(3) + " Movie Platform: " +rs.getString(4)+ " Production House: "+rs.getString(5));
			  
		  }
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}
	}
	public void insertmovie(int id, String name, String genre, String platform, String productionHouse) throws SQLException{
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/entertainment?characterEncoding=latin1", "root", "password");
		    Statement stmt =con.createStatement();
		    PreparedStatement st=con.prepareStatement("insert into movie(m_id, m_name, m_genre, platform, productionhouse) values(?,?,?,?,?)");
		    st.setInt(1, id);
		    st.setString(2, name);
		    st.setString(3, genre);
		    st.setString(4, platform);
		    st.setString(5, productionHouse);
		    int count=st.executeUpdate();  
		    System.out.println(count+"row/s affected");
		    
		}
		
		
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
	}
	public void updatemovie(String name,int id) throws SQLException{
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/entertainment?characterEncoding=latin1", "root", "password");
			Statement stmt =con.createStatement();
		    PreparedStatement st=con.prepareStatement("update movie set m_name=? where m_id=?");
		    st.setString(1,name);
		    st.setInt(2,id);
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
		    
		    PreparedStatement deleteEmp = con.prepareStatement("delete from movie where m_id=? and m_name=?");
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
