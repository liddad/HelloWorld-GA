package crossoverMethods;

import java.util.Arrays;
import java.util.SortedMap;

import fitnessFunctions.FitnessFunction;
import fitnessFunctions.NumericFitness;
import v1.Population;
import v1.RandomValueCreator;
import v1.TargetCreator;

public class SinglePointTester {

	public static void main(String[] args) {
		boolean[] targetString = TargetCreator.getBooleanArray("He");
		CrossoverMethod crossoverMethod = new SinglePointCrossover();
		FitnessFunction fitnessFunction = new NumericFitness(targetString);
		
		RandomValueCreator populationCreator = new RandomValueCreator(targetString.length);
		Population population = new Population(populationCreator.getRandomPopulation(2),fitnessFunction);
		
		SortedMap<Integer, boolean[]> s = population.getFitnessMap();
		System.out.println(Arrays.toString(s.get(s.firstKey())));
		System.out.println(Arrays.toString(s.get(s.lastKey())));
		crossoverMethod.crossover(population);
		System.out.println(Arrays.toString(s.get(s.firstKey())));
		System.out.println(Arrays.toString(s.get(s.lastKey())));
		
	}
}
