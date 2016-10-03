package fitnessFunctions;

import java.util.List;

public class NumericFitness implements FitnessFunction{

	private List<Boolean> target;
	
	public NumericFitness(List<Boolean> b1){
		this.target = b1;
	}
	
	public int fitnessFunction(List<Boolean> array){
		int correct = 0;
		for(int i = 0; i<array.size(); i++){
			if(target.get(i).equals(array.get(i))){
				correct++;
			}
		}
		return correct;
	}
}
