
public class ComputerFactory {

	public static Computer getComputer(String type, String ram, String cpu, String hdd)
	{
		if("PC".equalsIgnoreCase(type))
		{
			return new Pc(ram,hdd,cpu);
		}
		if("SERVER".equalsIgnoreCase(type))
		{
			return new Server(ram, hdd, cpu);
		}
		if("LAPTOP".equalsIgnoreCase(type))
		{
			return new Laptop(ram,hdd,cpu);
		}
		return null;
		//This can be combined with a singleton pattern.. for instance if there can be only one of server.
	}
}
