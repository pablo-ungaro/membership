package com.br.membership.util;

public class StringUtils {
    public static String toSnakeCase(String text) {
        return sanitize(text.replaceAll(" ", "_")).toUpperCase();
    }

    public static String sanitize(String input) {
        return input.replaceAll("[^\\w-a-zA-Z0-9-\\-]", "");
    }
}
