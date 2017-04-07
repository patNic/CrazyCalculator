import javax.swing.*;
import java.awt.Image;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		ImageIcon icon = new ImageIcon("src/images/icon.png");
		Image logo = icon.getImage();
		
		SplashScreen s = new SplashScreen(1000);
		s.showSplashAndExit();
		
		Gui g = new Gui();
		JFrame f = new JFrame("CRAZY CALCULATOR");
		f.setIconImage(logo);
		f.add(g);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1300, 600);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
	}
}
