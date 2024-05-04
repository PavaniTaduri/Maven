package Files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class filesmaven {
	
	static XSSFCell s_custid;
	static XSSFCell s_custname;

	public static void main(String[] args) throws IOException, InterruptedException{
 
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("C://Users//Administrator//Downloads//excel.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		//Get the number of rows in the file	
        System.out.println(sheet.getLastRowNum());
        
		int rowcount = sheet.getLastRowNum();
		for (int i = 1; i < rowcount +1; i ++) {
			s_custid = sheet.getRow(i).getCell(0);
			s_custname = sheet.getRow(i).getCell(1);
			display(s_custid,s_custname);
			XSSFCell cell = sheet.getRow(i).createCell(2);
			
			//cell.setCellStyle(style);
			
			//cell.setCellValue("tEST");
			//cell.setCellStyle(style);
			
		}
		//String cellval = cell.getStringCellValue();

	/*	fis.close();
		FileOutputStream fos = new FileOutputStream("C://Users//Administrator//Downloads//excel.xlsx");
		workbook.write(fos);
		workbook.close();
		fos.close(); */
	}
	static void display(XSSFCell s_custid2,XSSFCell s_custname2) throws InterruptedException

	{
 
		System.out.println("Custid is:" + s_custid2 + " Custname is : " + s_custname2);
	
		String p1 = s_custid2.toString();	
		String p2 = s_custname2.toString();
		
	}
}







   
	


