package fitnessFunctions;

public class NumericFitness implements FitnessFunction{

	public int fitnessFunction(char[] array){
		int correct = 0;
		char[] helloworld = ("Hello World!").toCharArray();
		for(int i = 0; i<helloworld.length; i++){
			if(helloworld[i]==array[i]){
				correct++;
			}
		}
		return correct;
	}
}
