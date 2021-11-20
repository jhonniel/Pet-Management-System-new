import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;


public class PanelSearch extends JPanel implements KeyListener,MouseListener{
	private JLabel lblSearch;
	private JTextField txtSearch;
	
	PanelSearch(){
		lblSearch =new JLabel("Search: ");
		txtSearch=new JTextField("Type your search");
		
		setLayout(new FlowLayout());
		add(lblSearch);
		add(txtSearch);	
		
		txtSearch.addKeyListener(this);
		txtSearch.addMouseListener(this);
	}

	public void keyPressed(KeyEvent e) { }
	public void keyReleased(KeyEvent e) { 
		if(e.getSource().equals(txtSearch)){
			PanelTable.tblSort=new TableRowSorter(PanelTable.modelPet);
			PanelTable.tblPet.setRowSorter(PanelTable.tblSort);
			PanelTable.tblSort.setRowFilter(RowFilter.regexFilter(txtSearch.getText(),0,1));
		}	
	}
	public void keyTyped(KeyEvent e) { }

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(txtSearch)){
			txtSearch.setText("");	
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource().equals(txtSearch)){
			if(txtSearch.getText().equals("")){
				txtSearch.setText("Type your search");
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
