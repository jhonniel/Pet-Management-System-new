import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class ProgressBar extends JFrame {
	JProgressBar progBar = new JProgressBar(0,100);
   
    
	public ProgressBar() {
		add(progBar, BorderLayout.CENTER);
		setTitle("Loading Program");
		setSize(400, 60);
		setUndecorated(true);
		setLocationRelativeTo(null);
	    progBar.setStringPainted(true);
	    setVisible(true);
	    int i = 0; 
        try { 
            while (i <= 100) { 
                // fill the menu bar 
                progBar.setValue(i + 20); 
                // delay the thread 
                Thread.sleep(500);
                i += 20;    
            } 
			Pet pet=new Pet();
			pet.setWindow();
            setVisible(false);
        } 
        catch (Exception e) { 
        } 
	}
	public static void main(String[] args) {
		new ProgressBar();
	}
}
