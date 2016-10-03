package selectionMethods;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fitnessFunctions.NumericFitness;
import v1.Population;
import v1.RandomValueCreator;

public class SelectionTests {

	private List<List<Boolean>> list;
	List<Boolean> b;
	int size ;
	
	@Before
	public void setup(){
		
		size = 5;
		b = new ArrayList<Boolean>();
		
		for(int i = 0; i<size; i++){
			b.add(false);
		}
		list = new ArrayList<List<Boolean>>();
		RandomValueCreator populationCreator = new RandomValueCreator(size);
		list = populationCreator.getRandomPopulation(40);
	}
	
	@Test
	public void testTournament() {
		SelectionMethod s = new TournamentSelectionMethod();
		Population p = new Population(list, new NumericFitness(b));
		float currentAvg = getAverageFitness(p);
		for(int i = 0; i<4; i++){
			p = s.selectParents(p);
			float nextAvg = this.getAverageFitness(p);
			assertTrue(nextAvg >= currentAvg);
			currentAvg = nextAvg;
		}
	}
	
	private float getAverageFitness(Population p){
		float avg = 0;
		for(List<Boolean> b:p.getPopulation()){
			avg+= (float)p.getFitnessFunction().fitnessFunction(b);
		}
		avg /= (float)list.size();
		return avg;
	}

}
