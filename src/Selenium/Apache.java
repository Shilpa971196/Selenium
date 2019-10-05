package Selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Apache {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
FileInputStream fis= new FileInputStream("C:\\Users\\user\\Desktop\\Book1.xlsx");
XSSFWorkbook rwb = new XSSFWorkbook(fis);
//HSSFWorkbook rwb= new HSSFWorkbook (fis);
XSSFSheet rsh =rwb.getSheetAt(0);
int nur= rsh.getPhysicalNumberOfRows();
int nuc = rsh.getRow(0).getPhysicalNumberOfCells();
for(int i=0;i<nuc;i++)
{
	int sum =0;
	for(int j = 0;j<nur;j++)
	{
		XSSFCell cell= rsh.getRow(i).getCell(i);
		//String x = cell.getStringCellValue();
		//String x= rsh.getRow(i).getCell(i).getStringCellValue();
		DataFormatter formatter = new DataFormatter();
		String x = formatter.formatCellValue(cell);
		int x1 = Integer.parseInt(x);
		sum= sum+x1;
		
	}
	XSSFCell cell = rsh.getRow(i).createCell(nuc);
	cell.setCellValue(sum);
	FileOutputStream fout = new FileOutputStream("C:\\Users\\user\\Desktop\\Book1.xlsx");
	rwb.write(fout);
	}
rwb.close();
	}

}
