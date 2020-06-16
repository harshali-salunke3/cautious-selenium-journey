package excelUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

@Test
public class readExcel extends BaseExcel{
	
	public List<String> func_readExcel(String strSheetName, String primaryColName, String primaryDataVal) throws IOException{
		
		FileInputStream ofs= new FileInputStream(System.getProperty("user.dir") + "\\TestData.xlsx");
		
		XSSFWorkbook objTestDataWbk = new XSSFWorkbook(ofs);
		List<String> allTestVals = null;
		
		Iterator<Sheet> objSheets = objTestDataWbk.sheetIterator();
		while(objSheets.hasNext()) {
			Sheet objSheet = objSheets.next();
			if(objSheet.getSheetName().equalsIgnoreCase(strSheetName)) {
				Iterator<Row> itr_Rows = objSheet.rowIterator();
				while(itr_Rows.hasNext()){
					Row currentRow = itr_Rows.next();
					Iterator<Cell> itr_Col = currentRow.cellIterator();
					while(itr_Col.hasNext()) {
						Cell currentCell = itr_Col.next();
						if(getCellValue(currentCell).equalsIgnoreCase(primaryColName)) {
							allTestVals.add(getCellValue(currentCell));
							//enter values in list
							while(itr_Col.hasNext()) {
								currentCell = itr_Col.next();
								allTestVals.add(getCellValue(currentCell));
							}
						}
					}	
				}
			}
		}
		objTestDataWbk.close();
		objTestDataWbk = null;
		return allTestVals;
	}
}
