
public class Pc extends Computer{
	
	private String ram;
	private String hdd;
	private String cpu;
	
	public Pc(String _ram, String _cpu, String _hdd) {
		this.ram = _ram;
		this.hdd = _hdd;
		this.cpu = _cpu;
	}
	@Override
	public String getRam() {
		return this.ram;
	}

	@Override
	public String getCpu() {
		return this.cpu;
	}

	@Override
	public String getHdd() {
		return this.hdd;
	}

}
