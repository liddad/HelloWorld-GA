package crossoverMethods;

import java.util.List;
import java.util.Random;


public class SinglePointCrossover extends CrossoverMethod {
	
	@Override
	protected void crossoverMethod(boolean[] item1, boolean[] item2, List<boolean[]> list){
		Random random = new Random();
		int cutoffPoint = random.nextInt(item1.length+1);
		boolean temp;
		for(int i = cutoffPoint; i<item1.length; i++){
			temp = item1[i];
			item1[i] = item2[i];
			item2[i] = temp;
		}
		list.add(item1);
		list.add(item2);
	}

}
