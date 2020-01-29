package generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Arun
 *
 */
public class FileLib {
	
	
/*****
 * 
 * @param path
 * @param key
 * @return
 * @throws IOException
 */

	public String getDataFromProperties(String key) throws IOException
	{
		FileInputStream f= new FileInputStream("./properties/commandata.properties");
		Properties p= new Properties();
		p.load(f);
		 
		return p.getProperty(key);
		
	}
	
	public String readDataFromExcel(String sheet,int rownum,int colnum) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		Workbook book = WorkbookFactory.create(new FileInputStream("./properties/input.xlsx.xlsx"));
		String data = book.getSheet(sheet).getRow(rownum).getCell(colnum).toString();
		
		return data;
		
	}
	
	
	
}



