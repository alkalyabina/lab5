package ru.itmo.allcommands;
import ru.itmo.exceptoins.CollectionIsEmptyException;
import ru.itmo.exceptoins.WrongAmountOfElementsException;
import ru.itmo.spaceMarine.Chapter;
import ru.itmo.spaceMarine.SpaceMarine;
import ru.itmo.utility.CollectionManager;
import ru.itmo.utility.Console;

/**
 * Command 'filter_greater_than_chapter'. Filters the collection by chapter.
 */
public class FilterGreaterThanChapter extends AbstractICommand {
    private CollectionManager collectionManager;


    public FilterGreaterThanChapter(CollectionManager collectionManager) {
        super("filter_greater_than_chapter <chapter>", "вывести элементы, значение поля chapter которых больше");
        this.collectionManager = collectionManager;
    }

    /**
     * Executes the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            String[] chapterTemp = argument.split(" ");
            if (chapterTemp.length != 2) throw new WrongAmountOfElementsException();
            Chapter chapter = new Chapter(chapterTemp[0], chapterTemp[1]);
            for (SpaceMarine spaceMarine: collectionManager.getCollection()) {
                if (spaceMarine.getChapter().compareTo(chapter) > 0) System.out.println(spaceMarine);
            }
            System.out.println("Солдаты подходящие под запрос - выведены.");
            return true;
        } catch (WrongAmountOfElementsException exception) {
                Console.println("Использование: '" + getName() + "'");
        } catch (IllegalArgumentException exception) {
            Console.printerror("Подразделения нет в списке!");
        }
        return false;
    }
}