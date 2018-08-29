package testAssertions;

import java.util.Arrays;
import java.util.LinkedList;

public class Student extends StudentId {

	Student student;
	private int id;
	private String name;
	private String lName;
	private String fullName;
	private String[] middleNames;
	private int age;

	public Student() {

	}

	public void setId(int _id) {
		this.id = _id;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setAge(int _age) {
		this.age = _age;
	}

	public int getAge() {
		return this.age;
	}

	public String getLname() {
		return this.lName;
	}

	public String getFullName() {
		return this.fullName;
	}

	public String[] getMiddleNames() {
		return this.middleNames;
	}

	public void setNames(String name) {
		String[] names = name.split("\\s");
		this.name = names[0];

		this.lName = names[names.length - 1];
		if (names.length > 2) {
			try {

				this.middleNames = Arrays.copyOfRange(names, 1, names.length - 1);
			} catch (IndexOutOfBoundsException e) {
				//logger here.
			}
		}
	}

}
