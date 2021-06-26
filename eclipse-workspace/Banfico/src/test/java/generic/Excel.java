package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

public class Excel implements Automation_Constants {
	public static String getCellValue(String PATH,String Sheet,int row,int col)
	{
		String value="";
		try
		{
			FileInputStream fis=new FileInputStream(PATH);
			Workbook wb=WorkbookFactory.create(fis);
			Cell c=wb.getSheet(Sheet).getRow(row).getCell(col);
			value=c.getStringCellValue();
			
		}
		catch(Exception e)
		{
			Reporter.log("path is invalid",true);
		}
		return value;
		
	}

}
