package selectionMethods;

import java.util.List;

import fitnessFunctions.FitnessFunction;
import v1.Population;

public interface SelectionMethod {

	public List<boolean[]> selectParents(Population p, FitnessFunction fitnessFunction);
}
