package Entertainment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Main {
	

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
	public void registerUser(user u)throws Exception
	{
		try 
		{
			String query = "insert into userlogin(username, pass, email) values(?,?,?)";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/entertainment?characterEncoding=latin1", "root", "password");
			Statement stmt =con.createStatement();
			PreparedStatement st= con.prepareStatement(query);
			st.setString(1, u.getUserName());
			st.setString(2, u.getPassword());
			st.setString(3, u.getEmail());
			int count = st.executeUpdate();
			System.out.println(count+" row/s affected");
			System.out.println(" ");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public user getUser(String email)throws Exception
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/entertainment?characterEncoding=latin1", "root", "password");
		String query = "select username,pass from userlogin where email='"+email+"'";
		
		try {
			user u = new user();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			u.username = rs.getString(1);
			u.pass = rs.getString(2);
			u.email = email;
			return u;
		
		}
		catch(Exception e)
		{
			System.out.println("getUser caused exception");
		}
		return null;
	}
	public login getAdmin(String email)throws Exception
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/entertainment?characterEncoding=latin1", "root", "password");
		String query = "select username, pass from login where email='"+email+"'";
		
		try {
			login l = new login();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			l.name = rs.getString(1);
			l.pass = rs.getString(2);
			l.email = email;
			return l;
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public String AuthenticateUser(String email)throws Exception
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/entertainment?characterEncoding=latin1", "root", "password");
		String query = "select pass from userlogin where email='"+email+"'";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			String pass = rs.getString(1);
			return pass;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String AuthenticateAdmin(String email)throws Exception
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/entertainment?characterEncoding=latin1", "root", "password");
		String query = "select pass from login where email='"+email+"'";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			String pass = rs.getString(1);
			return pass;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m=new Main();
		Scanner sc=new Scanner(System.in);
		System.out.println("------------------------------------------------");
		System.out.println("		Welcome to Entertainment Zone");
		System.out.println("------------------------------------------------");
		
		System.out.println("Press 1 for User Registeration ");
		System.out.println("Press 2 for User Sign In");
		System.out.println("Press 3 for Admin Sign In");
		int choice1 = sc.nextInt();
		
			switch(choice1) {
			case 1: 
					System.out.println("------------------------------------------------");
					System.out.println("         User Registration");
					System.out.println("------------------------------------------------");
					user u=new user();
					System.out.println("Enter your name:");
					sc.nextLine();
					u.setUserName(sc.nextLine());
					System.out.println();
					System.out.println("Enter your password:");
					u.setPassword(sc.nextLine());
					System.out.println();
					System.out.println("Enter your email:");
					u.setEmail(sc.nextLine());
					System.out.println();
					try {
						m.registerUser(u);
						System.out.println("User Registered.");
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					System.out.println("------------------------------------------------");
					System.out.println("         User Sign In");
					System.out.println("------------------------------------------------");
					System.out.println("Enter Email: ");
					String useremail1=sc.nextLine();
					System.out.println();
					System.out.println("Enter Password: ");
					String userpassword1=sc.nextLine();
					System.out.println();
					try {
						if(userpassword1.equals(m.AuthenticateUser(useremail1))) {
							m.getUser(useremail1);
							System.out.println("Press 1 for Movies Zone");
							System.out.println("Press 2 for Series Zone");
							System.out.println("Press 3 for Movies Watchlist Zone");
							System.out.println("Press 4 for Series Watchlist Zone");
							int choice2=sc.nextInt();
							
								switch(choice2) {
								case 1:
									try {
										System.out.println("------------------------------------------------");
										System.out.println("		Welcome to Movies Zone");
										System.out.println("------------------------------------------------");
										System.out.println("Press 1 to display all the movies");
										int choice3 = sc.nextInt();
											switch(choice3) {
											case 1:
												movie mv=new movie();
												mv.connect();
												mv.displaymovie();
												break;
											default:
												System.out.println("Incorrect choice....");
											}
									}
									catch(Exception e) {
										e.printStackTrace();
									}
									break;
									
								case 2:
									
									try {
										System.out.println("------------------------------------------------");
										System.out.println("		Welcome to Series Zone");
										System.out.println("------------------------------------------------");
										System.out.println("Press 1 to display all the series");
										System.out.println("Press 2 to display the series in Watch List");
										System.out.println("Press 3 to insert the series in Watch List");
										System.out.println("Press 4 to delete the series in Watch List");
										int choice4 = sc.nextInt();
											switch(choice4) {
											case 1:
												series sr=new series();
												sr.connect();
												sr.displayseries();
												break;
												
											default:
												System.out.println("Incorrect choice....");
												}
									}
									catch(Exception e) {
										e.printStackTrace();
									}
									break;
									
								case 3:
									try {
										System.out.println("------------------------------------------------");
										System.out.println("		Welcome to Movies Watch List Zone");
										System.out.println("------------------------------------------------");
										System.out.println("Press 1 to display the movies in Watch List");
										System.out.println("Press 2 to insert the movies in Watch List");
										System.out.println("Press 3 to delete the movies in Watch List");
										int choice4 = sc.nextInt();
										watchListMovie wlm=new watchListMovie();
										
											switch(choice4) {
											case 1:
												wlm.connect();
												wlm.displaymovie();
												break;
											case 2:
												wlm.connect();
												int id=sc.nextInt();
												wlm.insertmovie(id);				
												break;
											case 3:	
												wlm.connect();
												int movieid=sc.nextInt();
												sc.nextLine();
												String moviename=sc.nextLine();
												wlm.deletemovie(movieid,moviename);
												break;
											default:
												System.out.println("Incorrect choice....");
												}
									}
									catch(Exception e) {
										e.printStackTrace();
									}
									break;
								
								case 4:
									try {
										System.out.println("------------------------------------------------");
										System.out.println("		Welcome to Series Watch List Zone");
										System.out.println("------------------------------------------------");
										System.out.println("Press 1 to display the series in Watch List");
										System.out.println("Press 2 to insert the series in Watch List");
										System.out.println("Press 3 to delete the series in Watch List");
										int choice4 = sc.nextInt();
										watchListSerie wls=new watchListSerie();
											switch(choice4) {
											case 1:
												wls.connect();
												wls.displayserie();
												break;
											case 2:
												wls.connect();
												int id=sc.nextInt();
												wls.insertserie(id);				
												break;
											case 3:	
												wls.connect();
												int serieid=sc.nextInt();
												sc.nextLine();
												String seriename=sc.nextLine();
												wls.deleteserie(serieid,seriename);
												break;	
											default:
												System.out.println("Incorrect choice....");
												}
									}
									catch(Exception e) {
										e.printStackTrace();
									}
									break;	
								default:
									System.out.println("Incorrect choice!");
								}
								
							
						}
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					break;
			case 2:		
					System.out.println("------------------------------------------------");
					System.out.println("         User Sign In");
					System.out.println("------------------------------------------------");
					System.out.println("Enter Email: ");
					sc.nextLine();
					String useremail=sc.nextLine();
					System.out.println();
					System.out.println("Enter Password: ");
					String userpassword=sc.nextLine();
					System.out.println();
					try {
						if(userpassword.equals(m.AuthenticateUser(useremail))) {
							m.getUser(useremail);
							System.out.println("Press 1 for Movies Zone");
							System.out.println("Press 2 for Series Zone");
							System.out.println("Press 3 for Movies Watchlist Zone");
							System.out.println("Press 4 for Series Watchlist Zone");
							int choice2=sc.nextInt();
							
								switch(choice2) {
								case 1:
									try {
										System.out.println("------------------------------------------------");
										System.out.println("		Welcome to Movies Zone");
										System.out.println("------------------------------------------------");
										System.out.println("Press 1 to display all the movies");
										int choice3 = sc.nextInt();
											switch(choice3) {
											case 1:
												movie mv=new movie();
												mv.connect();
												mv.displaymovie();
												break;
											default:
												System.out.println("Incorrect choice....");
											}
									}
									catch(Exception e) {
										e.printStackTrace();
									}
									break;
								case 2:
									
									try {
										System.out.println("------------------------------------------------");
										System.out.println("		Welcome to Series Zone");
										System.out.println("------------------------------------------------");
										System.out.println("Press 1 to display all the series");
										int choice4 = sc.nextInt();
											switch(choice4) {
											case 1:
												series sr=new series();
												sr.connect();
												sr.displayseries();
												break;
												
											default:
												System.out.println("Incorrect choice....");
												}
									}
									catch(Exception e) {
										e.printStackTrace();
									}
									break;
								
								case 3:
									try {
										System.out.println("------------------------------------------------");
										System.out.println("		Welcome to Movies Watch List Zone");
										System.out.println("------------------------------------------------");
										System.out.println("Press 1 to display the movies in Watch List");
										System.out.println("Press 2 to insert the movies in Watch List");
										System.out.println("Press 3 to delete the movies in Watch List");
										int choice4 = sc.nextInt();
										watchListMovie wlm=new watchListMovie();
										
											switch(choice4) {
											case 1:
												wlm.connect();
												wlm.displaymovie();
												break;
											case 2:
												wlm.connect();
												int id=sc.nextInt();
												wlm.insertmovie(id);				
												break;
											case 3:	
												wlm.connect();
												int movieid=sc.nextInt();
												sc.nextLine();
												String moviename=sc.nextLine();
												wlm.deletemovie(movieid,moviename);
												break;
											default:
												System.out.println("Incorrect choice....");
												}
									}
									catch(Exception e) {
										e.printStackTrace();
									}
									break;
								
								case 4:
									try {
										System.out.println("------------------------------------------------");
										System.out.println("		Welcome to Series Watch List Zone");
										System.out.println("------------------------------------------------");
										System.out.println("Press 1 to display the series in Watch List");
										System.out.println("Press 2 to insert the series in Watch List");
										System.out.println("Press 3 to delete the series in Watch List");
										int choice4 = sc.nextInt();
										watchListSerie wls=new watchListSerie();
											switch(choice4) {
											case 1:
												wls.connect();
												wls.displayserie();
												break;
											case 2:
												wls.connect();
												int id=sc.nextInt();
												wls.insertserie(id);				
												break;
											case 3:	
												wls.connect();
												int serieid=sc.nextInt();
												sc.nextLine();
												String seriename=sc.nextLine();
												wls.deleteserie(serieid,seriename);
												break;	
											default:
												System.out.println("Incorrect choice....");
												}
									}
									catch(Exception e) {
										e.printStackTrace();
									}
									break;	
									
								default:
									System.out.println("Incorrect choice!");
								}
						}
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					break;
					
			case 3:
				
				try {
					System.out.println("------------------------------------------------");
					System.out.println("         Admin Sign In");
					System.out.println("------------------------------------------------");
					System.out.println("Enter Email: ");
					sc.nextLine();
					String ademail=sc.nextLine();
					System.out.println();
					System.out.println("Enter Password: ");
					String adpassword=sc.nextLine();
					System.out.println();
					if(adpassword.equals(m.AuthenticateAdmin(ademail))) {
						m.getAdmin(ademail);
						System.out.println("Press 1 for Movies Zone");
						System.out.println("Press 2 for Series Zone");
						System.out.println("Press 3 for Watchlist Zone");
						System.out.println("Press 0 to rollback to previous screen");
						int choice2=sc.nextInt();
						
							switch(choice2) {
							case 1:
								System.out.println("------------------------------------------------");
								System.out.println("		Welcome to Movies Zone");
								System.out.println("------------------------------------------------");
								System.out.println("Press 1 to display all the movies");
								System.out.println("Press 2 to insert the movies");
								System.out.println("Press 3 to update the movies");
								System.out.println("Press 4 to delete movies");
								System.out.println("Press 0 to rollback to previous screen");
								int choice3 = sc.nextInt();
								movie mv=new movie();
								try {
										switch(choice3) {
										case 1:
											mv.connect();
											mv.displaymovie();
										
											break;
										case 2:
											mv.connect();
											int id=sc.nextInt();
											sc.nextLine();
											String name=sc.nextLine();
											String genre=sc.nextLine();
											String platform=sc.nextLine();
											String productionHouse=sc.nextLine();
											mv.insertmovie(id, name, genre, platform, productionHouse);
											
											break;
										case 3:
											mv.connect();
											int mid=sc.nextInt();
											sc.nextLine();
											String mname=sc.nextLine();
											mv.updatemovie(mname, mid);
											
											break;
										case 4:
											mv.connect();
											int movieid=sc.nextInt();
											sc.nextLine();
											String moviename=sc.nextLine();
											mv.deletemovie(movieid,moviename);
											
											break;	
										default:
											System.out.println("Incorrect choice....");
										}
								}
								catch(Exception e) {
									e.printStackTrace();
								}
								
								break;
							case 2:
								
								try {
									System.out.println("------------------------------------------------");
									System.out.println("		Welcome to Series Zone");
									System.out.println("------------------------------------------------");
									System.out.println("Press 1 to display all the series");
									System.out.println("Press 2 to insert the series");
									System.out.println("Press 3 to update the series");
									System.out.println("Press 4 to delete series");
									System.out.println("Press 0 to rollback to previous screen");
									int choice4 = sc.nextInt();
									series sr=new series();
										switch(choice4) {
										case 1:
											sr.connect();
											sr.displayseries();
											
											break;
										case 2:	
											sr.connect();
											int id=sc.nextInt();
											sc.nextLine();
											String name=sc.nextLine();
											String genre=sc.nextLine();
											String platform=sc.nextLine();
											String productionHouse=sc.nextLine();
											int episodes=sc.nextInt();
											int seasons=sc.nextInt();
											sr.insertseries(id, name, genre, platform, productionHouse,episodes,seasons);
											
											break;
										case 3:
											int sid=sc.nextInt();
											sc.nextLine();
											String sname=sc.nextLine();
											sr.updateseries(sname, sid);
											
											break;
										case 4:
											sr.connect();
											int serieid=sc.nextInt();
											sc.nextLine();
											String seriename=sc.nextLine();
											sr.deleteseries(serieid,seriename);
											
											break;
										default:
											System.out.println("Incorrect choice....");
											}
								}
								catch(Exception e) {
									e.printStackTrace();
								}
								
								break;
							default:
								System.out.println("Incorrect choice!");
							}
							
						
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}	
				
				break;
				default:
					System.out.println("Incorrect choice....");
			}
	}
}
