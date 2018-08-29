
public class Main {

	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer("pc", "32gb", "1TB","i3");
		Computer server = ComputerFactory.getComputer("Server", "128gb", "40Tb", "Xeon");
		Computer laptop = ComputerFactory.getComputer("Laptop","16gb", "256gb", "i5u");
		
		System.out.println("Computer Factory Produced a Pc:: " + pc);
		System.out.println("Computer Factory Produced a Server:: " + server);
		System.out.println("Computer Factory Produced a Laptop:: " + laptop);
				

	}

}
