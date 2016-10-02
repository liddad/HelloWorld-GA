package crossoverMethods;

public class FiftyFiftyBitsCrossover extends CrossoverMethod {

	int[] array;
	int pos;
	public FiftyFiftyBitsCrossover(){
		super();
		array = new int[10000];
		pos = 0;
	}
	@Override
	protected BooleanObject cross(boolean[] item1, boolean[] item2){
		boolean temp;
		for(int i = 0; i<item1.length; i++){
			if(random.nextBoolean()){
				temp = item1[i];
				item1[i] = item2[i];
				item2[i] = temp;
			}
		}
		BooleanObject b = new BooleanObject();
		b.boolean1 = item1;
		b.boolean2 = item2;
		return b;
	}

}
