package generic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	static String  path="./data/book1.xlsx";
	public static String getCellValue(String path,String sheet,int r,int c) {
		String str="";
		try {
			Workbook w=WorkbookFactory.create(new FileInputStream(path));
			str=w.getSheet(sheet).getRow(r).getCell(c).toString();			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	public static void printCellData(String path,String sheet,int r,int c) {
		try {
			Workbook w=WorkbookFactory.create(new FileInputStream(path));
			for(int i=0;i<=r;i++) {
				for(int j=0;j<=c;j++) {
					String	s = w.getSheet(sheet).getRow(i).getCell(j).toString();
					System.out.print(s+" ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public static void main(String[] args) {
		int row = getRowCount(path,"Sheet1");
		int colmn=getColumnCount(path,"Sheet1");
		int cell = getCellCount(path,"Sheet1");
		printCellData(path,"Sheet1",row,colmn);
		System.out.println("Total Number of rows :-    "+row);
		System.out.println("Total Number of cells :-   "+cell);
		System.out.println("Total Number of columns :- "+colmn);
	}
	public static int getRowCount(String path,String sheet) {
		int rc=0;
		try {
			Workbook w=WorkbookFactory.create(new FileInputStream(path));
			rc = w.getSheet(sheet).getLastRowNum();
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		return rc;
	}
	public static int getColumnCount(String path,String sheet) {
		int col=0;
		try {
			Workbook w=WorkbookFactory.create(new FileInputStream(path));
			col=w.getSheet(sheet).getRow(0).getLastCellNum()-1;
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		return col;
	}
	public static int getCellCount(String path,String sheet) {
		int rc=0;
		int count=0;
		try {
			Workbook w=WorkbookFactory.create(new FileInputStream(path));
			rc = w.getSheet(sheet).getLastRowNum();
			for(int i=0;i<=rc;i++) {
				for(int j=0;j<=i;j++) {
					count++;
				}
			}
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}                                                             
		return count;

	}
}

