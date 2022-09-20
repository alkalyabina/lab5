package ru.itmo.allcommands;

import ru.itmo.exceptoins.IncorrectInputInScriptException;
import ru.itmo.exceptoins.WrongAmountOfElementsException;
import ru.itmo.spaceMarine.SpaceMarine;
import ru.itmo.utility.CollectionManager;
import ru.itmo.utility.Console;
import ru.itmo.utility.MarineAsker;

import java.util.Date;
/**
 * Command 'add_if_max'. Add a new element to collection if it's less than the minimal one.
 */

public class AddIfMaxICommand extends AbstractICommand{
        private CollectionManager collectionManager;
        private MarineAsker marineAsker;

        public AddIfMaxICommand(CollectionManager collectionManager, MarineAsker marineAsker) {
            super("add_if_max {element}", "добавить новый элемент, если его значение больше, чем у наибольшего");
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
                if (collectionManager.collectionSize() == 0 || marineToAdd.compareTo(collectionManager.getFirst()) > 0) {
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
