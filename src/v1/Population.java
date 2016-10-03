package v1;

import java.util.ArrayList;
import java.util.List;

import crossoverMethods.CrossoverMethod;
import fitnessFunctions.FitnessFunction;
import selectionMethods.SelectionMethod;

public class Population {
	
	private List<List<Boolean>> population;
	private FitnessFunction fitnessFunction;
	
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
//		System.out.println("Avg: " + getAverageFitness(this));
		Population parents = selectionMethod.selectParents(this);
//		System.out.println("Avg after: " + getAverageFitness(parents));
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
	
	private float getAverageFitness(Population p){
		float avg = 0;
		for(List<Boolean> b:p.getPopulation()){
			avg+= p.getFitnessFunction().fitnessFunction(b);
		}
		avg = (float)avg / (float)p.getPopulation().size();
		return avg;
	}
}
