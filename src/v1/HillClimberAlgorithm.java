package v1;

import java.util.List;

import fitnessFunctions.FitnessFunction;

public class HillClimberAlgorithm {
	
	private FitnessFunction fitnessFunction;

	public HillClimberAlgorithm(FitnessFunction fitnessFunction){
		this.fitnessFunction = fitnessFunction;
	}
	
	public int hillClimb(int bits){
		RandomValueCreator r = new RandomValueCreator(bits);
		List<Boolean> solution = r.getRandomPopulation(1).get(0);
		while(improve(solution));
		return fitnessFunction.fitnessFunction(solution);
		
	}
	
	private boolean improve(List<Boolean> list){
		int preFitness, postFitness;
		for(int i=0; i<list.size(); i++){
			preFitness = fitnessFunction.fitnessFunction(list);
			list.set(i, !list.get(i));
			postFitness = fitnessFunction.fitnessFunction(list);
			if(preFitness>postFitness){
				list.set(i, !list.get(i));
			} else{
				return true;
			}
		}
		return false;
	}
}
