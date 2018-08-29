package nz.ac.massey.sdc.cs;
import javax.swing.*;
import org.metawidget.swing.*;
public class myApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person person = new Person();
		
		SwingMetawidget metawidget = new SwingMetawidget();
		metawidget.setToInspect(person);
		
		JFrame jFrame = new JFrame("Metawidget Tutorial");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.getContentPane().add(metawidget);
		jFrame.setSize(400,250);
		jFrame.setVisible(true);
		
	}

}
