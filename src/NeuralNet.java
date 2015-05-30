import java.io.File;
import java.util.ArrayList;


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
	
	//Gives the first neurons their input data, then fires all 
	public void run(int[] input) {
		layers.get(0).feedInput(input, inputSize);
		for (NeuronLayer l : layers) {
			l.fireNeurons();
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
	
	public void printLayerOutput(int i) {
		NeuronLayer layer = layers.get(i); 
		for (Neuron n : layer.neurons) {
			System.out.print(" " + n.output); 
		}
	}
	
	public void printOutput() {
		NeuronLayer outputLayer = layers.get(layers.size() - 1);
		for (Neuron n : outputLayer.neurons){
			System.out.print(" " + n.output); 
		}
		System.out.println("");
	}
	
	public void saveWeights() {
		File f1 = new File("layer1.txt");
		File f2 = new File("layer2.txt");
		File f3 = new File("layer3.txt");
		//File f4 = new File("layer4.txt");
		layers.get(0).saveLayerWeights(f1);
		layers.get(1).saveLayerWeights(f2);
		layers.get(2).saveLayerWeights(f3);
		//layers.get(3).saveLayerWeights(f4);
	}
	
	public void loadWeights() {
		
	}
}
