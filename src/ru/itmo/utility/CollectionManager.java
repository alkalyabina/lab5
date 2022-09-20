package ru.itmo.utility;

import ru.itmo.exceptoins.CollectionIsEmptyException;
import ru.itmo.spaceMarine.SpaceMarine;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Operates the collection itself.
 */
public class CollectionManager {
    private NavigableSet<SpaceMarine> marinesCollection = new TreeSet<>();
    private LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;
    private final FileManager fileManager;

    public CollectionManager(FileManager fileManager) {
        this.lastInitTime = null;
        this.lastSaveTime = null;
        this.fileManager = fileManager;

        loadCollection();
    }

    /**
     * @return The collection itself.
     */
    public NavigableSet<SpaceMarine> getCollection() {
        return marinesCollection;
    }

    /**
     * @return Last initialization time or null if there wasn't initialization.
     */
    public LocalDateTime getLastInitTime() {
        return lastInitTime;
    }

    /**
     * @return Last save time or null if there wasn't saving.
     */
    public LocalDateTime getLastSaveTime() {
        return lastSaveTime;
    }

    /**
     * @return Name of the collection's type.
     */
    public String collectionType() {
        return marinesCollection.getClass().getName();
    }

    /**
     * @return Size of the collection.
     */
    public int collectionSize() {
        return marinesCollection.size();
    }

    /**
     * @return The first element of the collection or null if collection is empty.
     */
    public SpaceMarine getFirst() {
        if (marinesCollection.isEmpty()) return null;
        return marinesCollection.first();
    }

    /**
     * @param id ID of the marine.
     * @return A marine by his ID or null if marine isn't found.
     */
    public SpaceMarine getById(Integer id) {
        for (SpaceMarine marine : marinesCollection) {
            if (marine.getId().equals(id)) return marine;
        }
        return null;
    }


    /**
     * @param marineToFind A marine whose value will be found.
     * @return A marine by his value or null if marine isn't found.
     */
    public SpaceMarine getByValue(SpaceMarine marineToFind) {
        for (SpaceMarine marine : marinesCollection) {
            if (marine.equals(marineToFind)) return marine;
        }
        return null;
    }


    /**
     * Adds a new marine to collection.
     *
     * @param marine A marine to add.
     */
    public void addToCollection(SpaceMarine marine) {
        marinesCollection.add(marine);
    }

    /**
     * Removes a new marine to collection.
     *
     * @param marine A marine to remove.
     */
    public void removeFromCollection(SpaceMarine marine) {
        marinesCollection.remove(marine);
    }

    /**
     * Removes a new marine to collection.
     *
     * @param marine A marine to remove.
     */
    public void removeFromCollection2(SpaceMarine marine) {
        marinesCollection.remove(marine);
    }

    /**
     * Remove marines greater than the selected one.
     *
     * @param marineToCompare A marine to compare with.
     */
    public void removeLower(SpaceMarine marineToCompare) {
        List<SpaceMarine> temp = new ArrayList<>();
        for (SpaceMarine spaceMarine: marinesCollection) {
            if (spaceMarine.compareTo(marineToCompare) < 0) temp.add(spaceMarine);
        }

        for (SpaceMarine spaceMarine: temp) {
            marinesCollection.remove(spaceMarine);
        }
    }


    /**
     * Clears the collection.
     */
    public void clearCollection() {
        marinesCollection.clear();
    }

    /**
     * Generates next ID. It will be (the bigger one + 1).
     *
     * @return Next ID.
     */
    public int generateNextId() {
        if (marinesCollection.isEmpty()) return 1;
        return marinesCollection.last().getId() + 1;
    }

    /**
     * Saves the collection to file.
     */
    public void saveCollection() {
        fileManager.writeCollection(marinesCollection);
        lastSaveTime = LocalDateTime.now();
    }

    /**
     * Loads the collection from file.
     */
    private void loadCollection() {
        marinesCollection = fileManager.readCollection();
        lastInitTime = LocalDateTime.now();
    }

    /**
     * @return A marine by his chapter or null if marine isn't found.
     */
    public SpaceMarine getChapter(String chapter) {
        for (SpaceMarine marine : marinesCollection) {
            if (marine.getChapter().equals(chapter)) return marine;
        }
        return null;

    }

    /**
     * @return Chapter, who has greater Chapter .
     * @throws CollectionIsEmptyException If collection is empty.
     */
    public String chapterFilteredInfo() throws CollectionIsEmptyException {
        if (marinesCollection.isEmpty()) throw new CollectionIsEmptyException();
        SpaceMarine greaterChapter = getFirst();
        for (SpaceMarine chapter : marinesCollection) {
            if (chapter.getChapter().getParentLegion().compareTo(greaterChapter.getChapter().getParentLegion()) < 0)
                System.out.println(chapter);
            else System.out.println(greaterChapter);
            if (chapter.getChapter().getParentLegion().compareTo(greaterChapter.getChapter().getParentLegion()) > 0)
                System.out.println(chapter);
            else System.out.println(greaterChapter);

        }
        return greaterChapter.toString();
    }


    /**
     * @return Marine, who has max ID.
     * @throws CollectionIsEmptyException If collection is empty.
     */
    public String maxByID() throws CollectionIsEmptyException {
        if (marinesCollection.isEmpty()) throw new CollectionIsEmptyException();

        SpaceMarine maxMarine = getFirst();
        for (SpaceMarine marine : marinesCollection) {
            if (marine.getId() >= maxMarine.getId()) {
                maxMarine = marine;
            }
        }

        return maxMarine.toString();
    }

    @Override
    public String toString() {
        if (marinesCollection.isEmpty()) return "Коллекция пуста!";

        StringBuilder info = new StringBuilder();
        for (SpaceMarine marine : marinesCollection) {
            info.append(marine);
            if (marine != marinesCollection.last()) info.append("\n\n");
        }
        return info.toString();
    }
}