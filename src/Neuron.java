import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Neuron { 
	private ArrayList<ctn> connections;
	private double threshold; 
	public int output;
	private int input; 
	
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
	
	public void setInput(int i) {
		input = i;
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
			ctn x = new ctn(0.01, a); 
			connections.add(x);
			//System.out.println("connecting");
		}
	}

	//calculate the sum of the weights x inputs, determine whether threshold is reached
	public void fire() {
		output = 0;
		double sum = 0;
		
		//get input/weights
		if (connections.size() > 0) {			//MESSY
			//System.out.println("Size at fire: " + connections.size());
			for(ctn c : connections) {
				sum += c.w * c.n.output; 
			}
		}
		else {
			sum = (double)input;
			//System.out.println("initial inputs: " + sum ); 
		}
		
		//System.out.println("Threshold: " + threshold); 
		
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
				//System.out.println("new connection weight: " + c.w);
				c.n.updateError(e);
			}
		}

	}
	
	public void saveWeights(FileWriter wr) throws IOException {
		for (ctn c : connections) {
			wr.append(Double.toString(c.w)+ ","); 
		}
	}
 
}
