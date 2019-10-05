package KeywordDrivenFramework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Driver {
	static FileOutputStream fout;
	public static void main(String[] args) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException {
		// TODO Auto-generated method stub
		
		//Connection with gmail method
  Gmail gm = new Gmail();
  Method [] m= gm.getClass().getMethods();//refelect method
  Thread.sleep(1000);
  //Connection with Excel
  FileInputStream fis = new FileInputStream("F:\\Java Program 2019\\Selenium\\gmailexcel.xlsx");
  XSSFWorkbook rwb = new XSSFWorkbook(fis);
  XSSFSheet rsh1 = rwb.getSheetAt(0);
   
  int nur1 = rsh1.getPhysicalNumberOfRows();
  
  XSSFSheet rsh2 = rwb.getSheetAt(1);
  int nur2 = rsh2.getPhysicalNumberOfRows();
  
  for(int i=0 ; i<nur1; i++)
  {
	String runMode  = rsh1.getRow(i).getCell(2).getStringCellValue()  ;
	String testCaseId  = rsh1.getRow(i).getCell(0).getStringCellValue()  ;
	
	if(runMode.equalsIgnoreCase("yes")) {
		
		for(int j=0; j<nur2; j++) {
			String stepId = rsh2.getRow(j).getCell(0).getStringCellValue();
			if(testCaseId.equalsIgnoreCase(stepId)) {
				String method = rsh2.getRow(j).getCell(2).getStringCellValue();
				String locator = rsh2.getRow(j).getCell(3).getStringCellValue();
				String data = rsh2.getRow(j).getCell(4).getStringCellValue();
				String criteria = rsh2.getRow(j).getCell(5).getStringCellValue();
				for(int k=0;k<m.length;k++) {
					if(method.equalsIgnoreCase(m[k].getName())){
						String res = (String) m[k].invoke(gm, locator,data,criteria);
						XSSFCell cell = rsh2.getRow(j).getCell(6);
						cell.setCellValue(res);
						
						FileOutputStream fout = new FileOutputStream("F:\\Java Program 2019\\Selenium\\outputexcel2.xlsx");
						
					}
				}
			}
		}
	}
	
  }
   rwb.write(fout);
  rwb.close();
	}

}
