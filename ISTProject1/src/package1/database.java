package package1;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class database 
{
     static final String DATABASE_URL = "jdbc:ucanaccess://D:/Microsoft Access Files/speaker.accdb";
     Connection connection = null;
     Statement statement = null;
     ResultSet resultSet = null;
     PreparedStatement insertSpkInfo = null; 
 
     public database() {
	 		 try 
        	 {
        		 System.out.println("Starting database connection");
        		 // establish connection to database 
        		 connection = DriverManager.getConnection(DATABASE_URL);
        		 System.out.println("Made a connection");
                  
        		 // create statement for querying the database
        		 statement = connection.createStatement();
        		 System.out.println("Established statement");
        		 
        		 resultSet = statement.executeQuery("SELECT spkName, spkEmail,spkOrg,spkTitle, spkAddress, spkCity, month, day, year, fclName, fclCourse, fclSection, semester FROM TestInfo");
        		 
        		 System.out.println("Have a resultSet");
        	 }
        	 catch (SQLException sqlex)
        	 {
        		 JOptionPane.showMessageDialog(null, sqlex.getMessage(),"Database Error", JOptionPane.ERROR_MESSAGE);
        	 }
     }
         
     public int addSpkInfo(String speaker_name,String email,String organization, String title,  String a8ddress, String city, int month, int day, int year, 
        		 String faculty_name, String course, String section, String semesterSpeakerInv,String gift) 
         {
        	 int result = 0;
        	 
        	 try 
        	 {
        		 connection = DriverManager.getConnection(DATABASE_URL);
        		 insertSpkInfo = connection.prepareStatement("INSERT INTO TestInfo (spkName, spkEmail,spkOrg,spkTitle, spkAddress, spkCity, month, day, year, fclName, fclCourse, fclSection, semester,gift)"
        		 		+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS );
        		 insertSpkInfo.setString(1,speaker_name);
        		 insertSpkInfo.setString(2,email);
        		 insertSpkInfo.setString(3,organization);
        		 insertSpkInfo.setString(4,title);
        		 insertSpkInfo.setString(5,a8ddress);
        		 insertSpkInfo.setString(6,city);
        		 insertSpkInfo.setInt(7,month);
        		 insertSpkInfo.setInt(8,day);
        		 insertSpkInfo.setInt(9,year);
        		 insertSpkInfo.setString(10, faculty_name);
        		 insertSpkInfo.setString(11, course);
        		 insertSpkInfo.setString(12, section);
        		 insertSpkInfo.setString(13, semesterSpeakerInv);	 
        		 insertSpkInfo.setString(14, gift);	 

        		 result = insertSpkInfo.executeUpdate();

        		 if (result == 1)
        		 {
        			 JOptionPane.showMessageDialog(null, "Record Insert Completed",speaker_name,JOptionPane.INFORMATION_MESSAGE);
        		 }
        		 else if (result == 0) 
        		 {
        			 JOptionPane.showMessageDialog(null, "Record Insert Failed", speaker_name,JOptionPane.ERROR_MESSAGE);
        		 }

        	 }
        	 catch  (SQLException sqlex)
        	 {
        		 JOptionPane.showMessageDialog(null, sqlex.getMessage(),"Database Insert Failed", JOptionPane.ERROR_MESSAGE);
                  result = 0;
                  
        	 }
        	 finally 
        	 {
        		 try 
        		 {
        			 
        		    statement.close();
        		    connection.close();
        		    System.out.println("Closing Statement and connection to database");
        		 }
        		 
        		 catch (SQLException sqlex) 
        		 {
        			 JOptionPane.showMessageDialog(null,sqlex.getMessage(),"Database Close Error",JOptionPane.ERROR_MESSAGE);
        		     System.exit(1); 
        		 }
        	 }
        	 
        	 return result;
     }
         
     public int updateInfo(String speaker_name,String email,String organization, String title,  String a8ddress, String city, int month, int day, int year, 
        		 String faculty_name, String course, String section, String semesterSpeakerInv,String gift, int rowId) 
         {

        	 PreparedStatement updateInfo=null;
        	 
        	 int result = 1;
        	    
        	 try 
        	 {	 
        		 updateInfo = connection.prepareStatement("UPDATE TestInfo SET (spkName, spkEmail,spkOrg,spkTitle, spkAddress, spkCity, month, day, year, fclName, fclCourse, fclSection, semester,gift)"
         		 		+ " = (?,?,?,?,?,?,?,?,?,?,?,?,?,?) WHERE (ID) = (?)", Statement.RETURN_GENERATED_KEYS);
        		 updateInfo.setString(1,speaker_name);
        		 updateInfo.setString(2,email);
        		 updateInfo.setString(3,organization);
        		 updateInfo.setString(4,title);
        		 updateInfo.setString(5,a8ddress);
        		 updateInfo.setString(6,city);
        		 updateInfo.setInt(7,month);
        		 updateInfo.setInt(8,day);
        		 updateInfo.setInt(9,year);
        		 updateInfo.setString(10, faculty_name);
        		 updateInfo.setString(11, course);
        		 updateInfo.setString(12, section);
        		 updateInfo.setString(13, semesterSpeakerInv);	 
        		 updateInfo.setString(14, gift);
        		 updateInfo.setInt(15, rowId);
        		 result = updateInfo.executeUpdate();

        		 if (result == 1)
        		 {
        			 JOptionPane.showMessageDialog(null, "Record Update Completed", "Update Complete",JOptionPane.INFORMATION_MESSAGE);
        		 }
        		 else if (result == 0) 
        		 {
        			 JOptionPane.showMessageDialog(null, "Record Update Failed", "Update Failed",JOptionPane.ERROR_MESSAGE);
        		 }

        	 }
        	 catch  (SQLException sqlex)
        	 {
        		 JOptionPane.showMessageDialog(null, sqlex.getMessage(),"Database Update Failed", JOptionPane.ERROR_MESSAGE);
                  result = 0;
                  
        	 }
        	 finally 
        	 {
        		 try 
        		 {
        			 
        		    statement.close();
        		    connection.close();
        		    System.out.println("Closing Statement and connection to database");
        		 }
        		 
        		 catch (SQLException sqlex) 
        		 {
        			 JOptionPane.showMessageDialog(null,sqlex.getMessage(),"Database Close Error",JOptionPane.ERROR_MESSAGE);
        		     System.exit(1); 
        		 }
        	 }
        	 
        	 return result;
     }
     
	// Searches the Database
	public ArrayList<InfoRecord> searchInfo(String speaker_name, int month, int day, int year, Boolean check) {
			String searchInfo = null;
			ArrayList<InfoRecord> recordList = null;
			try {

				searchInfo = "SELECT * FROM TestInfo";
				connection = DriverManager.getConnection(DATABASE_URL);
				statement = connection.createStatement();

				ResultSet rs = statement.executeQuery(searchInfo);
				recordList = new ArrayList<InfoRecord>();
				while (rs.next()) {
					if (rs.getString("spkName").equals(speaker_name) && rs.getInt("month") == month && rs.getInt("day") == day && rs.getInt("year") == year) {
					String tempSpkName = rs.getString("spkName");
					String tempSpkEmail = rs.getString("spkEmail");
					String tempSpkOrg = rs.getString("spkOrg");
					String tempSpkTitle = rs.getString("spkTitle");
					String tempSpkAddress = rs.getString("spkAddress");
					String tempSpkCity = rs.getString("spkCity");
					int tempMonth = rs.getInt("month");
					int tempDay = rs.getInt("day");
					int tempYear = rs.getInt("year");
					String tempFclName = rs.getString("fclName");
					String tempFclCourse = rs.getString("fclCourse");
					String tempFclSection = rs.getString("fclSection");
					String tempSemester = rs.getString("semester");
					String tempGift = rs.getString("gift");

					InfoRecord tempRecord;
					tempRecord = new InfoRecord();

					tempRecord.setSpeakerInfo(tempSpkName, tempSpkEmail, tempSpkOrg, tempSpkTitle, tempSpkAddress,
							tempSpkCity);
					tempRecord.setFacultyInfo(tempFclName, tempFclCourse, tempFclSection, tempSemester);
					tempRecord.setDate(tempMonth, tempDay, tempYear);
					tempRecord.setGift(tempGift);
					if (check) {
						int tempID = rs.getInt("ID");
						tempRecord.setRowID(tempID);
					}
					recordList.add(tempRecord);
					}
				}
			} catch (SQLException sqlex) {
				JOptionPane.showMessageDialog(null, sqlex.getMessage(), "Database Search Failed",
						JOptionPane.ERROR_MESSAGE);

			} finally {
				try {

					statement.close();
					connection.close();
					System.out.println("Closing Statement and connection to database");
				}

				catch (SQLException sqlex) {
					JOptionPane.showMessageDialog(null, sqlex.getMessage(), "Database Close Error",
							JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
			}

			return recordList;
	}
		
	// Return Database
	public ArrayList<InfoRecord> getDatabase(int year) {	    
			String getInfo = null;
			ArrayList<InfoRecord> recordList = null;
			try {
				getInfo = "SELECT * FROM TestInfo;";
				connection = DriverManager.getConnection(DATABASE_URL);
				statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(getInfo);

				recordList = new ArrayList<InfoRecord>();
				while (rs.next())
				{
			        if ((rs.getInt("year") == year && rs.getString("semester").equals("Fall")) || (rs.getInt("year") == year+1 && rs.getString("semester").equals("Spring")) || (rs.getInt("year") == year+1 && rs.getString("semester").equals("Summer 1")) || (rs.getInt("year") == year+1 && rs.getString("semester").equals("Summer 2"))) {
						String tempSpkName = rs.getString("spkName");
				        String tempSpkEmail =rs.getString("spkEmail");
				        String tempSpkOrg = rs.getString("spkOrg");
				        String tempSpkTitle = rs.getString("spkTitle");
				        String tempSpkAddress = rs.getString("spkAddress");
				        String tempSpkCity = rs.getString("spkCity");
				        int tempMonth = rs.getInt("month");
				        int tempDay = rs.getInt("day");
				        int tempYear = rs.getInt("year");
				        String tempFclName = rs.getString("fclName");
				        String tempFclCourse = rs.getString("fclCourse");
				        String tempFclSection = rs.getString("fclSection");
				        String tempSemester = rs.getString("semester");
				        String tempGift = rs.getString("gift");
				       
				        InfoRecord tempRecord;
				        tempRecord = new InfoRecord();
				        
				        tempRecord.setSpeakerInfo(tempSpkName,tempSpkEmail,tempSpkOrg, tempSpkTitle, tempSpkAddress, tempSpkCity);
				        tempRecord.setFacultyInfo(tempFclName, tempFclCourse, tempFclSection, tempSemester);
				        tempRecord.setDate(tempMonth, tempDay, tempYear);
				        tempRecord.setGift(tempGift);
				       
				        recordList.add(tempRecord);
			        }
				}
			} catch (SQLException sqlex) {
				JOptionPane.showMessageDialog(null, sqlex.getMessage(), "Database Return Failed",
						JOptionPane.ERROR_MESSAGE);

			} finally {
				try {

					statement.close();
					connection.close();
					System.out.println("Closing Statement and connection to database");
				}

				catch (SQLException sqlex) {
					JOptionPane.showMessageDialog(null, sqlex.getMessage(), "Database Close Error",
							JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
			}
			return recordList;	
	}
		
	public ArrayList<String> returnGift(String speaker_name) 
    {
       	String returnGift;
       	ArrayList<String> prevGifts = null;
       	try {
       		returnGift = "SELECT spkName, gift FROM TestInfo";
       		connection = DriverManager.getConnection(DATABASE_URL);
       		statement = connection.createStatement();
       		ResultSet resultSet = statement.executeQuery(returnGift);

			prevGifts = new ArrayList<String>();

       		while(resultSet.next())
       		{
       			if (resultSet.getString("spkName").equals(speaker_name)) {
       				prevGifts.add(resultSet.getString("gift"));
       			}
    		}
       	 }
       	 catch(SQLException sqlex)
       	 {
       		 JOptionPane.showMessageDialog(null, sqlex.getMessage(),"Database Gift Selection Failed", JOptionPane.ERROR_MESSAGE);
       	 }
       	 finally 
       	 {
       		 try 
       		 {
       		    statement.close();
       		    connection.close();
       		    System.out.println("Closing Statement and connection to database");
       		 }
       		 
       		 catch (SQLException sqlex) 
       		 {
       			 JOptionPane.showMessageDialog(null,sqlex.getMessage(),"Database Close Error",JOptionPane.ERROR_MESSAGE);
       		     System.exit(1); 
       		 }
       	 }
   	return prevGifts;
    }
} 
         
