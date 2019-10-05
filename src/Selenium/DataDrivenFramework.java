package Selenium;
import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class DataDrivenFramework {
	public static int sum = 0;
	public static int i,j,k,l;

	public static void main(String[] args) throws RowsExceededException, WriteException, BiffException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\user\\Desktop\\DATA.xls");
		Workbook rwb = Workbook.getWorkbook(f);
		Sheet rsh = rwb.getSheet(0);

		WritableWorkbook wwb = Workbook.createWorkbook(f, rwb);

		WritableSheet wsh = wwb.getSheet(0);


		int nur = rsh.getRows();
		int nuc = rsh.getColumns();


		//Row wise sum

		for(i=0; i<nur;i++) {

		for(j=0;j<nuc;j++) {

		String x = rsh.getCell(j,i).getContents();
		int num = Integer.parseInt(x);

		sum=sum+num;  	
	}
		System.out.println("Sum of "+(i+1)+" row: "+sum);
		String s = Integer.toString(sum);
		Label l = new Label(j,i,s);
		wsh.addCell(l);
		Thread.sleep(1000);

		sum=0;
}
		for(int k=0; k<nuc;k++) {

			for(l=0;l<nur;l++) {

			String x1 = rsh.getCell(k,l).getContents();
			int num1 = Integer.parseInt(x1);

			sum=sum+num1;  	
			     }
			System.out.println("Sum of "+(k+1)+" Column: "+sum);
			String s = Integer.toString(sum);
			Label l1 = new Label(k,l,s);
			wsh.addCell(l1);
			Thread.sleep(1000);

			sum=0;
			    } 
			wwb.write();
			wwb.close();
			rwb.close();
			  }

			}
