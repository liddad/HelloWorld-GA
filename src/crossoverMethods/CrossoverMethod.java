package crossoverMethods;

import java.util.ArrayList;
import java.util.List;

import v1.Population;

public abstract class CrossoverMethod {

	public Population crossover(Population population) {
		List<boolean[]> populationList = population.getPopulation();
		List<boolean[]> newPopulation = new ArrayList<boolean[]>();
		for(int i=0; i<populationList.size(); i+=2){
			crossoverMethod(populationList.get(i), populationList.get(i+1), newPopulation);
		}
		return new Population(newPopulation, population.getFitnessFunction());
	}
	
	protected abstract void crossoverMethod(boolean[] item1, boolean[] item2, List<boolean[]> list);

}
