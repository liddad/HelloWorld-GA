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
	
	private boolean[] getRandomBooleanArray(){
		random = new Random(System.nanoTime());
		boolean[] array = new boolean[bits];
		for (int i = 0; i<bits; i++){
			array[i]=random.nextBoolean();
		}
		return array;
	}
	
	public List<boolean[]> getRandomPopulation(int populationSize){
		ArrayList<boolean[]> population = new ArrayList<boolean[]>();
		for(int i = 0; i<populationSize; i++){
			population.add(getRandomBooleanArray());
		}
		return population;
	}
}
