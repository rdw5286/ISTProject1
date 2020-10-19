// Package
package package1;

// Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class SpeakerGUI {
	
	public SpeakerGUI() {
		
	}
	
	class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String oldSpkName = "";
			String oldDate = "";
			Object source = e.getSource();
			if (submitButton.equals(source)) {
				// Submit Information
				try {
					// Get Speaking Date
					int month = Integer.parseInt(monthTF.getText());
					int day = Integer.parseInt(dayTF.getText());
					int year = Integer.parseInt(dayTF.getText());
					// Check Speaking Date
					if(!checkDate(month,day,year)) {
						return;
					}
						
					// Format Speaking Date
					String monthStr, dayStr, yearStr;
					if (month < 10) {
						monthStr = "0" + month;
					}
					else {
						monthStr = "" + month;
					}
					if (day < 10) {
						monthStr = "0" + day;
					}
					else {
						monthStr = "" + day;
					}
					// Set Speaking Date & Current Date
					String myDate = monthStr + "/" + dayStr + "/" + yearStr;
					LocalDateTime localDateTime = LocalDateTime.parse(myDate,DateTimeFormatter.ofPattern("MM/dd/yyyy"));
					long speakTime = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();	
					Date date = new Date();
					long curTime = date.getTime();
					
					// Check Speaking Date VS Current Date
					final int TIME_DIF = 1000*(7*24*60*60);
					if (TIME_DIF > curTime - speakTime) {
						JOptionPane.showMessageDialog(null, "Current date must be at least 1 week before speaking date.", "Invalid Date", JOptionPane.WARNING_MESSAGE);
					}
					else {
						// Create Object & Set Info
						InfoRecord newRecord = new InfoRecord();
						newRecord.setSpeakerInfo(spkNameTF.getText(),spkTitleTF.getText(),spkOrgTF.getText(),
												spkAddressTF.getText(),spkCityTF.getText(),spkEmailTF.getText());
						newRecord.setFacultyInfo(fclNameTF.getText(),fclCourseTF.getText(),fclSectionTF.getText());
						newRecord.setDate(month,day,year);
						
						// Determine Submit Style
						if (check) {
							/* Delete database info */
						}
						
						// Save Information
						/* Database Class & Info Pass Here */
					}
				} catch(NumberFormatException error) {
					JOptionPane.showMessageDialog(null, error.toString(), "Invalid Date", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if (clearButton.equals(source)) {
				// Clear Text Fields
				spkNameTF.setText("");
				spkEmailTF.setText("");
				spkOrgTF.setText("");
				spkTitleTF.setText("");
				spkAddressTF.setText("");
				spkCityTF.setText("");
				fclNameTF.setText("");
				fclCourseTF.setText("");
				fclSectionTF.setText("");
				monthTF.setText("");
				dayTF.setText("");
				yearTF.setText("");
			}
			else if (reportButton.equals(source)) {
				// Create Report
				/* Gather information and create a InfoRecord object for each row of the database. Afterward, call the 
				 * toString method for the object and copy the text over to a txt file. Do this process for all rows of the 
				 * database, and the report will be complete.
				 */
			}
			else if (searchButton.equals(source)) {
				// Search Speaker
				/* Search through database and add all occurrences of name and date. After searching, if the record occurs 
				 * 0 times, the program will output that the information is not recorded. If there is 1 record, then the 
				 * information is printed out. If there is more than 1, the user will chose which record they are interested 
				 * in (Based on course and section)
				 */
			}
			else {
				// Update Info
				/* Search through database and add all occurrences of name and date. Once the record is found (using the 
				 * method described in the searchButton action), we will set a check variable to 1 to change the way we 
				 * submit the information. Next, we will input all needed info into the TFs and then let the user edit 
				 * them. Once the submit button is pressed, the old record will be deleted and the new information shall 
				 * be added.
				 */
				
				// Change Program Variables
				oldSpkName = dataName;
				oldDate = dataDate;
				check = true;
			}
		}
	}
	
	/**
	 * This method checks the values provided for the speaking date and determines if said date exists.
	 * 
	 * @param month	Month of Speaking Date
	 * @param day	Day of Speaking Date
	 * @param year	Year of Speaking Date
	 * @return		Validity of Date (True or False)
	 */
	public Boolean checkDate(int month, int day, int year) {
		// Check Date Validity
		if (month < 1 || month > 12 || day > 31 || day < 1 || year < 1970) {
			// Invalid General Date
			JOptionPane.showMessageDialog(null, "Nonexistant Date Entered", "Invalid Date", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if ((month == 4 || month == 6 || month == 9 || month == 11) && (day > 30)) {
			// Invalid 30 Day Date
			JOptionPane.showMessageDialog(null, "Nonexistant Date Entered", "Invalid Date", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (month == 2 && ((day > 29 && (year % 4 == 0)) || (day > 28 && (year % 4 == 0)))) {
			// Invalid February Date
			JOptionPane.showMessageDialog(null, "Nonexistant Date Entered", "Invalid Date", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		// Date is Valid
		return true;
	}
	
	/**
	 * Initiates the program
	 * 
	 * @param args	Default parameter for main method
	 */
	public static void main(String[] args) {
		// Create Interface
		SpeakerGUI window = new SpeakerGUI();
	}
}
// End of Class
