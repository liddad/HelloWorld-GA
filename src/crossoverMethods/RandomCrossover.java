package crossoverMethods;

import java.util.List;

import v1.Population;
import v1.RandomValueCreator;

public class RandomCrossover extends CrossoverMethod {

	private RandomValueCreator random;
	public RandomCrossover(int crossoverRate, int mutationRate, int bits) {
		super(crossoverRate, mutationRate);
		random = new RandomValueCreator(bits);
	}
	@Override
	public Population crossover(Population p){
		return new Population(random.getRandomPopulation(p.getPopulation().size()), p.getFitnessFunction());
	}
	@Override
	protected void cross(List<Boolean> item1, List<Boolean> item2) {
		//Do nothing
	}

}
