package fitnessFunctions;

public class NumericFitness implements FitnessFunction{

	private boolean[] target;
	
	public NumericFitness(boolean[] target){
		this.target = target;
	}
	
	public int fitnessFunction(boolean[] array){
		int correct = 0;
		for(int i = 0; i<target.length; i++){
			if(target[i]==array[i]){
				correct++;
			}
		}
		return correct;
	}
}
