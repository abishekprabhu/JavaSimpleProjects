package FileHandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWriteAppend {

	public static void main(String[] args) {
		//Create a File
		File file = new File("EXAMPLE.txt");
		
		//checking file is created or not
		try {
			
			//find file is already exist
			boolean value = file.createNewFile();
			if(value) {
				
				System.out.println("File is Created.\n");
			}			
			else {
				System.out.println("File already Exist.\n");
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		//Write the data in File
		
		String data = "Test data in the File by Using FileWriter.";
		
		try {
			// written data to the file by creating a FileWriter object
			FileWriter Writing = new FileWriter(file);
			Writing.write(data);
			System.out.println("Written in the File.\n");
			Writing.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//Read the data in File
		
		try {
/*			read the data from the file by creating a BufferedReader object and 			
			using the readLine() method to read the data from the file. */
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			System.out.println("Reading inside the file.\n");
			System.out.println("Data:  "+ line);
			reader.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//create a new FileWriter object to append to the File
		try {
/*			second argument of the FileWriter constructor to true to indicate
			that you want to append data to the file instead of overwriting it. */
			
			FileWriter appendWriter = new FileWriter(file,true);
			// Append some text to the file
			appendWriter.write("\n\nThis is some more text added in the File.");
			System.out.println("\nAppend some text to the file.");			
			appendWriter.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
