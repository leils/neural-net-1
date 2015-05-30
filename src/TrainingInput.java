
public class TrainingInput {
	static int size = 25;
	
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
	
	
	static int[] output1 = {
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
	
	static int[] output5 = {
		0, 0, 1, 0, 1
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
	
	public void train5(NeuralNet n) {
		n.run(input5a);
		n.propError(output5, 5);
		n.run(input5b);
		n.propError(output5, 5);
		n.run(input5c);
		n.propError(output5, 5);
	}

}
