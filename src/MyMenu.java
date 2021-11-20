import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;

public class MyMenu extends JMenuBar implements ActionListener{
	JMenu menuFile, menuEdit, menuSource, subMenu;
	JMenuItem menuItems;
	ImageIcon icon;
	JRadioButton rdoMale, rdoFemale;
	ButtonGroup btnGrp;
	JCheckBox chkSkill;
	
	public MyMenu() {
		menuFile=new JMenu("File");
		menuFile.setMnemonic('F');
			subMenu=new JMenu("New");
				menuItems=new JMenuItem("Java Project");
				menuItems.addActionListener(this);
				menuItems.setAccelerator(KeyStroke.getKeyStroke(
						KeyEvent.VK_J,ActionEvent.ALT_MASK));		
				subMenu.add(menuItems);
				menuItems=new JMenuItem("Project");
				menuItems.addActionListener(this);
				subMenu.add(menuItems);
				menuItems=new JMenuItem("Package");	
				menuItems.addActionListener(this);
				subMenu.add(menuItems);
			menuFile.add(subMenu);
				
			menuItems=new JMenuItem("Open");
			menuFile.add(menuItems);
			
			icon=new ImageIcon("IMAGES/icon/add_user.png");
			menuItems=new JMenuItem("Save",icon);
			menuFile.add(menuItems);
			menuFile.addSeparator();
			
			menuItems=new JMenuItem("Exit");
			menuItems.addActionListener(this);
			menuFile.add(menuItems);
		
		menuEdit=new JMenu("Edit");
			rdoFemale=new JRadioButton("Female");
			rdoMale=new JRadioButton("Male");
			rdoFemale.setSelected(true); //initially selected
			menuEdit.add(rdoMale);
			menuEdit.add(rdoFemale);
			btnGrp=new ButtonGroup();
			btnGrp.add(rdoMale);
			btnGrp.add(rdoFemale);
			menuEdit.addSeparator();
			
			chkSkill=new JCheckBox("Eating");
			menuEdit.add(chkSkill);
			chkSkill=new JCheckBox("Drinking");
			menuEdit.add(chkSkill);
			chkSkill=new JCheckBox("Caring");
			menuEdit.add(chkSkill);
			
		menuSource=new JMenu("Source");
		
		add(menuFile);
		add(menuEdit);
		add(menuSource);	
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Java Project")){
			
		}else if(e.getActionCommand().equals("Project")){
			new Pet();
		}else if(e.getActionCommand().equals("Package")){
			//new ProgressBar().setUI();
		}else if(e.getActionCommand().equals("Exit")){
			System.exit(0);
		}
	}
}
