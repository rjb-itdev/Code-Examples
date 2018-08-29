
public class Laptop extends Computer {

	private String ram;
	private String hdd;
	private String cpu;

	public Laptop(String _ram, String _cpu, String _hdd) {
		this.ram = _ram;
		this.hdd = _hdd;
		this.cpu = _cpu;
	}
	@Override
	public String getRam() {
		// TODO Auto-generated method stub
		return this.ram;
	}

	@Override
	public String getCpu() {
		// TODO Auto-generated method stub
		return this.cpu;
	}

	@Override
	public String getHdd() {
		// TODO Auto-generated method stub
		return this.hdd;
	}
}
