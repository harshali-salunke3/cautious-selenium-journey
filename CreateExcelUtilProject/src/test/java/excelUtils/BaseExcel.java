package excelUtils;

import org.apache.poi.ss.usermodel.Cell;

public class BaseExcel {

	public String getCellValue(Cell objcell) {
		
		String cellVal=null;
		
		Cell oCell = objcell;
		
		if(oCell.getCellType().equals("String"))
			cellVal= oCell.getStringCellValue();
		if(oCell.getCellType().equals("Integer"))
			cellVal = String.valueOf(oCell.getNumericCellValue());
		
		return cellVal;
	}
}
