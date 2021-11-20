import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Database {
	private File myFile;
	private FileWriter fWrite;
	private FileReader fRead;
	private Scanner read;
	
	private Vector row;
	private String filename;
	private String data[];
	
	public Database() {
		filename="Pet.txt";
		myFile=new File(filename);
	}
	public Database(String filename) {
		this.filename=filename;
		myFile=new File(filename);
	}
	public void setFilename(String filename) {
		this.filename = filename;
		myFile=new File(filename);
	}
	public String getFilename() {
		return filename;
	}
	public void addRecords(String records){
		try {
			fWrite=new FileWriter(myFile);
			fWrite.write(records);
			fWrite.flush();
		} catch (Exception e) {
			errorMessage("Error 101: addRecords\n"+e.getMessage());
			e.printStackTrace(); //trace the cause of error
		}//end of try
	} //end of addRecords
	
	public Vector setColumns(){
		Vector column=new Vector();
		try {	
			fRead=new FileReader(myFile);
			read=new Scanner(fRead);
			
			while(read.hasNext()){
				column.add(read.nextLine());
			}
			fRead.close();
			read.close();
			//JOptionPane.showMessageDialog(null, column);	
		} catch (Exception e) {
			errorMessage("Error 102: setColumns\n"+e.getMessage());
			e.printStackTrace(); //trace the cause of error
		}//end of try
		return column;
	}//end of setColumns
	
	public void displayRecords(DefaultTableModel  model){
		try {
			fRead=new FileReader(myFile);
			read=new Scanner(fRead);
			
			while(read.hasNext()){
				data=read.nextLine().split("#");
				model.addRow(data);
			}
			fRead.close();
			read.close();
			//JOptionPane.showMessageDialog(null, column);	
		} catch (Exception e) {
			errorMessage("Error 103: displayRecords\n"+e.getMessage());
			e.printStackTrace(); //trace the cause of error
		}//end of try
	}
	
	
	public void loadToComboBox(JComboBox cboData){
		try {
			fRead=new FileReader(myFile);
			read=new Scanner(fRead);
			
			while(read.hasNext()){
				cboData.addItem(read.nextLine());
			}
			fRead.close();
			read.close();
		} catch (Exception e) {
			errorMessage("Error 104: loadtocombobox\n"+e.getMessage());	
			e.printStackTrace(); //trace the cause of error
		}//end of try
	}//end of loadtocombox
	
	
	public boolean isFound(String username, String password){
		boolean f=false;
		try {
			String un="", pwd="";
			fRead=new FileReader(myFile);
			read=new Scanner(fRead);
			while(read.hasNext()){
				un=read.next();
				pwd=read.next();
				if(un.equals(username) && pwd.equals(password)){
					f=true;
				}	
			}
			fRead.close();
			read.close();
		} catch (Exception e) {
			System.err.println("Error 105: isFound \n"+e.getMessage());
		}
		return f;
	}//end of isFound
	
	public void errorMessage(String error){
		System.err.println(error);
	}
	
}
