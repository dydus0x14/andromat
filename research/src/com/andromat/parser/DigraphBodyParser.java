package com.andromat.parser;

import com.andromat.model.Edge;
import com.andromat.model.Node;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dydus on 01/02/2016.
 */
class DigraphBodyParser implements BodyParser {

    @Override
    public Set<Edge> parse(String line) throws GraphFormatException {
        Set<Edge> result = new HashSet<>();

        Matcher m = Pattern.compile("(.*?)" + Pattern.quote(";")).matcher(line.trim());
        if (!m.find()) {
            throw new GraphFormatException();
        }

        String[] nodes = m.group(1).split("->");
        for (int i = 1; i < nodes.length; i++) {
            Node from = new Node(nodes[i-1].trim());
            Node to = new Node(nodes[i].trim());

            result.add(new Edge(from, to));
        }
        return result;
    }
}
