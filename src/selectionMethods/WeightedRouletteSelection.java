package selectionMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fitnessFunctions.FitnessFunction;
import v1.Population;

public class WeightedRouletteSelection implements SelectionMethod {

	@Override
	public Population selectParents(Population p) {
		List<Integer> list = new ArrayList<Integer>();
		List<List<Boolean>> population = p.getPopulation();
		List<List<Boolean>> newPop = new ArrayList<List<Boolean>>();
		FitnessFunction f = p.getFitnessFunction();
		int total = 0, current;
		for(int i = 0; i<population.size(); i++){
			current = f.fitnessFunction(population.get(i));
			list.add(i,current);
			total += current;
		}
		Random random = new Random(System.nanoTime());
		for(int i=0; i<population.size(); i++){
			current = random.nextInt(total);
			for(int j=0; j<list.size(); j++){
				current -= list.get(j);
				if(current<0){
					newPop.add(population.get(j));
					break;
				}
			}
		}
		return new Population(newPop, f);
	}

}
