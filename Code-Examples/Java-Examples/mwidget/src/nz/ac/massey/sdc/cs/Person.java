package nz.ac.massey.sdc.cs;

public class Person {
	private String first_name;
	private int age;
	private boolean retired;
	public String getmName() {
		return first_name;
	}
	public void setmName(String mName) {
		this.first_name = mName;
	}
	public int getmAge() {
		return age;
	}
	public void setmAge(int mAge) {
		this.age = mAge;
	}
	public boolean ismRetired() {
		return retired;
	}
	public void setmRetired(boolean mRetired) {
		this.retired = mRetired;
	}
	
}
