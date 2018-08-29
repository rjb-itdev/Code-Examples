package singletonPractice;

public class MySingletonClass {

	// Create using lazy initialization an instance of this class
	private static MySingletonClass instance = null;
	private static String name;
	// Create constructor as private //only visible in this class
	private MySingletonClass() {

	}

	// Create a method to return at least on object of this type.
	public static MySingletonClass createSingleton() {
		if (instance == null) {
			synchronized (MySingletonClass.class) {
				if (instance == null) {
					instance = new MySingletonClass();

				}
			}
		}
		return instance;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
}
