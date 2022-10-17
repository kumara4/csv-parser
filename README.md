# League Backend Challenge

CSVParserController.java is a basic web server. It accepts the following POST requests:

```
/echo
/invert
/flatten
/sum
/multiply 
```

Given an uploaded csv file
```
1,2,3
4,5,6
7,8,9
```

1. Echo (given)
    - Return the matrix as a string in matrix format. This request accepts a matrix of numbers and text values.
    
    ```
    // Expected output
    1,2,3
    4,5,6
    7,8,9
    ``` 
2. Invert (transpose)
    - Return the matrix as a string in matrix format where the columns and rows are inverted. This request accepts a matrix of numbers and text values.
    ```
    // Expected output
    1,4,7
    2,5,8
    3,6,9
    ``` 
3. Flatten
    - Return the matrix as a 1 line string, with values separated by commas. This request accepts a matrix of numbers and text values.
    ```
    // Expected output
    1,2,3,4,5,6,7,8,9
    ``` 
4. Sum
    - Return the sum of the integers in the matrix. This request accepts a matrix of numbers and text values. The matrix must contain at least one integer. If no integer is found, an exception is thrown and the endpoint returns a BAD_REQUEST code.  
    ```
    // Expected output
    45
    ``` 
5. Multiply
    - Return the product of the integers in the matrix. This request accepts a matrix of numbers and text values. The matrix must contain at least one integer. If no integer is found, an exception is thrown and the endpoint returns a BAD_REQUEST code. 
    ```
    // Expected output
    362880
    ``` 

The input file to these functions is a matrix, of any dimension where the number of rows are equal to the number of columns (square). Each value is an integer, and there is no header row. matrix.csv is example valid input. Each endpoint handles the case where the number of rows does not equal the number of columns (i.e. these cells are treated as an empty space). If a csv is uploaded containing text, each end point checks before parsing a string into an Integer. 

Build jar
```
mvn clean package
```

Run web server
```
java -jar target/parser-0.0.1-SNAPSHOT.jar
```

Send request
```
curl -XPOST -F 'file=@./src/test/resources/numbers.csv' "localhost:8080/echo"
```

## What we're looking for

- The solution runs
- The solution performs all cases correctly
- The code is easy to read
- The code is reasonably documented
- The code is tested
- The code is robust and handles invalid input and provides helpful error messages
