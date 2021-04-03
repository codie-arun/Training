package service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelCreatorServiceImpl implements ExcelCreatorService {

	
	Properties prop;
	private static ExcelCreatorServiceImpl excelCreatorServiceImpl;
	
		
	
	public ExcelCreatorServiceImpl(Properties prop) {
		
		this.prop = prop;
	}
	
	public static ExcelCreatorServiceImpl getExcelCreatorServiceImpl(Properties prop) {
		if(excelCreatorServiceImpl == null) {
			excelCreatorServiceImpl = new ExcelCreatorServiceImpl(prop);
			return excelCreatorServiceImpl;
		}else {
			return excelCreatorServiceImpl.getClone();
		}
	}
	
	public ExcelCreatorServiceImpl getClone() {
		try {
			return (ExcelCreatorServiceImpl)super.clone();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	public void generateExcel(String path) throws Exception {
		
		SaxXmlParser parser = new SaxXmlParser();
		ArrayList<ArrayList<String>> xmlobj = parser.parse(path);
		
		System.out.println(xmlobj);
		
		System.out.println(xmlobj.get(0).get(3));
		
		XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet spreadsheet = workbook.createSheet("Customer Invoice");
	    XSSFRow row;
		
	    int slno = 1;
	    int rowid = 0;
	    
	    row = spreadsheet.createRow(rowid);
	    
	    Cell cell = row.createCell(0);
        cell.setCellValue("Customer NO");
        cell = row.createCell(2);
        cell.setCellValue("Invoice Date");
        cell = row.createCell(4);
        cell.setCellValue("Customer Name");
	    
        row = spreadsheet.createRow(++rowid);
        
        cell = row.createCell(0);
        cell.setCellValue(xmlobj.get(0).get(0));
        cell = row.createCell(2);
        cell.setCellValue(xmlobj.get(0).get(1));
        cell = row.createCell(4);
        cell.setCellValue(xmlobj.get(0).get(2));
        
        int gst = Integer.parseInt(xmlobj.get(0).get(3));
        int total = Integer.parseInt(xmlobj.get(0).get(4));
        
        xmlobj.remove(0);
        
        rowid = rowid+2;
        row = spreadsheet.createRow(rowid);
        
        cell = row.createCell(0);
        cell.setCellValue("Sl NO");
        cell = row.createCell(1);
        cell.setCellValue("Item No");
        cell = row.createCell(2);
        cell.setCellValue("Name");
        cell = row.createCell(3);
        cell.setCellValue("Price");
        cell = row.createCell(4);
        cell.setCellValue("Quantity");
        cell = row.createCell(5);
        cell.setCellValue("Amount");
        
        int i=1;
        for(ArrayList<String> item: xmlobj) {
        	row = spreadsheet.createRow(++rowid);
        	
        	cell = row.createCell(0);
            cell.setCellValue(i++);
        	
        	int j = 1;
        	for(String d: item) {
        		cell = row.createCell(j++);
                cell.setCellValue(d);
        	}
        	
        }
        
        row = spreadsheet.createRow(++rowid);
        cell = row.createCell(4);
        cell.setCellValue("GST");
        cell = row.createCell(5);
        cell.setCellValue(gst);
        
        row = spreadsheet.createRow(++rowid);
        cell = row.createCell(4);
        cell.setCellValue("Total");
        cell = row.createCell(5);
        cell.setCellValue(total);
        
        
		  FileOutputStream out = new FileOutputStream(new File("D:/temp/Invoice.xlsx"));
		  workbook.write(out);
		  out.close();
		  System.out.println("Writesheet.xlsx written successfully");
        
	}
	
	
	
}
