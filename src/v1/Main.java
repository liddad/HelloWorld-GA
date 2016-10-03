package v1;

import java.util.ArrayList;
import java.util.List;

import crossoverMethods.CrossoverMethod;
import crossoverMethods.DoublePointCrossover;
import crossoverMethods.FiftyFiftyBitsCrossover;
import crossoverMethods.RandomCrossover;
import crossoverMethods.SinglePointCrossover;
import fitnessFunctions.FitnessFunction;
import fitnessFunctions.NumericFitness;
import selectionMethods.LinearSelection;
import selectionMethods.RandomSelection;
import selectionMethods.SelectionMethod;
import selectionMethods.TournamentSelectionMethod;
import selectionMethods.WeightedRouletteSelection;

public class Main {

	public static void main(String args[]){
		int crossoverRate = 8000;
		int mutationRate = 500;
		int populationSize = 100;
		List<Boolean> targetString = TargetCreator.getBooleanArray("Hello world!");
		
		FitnessFunction fitnessFunction = new NumericFitness(targetString);
		SelectionMethod selectionMethod = new TournamentSelectionMethod(2);
		CrossoverMethod crossoverMethod = new SinglePointCrossover(crossoverRate, mutationRate);
		
		RandomValueCreator populationCreator = new RandomValueCreator(targetString.size());
		List<List<Boolean>> randomPopulation = populationCreator.getRandomPopulation(populationSize);
		
		Population population = new Population(new ArrayList<List<Boolean>>(randomPopulation),fitnessFunction);
		
		EvolutionStarter evolver = new EvolutionStarter();
		long startTime, runtime;
		int result, runs=100, avgTime = 0;
		float correct = 0;
		for(int i=0;i<runs;i++){
			startTime = System.currentTimeMillis();
			result = evolver.geneticAlgorithm(fitnessFunction, selectionMethod, crossoverMethod, population, 1500);
			runtime = System.currentTimeMillis()-startTime;
			if(result == targetString.size()){
				correct++;
			}
			avgTime+=runtime;
			randomPopulation = populationCreator.getRandomPopulation(populationSize);
			population = new Population(new ArrayList<List<Boolean>>(randomPopulation),fitnessFunction);
		}
		correct=(correct/runs) * 100;
		avgTime/=runs;
		System.out.println("Using Tournament Selection with 2 possibilities and a Single Point Crossover with crossover rate " + crossoverRate/100.0 + "%, mutation rate " + mutationRate/100.0 + "% and population size " + populationSize);
		System.out.println("Genetic Algorithm evolved the best possible answer " + correct + "% of the time in an average of " + avgTime + " ms");
		
		runs = 100;
		correct = 0;
		avgTime = 0;
		((TournamentSelectionMethod)selectionMethod).setPossibilities(2);
		crossoverMethod = new FiftyFiftyBitsCrossover(crossoverRate, mutationRate);
		
		for(int i=0;i<runs;i++){
			startTime = System.currentTimeMillis();
			result = evolver.geneticAlgorithm(fitnessFunction, selectionMethod, crossoverMethod, population, 1500);
			runtime = System.currentTimeMillis()-startTime;
			if(result == targetString.size()){
				correct++;
			}
			avgTime+=runtime;
			randomPopulation = populationCreator.getRandomPopulation(populationSize);
			population = new Population(new ArrayList<List<Boolean>>(randomPopulation),fitnessFunction);
		}
		correct=(correct/runs) * 100;
		avgTime/=runs;
		System.out.println("Using Tournament Selection with 2 possibilities and a 'uniform crossover' with crossover rate " + crossoverRate/100.0 + "%, mutation rate " + mutationRate/100.0 + "% and population size " + populationSize);
		System.out.println("Genetic Algorithm evolved the best possible answer " + correct + "% of the time in an average of " + avgTime + " ms");
		
		correct = 0;
		avgTime = 0;
		runs = 40;
		selectionMethod = new LinearSelection();
		crossoverMethod = new SinglePointCrossover(crossoverRate, mutationRate);
		
		for(int i=0;i<runs;i++){
			startTime = System.currentTimeMillis();
			result = evolver.geneticAlgorithm(fitnessFunction, selectionMethod, crossoverMethod, population, 1500);
			runtime = System.currentTimeMillis()-startTime;
			if(result == targetString.size()){
				correct++;
			}
			avgTime+=runtime;
			randomPopulation = populationCreator.getRandomPopulation(populationSize);
			population = new Population(new ArrayList<List<Boolean>>(randomPopulation),fitnessFunction);
		}
		correct=(correct/runs) * 100;
		avgTime/=runs;
		System.out.println("Using Linear Selection and a Single Point Crossover with crossover rate " + crossoverRate/100.0 + "%, mutation rate " + mutationRate/100.0 + "% and population size " + populationSize);
		System.out.println("Genetic Algorithm evolved the best possible answer " + correct + "% of the time in an average of " + avgTime + " ms");
		
		correct = 0;
		avgTime = 0;
		runs = 100;
		selectionMethod = new TournamentSelectionMethod(2);
		crossoverMethod = new DoublePointCrossover(crossoverRate, mutationRate);
		
		for(int i=0;i<runs;i++){
			startTime = System.currentTimeMillis();
			result = evolver.geneticAlgorithm(fitnessFunction, selectionMethod, crossoverMethod, population, 1500);
			runtime = System.currentTimeMillis()-startTime;
			if(result == targetString.size()){
				correct++;
			}
			avgTime+=runtime;
			randomPopulation = populationCreator.getRandomPopulation(populationSize);
			population = new Population(new ArrayList<List<Boolean>>(randomPopulation),fitnessFunction);
		}
		correct=(correct/runs) * 100;
		avgTime/=runs;
		System.out.println("Using Tournament Selection with 2 possibilities and a Double Point Crossover with crossover rate " + crossoverRate/100.0 + "%, mutation rate " + mutationRate/100.0 + "% and population size " + populationSize);
		System.out.println("Genetic Algorithm evolved the best possible answer " + correct + "% of the time in an average of " + avgTime + " ms");
		
		correct = 0;
		avgTime = 0;
		selectionMethod = new WeightedRouletteSelection();
		crossoverMethod = new DoublePointCrossover(crossoverRate, mutationRate);
		
		for(int i=0;i<runs;i++){
			startTime = System.currentTimeMillis();
			result = evolver.geneticAlgorithm(fitnessFunction, selectionMethod, crossoverMethod, population, 1500);
			runtime = System.currentTimeMillis()-startTime;
			if(result == targetString.size()){
				correct++;
			}
			avgTime+=runtime;
			randomPopulation = populationCreator.getRandomPopulation(populationSize);
			population = new Population(new ArrayList<List<Boolean>>(randomPopulation),fitnessFunction);
		}
		correct=(correct/runs) * 100;
		avgTime/=runs;
		System.out.println("Using Weighted Roulette Selection and a Double Point Crossover with crossover rate " + crossoverRate/100.0 + "%, mutation rate " + mutationRate/100.0 + "% and population size " + populationSize);
		System.out.println("Genetic Algorithm evolved the best possible answer " + correct + "% of the time in an average of " + avgTime + " ms");
		
		correct = 0;
		avgTime = 0;
		selectionMethod = new RandomSelection();
		crossoverMethod = new RandomCrossover(crossoverRate, mutationRate, targetString.size());
		int seconds = 2;
		
		RandomReturnValue randomResult = evolver.geneticAlgorithmTimeLimit(fitnessFunction, selectionMethod, crossoverMethod, population, seconds);
		randomPopulation = populationCreator.getRandomPopulation(populationSize);
		population = new Population(new ArrayList<List<Boolean>>(randomPopulation),fitnessFunction);
		
		correct=(correct/runs) * 100;
		avgTime/=runs;
		System.out.println("Using Random generation, in " + seconds + " seconds, " + randomResult.combinations + " (non-unique) combinations were created. The highest fitness found was " + randomResult.maxFitness);
		
		correct = 0;
		avgTime = 0;
		HillClimberAlgorithm hillClimber = new HillClimberAlgorithm(fitnessFunction);
		
		for(int i=0;i<runs;i++){
			startTime = System.nanoTime();
			result = hillClimber.hillClimb(targetString.size());
			runtime = System.nanoTime()-startTime;
			if(result == targetString.size()){
				correct++;
			}
			avgTime+=runtime;
		}
		correct=(correct/runs) * 100;
		avgTime/=runs;
		
		System.out.println("Hill Climber got the max possible value " + correct + "% of the time in an average of " + avgTime + " ns");
		
		
	}
}
