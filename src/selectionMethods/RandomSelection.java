package selectionMethods;

import v1.Population;

public class RandomSelection implements SelectionMethod {

	@Override
	public Population selectParents(Population p) {
		return p;
	}

}
