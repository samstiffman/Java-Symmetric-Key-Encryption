package main;

import java.util.ArrayList;

public class Encrypt {

	public static byte[] encrypt(byte[] originalFile, SymmetricKey key) {
		
		
		ArrayList<Byte> fileList = new ArrayList<>(originalFile.length);  
		for(byte e: originalFile)
			fileList.add(e);
		final double size = fileList.size();
		for(int i=0; i<size;) {
			try {
				for(int q=0; q<key.hashValue.length;q++) {
					fileList.set(i, (byte)(fileList.get(i)^key.hashValue[q]));
					i++;
				}
			}catch(IndexOutOfBoundsException e) {
				break;
			}
		}
		byte[] returnArray = new byte[(int)size];
		for(int i=0; i<fileList.size(); i++) {
			returnArray[i] = fileList.get(i);
		}
		return returnArray;
	}	
}
