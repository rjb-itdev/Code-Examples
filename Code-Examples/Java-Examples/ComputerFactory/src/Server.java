
public class Server extends Computer {

	private String hdd;
	private String cpu;
	private String ram;

	Server(String _ram, String _cpu, String _hdd) {
		this.cpu = _cpu;
		this.hdd = _hdd;
		this.ram = _ram;

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
