/******45J lab***********
//Yung-Chu Chuang 50926235
//tzulingw Tzu-Ling Wang	77721457
//----------------------------------
//this file contains main, and it presents 
//all the movie info by using the to.string method.
************************/

public class Lab1
{
	public static void main(String[] args){

		// Create a new movie with default values for all attributes
		Movie movie = new Movie();

		// Set the appropriate fields for the book’s objects 
		movie.setTitle("Harry Potter and the Philosopher's Stone"); 
		movie.setPrice(3.99); 
		movie.setReleasedYear(2001); 
		movie.setDuration(152); 
		movie.setDirector("Chris", "Columbus", 1958, 20);

		// Prints out the state of the movie. 
		System.out.println(movie.toString());

		Movie HarryPotter1 = new Movie(152, 2001, 3.99, "Harry Potter and the Philosopher's Stone", new Director("Chris", "Columbus", 1958, 20));
		
		
		//test runs
		System.out.println("*****************************TEST RUN*********************************");
		//print out the state of the object
		System.out.println(HarryPotter1.toString());
		System.out.println("************************END OF TEST RUN****************************");
	}
}