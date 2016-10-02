package v1;

import java.io.UnsupportedEncodingException;

public class TargetCreator {

	public static boolean[] getBooleanArray(String target){
		
		byte[] byteArray = target.getBytes();
		boolean[] booleanArray = new boolean[byteArray.length*8];
		for (int i =0; i<byteArray.length; i++){
			for (int j=0; j<8; j++){
				booleanArray[i*8+(7-j)] = (byteArray[i]%(Math.pow(2, j+1))==(Math.pow(2, j)))?true:false;
				byteArray[i]-=byteArray[i]%(Math.pow(2, j+1));
			}
		}
		return booleanArray;
	}
	
	public static String readArray(boolean[] array){
		byte currByte;
		byte[] string = new byte[array.length/8];
		for(int i = 0; i<(array.length/8); i++){
			currByte = 0;
			for(int j=0; j<8; j++){
				if(array[(i*8)+j]){
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
