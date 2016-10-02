package crossoverMethods;

public class SinglePointCrossover extends CrossoverMethod {
	
	@Override
	protected BooleanObject cross(boolean[] item1, boolean[] item2){
		int cutoffPoint = random.nextInt(item1.length-1)+1;
		boolean temp;
		for(int i = cutoffPoint; i<item1.length; i++){
			temp = item1[i];
			item1[i] = item2[i];
			item2[i] = temp;
		}
		BooleanObject b = new BooleanObject();
		b.boolean1 = item1;
		b.boolean2 = item2;
		return b;
	}


}
