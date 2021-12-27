package io.java.Report.Extractor.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.java.Report.Extractor.Service.ProductService;



@RestController
public class ExportController {

    @Autowired
    private ProductService productService;
    
//    @Autowired
//    ExcelView excel;

    /**
     * Handle request to download an Excel document
     */
    @GetMapping("/download/excel")
    public ResponseEntity<Object> download() {

      productService.export(productService.getAll());
       return new ResponseEntity<Object>(productService.getAll(), HttpStatus.OK);
    }
}
