package nz.ac.massey.sdc.cs.rjb;

public class InvisiblePerson {
	private String name;
	private String lName;
	private int Age;
	
	private Leg rightLeg = createLeg("right",10,10);
	private Leg leftLeg = createLeg("left",10,11);
	
	public Leg createLeg(String name, int length, int size) {
		
		Leg leg = new Leg(name, length, size);
		
		return leg;
		
	}
	
	public Leg getLeg(Leg name)
	{
		if(rightLeg.getName().equals(name))
		{
			return name;
		}
		else
		{
			if(leftLeg.getName().equals(name))
			{
				return name;
			}
		}
		return null;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	



	private class Leg {
		
		private int legLength;
		private int shoeSize;
		private String name;
		
		public Leg(String _name, int _length, int _size) {
			this.setLegLength(_length);
			this.setName(_name);
			this.setShoeSize(_size);
		}
		
		public int getLegLength() {
			return legLength;
		}
		public void setLegLength(int legLength) {
			this.legLength = legLength;
		}
		
		public int getShoeSize() {
			return shoeSize;
		}
		public void setShoeSize(int shoeSize) {
			this.shoeSize = shoeSize;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	
	}
}

