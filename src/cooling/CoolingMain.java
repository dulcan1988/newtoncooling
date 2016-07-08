/**
 * @author Matt Kukla
 * Newton's Law of Cooling Calculator
 * version 0.0.1
 * file: CoolingMain.java
 * class CoolingMain - Displays GUI and parses data
 */

package cooling;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;


public class CoolingMain {
	
	//method for GUI
	protected static void coolingLawGUI(){
		//Main JFrame
		JFrame cool = new JFrame("Newton's Law of Cooling Calculator");
		cool.setPreferredSize(new Dimension(1000, 100));
		cool.setLayout(new FlowLayout());
		cool.setResizable(false);
		cool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cool.setIconImage(Toolkit.getDefaultToolkit().getImage("temperature-256.png"));
		
		//Surrounding temperature JLabel/JTextField
		JLabel tsLabel = new JLabel("Surrounding temperature: ");
		cool.add(tsLabel);
		
		JTextField tsField = new JTextField(5);
		cool.add(tsField);
		
		//Initial temperature JLabel/JTextField
		JLabel t0 = new JLabel("Initial temperature: ");
		cool.add(t0);
		
		JTextField t0Field = new JTextField(5);
		cool.add(t0Field);
		
		//Constant JLabel/JTextField
		JLabel kLabel = new JLabel("Constant: ");
		cool.add(kLabel);
		
		JTextField kField = new JTextField(5);
		cool.add(kField);
		
		//Object temperature JLabel and JTextField
		JLabel tempLabel = new JLabel("Object Temperature: ");
		cool.add(tempLabel);
		
		JTextField tempField = new JTextField(5);
		cool.add(tempField);

		
		//Time JLabel/JTextField
		JLabel timeLabel = new JLabel("Time: ");
		cool.add(timeLabel);
		
		JTextField timeField = new JTextField(5);
		cool.add(timeField);
		
		
		//Calculate button
		JButton calcButton = new JButton("Calculate");
		cool.add(calcButton);
		
		//Clear button
		JButton clearButton = new JButton("Clear");
		cool.add(clearButton);
		
		//"Calculate" button ActionListener
		calcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	 double t0 = 0;
            	 double ts = 0;
            	 double k = 0;
            	 double time = 0;
            	 double temp = 0;
            	 
            	
            	//Check to see which fields contain data
            	boolean tsIsEmpty = (tsField.getText().isEmpty());
            	boolean t0IsEmpty = (t0Field.getText().isEmpty());
            	boolean kIsEmpty = (kField.getText().isEmpty());
            	boolean timeIsEmpty = (timeField.getText().isEmpty());
            	boolean obTempIsEmpty = (tempField.getText().isEmpty());
            	
            	
            	if(!tsIsEmpty){
            		 ts = Double.parseDouble(tsField.getText());
            	}
            	
            	if(!t0IsEmpty){
            		 t0 = Double.parseDouble(t0Field.getText());
            	}
            	
            	if(!kIsEmpty){
            		 k = Double.parseDouble(kField.getText());
            	}
            	
            	if(!timeIsEmpty){
            		 time = Double.parseDouble(timeField.getText());
            	}
            	
            	if(!obTempIsEmpty){
            		 temp = Double.parseDouble(tempField.getText());
            	}
            	
          	            		
            	/*Decide which variables need to be solved for based on which fields
            	 * the user fills out*/
            	
            	//Calculate temp when given surrounding temp, initial temp, time, and k
            	if((obTempIsEmpty) && !(tsIsEmpty && t0IsEmpty && kIsEmpty && timeIsEmpty)){
            		
            		tempField.setText(Double.toString(CoolingCalc.T(time, t0, ts, k)));
            	
            	}

            		
            	//Calculate k when given temp, init. temp and surrounding temp.
            	else if(kIsEmpty && !(tsIsEmpty && t0IsEmpty && timeIsEmpty && obTempIsEmpty)){
                	//Pass parsed data to kCalc
                	kField.setText(Double.toString(CoolingCalc.kCalc(time, t0, ts, temp)));
            		 
            	}
            	
            	//Calculate initial temperature
            	else if (t0IsEmpty && !(tsIsEmpty && timeIsEmpty && obTempIsEmpty && kIsEmpty)){
            		t0Field.setText(Double.toString(CoolingCalc.t0Calc(time, ts, temp, k)));
            	}
            	
            	//Calculate surrounding temperature
            	else if (tsIsEmpty && !(t0IsEmpty && timeIsEmpty && obTempIsEmpty &&kIsEmpty)){
            		tsField.setText(Double.toString(CoolingCalc.tsCalc(time, temp, k, t0)));
            	}
            	
            	//Calculate time
            	else if (timeIsEmpty && !(tsIsEmpty &&obTempIsEmpty && kIsEmpty && t0IsEmpty)){
            		timeField.setText(Double.toString(CoolingCalc.timeCalc(temp, t0, ts, k)));
            	}

            	//If no fields are full, display an error message
            	else if ((tsIsEmpty == t0IsEmpty == kIsEmpty == timeIsEmpty == obTempIsEmpty == true)){
            		JOptionPane.showMessageDialog(null, "Error: No fields filled", "Error", 
            				JOptionPane.ERROR_MESSAGE);
            	}
            	          	 
            	//If too many fields are filled, display an error
            	else {
            		JOptionPane.showMessageDialog(null, "Error: too many fields filled", "Error", 
            				JOptionPane.ERROR_MESSAGE);
            	}
            	
            }
		});
		
		//"Clear" button ActionListener
		clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//Set all text fields to a blank string
            	tsField.setText(null);
            	t0Field.setText(null);
            	tempField.setText(null);
            	kField.setText(null);
            	timeField.setText(null);
 	
            }
            });
		
		//Make everything visible
		cool.pack();
		cool.setVisible(true);
			
	}
	
	//Display GUI
	public static void main(String args[]){
		coolingLawGUI();

	}
}