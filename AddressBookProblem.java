
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
public class EditFile {
	public static void main(String[] args)
	{
	System.out.print("Enter file name to read: ");
	Scanner scanner = new Scanner(System.in);
	String fileName = scanner.next();
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
		editoptions(choice,fileName); 
        break;
	case 2:
		editoptions(choice,fileName); 
        break;
	case 3:
		editoptions(choice,fileName); 
        break;
	case 4:
		editoptions(choice,fileName); 
        break;
	case 5:
		editoptions(choice,fileName); 
        break;
	case 6:
		editoptions(choice,fileName); 
        break;
	case 7:
		editoptions(choice,fileName); 
        break;
}
}
 public static void setVariable(int lineNumber, String data,String fileName) throws IOException 
 {
		
	    Path path = Paths.get("C:\\Users\\user\\Desktop\\AddressBook\\"+fileName);
	    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
	    lines.set(lineNumber - 1, data);
	    Files.write(path, lines, StandardCharsets.UTF_8);
	}
 static void editoptions(int choice,String fileName) 
 {
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("\n Enter text :");
		String Text = scanner.next();
		try{
		EditFile obj =new EditFile();
	    setVariable(choice, Text,fileName);
	    System.out.println("Done");
					} catch(IOException e) {
					    System.out.println("COULD NOT EDIT FILE");
					}
 }
 


}
