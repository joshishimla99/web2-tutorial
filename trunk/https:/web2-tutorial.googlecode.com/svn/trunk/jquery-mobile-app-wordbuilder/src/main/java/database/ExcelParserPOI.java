package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.naming.directory.DirContext;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelParserPOI {
	public static void main(String[] args) {
		XeroundDataAccess access = new XeroundDataAccess();
		File directory = new File("D:/Wordlist/");
		String filename[] = directory.list();

		for (int i = 0; i < 1; i++) {
			HSSFWorkbook wb = null;
			try {
				// InputStream is = new FileInputStream(new
				// File("/media/FreeAgent GoFlex Drive/start here/GRE/Wordlist/Excel/Wordlist/A Wordlist 1-322.xls"));
				InputStream is = new FileInputStream(new File("D:/Wordlist/"
						+ filename[i]));
				POIFSFileSystem fs = new POIFSFileSystem(is);
				wb = new HSSFWorkbook(fs);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// start appending the values
			StringBuffer sb = new StringBuffer();

			HSSFSheet sheet = wb.getSheetAt(0);

			// loop for every row in each worksheet
			for (Iterator rows = sheet.rowIterator(); rows.hasNext();) {
				HSSFRow row = (HSSFRow) rows.next();
				String word = getRowColumnValue(row, 1);
				String usage = getRowColumnValue(row, 2);
				String meaning = getRowColumnValue(row, 3);
				access.insert(word, usage, meaning);
			}
		}
		access.shutdown();
	}

	private static String getRowColumnValue(HSSFRow row, int c) {
		HSSFCell cell = row.getCell((int)c);
		if (cell != null) {
			String cellValue = getCellValue(cell);
			if (cellValue != null && cellValue.trim().length() > 0) {
				return cellValue;
			}
		}
		return "";
	}

	private static String getCellValue(HSSFCell cell) {
		if (cell == null)
			return null;

		String result = null;

		int cellType = cell.getCellType();
		switch (cellType) {
		case HSSFCell.CELL_TYPE_STRING:
			result = cell.getStringCellValue();
			break;
		default:
			break;
		}

		return result;
	}
}
