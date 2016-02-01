package com.andromat.parser;

import com.andromat.model.Edge;

import java.util.Set;

/**
 * Created by dydus on 01/02/2016.
 */
interface BodyParser {
    Set<Edge> parse(String line) throws GraphFormatException;
}
