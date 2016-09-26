package v1;

import java.util.ArrayList;

import crossoverMethods.CrossoverMethod;
import selectionMethods.SelectionMethod;

public class Population {
	
	public ArrayList<char[]> population;
	
	public Population(){
		population = new ArrayList<char[]>();
	}
	
	public ArrayList<char[]> getPopulation(){
		return new ArrayList<char[]>(population);
	}
	public void add(char[] string){
		population.add(string);
	}
	
	public Population select(SelectionMethod selectionMethod){
		return selectionMethod.selectParents(this);
	}
	
	public Population crossoverAndMutate(CrossoverMethod crossoverMethod){
		return crossoverMethod.crossover(this);
	}
}
