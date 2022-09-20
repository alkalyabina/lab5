package ru.itmo.allcommands;

import ru.itmo.exceptoins.WrongAmountOfElementsException;
import ru.itmo.utility.CollectionManager;
import ru.itmo.utility.Console;

/**
 * Command 'save'. Saves the collection to a file.
 */
public class SaveICommand extends AbstractICommand {
    private CollectionManager collectionManager;

    public SaveICommand(CollectionManager collectionManager) {
        super("save", "сохранить коллекцию в файл");
        this.collectionManager = collectionManager;
    }

    /**
     * Executes the command.
     *
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            collectionManager.saveCollection();
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        }
        return false;
    }
}

