package com.andromat;

import com.andromat.model.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by dydus on 31/01/2016.
 */
public class DotParser {
    /**
     * Parse a DOT file and output a graph
     */
    public static Graph parse(BufferedReader br) throws IOException, GraphFormatException {
        Graph g = new Graph();


        String name = parseFirstLine(br.readLine());
        g.setName(name);

        String line;
        while ((line = br.readLine()) != null)   {
            if (!parseBody(line, g) && !parseLastLine(line)) {
                throw new GraphFormatException("Wrong format of input file");
            }
        }

        br.close();

        return g;
    }

    private static String parseFirstLine(String line) {
        Pattern pattern = Pattern.compile(Pattern.quote("graph ") + "(.*?)" + Pattern.quote(" {"));
        Matcher matcher = pattern.matcher(line);
        return matcher.find() ? matcher.group(1) : null;
    }

    private static boolean parseBody(String line, Graph g)  {
        Pattern pattern = Pattern.compile("(.*?)" + Pattern.quote("--") + "(.*?)");
        Matcher matcher = pattern.matcher(line);
        boolean result = false;
        while(matcher.find()) {
            result = true;
        }
        return result;
    }

    private static boolean parseLastLine(String line)  {

        return true;
    }
}