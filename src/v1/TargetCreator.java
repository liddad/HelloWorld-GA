package v1;

public class TargetCreator {

	public static boolean[] getBooleanArray(String target){
		
		byte[] byteArray = target.getBytes();
		boolean[] booleanArray = new boolean[target.length()*8];
		for (int i =0; i<byteArray.length; i++){
			for (int j=0; j<8; j++){
				booleanArray[7-j] = (byteArray[i]%(2^(j+1))==(2^j))?true:false;
				byteArray[i]-=byteArray[i]%(2^(j+1));
			}
		}
		return booleanArray;
	}
}
