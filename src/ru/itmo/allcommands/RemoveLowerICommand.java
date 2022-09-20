package ru.itmo.allcommands;
import java.util.Date;

import ru.itmo.spaceMarine.SpaceMarine;
import ru.itmo.exceptoins.CollectionIsEmptyException;
import ru.itmo.exceptoins.IncorrectInputInScriptException;
import ru.itmo.exceptoins.MarineNotFoundException;
import ru.itmo.exceptoins.WrongAmountOfElementsException;
import ru.itmo.utility.CollectionManager;
import ru.itmo.utility.Console;
import ru.itmo.utility.MarineAsker;

/**
 * Command 'remove_lower'. Removes elements lower than user entered.
 */
public class RemoveLowerICommand extends AbstractICommand {
    private CollectionManager collectionManager;
    private MarineAsker marineAsker;

    public RemoveLowerICommand(CollectionManager collectionManager, MarineAsker marineAsker) {
        super("remove_lower {element}", "удалить из коллекции все элементы, превышающие заданный");
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
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();
            SpaceMarine marineToFind = new SpaceMarine(
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
            collectionManager.removeLower(marineToFind);
            Console.println("Солдаты успешно удалены!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}
