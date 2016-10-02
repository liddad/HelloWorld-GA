package crossoverMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import v1.Population;

public abstract class CrossoverMethod {
	
	protected Random random;
	protected int crossoverRate;
	protected int mutationRate;
	
	public CrossoverMethod(){
		random = new Random(System.nanoTime());
		crossoverRate = 80;
		mutationRate = 5;
	}
	
	public Population crossover(Population population) {
		random = new Random(System.nanoTime());
		List<boolean[]> populationList = population.getPopulation();
		List<boolean[]> newPopulation = new ArrayList<boolean[]>();
		for(int i=0; i<populationList.size(); i+=2){
			crossAndMutate(populationList.get(i), populationList.get(i+1), newPopulation);
		}
		return new Population(newPopulation, population.getFitnessFunction());
	}
	
	private void crossAndMutate(boolean[] item1, boolean[] item2, List<boolean[]> list) {
		if(random.nextInt(1000)<crossoverRate){
			BooleanObject b = cross(item1, item2);
			item1 = b.boolean1;
			item2 = b.boolean2;
		}
		if(random.nextInt(1000)<mutationRate){
			item1 = mutate(item1);
		}
		if(random.nextInt(1000)<mutationRate){
			item2 = mutate(item2);
		}
		list.add(item1);
		list.add(item2);		
	}
	
	protected boolean[] mutate(boolean[] item){
		int bit = random.nextInt(item.length);
		item[bit] = !item[bit];
		return item;
	}
	
	protected abstract BooleanObject cross(boolean[] item1, boolean[] item2);
	
	protected class BooleanObject{
		public boolean[] boolean1;
		public boolean[] boolean2;
	}

}
