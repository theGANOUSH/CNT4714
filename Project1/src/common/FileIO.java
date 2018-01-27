package common;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileIO {
	
	public static void readInventory(String input) {
		InputStream in = ClassLoader.class.getResourceAsStream("/src/common/inventory.txt");
		InputStreamReader inr = new InputStreamReader(in);
			
		
	}
	
	public static void writeTransactions(String output) {
		try {
			FileWriter stream = new FileWriter("transactions.txt");
			BufferedWriter writeOut = new BufferedWriter(stream);
			
			writeOut.write(output);
			writeOut.newLine();
			writeOut.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error: " + e.getMessage());
		}
	}
	
}
