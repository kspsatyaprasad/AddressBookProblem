import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class CreateFile 
{

	public static void main(String[] args) 
	{
		try 
		{   Scanner scanner = new Scanner(System.in);
		    System.out.print("Enter file name: ");
     		String fileName = scanner.next();
    		File myObj = new File("C:\\Users\\user\\Desktop\\AddressBook\\"+fileName);
			if (myObj.createNewFile())
			{
				System.out.println("File created: "+ myObj.getName());

			}  else 
			{
				System.out.println("File already exists.");
			}
		} 
		catch (IOException e) 
		{
			System.out.println("An error occured.");
			e.printStackTrace();
		}
		

		}
}