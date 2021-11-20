import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelInfo extends JPanel implements KeyListener,MouseListener{
	private JLabel lblID,lblName,lblGender,lblAge,lblBreed,lblType,lblPrice, lblColor;
	static JTextField txtID,txtName,txtAge,txtPrice,txtColor;
	private static JComboBox cboGender,cboBreed,cboType;
	
	private static JColorChooser chooser;
	private static Color color;
	
	private Database dbBreed=new Database("Breed.txt");
	private Database dbType=new Database("Type.txt");
	
	private static Vector rows;
	
	public PanelInfo() {
		lblID =new JLabel("ID: ");
		lblName =new JLabel("Name: ");
		lblGender =new JLabel("Gender: ");
		lblAge=new JLabel("Age: ");
		lblBreed =new JLabel("Breed: ");
		lblType =new JLabel("Type: ");
		lblPrice=new JLabel("Price: ");
		lblColor=new JLabel("Color: ");
		
		txtID=new JTextField();
		txtID.setEditable(false);
		txtName=new JTextField("N/A");
		txtAge=new JTextField("0");
		txtPrice=new JTextField("0.00");
		txtColor=new JTextField("0,0,255,0");
		
		String gender[]={"Male","Female"};
		cboGender=new JComboBox(gender);
		cboBreed=new JComboBox();
		dbBreed.loadToComboBox(cboBreed);
		cboType=new JComboBox();
		dbType.loadToComboBox(cboType);
		
		 setLayout(new GridLayout(8,2));
		 setBorder(BorderFactory.createTitledBorder(null,"Pet Registration Form",
				TitledBorder.CENTER,2));
		 add(lblID); add(txtID);
		 add(lblName); add(txtName);
		 add(lblGender); add(cboGender);
		 add(lblAge); add(txtAge);
		 add(lblBreed); add(cboBreed);
		 add(lblType); add(cboType);
		 add(lblPrice); add(txtPrice);
		 add(lblColor); add(txtColor);
		 
			txtPrice.addKeyListener(this);
			txtAge.addKeyListener(this);
			
		txtID.setText((PanelTable.tblPet.getRowCount()+1)+"");
		txtColor.addMouseListener(this);
		
		txtName.addMouseListener(this);
		txtAge.addMouseListener(this);
		txtPrice.addMouseListener(this);
	}
	
	public static void clear(){
		txtID.setText((PanelTable.tblPet.getRowCount()+1)+"");
		txtName.setText("N/A");
		txtAge.setText("0");
		txtPrice.setText("0.00");
		cboBreed.setSelectedIndex(0);
		cboType.setSelectedIndex(0);
		cboGender.setSelectedIndex(0);
		txtColor.setText("0,0,255,0");
	}
	
	public static Vector getValues(){
		rows=new Vector();
		rows.add(txtID.getText());
		rows.add(txtName.getText());
		rows.add(cboGender.getSelectedItem());
		rows.add(txtAge.getText());
		rows.add(cboBreed.getSelectedItem());
		rows.add(cboType.getSelectedItem());
		rows.add(txtPrice.getText());
		rows.add(txtColor.getText());
		return rows;
	}
	public static void setValues(Vector value){
		txtID.setText(value.get(0).toString());
		txtName.setText(value.get(1).toString());
		cboGender.setSelectedItem(value.get(2).toString());
		txtAge.setText(value.get(3).toString());
		cboBreed.setSelectedItem(value.get(4).toString());
		cboType.setSelectedItem(value.get(5).toString());
		txtPrice.setText(value.get(6).toString());
		txtColor.setText(value.get(7).toString());
	}
	public static void setColor(){
		String col[], strCol=PanelInfo.txtColor.getText();
		col=strCol.split(",");
		
		int r=Integer.parseInt(col[0]);
		int g=Integer.parseInt(col[1]);
		int b=Integer.parseInt(col[2]);
		
		chooser = new JColorChooser(); 
		chooser.setColor(r,g,b); // Set the selected color
	    color = chooser.getColor(); // Get current selected color
	    txtColor.setBackground(color);
	    txtColor.setText(color+"");
	}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {
		if(e.getSource().equals(txtPrice)){
			if(e.getKeyChar()=='-'){
				e.consume();
			}
		}else if(e.getSource().equals(txtAge)){
			if(e.getKeyChar()>='a' && e.getKeyChar()<='z'){
				e.consume();
			}
			//if(!(e.getKeyChar()>='a' && e.getKeyChar()<='z')){
		}
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(txtColor)){
			chooser = new JColorChooser(); 
			color=chooser.showDialog(null, "Select Color", Color.red);
		    chooser.setColor(color); // Set the selected color
		    color = chooser.getColor(); // Get current selected color
		    txtColor.setBackground(color);
		    txtColor.setText(color.getRed()+","+color.getGreen()+","+color.getBlue()+","+color.getAlpha());
		}else if(e.getSource().equals(txtName)){
			txtName.setText("");
		}else if(e.getSource().equals(txtAge)){
			txtAge.setText("");
		}else if(e.getSource().equals(txtPrice)){
			txtPrice.setText("");
		}
	}

	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { 
		if(e.getSource().equals(txtName)){
			if(txtName.getText().equals("")){
				txtName.setText("N/A");
			}
		}else if(e.getSource().equals(txtAge)){
			if(txtAge.getText().equals("")){
				txtAge.setText("0");
			}
		}else if(e.getSource().equals(txtPrice)){
			if(txtPrice.getText().equals("")){
				txtPrice.setText("0.00");
			}
		}
	}
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
}
