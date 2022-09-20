package ru.itmo.spaceMarine;

public enum AstartesCategory {
    DREADNOUGHT,
    ASSAULT,
    TACTICAL,
    HELIX,
    APOTHECARY;

    /**
     * Generates a list of enum string values.
     * @return String with all enum values splitted by comma.
     */
    public static String nameList() {
        String nameList = "";
        for (AstartesCategory category : values()) {
            nameList += category.name() + ", ";
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
