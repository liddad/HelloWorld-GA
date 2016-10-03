package selectionMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import v1.Population;

public class TournamentSelectionMethod implements SelectionMethod {

	private Random random;
	private int possibleNo;
	
	public TournamentSelectionMethod(int possibilities){
		super();
		random = new Random(System.nanoTime());
		possibleNo = possibilities;	
	}
	
	@Override
	public Population selectParents(Population p) {
		List<List<Boolean>> oldPopulation = p.getPopulation();
		List<List<Boolean>> newPopulation = new ArrayList<List<Boolean>>();
		int maxFitness;
		int maxPos;
		int fitness;
		List<Boolean> possible;
		for(int j = 0; j < oldPopulation.size(); j++){
			maxFitness = 0;
			maxPos = 0;
			fitness = 0;
			for(int i = 0; i< possibleNo; i++){
				int position = random.nextInt(oldPopulation.size());
				possible=oldPopulation.get(position);
				fitness = p.getFitnessFunction().fitnessFunction(possible);
				if(fitness>maxFitness){
					maxPos = position;
					maxFitness = fitness;
				}
			}
			newPopulation.add(oldPopulation.get(maxPos));
		}
		return new Population(newPopulation, p.getFitnessFunction());
	}
	
	public void setPossibilities(int n){
		possibleNo = n;
	}

}
