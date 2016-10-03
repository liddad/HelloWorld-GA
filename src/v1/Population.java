package v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import crossoverMethods.CrossoverMethod;
import fitnessFunctions.FitnessFunction;
import selectionMethods.SelectionMethod;

public class Population {
	
	public List<List<Boolean>> population;
	public FitnessFunction fitnessFunction;
	public List<Boolean> fittest;
	
	public Population(List<List<Boolean>> population, FitnessFunction fitnessFunction){
		this.population = population;
		this.fitnessFunction = fitnessFunction;
	}
	
	public List<List<Boolean>> getPopulation(){
		return new ArrayList<List<Boolean>>(population);
	}
	
	public FitnessFunction getFitnessFunction(){
		return fitnessFunction;
	}
	
	public Population generation(SelectionMethod selectionMethod, CrossoverMethod crossoverMethod){
		Population parents = selectionMethod.selectParents(this);
		return crossoverMethod.crossover(parents);
	}
	
	public List<Boolean> getFittest() {
		int maxFitness = 0;
		int maxPos = 0;
		int fitness;
		for(int i=0; i<population.size();i++){
			fitness = fitnessFunction.fitnessFunction(population.get(i));
			if(fitness>maxFitness){
				maxFitness = fitness;
				maxPos = i;
			}
		}
		return population.get(maxPos);
	}
}
