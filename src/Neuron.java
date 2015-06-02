import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Neuron { 
	private ArrayList<ctn> connections;
	private double threshold; 
	public double output;
	private double input; 
	
	//connection class
	public class ctn {
		public double w; 
		public Neuron n; 
		
		public ctn(double weight, Neuron neur) {
			w = weight;
			n = neur; 
		}
	}
	
	//constructor
	public Neuron(double d) {
		output = 0;
		threshold = d; 
		connections = new ArrayList<ctn>();
	}
	
	public void setInput(double d) {
		input = d;
		//System.out.println("Input: " + input); 
	}
	
	//returns true if connection with Neuron x exists
	private boolean isConnected(Neuron x) {
		for (ctn c : connections) {
			if (c.n.equals(x)) {
				return true;
			}
		}
		return false;
	}
	
	//create connection with Neuron a, if not already connected 
	public void connect(Neuron a) {
		//avoid connecting already connected neurons
		if (!isConnected(a)) {
			ctn x = new ctn(Math.random(), a); 
			connections.add(x);
		}
	}
	
	public void printW() {
		for (ctn c : connections) {
			System.out.print(c.w); 
		}
	}

	//calculate the sum of the weights x inputs, determine whether threshold is reached
	public void fire() {
		output = 0;
		double sum = 0;
		
		//get input/weights
		if (connections.size() > 0) {			//MESSY
			for(ctn c : connections) {
				sum += c.w * c.n.output; 
			}
		}
		else {
			sum = (double)input;
		}		
		if(sum > threshold) {
			output = 1;
		}
	}

	//update error through all available connections 
	public void updateError(double e) {
		double numCtns = (double)connections.size();
		if (numCtns > 0) {
			e = e / numCtns; 			
		}
		for (ctn c : connections) {
			if ((c.n.output == 0 && e > 0) || (c.n.output == 1 && e < 0)) {
				c.w = c.w + e; 
				c.n.updateError(e);
			}
		}

	}
	
	public void saveWeights(FileWriter wr) throws IOException {
		for (ctn c : connections) {
			wr.append(Double.toString(c.w)+ ","); 
		}
	}
	
	public void loadWeights(Scanner s) throws IOException {
		for (ctn c : connections) {
			c.w = s.nextDouble(); 
		}
	}
 
}
