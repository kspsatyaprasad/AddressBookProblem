import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class WriteFile {

	public static void main(String[] args) {
		File log = new File("C:\\Users\\user\\Desktop\\AddressBook\\NEWFILE.txt");

				try{
				    if(!log.exists()){
				        System.out.println("We had to make a new file.");
				        log.createNewFile();
				    }

				    FileWriter fileWriter = new FileWriter(log, true);

				    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				    
					Object timeStamp ="satya";
					bufferedWriter.write("******* " + timeStamp.toString() +"******* " + "\n");
				    bufferedWriter.close();

				    System.out.println("Done");
				} catch(IOException e) {
				    System.out.println("COULD NOT WRITE!!");
				}
		

		}
		
		

	}