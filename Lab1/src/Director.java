public class Director
{
	/*
	 String - first name of Director
	 String – last name of Director
	 int – birth year of Director
	 int – number of films the director has directed
	 */
	private String FirstName;
	private String LastName;
	private int BirthYear;
	private int NumOfFilm;
	
	public Director()
	{
	}
	public Director(String first, String last, int year, int film)
	{
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
		return this.FirstName;
	}
	public String getLastName()
	{
		return this.LastName;
	}
	public int getBirthYear()
	{
		return this.BirthYear;
	}
	public int getNumOfFilme()
	{
		return this.NumOfFilm;
	}
}