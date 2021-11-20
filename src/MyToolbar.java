import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.*;

public class MyToolbar extends JToolBar implements ActionListener{
	JButton btnNew, btnSave, btnOpen, btnClose;
	ImageIcon icon;	
	JLabel lblTime, lblDatepud;
	SimpleDateFormat sdf;

	public MyToolbar() {

		icon=new ImageIcon("IMAGES/1.png");
		btnNew=new JButton("",icon);
		btnNew.setActionCommand("New");
		//btnNew.setContentAreaFilled(false);
		//btnNew.setOpaque(true);
		btnNew.setToolTipText("New");

		icon=new ImageIcon("IMAGES/6.jpg");
		btnSave=new JButton("",icon);
		btnSave.setToolTipText("Save");
		btnSave.setActionCommand("Save");

		icon=new ImageIcon("IMAGES/7.png");
		btnOpen=new JButton("",icon);
		btnOpen.setToolTipText("Open");
		btnOpen.setActionCommand("Open");

		icon=new ImageIcon("IMAGES/8.png");
		btnClose=new JButton("",icon);
		btnClose.setToolTipText("Close");
		btnClose.setActionCommand("Close");

		add(btnNew);
		addSeparator();
		add(btnSave);
		add(btnOpen);
		add(btnClose);

		//Database db=new Database();
		//db.setFilename("Type.txt");
		//add(new JComboBox(db.fillToComboBox()));

		lblTime=new JLabel("Time: ");
		lblTime.setFont(new Font("Arial", Font.BOLD, 18));
		add(lblTime);
		addSeparator();
		
		lblDatepud=new JLabel("Date");
		lblDatepud.setFont(new Font("Arial", Font.BOLD, 18));
		add(lblDatepud);
		
		forTime();
		//toolBar.add(new PanelBirthdate());
		btnSave.setMnemonic('S');
		setFloatable(false);		
		btnSave.addActionListener(this);
		btnOpen.addActionListener(this);
		btnClose.addActionListener(this);
		btnNew.addActionListener(this);

	}
	public void forTime(){
		Timer time=new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sdf=new SimpleDateFormat("hh:mm:ss a");
				lblTime.setText("Time: "+sdf.format(new java.util.Date()));
				
				sdf=new SimpleDateFormat("MMMM dd, yyyy"); //MMMM dd, yyyy
				lblDatepud.setText("Date: "+sdf.format(new java.util.Date()));
			}
		});
		time.start();
	}
	public void actionPerformed(ActionEvent e) {

		if(e.getSource().equals(btnNew)){
			//PanelChange.card.next(PanelChange.panelMain);
			//PanelChange.card.show(PanelChange.panelMain,"New");
		}else if(e.getSource().equals(btnSave)){
			//PanelChange.card.show(PanelChange.panelMain,"Open");
		}else if(e.getSource().equals(btnOpen)){

		}
	}

}
