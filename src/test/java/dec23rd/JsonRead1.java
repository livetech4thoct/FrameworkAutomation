package dec23rd;

import java.io.FileNotFoundException;
import java.io.FileReader;



import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonRead1 {

	public static void main(String[] args) throws FileNotFoundException  {
		
		
		FileReader fis=new FileReader("src\\test\\resources\\testdata\\jsons\\Sample.json");
		
		JsonParser jsonParser=new JsonParser();
		
		Object obj=jsonParser.parse(fis);
		
		JsonObject jsonObj=(JsonObject)obj;
		
		JsonElement fName=(JsonElement) jsonObj.get("firstName");
		JsonElement age=(JsonElement) jsonObj.get("age");
		JsonElement pNo=(JsonElement) jsonObj.get("phone");
		
		System.out.println(fName);
		System.out.println(age);
		System.out.println(pNo);
		
		

		
	}

}
