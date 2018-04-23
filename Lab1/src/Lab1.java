/******45J lab***********
Yung-Chu Chuang 50926235
tzulingw Tzu-Ling Wang	77721457
----------------------------------
this file is our main, and it does test run by using the to.string method.

************************/

public class Lab1
{
	public static void main(String[] args){
		Movie HarryPotter1 = new Movie(152, 2001, 3.99, "Harry Potter and the Philosopher's Stone", new Director("Chris", "Columbus", 1958, 20));
		Movie HarryPotter2 = new Movie(161, 2002, 3.99, "Harry Potter and the Chamber of Secrets", new Director("Chris", "Columbus", 1958, 20));
		Movie HarryPotter3 = new Movie(142, 2004, 5.99, "Harry Potter and the Prisoner of Azkaban", new Director("Alfonso", "Cuar鏮", 1961, 17));
		Movie HarryPotter4 = new Movie(157, 2005, 5.99, "Harry Potter and the Goblet of Fire", new Director("Mike", "Newell", 1942, 80));
		Movie HarryPotter5 = new Movie(138, 2007, 10.99, "Harry Potter and the Order of the Phoenix", new Director("David", "Yates", 1963, 27));
		Movie HarryPotter6 = new Movie(153, 2009, 10.99, "Harry Potter and the Half-Blood Prince", new Director("David", "Yates", 1963, 27));
		Movie HarryPotter7_1 = new Movie(146, 2010, 19.99, "Harry Potter and the Deathly Hallows � Part 1", new Director("David", "Yates", 1963, 27));
		Movie HarryPotter7_2 = new Movie(130, 2011, 19.99, "Harry Potter and the Deathly Hallows � Part 2", new Director("David", "Yates", 1963, 27));
	
		System.out.println("*****************************TEST RUN*********************************");
		System.out.println(HarryPotter1.toString());
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println(HarryPotter2.toString());
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println(HarryPotter3.toString());
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println(HarryPotter4.toString());
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println(HarryPotter5.toString());
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println(HarryPotter6.toString());
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println(HarryPotter7_1.toString());
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println(HarryPotter7_2.toString());
		System.out.println("************************END OF TEST RUN****************************");
	}
}