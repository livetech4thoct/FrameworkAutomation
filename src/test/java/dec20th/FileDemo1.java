package dec20th;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {

	public static void main(String[] args) throws IOException {
		
		
		File f1=new File("D:\\007 LiveTech\\jars\\abc.txt");
		
		f1.createNewFile();
		
		System.out.println("End of Program..");

	}

}
