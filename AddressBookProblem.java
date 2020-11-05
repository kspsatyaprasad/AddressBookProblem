import java.io.File;
import java.io.IOException;
public class Testing 
{

	public static void main(String[] args) 
	{
		try 
		{
			File myObj = new File("C:\\Users\\user\\Desktop\\AddressBook\\NewFile.txt");
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