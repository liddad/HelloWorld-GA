package selectionMethods;

import java.util.ArrayList;
import java.util.List;

import fitnessFunctions.FitnessFunction;
import v1.Population;

public class LinearSelection implements SelectionMethod{

	private FitnessFunction fitnessFunction;
	
	@Override
	public Population selectParents(Population p) {
		List<List<Boolean>> populationList = p.getPopulation();
		fitnessFunction = p.getFitnessFunction();
		quicksort(populationList, 0, populationList.size()-1);
		return new Population(populationList, fitnessFunction);
	}
	
	private void quicksort(List<List<Boolean>> A, int lo, int  hi){
		if (lo < hi) {
			int p = partition(A, lo, hi);
			quicksort(A, lo, p - 1);
			quicksort(A, p + 1, hi);
		}
	}
    
	private int partition(List<List<Boolean>> A, int lo, int  hi){
		int pivot = fitnessFunction.fitnessFunction(A.get(hi));
		int i=lo;
		List<Boolean> temp;
		for(int j = lo; j<hi; j++){
			if(fitnessFunction.fitnessFunction(A.get(j))<=pivot){
				temp = A.get(i);
				A.set(i, A.get(j));
				A.set(j, temp);
				i++;
			}
		}
		temp = A.get(i);
		A.set(i, A.get(hi));
		A.set(hi, temp);
		return i;
	}

}
