/******45J lab***********
//Yung-Chu Chuang 50926235
//tzulingw Tzu-Ling Wang	77721457
//----------------------------------
//this file contains director object, and we used setter
//methods to set the vales and getters to get the 
//info that we are asking for. 
************************/

//constructor
public class Director
{
	/*
	 String - first name of Director
	 String - last name of Director
	 int - birth year of Director
	 int - number of films the director has directed
	 */
	private String FirstName;
	private String LastName;
	private int BirthYear;
	private int NumOfFilm;
	
	//default constructor
	public Director(){
	}
	
	//Copy Contructor
	public Director(String first, String last, int year, int film)	{
		this.FirstName = first;
		this.LastName = last;
		this.BirthYear = year;
		this.NumOfFilm = film;
	}
	
	//Setters
	public void setFirstName(String first)
	{
		this.FirstName = first;
	}
	public void setLastName(String last)
	{
		this.LastName = last;
	}
	public void setBirthYear(int year)
	{
		this.BirthYear = year;
	}
	public void setNumOfFilm(int film)
	{
		this.NumOfFilm = film;
	}

	//Getters
	public String getFirstName()
	{
		return FirstName;
	}
	public String getLastName()
	{
		return LastName;
	}
	public String getFullName()
	{
		return (FirstName + " " + LastName);
	}
	public int getBirthYear()
	{
		return BirthYear;
	}
	public int getNumOfFilme()
	{
		return NumOfFilm;
	}
}