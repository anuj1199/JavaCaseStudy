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
			System.out.println("Wrong Connection....");
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
			System.out.println("Wrong Input....");
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
			System.out.println("Not an registered email id.....");
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
			System.out.println("Not an admin email id");
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
			System.out.println("Entered email or password is incorrect");
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
			System.out.println("Entered email or password is incorrect");
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
		System.out.println("Select any option below");
		System.out.println("1. User Registeration");
		System.out.println("2. User Sign In");
		System.out.println("3. Admin Sign In");
		int choice1 = sc.nextInt();
		do {
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
							System.out.println("Successfully signed in...");
							System.out.println();
							System.out.println("Select any option below");
							System.out.println("1. Movies Zone");
							System.out.println("2. Series Zone");
							System.out.println("3. Movies Watchlist Zone");
							System.out.println("4. Series Watchlist Zone");
							int choice2=sc.nextInt();
							do {
								switch(choice2) {
								case 1:
									try {
										System.out.println("------------------------------------------------");
										System.out.println("		Welcome to Movies Zone");
										System.out.println("------------------------------------------------");
										System.out.println("Select any option below");
										System.out.println("1. Display movies");
										int choice3 = sc.nextInt();
										do {
											switch(choice3) {
											case 1:
												movie mv=new movie();
												mv.connect();
												System.out.println("Displaying the Movies");
												mv.displaymovie();
												break;
											default:
												System.out.println("Incorrect choice....");
												break;
											}
											System.out.println("------------------------------------------------");
											System.out.println("		Welcome to Movies Zone");
											System.out.println("------------------------------------------------");
											System.out.println("Select any option below");
											System.out.println("1. Display Movies");
											System.out.println("2. Go to previous screen");
											int choice4 = sc.nextInt();
											choice3=choice4;
										}while(choice3!=2);	
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
										System.out.println("Select any option below");
										System.out.println("1. Display Series");
										int choice3 = sc.nextInt();
										do {
											switch(choice3) {
											case 1:
												series sr=new series();
												sr.connect();
												System.out.println("Displaying the Series");
												sr.displayseries();
												break;
												
											default:
												System.out.println("Incorrect choice....");
												break;
												}
											System.out.println("------------------------------------------------");
											System.out.println("		Welcome to Series Zone");
											System.out.println("------------------------------------------------");
											System.out.println("Select any option below");
											System.out.println("1.Display Series");
											System.out.println("2. Go to previous screen");
											int choice4 = sc.nextInt();
											choice3=choice4;
										}while(choice3!=2);
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
										System.out.println("Select any option below");
										System.out.println("1. Display the movies in Watch List");
										System.out.println("2. Insert the movies in Watch List");
										System.out.println("3. delete the movies in Watch List");
										int choice3 = sc.nextInt();
										watchListMovie wlm=new watchListMovie();
										do {
											switch(choice3) {
											case 1:
												wlm.connect();
												System.out.println("Displaying the Movie Watchlist");
												wlm.displaymovie();
												break;
											case 2:
												wlm.connect();
												System.out.println("Enter Movie Id:");
												int id=sc.nextInt();
												wlm.insertmovie(id);	
												System.out.println("Movie Inserted.");
												break;
											case 3:	
												wlm.connect();
												System.out.println("Enter Movie Id:");
												int movieid=sc.nextInt();
												wlm.deletemovie(movieid);
												System.out.println("Movie Deleted.");
												break;
											default:
												System.out.println("Incorrect choice....");
												break;
												}
											System.out.println("------------------------------------------------");
											System.out.println("		Welcome to Movies Watch List Zone");
											System.out.println("------------------------------------------------");
											System.out.println("Select any option below");
											System.out.println("1. Display the movies in Watch List");
											System.out.println("2. Insert the movies in Watch List");
											System.out.println("3. Delete the movies in Watch List");
											System.out.println("4. Go to previous screen");
											int choice4 = sc.nextInt();
											choice3=choice4;
										}while(choice3!=4);	
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
										System.out.println("Select any option below");
										System.out.println("1. Display the series in Watch List");
										System.out.println("2. Insert the series in Watch List");
										System.out.println("3. Delete the series in Watch List");
										int choice3 = sc.nextInt();
										watchListSerie wls=new watchListSerie();
										do {
											switch(choice3) {
											case 1:
												wls.connect();
												System.out.println("Displaying Series Watchlist");
												wls.displayserie();
												break;
											case 2:
												wls.connect();
												System.out.println("Enter Serie Id:");
												int id=sc.nextInt();
												wls.insertserie(id);				
												System.out.println("Serie Inserted.");
												break;
											case 3:	
												wls.connect();
												System.out.println("Enter Serie Id:");
												int serieid=sc.nextInt();
												wls.deleteserie(serieid);
												System.out.println("Serie Deleted.");
												break;	
											default:
												System.out.println("Incorrect choice....");
												break;
												}
											System.out.println("------------------------------------------------");
											System.out.println("		Welcome to Series Watch List Zone");
											System.out.println("------------------------------------------------");
											System.out.println("Select any option below");
											System.out.println("1. Display the series in Watch List");
											System.out.println("2. Insert the series in Watch List");
											System.out.println("3. Delete the series in Watch List");
											System.out.println("4. Go to previous screen");
											int choice4 = sc.nextInt();
											choice3=choice4;
										}while(choice3!=4);
									}
									catch(Exception e) {
										e.printStackTrace();
									}
									break;	
									
								default:
									System.out.println("Incorrect choice!");
									break;
								}
								System.out.println("Select any option below");
								System.out.println("1. Movies Zone");
								System.out.println("2. Series Zone");
								System.out.println("3. Movies Watchlist Zone");
								System.out.println("4. Series Watchlist Zone");
								System.out.println("5. Go to previous screen");
								int choice5=sc.nextInt();	
								choice2=choice5;
							}while(choice2!=5);
							}
						
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					break;
					
			case 3:
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
				try {
					if(adpassword.equals(m.AuthenticateAdmin(ademail))) {
						m.getAdmin(ademail);
						System.out.println("Select any option below");
						System.out.println("1. Movies Zone");
						System.out.println("2. Series Zone");
						int choice2=sc.nextInt();
						do {
							switch(choice2) {
							case 1:
								System.out.println("------------------------------------------------");
								System.out.println("		Welcome to Movies Zone");
								System.out.println("------------------------------------------------");
								System.out.println("Select any option below");
								System.out.println("1. Display Movies");
								System.out.println("2. Insert Movies");
								System.out.println("3. Update Movies");
								System.out.println("4. Delete Movies");
								int choice3 = sc.nextInt();
								movie mv=new movie();
								try {
									do {
										switch(choice3) {
										case 1:
											mv.connect();
											System.out.println("Displaying Movies");
											mv.displaymovie();		
											break;
										case 2:
											mv.connect();
											System.out.println("Enter movie id:");
											int id=sc.nextInt();
											sc.nextLine();
											System.out.println("Enter movie name:");
											String name=sc.nextLine();
											System.out.println("Enter movie genre:");
											String genre=sc.nextLine();
											System.out.println("Enter movie platform:");
											String platform=sc.nextLine();
											System.out.println("Enter movie production house:");
											String productionHouse=sc.nextLine();
											mv.insertmovie(id, name, genre, platform, productionHouse);
											System.out.println("Movie Inserted.");
											break;
										case 3:
											mv.connect();
											System.out.println("Enter movie id:");
											int mid=sc.nextInt();
											sc.nextLine();
											System.out.println("Enter movie name:");
											String mname=sc.nextLine();
											mv.updatemovie(mname, mid);	
											System.out.println("Movie Updated.");
											break;
										case 4:
											mv.connect();
											System.out.println("Enter movie id:");
											int movieid=sc.nextInt();
											mv.deletemovie(movieid);	
											System.out.println("Movie Deleted.");
											break;	
										default:
											System.out.println("Incorrect choice....");
											break;
										}
										System.out.println("------------------------------------------------");
										System.out.println("		Welcome to Movies Zone");
										System.out.println("------------------------------------------------");
										System.out.println("Select any option below");
										System.out.println("1. Display Movies");
										System.out.println("2. Insert Movies");
										System.out.println("3. Update Movies");
										System.out.println("4. Delete Movies");
										System.out.println("5. Go to previous screen");
										int choice4 = sc.nextInt();	
										choice3=choice4;
									}while(choice3!=5);
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
									System.out.println("Select any option below");
									System.out.println("1. Display Series");
									System.out.println("2. Insert Series");
									System.out.println("3. Update Series");
									System.out.println("4. Delete Series");
									int choice4 = sc.nextInt();
									series sr=new series();
									do {
										switch(choice4) {
										case 1:
											sr.connect();
											System.out.println("Displaying Series");
											sr.displayseries();											
											break;
										case 2:	
											sr.connect();
											System.out.println("Enter serie id:");
											int id=sc.nextInt();
											sc.nextLine();
											System.out.println("Enter serie name:");
											String name=sc.nextLine();
											System.out.println("Enter serie genre:");
											String genre=sc.nextLine();
											System.out.println("Enter serie platform:");
											String platform=sc.nextLine();
											System.out.println("Enter serie production house:");
											String productionHouse=sc.nextLine();
											System.out.println("Enter number of episodes:");
											int episodes=sc.nextInt();
											System.out.println("Enter number of seasons:");
											int seasons=sc.nextInt();
											sr.insertseries(id, name, genre, platform, productionHouse,episodes,seasons);	
											System.out.println("Serie Inserted.");
											break;
										case 3:
											sr.connect();
											System.out.println("Enter serie id:");
											int sid=sc.nextInt();
											sc.nextLine();
											System.out.println("Enter serie name:");
											String sname=sc.nextLine();
											sr.updateseries(sname, sid);	
											System.out.println("Serie Updated.");
											break;
										case 4:
											sr.connect();
											System.out.println("Enter serie id:");
											int serieid=sc.nextInt();
											sr.deleteseries(serieid);	
											System.out.println("Serie Deleted.");
											break;
										default:
											System.out.println("Incorrect choice....");
											}
										System.out.println("------------------------------------------------");
										System.out.println("		Welcome to Series Zone");
										System.out.println("------------------------------------------------");
										System.out.println("Select any option below");
										System.out.println("1. Display Series");
										System.out.println("2. Insert Series");
										System.out.println("3. Update Series");
										System.out.println("4. Delete Series");
										System.out.println("5. Go to previous screen");
										int choice5 = sc.nextInt();
										choice4=choice5;
									}while(choice4!=5);	
								}
								catch(Exception e) {
									e.printStackTrace();
								}			
								break;
							default:
								System.out.println("Incorrect choice!");
								break;
							}
							System.out.println("Select any option below");
							System.out.println("1. Movies Zone");
							System.out.println("2. Series Zone");
							System.out.println("3. Go to previous screen");
							int choice5=sc.nextInt();
							choice2=choice5;
						}while(choice2!=3);	
					}
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}	
				
				break;
				default:
					System.out.println("Incorrect choice....");
					break;
			}
			
			System.out.println("------------------------------------------------");
			System.out.println("		Welcome to Entertainment Zone");
			System.out.println("------------------------------------------------");
			System.out.println("Select any option below");
			System.out.println("1. User Registeration ");
			System.out.println("2. User Sign In");
			System.out.println("3. Admin Sign In");
			System.out.println("4. Exit");
			int x=sc.nextInt();
			choice1=x;
			}while(choice1!=4);
		System.out.println("------------------------------------------------");
		System.out.println("		THANK YOU");
		System.out.println("------------------------------------------------");
	}
}
