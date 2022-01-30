package Entertainment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class series {
	public int s_id;
	public String s_name;
	public String s_genre;
	public String platform;
	public String productionhouse;
	public int episodes;
	public int seasons;
	
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
	public void displayseries() throws SQLException{
		try { 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/entertainment?characterEncoding=latin1", "root", "password");
			Statement stmt =con.createStatement();
		    ResultSet rs=stmt.executeQuery("select * from series");
		  
		  while(rs.next())
		  {
			  System.out.println("Series Id: "+rs.getInt(1)+ " Series Name: " + rs.getString(2) + " Series Genre: " + rs.getString(3) + " Series Platform: " +rs.getString(4)+ " Production House: "+rs.getString(5)+" Episodes: "+rs.getInt(6)+" Seasons: "+rs.getInt(7));	
			  
		  }
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}
	}
	public void insertseries(int id,String name, String genre, String platform, String productionHouse, int episodes ,int seasons) throws SQLException{
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/entertainment?characterEncoding=latin1", "root", "password");
		    Statement stmt =con.createStatement();
		    PreparedStatement st=con.prepareStatement("insert into series(s_id, s_name, s_genre, platform, productionhouse, episodes,seasons) values(?,?,?,?,?,?,?)");
		    st.setInt(1, id);
		    st.setString(2,name);
		    st.setString(3, genre);
		    st.setString(4, platform);
		    st.setString(5, productionHouse);
		    st.setInt(6, episodes);
		    st.setInt(7, seasons);
		    int count=st.executeUpdate();  
		    System.out.println(count+"row/s affected");
		    
		}
		
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
	}
	public void updateseries(String name,int id) throws SQLException{
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/entertainment?characterEncoding=latin1", "root", "password");
			Statement stmt =con.createStatement();
		    PreparedStatement st=con.prepareStatement("update series set s_name=? where s_id=?");
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
	public void deleteseries(int id, String name) throws SQLException{
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/entertainment?characterEncoding=latin1", "root", "password");
		    Statement stmt =con.createStatement();
		    
		    PreparedStatement deleteEmp = con.prepareStatement("delete from series where s_id=? and s_name=?");
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
