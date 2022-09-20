package ru.itmo.utility;

public class Validator {
    public static boolean checkNonNull(Object o) {
        return String.valueOf(o) != "null";
    }

    public static boolean checkNonEmpty(Object o) {
        return String.valueOf(o) != "";
    }

    public static boolean greaterThanZero(Double number) {
        return number > 0;
    }
}
