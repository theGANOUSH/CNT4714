package fileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import common.Book;


public class FileIO {
	
	public static List<Book> readCSV() throws FileNotFoundException, IOException{
		List<Book> books = new ArrayList<>();
		
		FileInputStream file = new FileInputStream("src/FileIO/inventory.txt");
		DataInputStream in = new DataInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String line;
		
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] fields = line.split(",");
            String id = fields[0];
            String title = fields[1];
            String price = fields[2];
            
            Book newBook = new Book(Integer.valueOf(id), price, title);
            
            books.add(newBook);
        }
        
        br.close();
        in.close();
		
		return books;
	}
	
	public static Book search(int id) throws FileNotFoundException, IOException {
		
		List<Book> library = null;
		Book foundBook = null;
		
		library = readCSV();
		
		for(Book d : library){
			if(d.getID() != 0 && d.getID()== id) {
				foundBook = d;
		        }
			}
		
		return foundBook;
	}
	
	public static void writeTransaction(String output) {
		try {
			FileWriter outStream = new FileWriter("transactions.txt", true);
			
			BufferedWriter oFile = new BufferedWriter(outStream);
			
			oFile.append(output);
			
			oFile.close();
			outStream.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error: " +e.getMessage());
		}
		
	}

	
}
