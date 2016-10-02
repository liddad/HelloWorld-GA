package selectionMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import v1.Population;

public class TournamentSelectionMethod implements SelectionMethod {

	private Random random;
	public TournamentSelectionMethod(){
		random = new Random(System.nanoTime());
	}
	@Override
	public Population selectParents(Population p) {
		random = new Random(System.nanoTime());
		List<boolean[]> oldPopulation = p.getPopulation();
		List<boolean[]> newPopulation = new ArrayList<boolean[]>();
		int possibleNo = 8;
		int maxFitness = 0;
		int maxPos = 0;
		int fitness = 0;
		boolean[] possible;
		for(int j = 0; j < oldPopulation.size(); j++){
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

}
