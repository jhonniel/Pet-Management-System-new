import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class PanelButtons extends JPanel implements ActionListener{
	static JButton btnSave,btnClear,btnUpdate,btnDelete,btnClose;
	Vector rows;
	ImageIcon icon;
	
	Pet pet=new Pet();
	
	PanelButtons(){
		// JButton instantiations
		icon = new ImageIcon("IMAGES/icon/add_user.png");
		btnSave = new JButton("ADD", icon);
		icon = new ImageIcon("IMAGES/icon/edit_user.png");
		btnUpdate = new JButton("EDIT",icon);
		icon = new ImageIcon("IMAGES/icon/clear.png");
		btnClear = new JButton("CLEAR", icon);
		icon = new ImageIcon("IMAGES/icon/delete_user.png");
		btnClose = new JButton("CLOSE",icon);
		icon = new ImageIcon("IMAGES/icon/close.png");
		btnDelete = new JButton("DELETE",icon);

		// Adding components to JPanel -panelButtons
		setLayout(new GridLayout(1,7,4,1));
		setOpaque(false);
		add(btnSave);
		add(btnClear);
		add(new JLabel(""));
		add(btnUpdate);
		add(btnDelete);
		add(btnClose);
			 
		btnSave.addActionListener(this);
		btnClear.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnClose.addActionListener(this);	
		
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
	} //end of constructor
	
	public static void setSaveButtons(){
		btnSave.setEnabled(true);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
	}
	public static void setDefaultButtons(){
		btnSave.setEnabled(false);
		btnUpdate.setEnabled(true);
		btnDelete.setEnabled(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnSave)){
			PanelTable.modelPet.addRow(PanelInfo.getValues());
			pet.walaNaFinishNa();
			PanelInfo.clear();
		}else if(e.getSource().equals(btnUpdate)){
			rows=new Vector(PanelInfo.getValues());
			int row=PanelTable.tblPet.getSelectedRow();
			JOptionPane.showMessageDialog(null, rows);
			PanelTable.tblPet.setValueAt(rows.get(1), row, 1);
			PanelTable.tblPet.setValueAt(rows.get(2), row, 2);
			PanelTable.tblPet.setValueAt(rows.get(3), row, 3);
			PanelTable.tblPet.setValueAt(rows.get(4), row, 4);
			PanelTable.tblPet.setValueAt(rows.get(5), row, 5);
			PanelTable.tblPet.setValueAt(rows.get(6), row, 6);
			PanelTable.tblPet.setValueAt(rows.get(7), row, 7);
			PanelInfo.clear();
			PanelInfo.setColor();
			PanelButtons.setDefaultButtons();
			btnSave.setEnabled(true);
			//pet.walaNaFinishNa();
		}else if(e.getSource().equals(btnClear)){
			PanelInfo.clear();
		}else if(e.getSource().equals(btnDelete)){
			int row=PanelTable.tblPet.getSelectedRow();
			PanelTable.modelPet.removeRow(row);
			//pet.walaNaFinishNa();
		}else if(e.getSource().equals(btnClose)){
			pet.walaNaFinishNa();
			System.exit(0);
		}
	}

}
