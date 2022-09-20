package ru.itmo.allcommands;

import ru.itmo.exceptoins.CollectionIsEmptyException;
import ru.itmo.exceptoins.MarineNotFoundException;
import ru.itmo.exceptoins.WrongAmountOfElementsException;
import ru.itmo.spaceMarine.SpaceMarine;
import ru.itmo.utility.CollectionManager;
import ru.itmo.utility.Console;

/**
 * Command 'remove_by_id'. Removes the element by its ID.
 */
public class RemoveByIDICommand extends AbstractICommand {
        private CollectionManager collectionManager;
        public RemoveByIDICommand(CollectionManager collectionManager) {
            super("remove_by_id <ID>", "удалить элемент из коллекции по ID");
            this.collectionManager = collectionManager;
        }

    public RemoveByIDICommand(String name, String description) {
        super(name, description);
    }

    /**
         * Executes the command.
         * @return Command exit status.
         */
        @Override
        public boolean execute(String argument) {
            try {
                if (argument.isEmpty()) throw new WrongAmountOfElementsException();
                if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();
                Integer id = Integer.parseInt(argument);
                SpaceMarine marineToRemove = collectionManager.getById(id);
                if (marineToRemove == null) throw new MarineNotFoundException();
                collectionManager.removeFromCollection(marineToRemove);
                Console.println("Солдат успешно удален!");
                return true;
            } catch (WrongAmountOfElementsException exception) {
                Console.println("Использование: '" + getName() + "'");
            } catch (CollectionIsEmptyException exception) {
                Console.printerror("Коллекция пуста!");
            } catch (NumberFormatException exception) {
                Console.printerror("ID должен быть представлен числом!");
            } catch (MarineNotFoundException exception) {
                Console.printerror("Солдата с таким ID в коллекции нет!");
            }
            return false;
        }
    }

