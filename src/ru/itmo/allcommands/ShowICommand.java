package ru.itmo.allcommands;

import ru.itmo.exceptoins.WrongAmountOfElementsException;
import ru.itmo.utility.CollectionManager;
import ru.itmo.utility.Console;

/**
 * Command 'show'. Shows information about all elements of the collection.
 */
public class ShowICommand extends AbstractICommand {
    private CollectionManager collectionManager;

    public ShowICommand(CollectionManager collectionManager) {
        super("show", "вывести все элементы коллекции");
        this.collectionManager = collectionManager;
    }

    /**
     * Executes the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            Console.println(collectionManager);
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        }
        return false;
    }
}