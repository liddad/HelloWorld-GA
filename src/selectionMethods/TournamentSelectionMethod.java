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
		List<List<Boolean>> oldPopulation = p.getPopulation();
		List<List<Boolean>> newPopulation = new ArrayList<List<Boolean>>();
		int possibleNo = 2;
		int maxFitness;
		int maxPos;
		int fitness;
		List<Boolean> possible;
		for(int j = 0; j < oldPopulation.size(); j++){
			maxFitness = 0;
			maxPos = 0;
			fitness = 0;
			possible = null;
			for(int i = 0; i< possibleNo; i++){
				int position = random.nextInt(oldPopulation.size());
//				System.out.println("Pos: " + position);
				possible=oldPopulation.get(position);
//				System.out.println("i: " + possible.toString());
				fitness = p.getFitnessFunction().fitnessFunction(possible);
//				System.out.println("Fitness: " + fitness);
				if(fitness>maxFitness){
					maxPos = position;
					maxFitness = fitness;
				}
			}
//			System.out.println("MaxFitness: " + maxFitness + " Maxpos: " + maxPos);
			newPopulation.add(oldPopulation.get(maxPos));
		}
		return new Population(newPopulation, p.getFitnessFunction());
	}

}
