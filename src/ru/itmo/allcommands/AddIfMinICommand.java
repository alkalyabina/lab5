package ru.itmo.allcommands;

import java.util.Date;

import ru.itmo.spaceMarine.SpaceMarine;
import ru.itmo.exceptoins.IncorrectInputInScriptException;
import ru.itmo.exceptoins.WrongAmountOfElementsException;
import ru.itmo.utility.CollectionManager;
import ru.itmo.utility.Console;
import ru.itmo.utility.MarineAsker;

/**
 * Command 'add_if_min'. Add a new element to collection if it's less than the minimal one.
 */
public class AddIfMinICommand extends AbstractICommand {
    private CollectionManager collectionManager;
    private MarineAsker marineAsker;

    public AddIfMinICommand(CollectionManager collectionManager, MarineAsker marineAsker) {
        super("add_if_min {element}", "добавить новый элемент, если его значение меньше, чем у наименьшего");
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
            SpaceMarine marineToAdd = new SpaceMarine(
                    collectionManager.generateNextId(),
                    marineAsker.askName(),
                    marineAsker.askCoordinates(),
                    new Date(),
                    marineAsker.askHealth(),
                    marineAsker.askHeight(),
                    marineAsker.askCategory(),
                    marineAsker.askWeaponType(),
                    marineAsker.askChapter()
            );
            if (collectionManager.collectionSize() == 0 || marineToAdd.compareTo(collectionManager.getFirst()) < 0) {
                collectionManager.addToCollection(marineToAdd);
                Console.println("Солдат успешно добавлен!");
                return true;
            } else Console.printerror("Значение солдата больше, чем значение наименьшего из солдат!");
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}
