package ru.itmo.allcommands;


import java.util.Date;

import ru.itmo.spaceMarine.SpaceMarine;
import ru.itmo.exceptoins.IncorrectInputInScriptException;
import ru.itmo.exceptoins.WrongAmountOfElementsException;
import ru.itmo.utility.CollectionManager;
import ru.itmo.utility.Console;
import ru.itmo.utility.MarineAsker;

/**
 * Command 'add'. Add a new element to collection.
 */
public class AddICommand extends AbstractICommand {
    private CollectionManager collectionManager;
    private MarineAsker marineAsker;

    public AddICommand(CollectionManager collectionManager, MarineAsker marineAsker) {
        super("add {element}", "добавить новый элемент в коллекцию");
        this.collectionManager = collectionManager;
        this.marineAsker = marineAsker;
    }

    /**
     * Executes the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            collectionManager.addToCollection(new SpaceMarine(
                    collectionManager.generateNextId(),
                    marineAsker.askName(),
                    marineAsker.askCoordinates(),
                    new Date(),
                    marineAsker.askHealth(),
                    marineAsker.askHeight(),
                    marineAsker.askCategory(),
                    marineAsker.askWeaponType(),
                    marineAsker.askChapter()
            ));
            Console.println("Солдат успешно добавлен!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}
