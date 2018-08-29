
public abstract class Computer {
	
	public abstract String getRam();
	public abstract String getCpu();
	public abstract String getHdd();
	
	@Override
	public String toString()
	{
		return "Ram = " + this.getRam() + ", Cpu = " + this.getCpu() + ", Hdd = " + this.getHdd();
	}
}
