package com.example.parser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@RestController
public class CSVParserController {

    @PostMapping("/echo")
    public ResponseEntity<String> echo(@RequestBody MultipartFile file) {
        try {
            validateFile(file);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new String(file.getBytes()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PostMapping("/invert")
    public ResponseEntity<String> invert(@RequestBody MultipartFile file) throws IOException, CsvException {
        try {
            validateFile(file);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CSVParser.invert(readFile(file)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PostMapping("/flatten")
    public ResponseEntity<String> flatten(@RequestBody MultipartFile file) throws IOException, CsvException {
        try {
            validateFile(file);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CSVParser.flatten(readFile(file)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PostMapping("/sum")
    public ResponseEntity sum(@RequestBody MultipartFile file) {
        try {
            validateFile(file);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CSVParser.sum(readFile(file)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error message");
        }
    }

    @PostMapping("/multiply")
    public ResponseEntity multiple(@RequestBody MultipartFile file) {
        try {
            validateFile(file);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CSVParser.multiply(readFile(file)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error message");
        }
    }

    private static void validateFile(MultipartFile file) throws Exception {
        if (file == null || file.isEmpty()) {
            throw new Exception("Null or empty file found.");
        }
    }

    private static List<String[]> readFile(MultipartFile file) throws Exception {
        InputStreamReader reader;
        try {
            reader = new InputStreamReader(file.getInputStream());
            CSVReader csvReader = new CSVReader(reader);
            return csvReader.readAll();
        } catch (Exception e) {
            throw new Exception("Could not read from file");
        }
    }

}
