package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SAM {

	public static void main(String args[]){
		if (args.length < 2) {
	         System.out.println("Please provide input and output files");
	         System.exit(0);
	    }
	    String inputFile = args[0];
	    String outputFile = args[1];
	     
	    if(args.length == 2) {
			try(
				InputStream inputStream = new FileInputStream(inputFile);
				OutputStream outputStream = new FileOutputStream(outputFile);
			 ){
				long fileSize = new File(inputFile).length();
				byte[] allBytes = new byte[(int) fileSize];
				inputStream.read(allBytes);
				SymmetricKey key = new SymmetricKey();
				System.out.println("Your Symmetric key: Keep this " + key);
				outputStream.write(Encrypt.encrypt(allBytes, key));
			}catch(IOException e) {
				e.printStackTrace();
			}
	    }
		else if(args.length == 3) {
			System.out.println(args[2]); 
			String[] byteValues = args[2].substring(1, args[2].length() - 1).split(",");
					
			byte[] bytes = new byte[byteValues.length];

			for (int i=0, len=bytes.length; i<len; i++) 
				bytes[i] = Byte.parseByte(byteValues[i].trim());     
			SymmetricKey key = new SymmetricKey(bytes);
			try(
				InputStream inputStream = new FileInputStream(inputFile);
				OutputStream outputStream = new FileOutputStream(outputFile);
			    ){ 
				long fileSize = new File(inputFile).length();
				byte[] allBytes = new byte[(int) fileSize];
				byte[] tempKey = new byte[16];
				inputStream.read(allBytes);
				inputStream.read(tempKey);
				outputStream.write(Encrypt.encrypt(allBytes, key));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
