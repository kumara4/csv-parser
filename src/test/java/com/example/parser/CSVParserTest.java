package com.example.parser;

import com.opencsv.CSVReader;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CSVParserTest {

    @Test
    public void invertNumbersOnlyMatrix3x3() throws Exception {
        /**
         * input: 1,2,3
         *        4,5,6
         *        7,8,9
         *
         * expected output:
         *        1,4,7
         *        2,5,8
         *        3,6,9
         */
        CSVReader inputString = new CSVReader(new FileReader("src/test/resources/numbers.csv"));
        String outputString = new String(Files.readAllBytes(Paths.get("src/test/resources/inverted-output/numbers.txt")));

        String invertedString = CSVParser.invert(inputString.readAll());
        Assert.assertNotNull(invertedString);
        Assert.assertEquals(outputString, invertedString);
    }

    @Test
    public void invertNumbersOnlyMatrix2x4() throws Exception {
        /**
         * input: 1,2,3
         *        4,5,6,7
         *
         * expected output:
         *        1,4
         *        2,5
         *        3,6
         *         ,7
         */
        CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/numbers2x4.csv"));
        String outputString = new String(Files.readAllBytes(Paths.get("src/test/resources/inverted-output/numbers2x4.txt")));

        String invertedString = CSVParser.invert(csvReader.readAll());
        Assert.assertNotNull(invertedString);
        Assert.assertEquals(outputString, invertedString);
    }

    @Test
    public void invertNumbersOnlyMatrix2x3() throws Exception {
        /**
         * input: 9,8,7
         *        6,5
         *
         * expected output:
         *        9,6
         *        8,5
         *        7
         */
        CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/numbers2x3.csv"));
        String outputString = new String(Files.readAllBytes(Paths.get("src/test/resources/inverted-output/numbers2x3.txt")));

        String invertedString = CSVParser.invert(csvReader.readAll());
        Assert.assertNotNull(invertedString);
        Assert.assertEquals(outputString, invertedString);
    }

    @Test
    public void invertNumbersAndStrings() throws Exception {
        /**
         * input: 10,hi,3
         *        hello,hey,22
         *        4,8,12,16,20
         *
         * expected output:
         *        10,hello,4
         *        hi,hey,8
         *        3,22,12
         *         , ,16
         *         , ,20
         *
         */
        CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/numbersAndStrings.csv"));
        String outputString = new String(Files.readAllBytes(Paths.get("src/test/resources/inverted-output/numbersAndStrings.txt")));

        String invertedString = CSVParser.invert(csvReader.readAll());
        Assert.assertNotNull(invertedString);
        Assert.assertEquals(outputString, invertedString);
    }

    @Test
    public void flattenNumbersOnlyMatrix3x3() throws Exception {
        /**
         * input: 1,2,3
         *        4,5,6
         *        7,8,9
         *
         * expected output:
         *        1,2,3,4,5,6,7,8,9
         */
        CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/numbers.csv"));
        String outputString = new String(Files.readAllBytes(Paths.get("src/test/resources/flatten-output/numbers.txt")));

        String flattenedString = CSVParser.flatten(csvReader.readAll());
        Assert.assertNotNull(flattenedString);
        Assert.assertEquals(outputString, flattenedString);
    }

    @Test
    public void flattenStringsOnlyMatrix() throws Exception {
        /**
         * input: hi,hello,hey
         *        bye,goodbye
         *        yes
         *
         * expected output:
         *        hi,hello,hey,bye,goodbye,yes
         */
        CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/text.csv"));
        String outputString = new String(Files.readAllBytes(Paths.get("src/test/resources/flatten-output/text.txt")));

        String flattenedString = CSVParser.flatten(csvReader.readAll());
        Assert.assertNotNull(flattenedString);
        Assert.assertEquals(outputString, flattenedString);
    }

    @Test
    public void sumNumbersOnlyMatrix() throws Exception {
        CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/numbers.csv"));
        Integer expectedSum = Integer.parseInt(new String(Files.readAllBytes(Paths.get("src/test/resources/sum-output/numbers.txt"))));
        Integer sum = CSVParser.sum(csvReader.readAll());
        Assert.assertNotNull(sum);
        Assert.assertEquals(expectedSum, sum);
    }

    @Test
    public void sumNumbersAndStringsMatrix() throws Exception {
        CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/numbersAndStrings.csv"));
        Integer expectedSum = Integer.parseInt(new String(Files.readAllBytes(Paths.get("src/test/resources/sum-output/numbersAndStrings.txt"))));
        Integer sum = CSVParser.sum(csvReader.readAll());
        Assert.assertNotNull(sum);
        Assert.assertEquals(expectedSum, sum);
    }

    @Test
    public void sumStringsOnlyMatrix() throws Exception{
        CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/text.csv"));
        Exception exception = assertThrows(Exception.class, () -> CSVParser.sum(csvReader.readAll()));
        String expectedMessage = "No number found in matrix";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void multiplyNumbersOnlyMatrix() throws Exception {
        CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/numbers.csv"));
        Integer expectedProduct = Integer.parseInt(new String(Files.readAllBytes(Paths.get("src/test/resources/multiply-output/numbers.txt"))));
        Integer product = CSVParser.multiply(csvReader.readAll());
        Assert.assertNotNull(product);
        Assert.assertEquals(expectedProduct, product);
    }

    @Test
    public void multiplyNumbersAndStringsMatrix() throws Exception {
        CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/numbersAndStrings.csv"));
        Integer expectedProduct = Integer.parseInt(new String(Files.readAllBytes(Paths.get("src/test/resources/multiply-output/numbersAndStrings.txt"))));
        Integer product = CSVParser.multiply(csvReader.readAll());
        Assert.assertNotNull(product);
        Assert.assertEquals(expectedProduct, product);
    }

    @Test
    public void multiplyStringsOnlyMatrix() throws Exception{
        CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/text.csv"));
        Exception exception = assertThrows(Exception.class, () -> CSVParser.multiply(csvReader.readAll()));
        String expectedMessage = "No number found in matrix";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}
