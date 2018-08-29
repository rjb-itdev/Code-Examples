package nz.ac.massey.sdc.rjb;
import java.util.logging.Logger;

import nz.ac.massey.sdc.cs.rjb.*;
public class Main {

	
	public static void main(String[] args) {
		//Invisible person is visible because class is public.
		//Default is protected, then it is not visible in this file
		InvisiblePerson p = new InvisiblePerson();
		
		
		p.setAge(30);
		p.setName("Ross");
		p.setlName("Bell");
		
		p.createLeg("Left", 10, 10);
		p.createLeg("Right", 11, 10);
		
		System.out.println(p.getName());
		System.out.println(p.getlName());
		System.out.println(p.getAge());
		
	}
	

}



