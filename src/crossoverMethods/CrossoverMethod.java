package crossoverMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fitnessFunctions.FitnessFunction;
import v1.Population;

public abstract class CrossoverMethod {
	
	protected Random random;
	protected int crossoverRate;
	protected int mutationRate;
	
	public CrossoverMethod(int crossoverRate, int mutationRate){
		random = new Random(System.nanoTime());
		this.crossoverRate = crossoverRate;
		this.mutationRate = mutationRate;
	}

	
	public Population crossover(Population population) {
		List<List<Boolean>> populationList = population.getPopulation();
		List<List<Boolean>> newPopulation = new ArrayList<List<Boolean>>();
		for(int i=0; i<populationList.size(); i+=2){
			crossAndMutate(new ArrayList<Boolean>(populationList.get(i)), new ArrayList<Boolean>(populationList.get(i+1)), newPopulation);
		}
		return new Population(newPopulation, population.getFitnessFunction());
	}
	
	public List<List<Boolean>> testCrossover(List<Boolean> b1, List<Boolean> b2){
		cross(b1, b2);
		List<List<Boolean>> list = new ArrayList<List<Boolean>>();
		list.add(b1);
		list.add(b2);
		return list;
	}
	
	private void crossAndMutate(List<Boolean> item1, List<Boolean> item2, List<List<Boolean>> list) {
		if(random.nextInt(10000)<8000){
			cross(item1, item2);
		}
		if(random.nextInt(10000)<mutationRate){
			mutate(item1);
		}
		if(random.nextInt(10000)<mutationRate){
			mutate(item2);
		}
		list.add(item1);
		list.add(item2);		
	}
	
	protected void mutate(List<Boolean> item){
		int bit = random.nextInt(item.size());
		item.set(bit, !item.get(bit));
	}
	
	protected abstract void cross(List<Boolean> item1, List<Boolean> item2);
	

}
