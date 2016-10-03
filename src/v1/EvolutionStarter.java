package v1;

import java.util.ArrayList;
import java.util.List;

import crossoverMethods.CrossoverMethod;
import fitnessFunctions.FitnessFunction;
import selectionMethods.SelectionMethod;

public class EvolutionStarter {

	public int geneticAlgorithm(FitnessFunction fitnessFunction, SelectionMethod selectionMethod, CrossoverMethod crossoverMethod, Population population, int acceptanceNo){
		
		int subsequentNonMovers=0;
		int lastMaxFitness = 0;
		int lastMax = 0;
		List<Boolean> maxBest = null;
		List<Boolean> currentBest = null;
		
		while(subsequentNonMovers<acceptanceNo){
			population = population.generation(selectionMethod, crossoverMethod);
			currentBest = population.getFittest();
			lastMax = fitnessFunction.fitnessFunction(currentBest);
			if(lastMaxFitness<lastMax) {
//				maxBest = new ArrayList<Boolean>(currentBest);
				lastMaxFitness = lastMax;
				subsequentNonMovers = 0;
			} else{
				subsequentNonMovers++;
			}
		}
		return lastMaxFitness;
	}
	
public RandomReturnValue geneticAlgorithmTimeLimit(FitnessFunction fitnessFunction, SelectionMethod selectionMethod, CrossoverMethod crossoverMethod, Population population, int seconds){
		
		int subsequentNonMovers=0;
		int lastMaxFitness = 0;
		int lastMax = 0;
		int cycles = 0;
		List<Boolean> maxBest = null;
		List<Boolean> currentBest = null;
		long endTime = System.currentTimeMillis() + (seconds*1000);
		while(System.currentTimeMillis()<endTime){
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
				subsequentNonMovers++;
			}
			cycles++;
		}
		RandomReturnValue r = new RandomReturnValue();
		r.combinations = cycles * population.getPopulation().size();
		r.maxFitness = lastMaxFitness;
		return r;
	}
}
