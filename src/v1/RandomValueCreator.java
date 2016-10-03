package v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomValueCreator {

	private int bits;
	private Random random;
	
	public RandomValueCreator(int bits){
		this.bits = bits;
		random = new Random(System.nanoTime());
	}
	
	private List<Boolean> getRandomBooleanArray(){
		random = new Random(System.nanoTime());
		List<Boolean> array = new ArrayList<Boolean>();
		for (int i = 0; i<bits; i++){
			array.add(random.nextBoolean());
		}
		return array;
	}
	
	public List<List<Boolean>> getRandomPopulation(int populationSize){
		ArrayList<List<Boolean>> population = new ArrayList<List<Boolean>>();
		for(int i = 0; i<populationSize; i++){
			population.add(getRandomBooleanArray());
		}
		return population;
	}
}
