package selectionMethods;

import fitnessFunctions.FitnessFunction;
import fitnessFunctions.NumericFitness;
import v1.Population;
import v1.RandomValueCreator;
import v1.TargetCreator;

public class TournamentTester {

	public static void main(String[] args) {
		boolean[] targetString = TargetCreator.getBooleanArray("Hello World!");
		SelectionMethod selectionMethod = new TournamentSelectionMethod();
		FitnessFunction fitnessFunction = new NumericFitness(targetString);
		
		RandomValueCreator populationCreator = new RandomValueCreator(targetString.length);
		Population population = new Population(populationCreator.getRandomPopulation(1000),fitnessFunction);
		
	for(int j=0; j<100; j++){
		System.out.println(population.getFitnessMap().keySet().toString());
		int avg = 0;
		for(int i:population.getFitnessMap().keySet()){
			avg+= i;
		}
		avg/=population.getFitnessMap().keySet().size();
		population = selectionMethod.selectParents(population);
	}


	}

}
