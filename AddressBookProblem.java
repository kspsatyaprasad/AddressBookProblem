
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths;
import java.util.List; 
import java.io.IOException;
import java.nio.charset.StandardCharsets;
public class EditFile {
	 public static void setVariable(int lineNumber, String data) throws IOException {
		String fileName="bridge.txt";
	    Path path = Paths.get("C:\\Users\\user\\Desktop\\AddressBook\\"+fileName);
	    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
	    lines.set(lineNumber - 1, data);
	    Files.write(path, lines, StandardCharsets.UTF_8);
	}
	public static void main(String[] args) {
			try{
			String a="newtext";
		EditFile obj =new EditFile();
		int line=3;
	    setVariable(line, a);
	    System.out.println("Done");
					} catch(IOException e) {
					    System.out.println("COULD NOT EDIT FILE");
					}
	}

}
