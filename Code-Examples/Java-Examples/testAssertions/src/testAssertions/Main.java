package testAssertions;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student student = new Student();
		student.setAge(35);
		student.setNames("Ross James Bell");
		
		student.setId(student.generateRandomId());
		
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getMiddleNames().length);
		for(String i : student.getMiddleNames())
		{
			System.out.println(i);
		}
		System.out.println(Integer.MAX_VALUE);
	}

}
