import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;


public class Driver {
	static int size = 400;

	public static void main(String[] args) throws IOException {
		System.out.println("Creating neural net.");
		NeuralNet n = new NeuralNet(size);
		
		n.addLayer(size);	//input layer 
		n.addLayer(400);	//hidden layer
		n.addLayer(400);	//hidden layer
		n.addLayer(5);		//output layer
		
		n.connectLayers();
				
		//n.printAllWeights();
		
		TrainingInput t = new TrainingInput();
				
		CSVReader dataReader = new CSVReader(new FileReader("TestCases/Data.csv"));
		CSVReader labelReader = new CSVReader(new FileReader("TestCases/Labels.csv"));
		
		String[] line; 
		String[] expOutput; 
		int i = 0;
		while (((line = dataReader.readNext()) != null) && i++ < 5) {
			expOutput = labelReader.readNext();
			n.feedCSVInput(line);
			n.fireAllNeurons();
			n.propError(t.returnOutput(expOutput), 5);
		}
		
		n.saveWeights();
		
		
		
		
		System.out.println("End.");
	}

}
