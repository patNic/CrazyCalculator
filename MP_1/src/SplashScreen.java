import java.awt.*;
import javax.swing.*;

public class SplashScreen extends JWindow {
  private int duration;
  public SplashScreen(int d) {
    duration = d;
  }

  public void showSplash() {
    JPanel content = (JPanel)getContentPane();
    //content.setBackground(Color.white);

    int width = 375;
    int height =200;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screen.width-width)/2;
    int y = (screen.height-height)/2;
    setBounds(x,y,width,height);

    JLabel label = new JLabel(new ImageIcon("src/images/splashScreen.png"));
    content.add(label, BorderLayout.CENTER);

    setVisible(true);

    try { Thread.sleep(duration); } catch (Exception e) {}

    setVisible(false);
  }

  public void showSplashAndExit() {
    showSplash();
    
  }

}