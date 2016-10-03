package v1;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

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
		int crossoverRate = 8000;
		int mutationRate = 110;
		int populationSize = 100;
		List<Boolean> maxBest = null;
		List<Boolean> currentBest = null;
		List<Boolean> targetString = TargetCreator.getBooleanArray("Hello world!");
		
		FitnessFunction fitnessFunction = new NumericFitness(targetString);
		SelectionMethod selectionMethod = new TournamentSelectionMethod();
		CrossoverMethod crossoverMethod = new SinglePointCrossover(crossoverRate, mutationRate);
		
		RandomValueCreator populationCreator = new RandomValueCreator(targetString.size());
		Population population = new Population(populationCreator.getRandomPopulation(populationSize),fitnessFunction);
		
		long startTime = System.nanoTime();
		while(subsequentNonMovers<5000){
			population = population.generation(selectionMethod, crossoverMethod);
			currentBest = population.getFittest();
			lastMax = fitnessFunction.fitnessFunction(currentBest);
			if(lastMaxFitness==lastMax){
				subsequentNonMovers++;
			} else if(lastMaxFitness<lastMax) {
				maxBest = new ArrayList<Boolean>(currentBest);
				lastMaxFitness = lastMax;
				subsequentNonMovers = 0;
			} else{
				subsequentNonMovers = 0;
			}
			cycles++;
		}
		System.out.println("Run time: " + (System.nanoTime()-startTime) + " ns");
		System.out.println("No of cycles: " + cycles);
		System.out.println("Calculated Fitness: " + lastMaxFitness);
		System.out.println("Generated String: " + TargetCreator.readArray(maxBest));
	}
}
