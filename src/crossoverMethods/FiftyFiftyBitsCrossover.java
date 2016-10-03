package crossoverMethods;

import java.util.List;

public class FiftyFiftyBitsCrossover extends CrossoverMethod {

	public FiftyFiftyBitsCrossover(int crossoverRate, int mutationRate){
		super(crossoverRate, mutationRate);
	}
	
	@Override
	protected void cross(List<Boolean> item1, List<Boolean> item2){
		boolean temp;
		for(int i = 0; i<item1.size(); i++){
			if(random.nextBoolean()){
				temp = item1.get(i);
				item1.set(i, item2.get(i));
				item2.set(i, temp);
			}
		}
	}

}
