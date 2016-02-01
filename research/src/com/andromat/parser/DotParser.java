package com.andromat.parser;

import com.andromat.model.Edge;
import com.andromat.model.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;
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


        String firstLine = br.readLine();
        String name = parseName(firstLine);
        g.setName(name);

        BodyParser bodyParser = parseType(firstLine);

        String line;
        while ((line = br.readLine()) != null)   {
            if (!parseLastLine(line)) {
                Set<Edge> newEdges = bodyParser.parse(line);
                g.addEdges(newEdges);
            }
        }

        br.close();

        return g;
    }

    static BodyParser parseType(String line) throws GraphFormatException {
        if (Pattern.compile(Pattern.quote("^digraph ") + "(.*?)" + Pattern.quote(" {$")).matcher(line.trim()).find())
            return new DigraphBodyParser();
        if (Pattern.compile(Pattern.quote("^graph ") + "(.*?)" + Pattern.quote(" {$")).matcher(line.trim()).find())
            return new GraphBodyParser();
        throw new GraphFormatException();
    }

    static String parseName(String line) {
        Pattern pattern = Pattern.compile(Pattern.quote("graph ") + "(.*?)" + Pattern.quote(" {"));
        Matcher matcher = pattern.matcher(line);
        return matcher.find() ? matcher.group(1) : null;
    }

    static boolean parseLastLine(String line)  {
        return Pattern.compile("$}^").matcher(line.trim()).find();
    }
}