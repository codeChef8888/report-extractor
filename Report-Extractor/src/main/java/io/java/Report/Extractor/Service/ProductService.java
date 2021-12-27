package io.java.Report.Extractor.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.java.Report.Extractor.Models.Product;
import io.java.Report.Extractor.Repository.ProductRepository;



@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAll() {
		return productRepository.findAll();
	}
	
	public void export(List<Product> product) {
		
		try {
		String excelFilePath="E:\\Reviews-export.xlsx";
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Reviews");
		writeHeaderLine(sheet);
		writeDataLines(product, workbook, sheet);
	    FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
        workbook.close();
		}catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
	}
	
	private void writeHeaderLine(XSSFSheet sheet) {
		// create header row
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Id");
//		header.getCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("Name");
//		header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("Type");
//		header.getCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("Location");
//		header.getCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("Attributes");
//		header.getCell(4).setCellStyle(style);
		header.createCell(5).setCellValue("Comments");
//		header.getCell(5).setCellStyle(style);
		header.createCell(6).setCellValue("Availability");
//		header.getCell(6).setCellStyle(style);
		header.createCell(7).setCellValue("Production");
//		header.getCell(7).setCellStyle(style);
		header.createCell(8).setCellValue("Requriment");
//		header.getCell(8).setCellStyle(style);
		header.createCell(9).setCellValue("Review");
//		header.getCell(9).setCellStyle(style);
		header.createCell(10).setCellValue("Quantity");
//		header.getCell(10).setCellStyle(style);
		header.createCell(11).setCellValue("Quality");
//		header.getCell(11).setCellStyle(style);
		header.createCell(12).setCellValue("Rate");
//		header.getCell(12).setCellStyle(style);
		header.createCell(13).setCellValue("Price");
//		header.getCell(13).setCellStyle(style);
		header.createCell(14).setCellValue("Discount");
//		header.getCell(14).setCellStyle(style);

	}
	
	private void writeDataLines(List<Product> products,XSSFWorkbook workbook,
            XSSFSheet sheet) {
		int rowCount = 1;

		for (Product p : products) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellValue(p.getId());
			userRow.createCell(1).setCellValue(p.getName());
			userRow.createCell(2).setCellValue(p.getType());
			userRow.createCell(3).setCellValue(p.getLocation());
			userRow.createCell(4).setCellValue(p.getAttributes());
			userRow.createCell(5).setCellValue(p.getComments());
			userRow.createCell(6).setCellValue(p.getAvailability());
			userRow.createCell(7).setCellValue(p.getProduction());
			userRow.createCell(8).setCellValue(p.getRequirement());
			userRow.createCell(9).setCellValue(p.getReview());
			userRow.createCell(10).setCellValue(p.getQuantity());
			userRow.createCell(11).setCellValue(p.getQuality());
			userRow.createCell(12).setCellValue(p.getRate());
			userRow.createCell(13).setCellValue(p.getPrice());
			userRow.createCell(14).setCellValue(p.getDiscount());

		}
	}
	
}
