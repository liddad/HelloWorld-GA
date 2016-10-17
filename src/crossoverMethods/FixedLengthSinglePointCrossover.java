package crossoverMethods;

import java.util.List;

public class SinglePointCrossover extends CrossoverMethod {
	
	public SinglePointCrossover(int crossoverRate, int mutationRate){
		super(crossoverRate, mutationRate);
	}
	
	@Override
	protected void cross(List<Boolean> item1, List<Boolean> item2){
		int cutoffPoint = random.nextInt(item1.size()-1)+1;
		boolean temp;
		for(int i = cutoffPoint; i<item1.size(); i++){
			temp = item1.get(i);
			item1.set(i, item2.get(i));
			item2.set(i, temp);
		}
	}


}
