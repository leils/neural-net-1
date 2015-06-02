import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.opencsv.CSVReader;


public class NeuronLayer {
	public ArrayList<Neuron> neurons;
	
	public NeuronLayer(int numNs){
		neurons = new ArrayList<Neuron>();
		while(numNs-- > 0){
			Neuron x = new Neuron(.5);
			neurons.add(x); 
		}
	}

	//Connect the neurons in layer nL to current layer: nL feeds into current
	public void connectToLayer(NeuronLayer nL) {
		for (Neuron n : nL.neurons) {
			for (Neuron a : neurons) {
				a.connect(n); 
			}
		}
	}
	
	//Feed the input layer the input -- only used in the initial layer 
	public void feedInput(int[] input, int inputSize) {
		for (int i = 0; i < inputSize; i++) {
			neurons.get(i).setInput(input[i]);
		}	
	}
	
	public void readCSV(String[] input) {
		int i = 0;
		for (Neuron n : neurons) {
			n.setInput(Double.parseDouble(input[i++]));
		}


		
	}
	
	//Fire all neurons in this layer
	public void fireNeurons() {
		//System.out.println("firing neurons.");
		for (Neuron n: neurons) {
			n.fire();
		}
	}
	
	public void printWeights() {
		for (Neuron n: neurons) {
			n.printW(); 
			System.out.println("");
		}
	}
	
	public void saveLayerWeights(File f) {
		try {
			FileWriter wr = new FileWriter(f);
			for (Neuron n : neurons) {
				n.saveWeights(wr); 
				wr.append("\n");
			}
			wr.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadLayerWeights(File f) throws IOException {
		try {
			Scanner s = new Scanner(f);
			for (Neuron n : neurons) {
				n.loadWeights(s);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	

}
