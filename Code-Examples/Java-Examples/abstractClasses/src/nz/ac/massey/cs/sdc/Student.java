package nz.ac.massey.cs.sdc;

public class Student {

	String name;
	String lName;
	
	public void edit()
	{
		Form form = new Form();
		form.display();
	}
	
	
	class Form
	{
		public void display()
		{
			System.out.println("This is a violation where the presentation layer relies on the Domain layer (Student)");
		}
	}
}
