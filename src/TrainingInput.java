
public class TrainingInput {
	static int size = 25;
	static int[] output0 = {0, 0, 0, 0, 0};
	static int[] output1 = {0, 0, 0, 0, 1}; 
	static int[] output2 = {0, 0, 0, 1, 0};
	static int[] output3 = {0, 0, 0, 1, 1}; 
	static int[] output4 = {0, 0, 1, 0, 0}; 
	static int[] output5 = {0, 0, 1, 0, 1}; 
	static int[] output6 = {0, 0, 1, 1, 0}; 
	static int[] output7 = {0, 0, 1, 1, 1}; 
	static int[] output8 = {0, 1, 0, 0, 0}; 
	static int[] output9 = {0, 1, 0, 0, 1}; 
	
	static int[][] outputs = {
		output0, output1, output2, output3, 
		output4, output5, output6, output7,
		output8, output9
	};
	
	static int[] inputNull = {
		0, 0, 0, 0, 0,
		0, 0, 0, 0, 0,
		0, 0, 0, 0, 0,
		0, 0, 0, 0, 0,
		0, 0, 0, 0, 0
	};
	
	static int[] input1a = {
		1, 0, 0, 0, 0,
		1, 0, 0, 0, 0,
		1, 0, 0, 0, 0,
		1, 0, 0, 0, 0,
		1, 0, 0, 0, 0
	};
	static int[] input1b = {
		0, 1, 0, 0, 0,
		0, 1, 0, 0, 0,
		0, 1, 0, 0, 0,
		0, 1, 0, 0, 0,
		0, 1, 0, 0, 0
	};
	static int[] input1c = {
		0, 0, 1, 0, 0,
		0, 0, 1, 0, 0,
		0, 0, 1, 0, 0,
		0, 0, 1, 0, 0,
		0, 0, 1, 0, 0
	};
	static int[] input1d = {
		0, 0, 0, 1, 0,
		0, 0, 0, 1, 0,
		0, 0, 0, 1, 0,
		0, 0, 0, 1, 0,
		0, 0, 0, 1, 0
	};
	static int[] input1e = {
		0, 0, 0, 0, 1,
		0, 0, 0, 0, 1,
		0, 0, 0, 0, 1,
		0, 0, 0, 0, 1,
		0, 0, 0, 0, 1
	};
	

	
	static int[] input5a = {
		1, 1, 1, 0, 0,
		1, 0, 0, 0, 0,
		1, 1, 1, 0, 0,
		0, 0, 1, 0, 0,
		1, 1, 1, 0, 0
	};
	
	static int[] input5b = {
		0, 1, 1, 1, 0,
		0, 1, 0, 0, 0,
		0, 1, 1, 1, 0, 
		0, 0, 0, 1, 0,
		0, 1, 1, 1, 0
	};
	
	static int[] input5c = {
		0, 0, 1, 1, 1,
		0, 0, 1, 0, 0,
		0, 0, 1, 1, 1, 
		0, 0, 0, 0, 1,
		0, 0, 1, 1, 1
	};	
	

	
	static int[] input4a = {
		1, 0, 1, 0, 0,
		1, 0, 1, 0, 0,
		1, 1, 1, 0, 0,
		0, 0, 1, 0, 0,
		0, 0, 1, 0, 0
	};
	
	static int[] input4b = {
		0, 1, 0, 1, 0,
		0, 1, 0, 1, 0,
		0, 1, 1, 1, 0,
		0, 0, 0, 1, 0,
		0, 0, 0, 1, 0
	};
	
	static int[] input4c = {
		0, 0, 1, 0, 1,
		0, 0, 1, 0, 1,
		0, 0, 1, 1, 1,
		0, 0, 0, 0, 1,
		0, 0, 0, 0, 1
	};
	

	
	
	public void train1(NeuralNet n) {
		n.run(input1a);
		n.propError(output1, 5);
		n.run(input1b); 
		n.propError(output1, 5);
		n.run(input1c);
		n.propError(output1, 5);
		n.run(input1d);
		n.propError(output1, 5);
		n.run(input1e);
		n.propError(output1, 5);
	}
	
	public void train4(NeuralNet n) {
		n.run(input4a);
		n.propError(output4, 5);
		n.run(input4b);
		n.propError(output4, 5);
		n.run(input4c);
		n.propError(output4, 5);
	}
	
	public void train5(NeuralNet n) {
		n.run(input5a);
		n.propError(output5, 5);
		n.run(input5b);
		n.propError(output5, 5);
		n.run(input5c);
		n.propError(output5, 5);
	}

	public int[] returnOutput(String[] expOutput) {
		if (expOutput[0].equals("10")) {
			 return outputs[0]; 
		}
		else {
			int x = Integer.parseInt(expOutput[0]);
			return outputs[x];
		}
	}
}
