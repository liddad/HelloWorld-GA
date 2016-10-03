package fitnessFunctions;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FitnessFunctionTester {

	private List<Boolean> b1;
	private List<Boolean> b2;
	private int size;
	
	@Before
	public void setup(){
		size = 20;
		b1 = new ArrayList<Boolean>();
		b2 = new ArrayList<Boolean>();
		
		for(int i=0; i<size; i++){
			b1.add((i%2==1)?true:false);
			b2.add(false);
		}
	}
	@Test
	public void testNumericFitness() {
		FitnessFunction test = new NumericFitness(b1);
		
		assertEquals(test.fitnessFunction(b2), size/2);
		assertEquals(test.fitnessFunction(b1), size);
	}

}
