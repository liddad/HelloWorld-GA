package crossoverMethods;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CrossoverTests {

	private List<Boolean> b1;
	private List<Boolean> b2;
	private int size;
	
	@Before
	public void setup(){
		size = 10;
		b1 = new ArrayList<Boolean>();
		b2 = new ArrayList<Boolean>();
		
		for(int i=0; i<size; i++){
			b1.add((i%2==1)?true:false);
			b2.add(false);
		}
	}
	@Test
	public void testFiftyFifty() {
		CrossoverMethod test = new FiftyFiftyBitsCrossover(800, 50);
		List<List<Boolean>> b = test.testCrossover(b1, b2);
		List<Boolean> b1dash = b.get(0);
		List<Boolean> b2dash = b.get(1);
		for(int i=0;i<size;i++){
			if(i%2==0){
				assertEquals(b1dash.get(i),b2dash.get(i));
			} else {
				assertNotEquals(b1dash.get(i),b2dash.get(i));
			}
		}
	}
	
	@Test
	public void testSinglePoint(){
		CrossoverMethod test = new SinglePointCrossover(800, 50);
		List<List<Boolean>> b = test.testCrossover(b1, b2);
		List<Boolean> b1dash = b.get(0);
		List<Boolean> b2dash = b.get(1);
		int i = 0;
		while(i<size&&b1.get(i)==b1dash.get(i)){
			assertEquals(b2.get(i), b2dash.get(i));
			i++;
		}
		for(;i<size;i++){
			assertEquals(b1.get(i),b2dash.get(i));
			assertEquals(b2.get(i),b1dash.get(i));
		}
		
	}

}
