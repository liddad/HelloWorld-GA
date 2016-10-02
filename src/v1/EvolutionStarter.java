package v1;

import crossoverMethods.CrossoverMethod;
import crossoverMethods.FiftyFiftyBitsCrossover;
import crossoverMethods.SinglePointCrossover;
import fitnessFunctions.FitnessFunction;
import fitnessFunctions.NumericFitness;
import selectionMethods.SelectionMethod;
import selectionMethods.TournamentSelectionMethod;

public class EvolutionStarter {

	public static void main(String args[]){
		int subsequentNonMovers=0;
		int lastMaxFitness = 0;
		int cycles = 0;
		int lastMax = 0;
		int populationSize = 10000;
		boolean[] targetString = TargetCreator.getBooleanArray("Hello World!");
		System.out.println(targetString.length);
		
		FitnessFunction fitnessFunction = new NumericFitness(targetString);
		SelectionMethod selectionMethod = new TournamentSelectionMethod();
		CrossoverMethod crossoverMethod = new SinglePointCrossover();
		
		RandomValueCreator populationCreator = new RandomValueCreator(targetString.length);
		Population population = new Population(populationCreator.getRandomPopulation(populationSize),fitnessFunction);
		
		while(subsequentNonMovers<10){
			population = population.generation(selectionMethod, crossoverMethod);
			lastMax = population.getFitnessMap().lastKey();
			if(lastMaxFitness==lastMax){
				subsequentNonMovers++;
			} else if(lastMaxFitness<lastMax) {
				lastMaxFitness = lastMax;
				subsequentNonMovers = 0;
			} else{
				subsequentNonMovers = 0;
			}
			cycles++;
		}
		
		System.out.println(cycles);
		System.out.println(lastMaxFitness);
		System.out.println(TargetCreator.readArray(population.getFitnessMap().get(population.getFitnessMap().lastKey())));
		
	}
}
