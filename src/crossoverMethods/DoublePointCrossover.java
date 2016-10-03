package crossoverMethods;

import java.util.List;

public class DoublePointCrossover extends CrossoverMethod {

	public DoublePointCrossover(int crossoverRate, int mutationRate) {
		super(crossoverRate, mutationRate);
	}

	@Override
	protected void cross(List<Boolean> item1, List<Boolean> item2) {
		int bound1 = random.nextInt(item1.size()+1);
		int bound2 = random.nextInt(item1.size()+1);
		if(bound2<bound1){
			int temp = bound1;
			bound1 = bound2;
			bound2 = temp;
		}
		for(int i=bound1; i<bound2; i++){
			boolean temp = item1.get(i);
			item1.set(i, item2.get(i));
			item2.set(i, temp);
		}

	}

}
