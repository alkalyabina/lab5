package ru.itmo.utility;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import ru.itmo.spaceMarine.SpaceMarine;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeSet;

public class FileManager {
    private final Gson gson = new Gson();
    private final String filename;

    public FileManager(String filename) {
        this.filename = filename;
    }

    /**
     * Writes collection to a file.
     *
     * @param collection Collection to write.
     */
    public void writeCollection(Collection<?> collection) {
        if (!filename.equals("")) {
            try (BufferedOutputStream collectionBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filename))) {
                System.out.println(collection);
                collectionBufferedOutputStream.write(gson.toJson(collection).getBytes(StandardCharsets.UTF_8));
                Console.println("Коллекция успешна сохранена в файл!");
            } catch (IOException exception) {
                Console.printerror("Загрузочный файл является директорией/не может быть открыт!");
            }
        } else Console.printerror(" загрузочный файл не найдена!");
    }

    /**
     * Reads collection from a file.
     *
     * @return Readed collection.
     */
    public TreeSet<SpaceMarine> readCollection() {
        if (!filename.equals("")) {
            try (Scanner collectionFileScanner = new Scanner(new File(filename))) {
                TreeSet<SpaceMarine> collection;
                Type collectionType = new TypeToken<TreeSet<SpaceMarine>>() {}.getType();
                collection = gson.fromJson(collectionFileScanner.nextLine().trim(), collectionType);
                TreeSet<SpaceMarine> temp = new TreeSet<>();
                for (SpaceMarine spaceMarine : collection) {
                    boolean checked = true;
                    checked = checked && Validator.checkNonNull(spaceMarine.getId());
                    checked = checked && Validator.checkNonNull(spaceMarine.getName());
                    checked = checked && Validator.checkNonNull(spaceMarine.getCoordinates());
                    checked = checked && Validator.checkNonNull(spaceMarine.getCreationDate());
                    checked = checked && Validator.checkNonNull(spaceMarine.getHealth());
                    checked = checked && Validator.greaterThanZero(Double.parseDouble(spaceMarine.getHealth() + ""));
                    checked = checked && Validator.checkNonNull(spaceMarine.getCategory());
                    checked = checked && Validator.checkNonNull(spaceMarine.getWeaponType());
                    checked = checked && Validator.checkNonNull(spaceMarine.getChapter());
                    checked = checked && spaceMarine.getCoordinates().getX() <= 190;
                    checked = checked && Validator.checkNonNull(spaceMarine.getCoordinates().getY());
                    checked = checked && spaceMarine.getCoordinates().getY() > -1;
                    checked = checked && Validator.checkNonNull(spaceMarine.getChapter().getChapterName());
                    checked = checked && Validator.checkNonEmpty(spaceMarine.getChapter().getChapterName());
                    if (checked) temp.add(spaceMarine);
                    else System.out.println("Неправильный элемент в json.");
                }
                Console.println("Коллекция успешна загружена!");
                return temp;
            } catch (FileNotFoundException exception) {
                Console.printerror("Загрузочный файл не найден!");
            } catch (NoSuchElementException exception) {
                Console.printerror("Загрузочный файл пуст!");
            } catch (JsonParseException | NullPointerException exception) {
                Console.printerror("В загрузочном файле не обнаружена необходимая коллекция!");
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        } else Console.printerror("загрузочный файл не найден!");
        return new TreeSet<>();
    }

    @Override
    public String toString() {
        return "FileManager (класс для работы с загрузочным файлом)";
    }
}