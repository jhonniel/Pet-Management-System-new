import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Pet extends JFrame implements WindowListener,MouseListener{
	Vector rows;
	PanelTable table=new PanelTable();
	//JScrollPane pane;
	Database dbPet=new Database("Pet.txt");
	Pet(){ } //end of constructor
	
	public void setWindow(){
		setJMenuBar(new MyMenu());	
		//pane=new JScrollPane();
		//pane.setViewportView(PanelTable.tblPet); //so table is viewed
		//PanelTable.tblPet.setFillsViewportHeight(true);
		setLayout(null);
		add(new MyToolbar()).setBounds(5, 5, 1000, 100);
		add(new PanelInfo()).setBounds(10,110, 250, 300);
		add(new PanelSearch()).setBounds(240,110,200,30);
		add(new PanelButtons()).setBounds(15, 420, 700, 30);
		add(new PanelTable()).setBounds(270,140,700,270);
		setTitle("Pet Information Form");
		setSize(1000,550);
		getContentPane().setBackground(new Color(0, 0, 200,90));
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addWindowListener(this);
		addMouseListener(this);
		
		
	} //end of setWindow
	
	public void walaNaFinishNa(){
		String records="";	
		for (int row = 0; row < PanelTable.tblPet.getRowCount(); row++) {
			for (int column = 0; column < PanelTable.tblPet.getColumnCount(); column++) {
				records+=PanelTable.tblPet.getValueAt(row, column)+"#";
			}
			records+="\n";
		}
		//JOptionPane.showMessageDialog(null, records);
		dbPet.addRecords(records);
	}
	
	public void windowOpened(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {
		walaNaFinishNa();
	}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}

	public void mouseClicked(MouseEvent e) {
		PanelButtons.setSaveButtons();
		PanelInfo.txtID.setText((PanelTable.tblPet.getRowCount()+1)+"");
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
		
	}
	
}//end of class
