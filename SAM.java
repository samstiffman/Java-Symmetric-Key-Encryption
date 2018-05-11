package FileXOR;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class SAM {

	public static void main(String args[]){
		if (args.length < 2) {
	         System.out.println("Please provide Input file and key");
	         System.exit(0);
	    }
	    String inputFile = args[0];
	    String outputFile = args[1];
	     
//		String inputFile = "C:\\Users\\18SamuelPS\\Desktop\\File.txt";
//	    String outputFile = "C:\\Users\\18SamuelPS\\Desktop\\E.txt";

//		inputFile = "C:\\Users\\18SamuelPS\\Desktop\\E.txt";
//	    outputFile = "C:\\Users\\18SamuelPS\\Desktop\\D.txt";
	    		if(args.length == 3) {
														
					char[] characters = args[2].toCharArray();
					byte[] bytes = new byte[characters.length];
					for(int i=0; i<characters.length; i++) {
						bytes[i] = (byte)characters[i];
					}
					
					SymmetricKey key = new SymmetricKey(bytes);
					byte allBytes[] = null;
				    try(InputStream inputStream = new FileInputStream(inputFile);){ 
				    	 long fileSize = new File(inputFile).length();
				    	 allBytes = new byte[(int) fileSize];
				    	 byte[] tempKey = new byte[16];
				    	 inputStream.read(allBytes);
				    	 inputStream.read(tempKey);
				    }catch(IOException e) {
				    	e.printStackTrace();
				    	System.exit(0);
				    }
				    try(OutputStream outputStream = new FileOutputStream(outputFile);){
				    	 outputStream.write(encrypt(allBytes, key));
				    }catch(IOException e) {
				    	e.printStackTrace();
				    }
				}
	}
	public static byte[] encrypt(byte[] originalFile, SymmetricKey key) {
		
		
		ArrayList<Byte> fileList = new ArrayList<>(originalFile.length);  
		for(byte e: originalFile)
			fileList.add(e);
		final double size = fileList.size();
		for(int k=0; k<200; k++) {
			for(int i=k; i<size;) {
				try {
					for(int q=0; q<key.hashValue.length;q++) {
						fileList.set(i, (byte)(fileList.get(i)^key.hashValue[q]));
						i++;
					}
				}catch(IndexOutOfBoundsException e) {
					break;
				}
			}
			for(int i=(int) size; i>k;) {
				try {
					for(int q=0; q<key.hashValue.length;q++) {
						fileList.set(i, (byte)(fileList.get(i)^key.hashValue[q]));
						i-=k;
					}
				}catch(IndexOutOfBoundsException e) {
					break;
				}
			}
		}
		byte[] returnArray = new byte[(int)size];
		for(int i=0; i<fileList.size(); i++) 
			returnArray[i] = fileList.get(i);
		return returnArray;
	}	
}
