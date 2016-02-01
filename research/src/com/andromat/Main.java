package com.andromat;

import com.andromat.model.Graph;
import com.andromat.parser.DotParser;

import java.io.*;

/**
 * Created by dydus on 31/01/2016.
 */
public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("res/raw/example1.dot"));
            Graph result = DotParser.parse(bufferedReader);
            System.out.print(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
