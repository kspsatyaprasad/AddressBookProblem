import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class WriteFile 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter file name to write: ");
		String fileName = scanner.next();
		System.out.print("Enter file extension to write: ");
		String fileExtension = scanner.next();
		//System.out.print("Enter Text to write: ");
		//String text = scanner.next();
		File log = new File("C:\\Users\\user\\Desktop\\AddressBook\\"+fileName+fileExtension);
		try{
		    if(!log.exists()){
		        System.out.println("We had to make a new file.");
		        log.createNewFile();
		    }

		    FileWriter fileWriter = new FileWriter(log, true);

		    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		    Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
		    System.out.print("\nEnter a address: ");  
		    String address= sc.nextLine();              //reads string   
		    System.out.print("\nYou entered address: "+address);   
		   // bufferedWriter.close();
		    System.out.print("\nEnter firstname: ");  
		    String firstname= sc.nextLine();              //reads string   
		    System.out.print("\nYou entered firstname: "+firstname);   
		  //  bufferedWriter.close();
		    System.out.print("\nEnter secondname: ");  
		    String secondname= sc.nextLine();              //reads string   
		    System.out.print("\nYou entered secondname: "+secondname);   
		   // bufferedWriter.close();
		    System.out.print("\nEnter city: ");  
		    String city= sc.nextLine();              //reads string   
		    System.out.print("\nYou entered city: "+city);   
		   // bufferedWriter.close();
		    System.out.print("\nEnter state: ");  
		    String state= sc.nextLine();              //reads string   
		    System.out.print("\nYou entered state: "+state);   
		   // bufferedWriter.close();
		    System.out.print("\nEnter zip: ");  
		    String zip= sc.nextLine();              //reads string   
		    System.out.print("\nYou entered zip: "+zip);   
		   // bufferedWriter.close();
		    System.out.print("\nEnter phonenumber: ");  
		    String phonenumber= sc.nextLine();              //reads string   
		    System.out.print("\nYou entered phonenumber: "+phonenumber);   
		    System.out.print("\n SAVINGMENU \n TOSAVE-1 \n DON'TSAVE-2\n SAVEAS-3\n");  
		      int choice_for_saving = scanner.nextInt();
	switch(choice_for_saving) {
	case 1:
		 
		System.out.print("You Choose TO SAVE\n");
		bufferedWriter.write(address.toString()+ "\n");
		bufferedWriter.write(firstname + "\n");
		bufferedWriter.write(secondname + "\n");
 		bufferedWriter.write( city.toString() + "\n");
		bufferedWriter.write(state.toString()  + "\n");
		bufferedWriter.write( zip.toString() + "\n");
		bufferedWriter.write( phonenumber.toString() + "\n");
		bufferedWriter.close();
		
		System.out.print("Your data is STORED\n");
		break;
	case 2:
		System.out.print("You Choose NOT TO SAVE \n");
		break;
	case 3:
		System.out.print("You Choose SAVE AS\n");
		
		bufferedWriter.write(address.toString()+ "\n");
		bufferedWriter.write(firstname + "\n");
		bufferedWriter.write(secondname + "\n");
 		bufferedWriter.write( city.toString() + "\n");
		bufferedWriter.write(state.toString()  + "\n");
		bufferedWriter.write( zip.toString() + "\n");
		bufferedWriter.write( phonenumber.toString() + "\n");
		bufferedWriter.close();
		System.out.print("Enter file extension to SAVEAS: ");
		String SaveasfileExtension = scanner.next();
		byte[] array = new byte[500];
	    try {
	      FileInputStream sourceFile = new FileInputStream("C:\\Users\\user\\Desktop\\AddressBook\\"+fileName+fileExtension);
	      FileOutputStream destFile = new FileOutputStream("C:\\Users\\user\\Desktop\\AddressBook\\"+fileName+SaveasfileExtension);

	      // reads all data from input.txt
	      sourceFile.read(array);

	      // writes all data to newFile
	      destFile.write(array);
	      System.out.println("The input.txt file is copied to newFile.");

	      // closes the stream
	      sourceFile.close();
	      destFile.close();
	    }
	    catch (Exception e) {
	      e.getStackTrace();
	    }
		default:
		break; 
	    }
		    System.out.println("\nDone");
		} catch(IOException e) {
		    System.out.println("COULD NOT WRITE INTO FILE!!");
		}
		
	
	}
	    
	}
