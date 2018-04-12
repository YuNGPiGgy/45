public class Movie
{
	/*
	int - duration of the movie in minutes
	int - year the movie was released
	double - price of the movie in USD
	String - title of the movie
	Director – an object representing the Director of the movie 
		(for this assignment, you may assume the movie has only one director).
	*/
	private int Duration;
	private int ReleasedYear;
	private double Price;
	private String Title;
	private Director Director;
	
	public Movie()
	{
	}
	public Movie(int time, int year, double price, String title, Director director)
	{
		this.Duration = time;
		this.ReleasedYear = year;
		this.Price = price;
		this.Title = title;
		this.Director = director;
	}
	//Setters
	public void setDuration(int time)
	{
		this.Duration = time;
	}
	public void setReleasedYear(int year)
	{
		this.ReleasedYear = year;
	}
	public void setPrice(double price)
	{
		this.Price = price;
	}
	public void setTitle(String title)
	{
		this.Title = title;
	}
	public void setDirector(String first, String last, int birthYear, int films)
	{
		this.Director = new Director(first, last, birthYear, films);
	}
	//Getters
	public int getDuration()
	{
		return Duration;
	}
	public int getReleasedYear()
	{
		return ReleasedYear;
	}
	public double getPrice()
	{
		return Price;
	}
	public String getTitle()
	{
		return Title;
	}
	public Director getDirector()
	{
		return Director;
	}

	public String toString()
	{
		return("Title: " + this.getTitle() + 
				"\nPublished in: " + this.getReleasedYear() +
				"\nDuration: " + this.getDuration() + " minutes" +
				"\nPrice: $" + this.getPrice() +
				"\nDirected by " + this.getDirector().getFullName() + 
				", who was born in " + this.getDirector().getBirthYear() +
				" and has " + this.getDirector().getNumOfFilme() + " release(s).");
	}
	
}