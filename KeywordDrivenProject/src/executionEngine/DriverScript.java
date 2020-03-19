package executionEngine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import config.ActionKeywords;

public class DriverScript {

	public static void main(String[] args) throws IOException {
		
		String xlfilepath="E:\\Selenium\\KeywordDrivenProject\\src\\dataEngine\\keyworddata.xlsx";
		XSSFWorkbook xlworkbook; 
		XSSFSheet xlsheet;
		XSSFCell xlcell;
		
		FileInputStream xlfile=new FileInputStream(xlfilepath);
		xlworkbook=new XSSFWorkbook(xlfile);
		xlsheet=xlworkbook.getSheet("Sheet1");
		
		for(int row=1;row<=6;row++)
		{
			xlcell=xlsheet.getRow(row).getCell(3);
			String celldata=xlcell.getStringCellValue();
	
			if(celldata.equals("openBrowser"))
			{
				ActionKeywords.openBrowser();
			}
			else if(celldata.equals("navigate"))
			{
				ActionKeywords.navigate();
			}
			else if(celldata.equals("username"))
			{
				ActionKeywords.username();
			}
			else if(celldata.equals("pwd"))
			{
				ActionKeywords.pwd();
			}
			else
			{
				ActionKeywords.clickSubmit();
			}
		}
	}

}
