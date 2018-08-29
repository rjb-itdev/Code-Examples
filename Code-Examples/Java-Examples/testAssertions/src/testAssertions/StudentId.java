package testAssertions;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class StudentId{
	
	
	private List<Integer> idList = new ArrayList<Integer>();
	private int maximum = 999_999_999;
	private int minimum = 100_000_000;
	
	public int generateRandomId()
	{
		Random rn  = new Random();
		int n = maximum - minimum;
		int i = rn.nextInt() % n;
		int id = minimum - i;
		if(checkIdLength(id) && checkIdRange(id)) {	
			if(!idList.contains(id))
			{				
				idList.add(id);
				return id;
			}
			System.out.println("Id exists");
		}
		return generateRandomId();
	}
	
	private boolean checkIdLength(int id)
	{
		if(String.valueOf(id).length() == 9){
			return true;
		}
		else
		{
			return false;
		}
	}
	private boolean checkIdRange(int id)
	{
		assert id >= 100_000_000;
		assert id <= 999_999_999;
		if(id >= 100_000_000 && id <= 999_999_999 && checkIdLength(id))
		{
			return true;
		}
		return false;
	}
}
