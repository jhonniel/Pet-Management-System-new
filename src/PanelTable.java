import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class PanelTable extends JPanel implements MouseListener{
	static JTable tblPet;
	static DefaultTableModel modelPet;
	static TableRowSorter tblSort;
	private Database dbPet=new Database("Pet.txt");
	private Database dbColumn=new Database("PetColumns.txt");
	private Vector value;
	
	public PanelTable() {
		tblSort=new TableRowSorter();
		modelPet=new DefaultTableModel();
		tblPet=new JTable(modelPet);
		modelPet.setColumnIdentifiers(dbColumn.setColumns());
		dbPet.displayRecords(modelPet);
	
		setLayout(new GridLayout());
		add(new JScrollPane(tblPet));
		tblPet.addMouseListener(this);
	}

	public void walaNaFinishNa(){
		String records="";	
		for (int row = 0; row < tblPet.getRowCount(); row++) {
			for (int column = 0; column < tblPet.getColumnCount(); column++) {
				records+=tblPet.getValueAt(row, column)+"#";
			}
			records+="\n";
		}
		//JOptionPane.showMessageDialog(null, records);
		dbPet.addRecords(records);
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(tblPet)){
			int row=tblPet.getSelectedRow();
			value=new Vector();
			
			value.add(tblPet.getValueAt(row,0)+"");
			value.add(tblPet.getValueAt(row,1)+"");
			value.add(tblPet.getValueAt(row,2)+"");
			value.add(tblPet.getValueAt(row,3)+"");
			value.add(tblPet.getValueAt(row,4)+"");
			value.add(tblPet.getValueAt(row,5)+"");
			value.add(tblPet.getValueAt(row,6)+"");
			value.add(tblPet.getValueAt(row,7)+"");
			
			PanelInfo.setValues(value);
			PanelInfo.setColor();
			PanelButtons.setDefaultButtons();
		}
	}
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
}
