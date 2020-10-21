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

// SpeakerGUI Class
public class SpeakerGUI extends JFrame {
	private JLabel name,
    			   email,
    			   organization,
    			   title,
    			   address,
    			   city,
    			   vDate,
    			   course,
    			   section,
    			   faculty_name,
    			   semester;
    
	private JTextField spkNameTF,
        			   spkEmailTF,
        			   spkOrgTF,
        			   spkTitleTF,
        			   spkAddressTF,
        			   spkCityTF,
        			   vDateTxt,
        			   monthTF,
        			   dayTF,
        			   yearTF,
        			   fclNameTF,
        			   fclCourseTF,
        			   fclSectionTF; 

	private JButton AutoButton, 
     				submitButton, 
     				reportButton, 
     				searchButton, 
     				clearButton, 
     				updateButton;
	private JTextArea display;
	private ButtonGroup optionGroup = new ButtonGroup();
	private JRadioButton semesterOption[] = new JRadioButton[4];
	private String semesterOptionLabels[] = {"Fall","Spring","Summer1","Summer2"};

	private JPanel enterPersonPanel,
    			   radioButtonPanel, 
    			   displayPanel,
    			   buttonPanel;

	private InfoRecord a; 
	private Boolean check;

	public SpeakerGUI() {
		super("Enter Information");
		setLayout(new GridLayout(4, 4, 4,4));

		enterPersonPanel = createEnterContent();
		add(enterPersonPanel);
		radioButtonPanel = createRadioButtonPanel();
		add(radioButtonPanel);
		displayPanel = createDisplayPanel();
		add(displayPanel);
		buttonPanel = createButtonPanel();
		add(buttonPanel);
		
		a = new InfoRecord ();
		check = false;
		
		setSize(512, 512);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	// Panel Methods
	public JPanel createEnterContent() 
 	{
 		name = new JLabel("Name: ",SwingConstants.RIGHT);
 		organization = new JLabel("Organization: ",SwingConstants.RIGHT);
 		address = new JLabel("Address: ",SwingConstants.RIGHT);
 		vDate = new JLabel("Visiting Date: ",SwingConstants.RIGHT);
 		title = new JLabel("Title: ",SwingConstants.RIGHT);
 		email = new JLabel("Email: ",SwingConstants.RIGHT);
 		city = new JLabel("City: ",SwingConstants.RIGHT);
 		
 		spkNameTF = new JTextField(25);
 		spkEmailTF = new JTextField(25);		
 		spkOrgTF = new JTextField(25);
 		spkTitleTF = new JTextField(25);
 		spkAddressTF = new JTextField(25);
 		spkCityTF = new JTextField(25);
 		vDateTxt = new JTextField(25);	
 		
 		AutoButton = new JButton("Autofill");
 	  
        enterPersonPanel = new JPanel();
 		enterPersonPanel.setLayout(new GridLayout(4,6,4,4));
 		enterPersonPanel.setBorder(BorderFactory.createTitledBorder("Speaker Information"));
 		enterPersonPanel.setBackground(Color.lightGray);
 		enterPersonPanel.add(name);
 	    enterPersonPanel.add(spkNameTF);
 	    enterPersonPanel.add(email);
		enterPersonPanel.add(spkEmailTF);
 		enterPersonPanel.add(organization);
 		enterPersonPanel.add(spkOrgTF);
 		enterPersonPanel.add(title);
 		enterPersonPanel.add(spkTitleTF);
 		enterPersonPanel.add(address);
 	    enterPersonPanel.add(spkAddressTF);
 		enterPersonPanel.add(city);
 		enterPersonPanel.add(spkCityTF);
		enterPersonPanel.add(vDate);
 	    enterPersonPanel.add(vDateTxt);
 	    enterPersonPanel.add(AutoButton);
 		return enterPersonPanel;
 	} 
     
    public JPanel createRadioButtonPanel() 
 	{
    	faculty_name = new JLabel("Name: ",SwingConstants.RIGHT);
  		course = new JLabel("Course: ",SwingConstants.RIGHT);
  		section = new JLabel("Section: ",SwingConstants.RIGHT);
 		semester = new JLabel("Semester: ",SwingConstants.RIGHT);

  		fclNameTF = new JTextField(20);
  		fclCourseTF = new JTextField(20);		
  		fclSectionTF = new JTextField(20);
 		
 		radioButtonPanel = new JPanel();
 		radioButtonPanel.setLayout(new GridLayout(1,2));
 		radioButtonPanel.setBorder(BorderFactory.createTitledBorder("Faculty Information"));
 		radioButtonPanel.setBackground(Color.lightGray);
 		
 		JPanel fclEntryPanel = new JPanel();
 		fclEntryPanel.setLayout(new GridLayout(3,2,4,10));
 		fclEntryPanel.setBackground(Color.lightGray);
 		fclEntryPanel.add(faculty_name);
 		fclEntryPanel.add(fclNameTF);
 		fclEntryPanel.add(course); 		
 		fclEntryPanel.add(fclCourseTF);
 		fclEntryPanel.add(section);
 		fclEntryPanel.add(fclSectionTF);
 		radioButtonPanel.add(fclEntryPanel);
        
    	JPanel semesterPanel = new JPanel();
    	semesterPanel.setLayout(new GridLayout(4,2));
 		semesterPanel.setBackground(Color.lightGray);
    	semesterPanel.add(semester);
 		for(int i = 0; i < semesterOption.length-1; i++)
 		{
 			semesterOption[i] = new JRadioButton(semesterOptionLabels[i]);
 			semesterOption[i].setBackground(Color.lightGray);
 			semesterPanel.add(semesterOption[i]);
 	 		semesterPanel.add(new JLabel(""));
 			optionGroup.add(semesterOption[i]);
 		}
 		int i2 = semesterOption.length-1;
 		semesterOption[i2] = new JRadioButton(semesterOptionLabels[i2]);
 		semesterOption[i2].setBackground(Color.lightGray);
 		semesterPanel.add(semesterOption[i2]);
 		optionGroup.add(semesterOption[i2]);
 		semesterOption[0].setSelected(true);
 		radioButtonPanel.add(semesterPanel);
 		
 		return radioButtonPanel;
 	}
      
    public JPanel createButtonPanel() 
 	{
 		ButtonHandler handler = new ButtonHandler();
 		buttonPanel = new JPanel();
 		buttonPanel.setLayout(new GridLayout(4,6,7,8));
 		buttonPanel.setBorder(BorderFactory.createTitledBorder(""));
 		buttonPanel .setBackground(Color.lightGray);
 		
 		submitButton = new JButton("Submit");
 		buttonPanel.add(submitButton);
 		submitButton.addActionListener(handler);
 		
 		reportButton = new JButton("Create Report");
 		buttonPanel.add(reportButton);
 		
 		searchButton = new JButton("Search");
 		buttonPanel.add(searchButton);
 		
 		updateButton = new JButton("UPDATE");
 		buttonPanel.add(updateButton);
 		
 		clearButton = new JButton("Clear");
 		buttonPanel.add(clearButton);
 		
 		return buttonPanel;
 	}
     
 	public JPanel createDisplayPanel()
 	{
 		displayPanel = new JPanel();
 		displayPanel.setBorder(BorderFactory.createTitledBorder(""));
 		displayPanel.setBackground(Color.LIGHT_GRAY);
 		display = new JTextArea(50, 50);
 		display.setEditable(false);
 		displayPanel.add(display);
 		
 		return displayPanel;
 	}
	
	// ButtonHandler Class
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
						dayStr = "0" + day;
					}
					else {
						dayStr = "" + day;
					}
					yearStr = "" + year;
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
						String semester = "";
						for (int i = 0; i<semesterOption.length; i++) {
							if (semesterOption[i].isSelected()) {
								semester = semesterOption[i].getText();
							}
						}
						newRecord.setFacultyInfo(fclNameTF.getText(),fclCourseTF.getText(),fclSectionTF.getText(),semester);
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
				/*
				oldSpkName = dataName;
				oldDate = dataDate;
				check = true;
				*/
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
