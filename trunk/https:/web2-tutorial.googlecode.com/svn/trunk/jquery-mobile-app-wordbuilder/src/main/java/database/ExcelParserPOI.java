package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

public class ExcelParserPOI {
	
	private XeroundDAO xeroundDAO; 
	
	public XeroundDAO getXeroundDAO() {
		return xeroundDAO;
	}

	public void setXeroundDAO(XeroundDAO dao) {
		this.xeroundDAO = dao;
	}

	public void populateDatabase() {
		System.out.println("Inside populate database");
		File directory = new File("D:/Wordlist/");
		String filename[] = directory.list();

		for (int i = 0; i < 1; i++) {
			System.out.println("Fetching excel data for " + filename[i]);
			List<HSSFSheet> sheets = getWorkBookSheets(filename, i);
			populateWorkbookData(sheets);
		}
	}

	private void populateWorkbookData(List<HSSFSheet> sheets) {
		for (HSSFSheet sheet : sheets) {
			System.out.println("Populating the data for the sheet ");
			// loop for every row in each worksheet
			for (Iterator<Row> rows = sheet.rowIterator(); rows.hasNext();) {
				HSSFRow row = (HSSFRow) rows.next();
				if (row.getRowNum() != 0 ) {
					System.out.println("Populating the data for the row " + row.getRowNum());
					String word = getRowColumnValue(row, 1);
					String usage = getRowColumnValue(row, 2);
					String meaning = getRowColumnValue(row, 3);
					xeroundDAO.insert(word, usage, meaning);					
				}
			}				
		}
	}

	private List<HSSFSheet> getWorkBookSheets(String[] filename, int i) {
		System.out.println("Retrieving all the sheet information for " + filename[i]);
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

		int noOfSheets = wb.getNumberOfSheets();
		List<HSSFSheet> sheets = new ArrayList<HSSFSheet>();
		for (int sheetIndex = 0 ; sheetIndex < noOfSheets ; sheetIndex++) {
			sheets.add(wb.getSheetAt(sheetIndex));	
		}
		System.out.println("The number of sheets are " + sheets.size());
		return sheets;
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
