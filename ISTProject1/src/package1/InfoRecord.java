package package1;

public class InfoRecord {
	
	private String speaker_name;
	private String title;
	private String organization;
	private String address;
	private String city;
	private String email;
	private int day;
	private int month;
	private int year;
	private String semester;
	private int timesVisited;
	private String[] gifts;
	
	
	private String faculty_name;
	private String course;
	private String section;
	private String semesterSpeakerInv;
	
	
	// Utilizing default constructor
	
	
	public void setSpeakerInfo(String speaker_name, String title, String organization, String address, String city, 
			String email) {
		this.speaker_name = speaker_name;
		this.title = title;
		this.organization = organization;
		this.address = address;
		this.city = city;
		this.email = email;
		
	}
	
	public void setFacultyInfo(String faculty_name, String course, String section, String semesterSpeakerInv)
	{
		this.faculty_name = faculty_name;
		this.course = course;
		this.section = section;
		this.semesterSpeakerInv = semesterSpeakerInv;
	}
	
	public void setDate(int month, int day, int year)
	{
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public String[] getSpeakerInfo()
    {
        String speaker_info[] = new String[6];
        speaker_info[0]= speaker_name;
        speaker_info[1] =  title;
        speaker_info[2] =  organization;
        speaker_info[3] =  address;
        speaker_info[4] =  city;
        speaker_info[5] =  email;
        
        return speaker_info; 
    }
	
	public String[] getFacultyInfo()
	{
		String faculty_info[] = new String[4];
		faculty_info[0] = faculty_name;
		faculty_info[1] = course;
		faculty_info[2] = section;
		faculty_info[3] = semesterSpeakerInv;
		
		return faculty_info;

	}
	
	public String[] getDate() 
	{
		String spk_date[] = new String[3];
		spk_date[0] = Integer.toString(month);
		spk_date[1] = Integer.toString(day);
		spk_date[2] = Integer.toString(year);

		return spk_date;
		
		
			
	}
	
	public String toString() {
		return "Speaker Name: " + speaker_name + "\n " + "Title: " + title + "\n" + "Organization: " +
		organization + "\n" + "Address: " + address + "\n" + "City: " + city + "\n" + "Email: " + email + "\n" + "Date: " +
		getDate() + "\n" + "Semester: " + semester + "\n\n\n" + "Faculty Member in charge: " + faculty_name + "\n" + "Course: "	+
		course + "\n" + "Section: " + section;
		
	}
	/**
	 * @return the speaker_name
	 */
	public String getSpeaker_name() {
		return speaker_name;
	}

	/**
	 * @param speaker_name the speaker_name to set
	 */
	public void setSpeaker_name(String speaker_name) {
		this.speaker_name = speaker_name;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the semester
	 */
	public String getSemester() {
		return semester;
	}

	/**
	 * @param semester the semester to set
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}

	/**
	 * @return the faculty_name
	 */
	public String getFaculty_name() {
		return faculty_name;
	}

	/**
	 * @param faculty_name the faculty_name to set
	 */
	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}

	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * @return the section
	 */
	public String getSection() {
		return section;
	}

	/**
	 * @param section the section to set
	 */
	public void setSection(String section) {
		this.section = section;
	}

	/**
	 * @return the semesterSpeakerInv
	 */
	public String getSemesterSpeakerInv() {
		return semesterSpeakerInv;
	}

	/**
	 * @param semesterSpeakerInv the semesterSpeakerInv to set
	 */
	public void setSemesterSpeakerInv(String semesterSpeakerInv) {
		this.semesterSpeakerInv = semesterSpeakerInv;
	}
}
