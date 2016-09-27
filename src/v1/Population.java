package v1;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import crossoverMethods.CrossoverMethod;
import fitnessFunctions.FitnessFunction;
import selectionMethods.SelectionMethod;

public class Population {
	
	public List<boolean[]> population;
	public FitnessFunction fitnessFunction;
	public SortedMap<Integer, boolean[]> fitnessMap;
	
	public Population(List<boolean[]> population, FitnessFunction fitnessFunction){
		population = new ArrayList<boolean[]>();
		this.fitnessFunction = fitnessFunction;
		rankIndividuals();
	}

	public SortedMap<Integer, boolean[]> getFitnessMap(){
		return new TreeMap<Integer,boolean[]>(fitnessMap);
	}
	
	public List<boolean[]> getPopulation(){
		return new ArrayList<boolean[]>(population);
	}
	
	public FitnessFunction getFitnessFunction(){
		return fitnessFunction;
	}
	
	public Population generation(SelectionMethod selectionMethod, CrossoverMethod crossoverMethod){
		List<boolean[]> parents = selectionMethod.selectParents(this, fitnessFunction);
		return crossoverMethod.crossover(new Population(parents, fitnessFunction));
	}
	
	private void rankIndividuals() {
		fitnessMap = new TreeMap<Integer, boolean[]>();
		for(boolean[] b: population){
			fitnessMap.put(fitnessFunction.fitnessFunction(b), b);
		}
	}
}
