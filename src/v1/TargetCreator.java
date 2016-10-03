package v1;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class TargetCreator {

	public static List<Boolean> getBooleanArray(String target){
		
		byte[] byteArray = target.getBytes();
		List<Boolean> booleanArray = new ArrayList<Boolean>();
		for (int i =0; i<byteArray.length; i++){
			for(int j=0; j<8; j++){
				booleanArray.add(false);
			}
			for (int j=0; j<8; j++){
				booleanArray.set(i*8+(7-j), (byteArray[i]%(Math.pow(2, j+1))==(Math.pow(2, j)))?true:false);
				byteArray[i]-=byteArray[i]%(Math.pow(2, j+1));
			}
		}
		return booleanArray;
	}
	
	public static String readArray(List<Boolean> array){
		byte currByte;
		byte[] string = new byte[array.size()/8];
		for(int i = 0; i<(array.size()/8); i++){
			currByte = 0;
			for(int j=0; j<8; j++){
				if(array.get((i*8)+j)){
					currByte += Math.pow(2,7-j);
				}
			}
			string[i] = currByte;
		}
		String s;
		try {
			s = new String(string, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			s = "Error";
		}
		return s;
		
	}
}
