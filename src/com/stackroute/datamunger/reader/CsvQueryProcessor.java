package com.stackroute.datamunger.reader;

import java.io.*;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;

public class CsvQueryProcessor extends QueryProcessingEngine {
    private String fileName;

    // Parameterized constructor to initialize filename
    public CsvQueryProcessor(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
    }

    /*
     * Implementation of getHeader() method. We will have to extract the headers
     * from the first line of the file.
     * Note: Return type of the method will be Header
     */

    @Override
    public Header getHeader() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String stringReader;
        // read the first line
        stringReader = bufferedReader.readLine();
        String[] lines;
        lines = stringReader.split(",");
        //populate the header object with the String array containing the header names
        Header header = new Header(lines);
        return header;
    }

    /**
     * getDataRow() method will be used in the upcoming assignments
     */

    @Override
    public void getDataRow() {

    }

    /*
     * Implementation of getColumnType() method. To find out the data types, we will
     * read the first line from the file and extract the field values from it. If a
     * specific field value can be converted to Integer, the data type of that field
     * will contain "java.lang.Integer", otherwise if it can be converted to Double,
     * then the data type of that field will contain "java.lang.Double", otherwise,
     * the field is to be treated as String.
     * Note: Return Type of the method will be DataTypeDefinitions
     */

    @Override
    public DataTypeDefinitions getColumnType() throws IOException {
        FileReader fileReader;
        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException exception) {
            fileReader = new FileReader("data/ipl.csv");
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String stringReader;
        stringReader = bufferedReader.readLine();
        String firstLine;
        firstLine = bufferedReader.readLine();
        String[] variables;
        variables = firstLine.split(",", 30);
        String[] array;
        array = new String[variables.length];
        int i = 0;
        for (String string : variables) {
            if (string.matches("[0-9]+")) {
                array[i] = "java.lang.Integer";
                i++;
            } else{
                array[i] = "java.lang.String";
                i++;
            }

        }
        DataTypeDefinitions dataTypeDefinitions = new DataTypeDefinitions(array);
        return dataTypeDefinitions;
    }
}
