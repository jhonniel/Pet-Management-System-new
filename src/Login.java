import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JFrame{
	JLabel lblUsername=new JLabel("Username: ");
	JLabel lblPassword=new JLabel("Password: ");

	JTextField txtUN=new JTextField("admin1",15);
	JPasswordField txtPass=new JPasswordField("1234",15);
	JButton btnLogin=new JButton("Login");
	JButton btnCancel=new JButton("Cancel");

	int attempt=2;
	Database db=new Database();
	public Login() {
		setTitle("Log-in Account");
		setLayout(new FlowLayout());
		setSize(300, 130);
		
		db.setFilename("Account.txt");
		add(lblUsername);add(txtUN);
		add(lblPassword);add(txtPass);
		add(btnLogin); add(btnCancel);
			
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u, p;
				u=txtUN.getText();
				p=txtPass.getText();
				if(attempt>0){
					if(db.isFound(u, p)){
						JOptionPane.showMessageDialog(null, "Log-in Successful");
						setVisible(false);
						new ProgressBar();
					}else{
						JOptionPane.showMessageDialog(null, "Incorrect. Remaining attempts: "+attempt);
						attempt--;
					}
				}else{
					JOptionPane.showMessageDialog(null, "Programm terminating....");
					System.exit(0);
				}
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);	
			}
		});
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Login();
	}
}
