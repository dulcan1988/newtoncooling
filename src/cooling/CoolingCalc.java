/**
 * @author Matt Kukla
 * Newton's Law of Cooling Calculator
 * version 0.0.1
 * file: Calc.java
 * class Calc - performs calculations and returns them 
 * to main JFrame
 */


package cooling;

import javax.swing.JOptionPane;

public class CoolingCalc {
	
	//Calculate temperature given time, initial temperature, and constant
	public static double T(double time, double t_0, double t_s, double k){
		double temp = t_s + (t_0 - t_s) * Math.exp((-k) * time);
		return temp;	
	}
	
	//Solve for k given time, initial temperature, object temperature and surrounding temperature
	public static double kCalc(double time, double t_0, double t_s, double temp){
		
		//Catch divide by zero error
		if(time == 0 || temp == 0){
			JOptionPane.showMessageDialog(null, "Error: Time/Temperature may not be zero!", "Error", 
    				JOptionPane.ERROR_MESSAGE);
			return 0;
		}
		
		//If all is well, calculate k
		else{
		double k = Math.log((t_s/(t_s - temp)- (t_0/(t_s - temp)))) / time;
		return k;
		}
	}
	
	//Solve for initial temp. given k, time, and surrounding temp.
	public static double t0Calc(double time, double t_s, double temp, double k){
		
		//Calculate t0
		double t0 = Math.exp(k * time) - t_s * Math.exp(k * time) + t_s;
		
		return t0;
	}
	
	//Solve for surrounding temperature given initial temperature, time, and constant
	public static double tsCalc(double time, double temp, double k, double t0){
		double ts = (Math.exp(k * time) - t0) / (Math.exp(k * time) - 1);
		
		return ts;
	}
	
	//Solve for time given surrounding temperature, initial temperature, and constant
	public static double timeCalc(double temp, double t0, double ts, double k){
		
		//Catch divde by zero error
		if(k == 0){
			JOptionPane.showMessageDialog(null, "Error: Constant may not be zero!", "Error", 
    				JOptionPane.ERROR_MESSAGE);
			return 0;
		}
		
		else {
			double time = Math.log( (ts) / (ts - temp) - (t0 / (ts - temp))) / k;
			
			//Check for divide by zero error
			if(Double.isNaN(time)){
				JOptionPane.showMessageDialog(null, "Error: Cannot divide by 0 to solve for time!",
													"Error", JOptionPane.ERROR_MESSAGE);
				return 0;
			}
			
			else{
				return time;
			}
			
		}
	}
	
	
}
