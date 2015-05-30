
public class Driver {
	static int size = 25;
	
	public static void printLayers(NeuralNet n) {
		System.out.println("Layer 0"); 
		n.printLayerOutput(0);
		System.out.println("\nLayer 1");
		n.printLayerOutput(1);
		System.out.println("\nOutput Layer");
		n.printOutput();
	}

	public static void main(String[] args) {
		System.out.println("Creating neural net.");
		NeuralNet n = new NeuralNet(size);
		
		n.addLayer(size);	//input layer 
		n.addLayer(100);	//hidden layer
		n.addLayer(5);		//output layer
		
		n.connectLayers();
		
		TrainingInput t = new TrainingInput(); 
		
		for (int i = 0; i < 12000; i++) {
			//n.run(input5);
			/*System.out.println("Layer 0"); 
			n.printLayerOutput(0);
			System.out.println("\nLayer 1");
			n.printLayerOutput(1);
			System.out.println("\nOutput Layer");
			n.printOutput();*/
			/*
			n.propError(output5, 5);
			
			n.run(input1); 
			n.propError(output1, 5);*/
			
			t.train1(n);
			t.train5(n);
		}
		System.out.println("Input 1a");
		n.run(TrainingInput.input1a);
		n.printOutput();
		
		printLayers(n);

		System.out.println("Input 1b");
		n.run(TrainingInput.input1b);
		n.printOutput();

		System.out.println("Input 1c");
		n.run(TrainingInput.input1c);
		n.printOutput();
	
		System.out.println("Input 1d");
		n.run(TrainingInput.input1d);
		n.printOutput();
		
		System.out.println("Input 1e");
		n.run(TrainingInput.input1e);
		n.printOutput();
		
		System.out.println("Input 5");
		n.run(TrainingInput.input5a);
		n.printOutput(); 

		System.out.println("Input Null");
		n.run(TrainingInput.inputNull);
		n.printOutput(); 
		
		/*n.run(input5);
		n.printOutput();*/
		
		n.saveWeights();
		
		System.out.println("End.");
	}

}
