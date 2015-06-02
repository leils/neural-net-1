import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;


public class NeuralNet {
	private ArrayList<NeuronLayer> layers; 
	private int inputSize; 
	
	
	public NeuralNet(int iSize){
		layers = new ArrayList<NeuronLayer>();
		inputSize = iSize; 
	}
	
	//Adds a layer of neurons 
	public void addLayer(int numNeurons) {
		layers.add(new NeuronLayer(numNeurons));
	}
	
	//Connects all layers 
	public void connectLayers() {
		for (int i = 1; i < layers.size(); i++) {
			layers.get(i).connectToLayer(layers.get(i - 1));
		}
	}
	
	public void feedCSVInput(String[] input) {
		NeuronLayer inputLayer = layers.get(0); 
		inputLayer.readCSV(input); 
	}
	
	public void fireAllNeurons() {
		for (NeuronLayer l : layers) {
			l.fireNeurons();
		}
	}
	
	//Gives the first neurons their input data, then fires all 
	public void run(int[] input) {
		layers.get(0).feedInput(input, inputSize);
		fireAllNeurons(); 
	}
	
	
	//Print connection weighs, separated by layers. 
	public void printAllWeights() {
		int num = 0;
		for (NeuronLayer l : layers) {
			System.out.println("Layer" + num++);
			l.printWeights();
			System.out.println("----------");
		}
	}
	
	//Calculates error for the output neurons and feeds them that error
	public void propError(int[] expOutput, int outputNum) {
		NeuronLayer outputLayer = layers.get(layers.size() - 1);
		for (int i = 0; i < outputNum; i++) {
			Neuron curN = outputLayer.neurons.get(i); 
			double err = expOutput[i] - curN.output;
			//System.out.println("err: " + err); 
			curN.updateError(err);
		}
	}
	
	//Print a single layer's output
	public void printLayerOutput(int i) {
		NeuronLayer layer = layers.get(i); 
		for (Neuron n : layer.neurons) {
			System.out.print(" " + n.output); 
		}
	}
	
	//Print output of all layers
	public void printLayers() {
		for (int i = 0; i < layers.size(); i++) {
			System.out.println("Layer " + i ); 
			printLayerOutput(i); 	
		}
	}
	
	//Print output of final layer
	public void printOutput() {
		NeuronLayer outputLayer = layers.get(layers.size() - 1);
		for (Neuron n : outputLayer.neurons){
			System.out.print(" " + n.output); 
		}
		System.out.println("");
	}
	
	//Save weights of each neuron's connections into a file, one for each layer
	public void saveWeights() {
		for (int i = 0; i < layers.size(); i++) {
			File f = new File("layer" + i + ".txt"); 
			layers.get(i).saveLayerWeights(f);
		}
	}
	
	//Load weights for each neuron, based on files 
	public void loadWeights() {
		for (int i = 0; i < layers.size(); i++) {
			File f = new File("layer" + i + ".txt");
			try {
				layers.get(i).loadLayerWeights(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
	}
}
