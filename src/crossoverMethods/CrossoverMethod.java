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
	private int mutations;
	private FitnessFunction fitnessFunction;
	
	public CrossoverMethod(int crossoverRate, int mutationRate){
		random = new Random(System.nanoTime());
		this.crossoverRate = crossoverRate;
		this.mutationRate = mutationRate;
		mutations = 0;
	}
	
	private float getAverageFitness(Population p){
		float avg = 0;
		for(List<Boolean> b:p.getPopulation()){
			avg+= (float)p.getFitnessFunction().fitnessFunction(b);
		}
		avg /= (float)p.getPopulation().size();
		return avg;
	}
	
	public Population crossover(Population population) {
		random = new Random(System.nanoTime());
		List<List<Boolean>> populationList = population.getPopulation();
		List<List<Boolean>> newPopulation = new ArrayList<List<Boolean>>();
//		System.out.println("Before: " + this.getAverageFitness(population));
		fitnessFunction = population.getFitnessFunction();
		for(int i=0; i<populationList.size(); i+=2){
			crossAndMutate(new ArrayList<Boolean>(populationList.get(i)), new ArrayList<Boolean>(populationList.get(i+1)), newPopulation);
		}
//		System.out.println("After: " + this.getAverageFitness(new Population(newPopulation, population.getFitnessFunction())));
		return new Population(newPopulation, population.getFitnessFunction());
	}
	
	public List<List<Boolean>> testCrossover(List<Boolean> b1, List<Boolean> b2){
		BooleanObject b = cross(b1, b2);
		List<List<Boolean>> list = new ArrayList<List<Boolean>>();
		list.add(b.boolean1);
		list.add(b.boolean2);
		return list;
	}
	
	public int getMutations(){
		int m = mutations;
		mutations = 0;
		return m;
	}
	
	private void crossAndMutate(List<Boolean> item1, List<Boolean> item2, List<List<Boolean>> list) {
		if(random.nextInt(10000)<8000){
//			System.out.println("Item 1: " + item1.toString());
//			System.out.println("Item 2: " + item2.toString());
//			System.out.println(((float)(fitnessFunction.fitnessFunction(item1)+fitnessFunction.fitnessFunction(item2)))/2.0);
			cross(item1, item2);
//			System.out.println("Item 1 after: " + item1.toString());
//			System.out.println("Item 2 after: " + item2.toString());
//			System.out.println(((float)(fitnessFunction.fitnessFunction(item1)+fitnessFunction.fitnessFunction(item2)))/2.0);
		}
		if(random.nextInt(10000)<mutationRate){
			mutations++;
			if(random.nextBoolean()){
				item1 = mutate(item1);
			} else {
				item2 = mutate(item2);
			}	
		}
		list.add(item1);
		list.add(item2);		
	}
	
	protected List<Boolean> mutate(List<Boolean> item){
		int bit = random.nextInt(item.size());
		item.set(bit, !item.get(bit));
		return item;
	}
	
	protected abstract BooleanObject cross(List<Boolean> item1, List<Boolean> item2);
	
	protected class BooleanObject{
		public List<Boolean> boolean1;
		public List<Boolean> boolean2;
	}

}
