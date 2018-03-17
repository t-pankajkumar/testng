import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTesting {

	public static void main(String[] args) {
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\Users\\pankajkumar\\Downloads\\excel.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			XSSFRow row = sheet.getRow(0);
			XSSFCell cell = row.getCell(0);
			String s = cell.getStringCellValue();
			System.out.println(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getCellData(int row,int col) {
		
	}

}
