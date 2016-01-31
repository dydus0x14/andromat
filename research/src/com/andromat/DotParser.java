package com.andromat;

import com.andromat.model.Graph;

import java.io.BufferedReader;
import java.io.IOException;


/**
 * Created by dydus on 31/01/2016.
 */
public class DotParser {
    /**
     * Parse a DOT file and output a graph
     */
    public static Graph parse(BufferedReader br) throws IOException, GraphFormatException {
        Graph g = new Graph();


        parseFirstLine(br.readLine(), g);
        String line;
        while ((line = br.readLine()) != null)   {
            if (!parseBody(line, g) && !parseLastLine(line)) {
                throw new GraphFormatException("Wrong format of input file");
            }
        }

        br.close();

        return g;
    }

    private static boolean parseFirstLine(String line, Graph g) {

        return true;
    }

    private static boolean parseBody(String line, Graph g)  {

        return true;
    }

    private static boolean parseLastLine(String line)  {

        return true;
    }
}