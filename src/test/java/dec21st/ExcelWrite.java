package dec21st;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void main(String[] args) throws IOException {
		
	FileInputStream fis=new FileInputStream("D:\\007 LiveTech\\jars\\xyz\\Book1.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet ws=wb.getSheet("Sheet3");
		
		//case1 : modfying an exiting ceel
		
		//ws.getRow(1).getCell(1).setCellValue("Old Live Tech");
		
		//case 2: creating a cell in existing row
		
		//ws.getRow(2).createCell(2).setCellValue("APPIUM");
		
		//case 3
		
		ws.createRow(4).createCell(0).setCellValue(false);
		
		FileOutputStream fos=new FileOutputStream("D:\\007 LiveTech\\jars\\xyz\\Book1.xlsx");
		
		wb.write(fos);
		
		wb.close();
		
		System.out.println("End of Program..");

	}

}
