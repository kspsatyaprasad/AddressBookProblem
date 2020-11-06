import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;  
//PROVIDES SAVE AS OPTION
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AddressBook 
{

	
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) 
	{
		Options methods = new Options();
		methods.askUser();
	}
}
class Options 
{
	/** MENU TO BE PROVIDED TO USER **/
	void askUser() 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select an action..");
		System.out.println("1. To Create a contact");
		System.out.println("2. To Write into a contact");
		System.out.println("3. To Read into a contact");
		System.out.println("4. To Rename a contact");
		System.out.println("5. To Edit a contact");
		System.out.println("6. To Delete a contact");
		System.out.println("7. To Quit");

		int choice = scanner.nextInt();
		switch(choice) 
		{
		case 1:
			System.out.print("You Choose to create a contact \n");
			CreateFile();
			System.out.println("\n");
			askUser();
			break;
		case 2:
			System.out.print("You Choose to write into a contact \n");
			WriteFile();
			System.out.println("\n");
			askUser();
			break;
		case 3:
			System.out.print("You Choose to read into a contact \n");
			ReadFile();
			System.out.println("\n");
			askUser();
			break;
		case 4:
			System.out.print("You Choose to rename a contact \n");
			RenameFile();
			System.out.println("\n");
			askUser();
			break;
		case 5:
			System.out.print("You Choose to edit a contact \n");
			edit();
			System.out.println("\n");
			askUser();
			break;
		case 6:
			System.out.print("You Choose to delete a contact \n");
			deleteFile();
			System.out.println("\n");
			askUser();
			break;

		default:
			break;
		}
	}
	
	void CreateFile() 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter contact name: ");
		String contactName = scanner.next();
		try 
		{
			File myObj = new File("C:\\Users\\user\\Desktop\\AddressBook\\"+contactName);
			if (myObj.createNewFile()) 
			{
				System.out.println("contact created: "+ myObj.getName());

			}  else
			{
				System.out.println("contact already exists.");
				
			 if(myObj.exists()) 
			 {
					System.out.println("File name: "+myObj.getName());
					System.out.println("AbsolutePath: "+myObj.getAbsolutePath());
					System.out.println("Writable: "+myObj.canWrite());
					System.out.println("Readable: "+myObj.canRead());
					System.out.println("File size in Bytes: "+myObj.length());

		     }	
		}
	} 
		catch (IOException e)
		{
		System.out.println("An error occured.");
		e.printStackTrace();
	    }
			 }
		
		public void WriteFile() 
		{
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter contact name to write: ");
			String contactName = scanner.next();
			System.out.print("Enter file extension of the contact name file: ");
			String contactExtension = scanner.next();
			File log = new File("C:\\Users\\user\\Desktop\\AddressBook\\"+contactName+contactExtension);
			try
			{
			    if(!log.exists())
			    {
			        System.out.println("We had to make a new contact.");
			        log.createNewFile();
			    }

			    FileWriter contactWriter = new FileWriter(log, true);

			    BufferedWriter bufferedWriter = new BufferedWriter(contactWriter);
			    Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
			    System.out.print("\nEnter a address: ");  
			    String address= sc.nextLine();              //reads string   
			    System.out.print("\nYou entered address: "+address);   
			    System.out.print("\nEnter firstname: ");  
			    String firstname= sc.nextLine();              //reads string   
			    System.out.print("\nYou entered firstname: "+firstname);   
			    System.out.print("\nEnter secondname: ");  
			    String secondname= sc.nextLine();              //reads string   
			    System.out.print("\nYou entered secondname: "+secondname);   
			    System.out.print("\nEnter city: ");  
			    String city= sc.nextLine();              //reads string   
			    System.out.print("\nYou entered city: "+city);   
			    System.out.print("\nEnter state: ");  
			    String state= sc.nextLine();              //reads string   
			    System.out.print("\nYou entered state: "+state);   
			    System.out.print("\nEnter zip: ");  
			    String zip;
			   while(true) {
			    zip= sc.nextLine();              //reads string   
			    String zipRegex = "^[0-9]{6}$";
			      if( zip.matches(zipRegex))
					  {
			    	  System.out.print("\nYou entered zip: "+zip);
					  break;
					  }
			     else
			    	  System.out.println("Entered zip is invalid");
			   }
			   String phonenumber;
			   while(true) 
			   {
			    System.out.print("\nEnter phonenumber: ");  
			    phonenumber= sc.nextLine();              //reads string  
			    String phonenumberRegex = "^(\\d{2}[ ]){1}\\d{8}$";
			      if( phonenumber.matches(phonenumberRegex))
			      {
					  System.out.print("\nYou entered phonenumber: "+phonenumber);   
					  break;
			      }
			      else
			    	  System.out.println("Entered mobile number is invalid");
			   }
			    System.out.print("\n SAVINGMENU \n TOSAVE-1 \n DON'TSAVE-2\n SAVEAS-3\n");  
			      int choice_for_saving = scanner.nextInt();
		switch(choice_for_saving)
		{
		case 1:
			save(address,firstname,secondname,city,state,zip,phonenumber,contactName,contactExtension); 

			
			System.out.print("Your data is STORED\n");
			break;
		case 2:
			System.out.print("You Choose NOT TO SAVE \n");
			break;
		case 3:
			System.out.print("You Choose SAVE AS\n");
			save(address,firstname,secondname,city,state,zip,phonenumber,contactName,contactExtension); 
			System.out.print("Enter contact extension to SAVEAS: ");
			String SaveascontactExtension = scanner.next();
			byte[] array = new byte[500];
		    try 
		    {
		      FileInputStream sourceFile = new FileInputStream("C:\\Users\\user\\Desktop\\AddressBook\\"+contactName+contactExtension);
		      FileOutputStream destFile = new FileOutputStream("C:\\Users\\user\\Desktop\\AddressBook\\"+contactName+SaveascontactExtension);

		      // reads all data from input.txt
		      sourceFile.read(array);

		      // writes all data to newFile
		      destFile.write(array);
		      //System.out.println("The input.txt contact is copied to newFile.");

		      // closes the stream
		      sourceFile.close();
		      destFile.close();
		    }
		    catch (Exception e)
		    {
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
		void ReadFile() 
		{
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter contact name to read: ");
			String contactName = scanner.next();
		    try {
		  	  File myObj = new File("C:\\Users\\user\\Desktop\\AddressBook\\" +contactName);
		        Scanner myReader = new Scanner(myObj);
		        while (myReader.hasNextLine()) 
		        {
		          String data = myReader.nextLine();
		          System.out.println(data);
		        }
		        myReader.close();
		      } 
		    catch (FileNotFoundException e) 
		    {
		        System.out.println("An error occurred.");
		        e.printStackTrace();
		    }
		}
		void RenameFile()
		{
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter Old contact name: ");
			String oldcontactName = scanner.next();
			System.out.print("Enter New contact name: ");
			String newcontactName = scanner.next();
			File oldName = new File("C:\\Users\\user\\Desktop\\AddressBook\\" +oldcontactName); 
			File newName =  new File("C:\\Users\\user\\Desktop\\AddressBook\\" +newcontactName); 
			  
			        if (oldName.renameTo(newName))  
			            System.out.println("Renamed successfully");         
			        else 
			            System.out.println("Sorry contact is not renamed ");   
		}
		void save(String address,String firstname,String secondname,String city,String state,String zip,String phonenumber,String contactName,String contactExtension) 
		{
		
		File log = new File("C:\\Users\\user\\Desktop\\AddressBook\\"+contactName+contactExtension);
	   try 
	   {
		if(!log.exists())
		{
	        System.out.println("We had to make a new contact.");
	        log.createNewFile();
	    }

	    FileWriter contactWriter = new FileWriter(log, true);

	    BufferedWriter bufferedWriter = new BufferedWriter(contactWriter);
		bufferedWriter.write(address.toString()+ "\n");
		bufferedWriter.write(firstname + "\n");
		bufferedWriter.write(secondname + "\n");
 		bufferedWriter.write( city.toString() + "\n");
		bufferedWriter.write(state.toString()  + "\n");
		bufferedWriter.write( zip.toString() + "\n");
		bufferedWriter.write( phonenumber.toString() + "\n");
		bufferedWriter.close();
	   }
	    catch (Exception e) 
	    {
		    e.getStackTrace();
	    }

		}
		void edit() 
		{
			System.out.print("Enter contact name to read: ");
			Scanner scanner = new Scanner(System.in);
			String contactName = scanner.next();
			System.out.println("\nYou choose to EDIT");
			System.out.println("Press 1 to EDIT Address");
			System.out.println("Press 2 to EDIT firstname");
			System.out.println("Press 3 to EDIT secondname");
			System.out.println("Press 4 to EDIT city");
			System.out.println("Press 5 to EDIT state");
			System.out.println("Press 6 to EDIT zip");
			System.out.println("Press 7 to EDIT phonenumber");

			int choice = scanner.nextInt();
			switch(choice) 
			{
			case 1:
				editoptions(choice,contactName); 
                break;
			case 2:
				editoptions(choice,contactName); 
                break;
			case 3:
				editoptions(choice,contactName); 
                break;
			case 4:
				editoptions(choice,contactName); 
                break;
			case 5:
				editoptions(choice,contactName); 
                break;
			case 6:
				editoptions(choice,contactName); 
                break;
			case 7:
				editoptions(choice,contactName); 
                break;
		}
      }
		 public static void setVariable(int lineNumber, String data,String contactName) throws IOException 
		 {
				
			    Path path = Paths.get("C:\\Users\\user\\Desktop\\AddressBook\\"+contactName);
			    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			    lines.set(lineNumber - 1, data);
			    Files.write(path, lines, StandardCharsets.UTF_8);
		 }
		 void editoptions(int choice,String contactName) 
		 {
			    Scanner scanner = new Scanner(System.in);
			    System.out.print("\n Enter text :");
				String Text = scanner.next();
				try
				{
				EditFile obj =new EditFile();
			    setVariable(choice, Text,contactName);
			    System.out.println("Done");
				} 
				catch(IOException e)
				{
				    System.out.println("COULD NOT EDIT FILE");
							
				}
		 }
		 void deleteFile() 
		 {     
			   Scanner scanner = new Scanner(System.in);
			   System.out.print("Enter contact name to delete: ");
			   String contactName = scanner.next();
			   File contact = new File("C:\\Users\\user\\Desktop\\AddressBook\\"+contactName); 
		        if(contact.delete()) 
		        { 
		            System.out.println("File deleted successfully"); 
		        } 
		        else
		        { 
		            System.out.println("Failed to delete the contact"); 
		        }
			   
		 }
}

	