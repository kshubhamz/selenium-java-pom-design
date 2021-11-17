package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	private ExcelReader() {

	}

	public static Map<String, Map<String, String>> readExcel(String testDataPath, String sheetname) throws IOException {
		Map<String, Map<String, String>> map = new HashedMap<>();

		FileInputStream fileInputStream = new FileInputStream(testDataPath);
		XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
		XSSFSheet sh = wb.getSheet(sheetname);

		int row = sh.getPhysicalNumberOfRows();
		int col = sh.getRow(0).getPhysicalNumberOfCells();

		for (int i = 1; i < row; i++) {
			Map<String, String> rowData = new HashedMap<>();
			String testId = getCellValue(sh.getRow(i).getCell(0));
			for (int j = 1; j < col; j++) {
				String colName = getCellValue(sh.getRow(0).getCell(j));
				String colValue = getCellValue(sh.getRow(i).getCell(j));
				rowData.put(colName, colValue);
			}
			map.put(testId, rowData);
		}

		wb.close();
		fileInputStream.close();
		return map;
	}

	private static String getCellValue(XSSFCell cell) {
		try {
			switch (cell.getCellType()) {
			case STRING:
				return cell.getStringCellValue();
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					return String.valueOf(sdf.format(cell.getDateCellValue()));
				} else {
					return String.format("%.1f", cell.getNumericCellValue());
				}
			case BLANK:
				return "";
			default:
				return "";
			}
		} catch (Exception e) {
			return "";
		}
	}

}
