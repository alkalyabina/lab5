package ru.itmo.spaceMarine;

/**
 * Chapter with marines.
 */
public class Chapter {
    private final String chapterName;
    private final String parentLegion;

    public Chapter(String chapterName, String parentLegion) {
        this.chapterName = chapterName;
        this.parentLegion = parentLegion;
    }

    /**
     * @return Name of the chapter.
     */
    public String getChapterName() {
        return chapterName;
    }

    public String getParentLegion() {
        return parentLegion;
    }

    /**
     * @return Parent Legion.
     */


    public int compareTo(Chapter o) {
        if (this.chapterName.equals(o.chapterName)) return this.parentLegion.compareTo(o.parentLegion);
        return this.chapterName.compareTo(o.chapterName);
    }
}



