package ru.itmo.allcommands;
import ru.itmo.exceptoins.CollectionIsEmptyException;
import ru.itmo.exceptoins.WrongAmountOfElementsException;
import ru.itmo.utility.CollectionManager;
import ru.itmo.utility.Console;

/**
 * Command 'max_by_ID'. Prints the element of the collection with maximum ID.
 */
public class MaxByIDICommand extends AbstractICommand {
    public CollectionManager collectionManager;

    public MaxByIDICommand(CollectionManager collectionManager) {
        super("max_by_id", "вывести элемент, значение поля ID которого максимально");
        this.collectionManager = collectionManager;
    }

    /**
     * Executes the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            Console.println(collectionManager.maxByID());
            return true;
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        }
        return true;
    }
}
