package dec21st;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) throws IOException {
	
		FileInputStream fis=new FileInputStream("D:\\007 LiveTech\\jars\\Book1.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet ws=wb.getSheet("Sheet1");
		
		System.out.println("LastRowNum"+ws.getLastRowNum());
		
		System.out.println("PhysicalNumberOfRows"+ws.getPhysicalNumberOfRows());
		
		XSSFRow row=null;
		XSSFCell cell=null;
		
		for(int i=0;i<=ws.getLastRowNum();i++)
		{
			row=ws.getRow(i);
			
			//System.out.println("LastCellNum"+row.getLastCellNum());
			
			//System.out.println("PhysicalNumberOfCells"+row.getPhysicalNumberOfCells());
			
			for(int j=0;j<row.getLastCellNum();j++)
			{
				cell=row.getCell(j);
				//System.out.println(cell);
				if(cell.getCellType()==CellType.NUMERIC)
				{
					System.out.println(cell.getNumericCellValue()+" is Number");
				}
				else if(cell.getCellType()==CellType.STRING)
				{
					System.out.println(cell.getStringCellValue()+" is String");
				}
				else if(cell.getCellType()==CellType.BOOLEAN)
				{
					System.out.println(cell.getBooleanCellValue()+" is Boolean");
				}
			}
			
		}
		
		System.out.println("End of Program...");
		
		
		
		
	}

}
