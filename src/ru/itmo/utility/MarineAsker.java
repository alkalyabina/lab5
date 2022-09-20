package ru.itmo.utility;

import ru.itmo.exceptoins.IncorrectInputInScriptException;
import ru.itmo.exceptoins.MustBeNotEmptyException;
import ru.itmo.exceptoins.NotInDeclaredLimitsException;
import ru.itmo.run.App;
import ru.itmo.spaceMarine.*;


import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Asks a user a marine's value.
 */
public class MarineAsker {

    private Scanner userScanner;
    private boolean fileMode;

    public MarineAsker(Scanner userScanner) {
        this.userScanner = userScanner;
        fileMode = false;
    }

    /**
     * Sets a scanner to scan user input.
     *
     * @param userScanner Scanner to set.
     */
    public void setUserScanner(Scanner userScanner) {
        this.userScanner = userScanner;
    }

    /**
     * @return Scanner, which uses for user input.
     */
    public Scanner getUserScanner() {
        return userScanner;
    }

    /**
     * Sets marine asker mode to 'File Mode'.
     */
    public void setFileMode() {
        fileMode = true;
    }

    /**
     * Sets marine asker mode to 'User Mode'.
     */
    public void setUserMode() {
        fileMode = false;
    }

    /**
     * Asks a user the marine's name.
     *
     * @return Marine's name.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public String askName() throws IncorrectInputInScriptException {
        String name;
        while (true) {
            try {
                Console.println("Введите имя:");
                Console.print(App.PS2);
                name = userScanner.nextLine().trim();
                if (fileMode) Console.println(name);
                if (name.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Имя не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Имя не может быть пустым!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return name;
    }

    /**
     * Asks a user the marine's Y coordinate.
     *
     * @return Marine's Y coordinate.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public double askY() throws IncorrectInputInScriptException {
        String strY;
        double y;
        while (true) {
            int MIN_Y = -1;
            try {
                Console.println("Введите координату Y > " + (MIN_Y) + ":");
                Console.print(App.PS2);
                strY = userScanner.nextLine().trim();
                if (fileMode) Console.println(strY);
                if (strY.equals("")) throw new MustBeNotEmptyException();
                y = Double.parseDouble(strY);
                if (y <= MIN_Y) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Координата Y не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Координата не может быть пустой!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Координата Y должна быть больше  " + MIN_Y + "!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Координата Y должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return y;
    }

    /**
     * Asks a user the marine's X coordinate.
     *
     * @return Marine's X coordinate.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Float askX() throws IncorrectInputInScriptException {
        String strX;
        float x;
        while (true) {
            int MAX_X = 190;
            try {
                Console.println("Введите координату X <= " + (MAX_X) + ":");
                Console.print(App.PS2);
                strX = userScanner.nextLine().trim();
                if (fileMode) Console.println(strX);
                if (strX.equals("")) throw new MustBeNotEmptyException();
                x = Float.parseFloat(strX);
                if (x > MAX_X) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Координата X не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Координата не может быть пустой!");
                if (fileMode) throw new IncorrectInputInScriptException();
            }catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Координата X не может превышать " + MAX_X + "!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Координата X должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return x;
    }

    /**
     * Asks a user the marine's coordinates.
     *
     * @return Marine's coordinates.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Coordinates askCoordinates() throws IncorrectInputInScriptException {
        double y;
        Float x;
        x = askX();
        y = askY();
        return new Coordinates(x, y);
    }

    /**
     * Asks a user the marine's health.
     *
     * @return Marine's health.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Long askHealth() throws IncorrectInputInScriptException {
        String strHealth;
        long health;
        while (true) {
            try {
                Console.println("Введите здоровье > 0 :");
                Console.print(App.PS2);
                strHealth = userScanner.nextLine().trim();
                if (fileMode) Console.println(strHealth);
                health = Long.parseLong(strHealth);
                double MIN_HEALTH = 0;
                if (health <= MIN_HEALTH) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Здоровье не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Здоровье должно быть больше нуля!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Здоровье должно быть представлено числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return health;
    }

    /**
     * Asks a user the marine's height.
     *
     * @return Marine's height.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public double askHeight() throws IncorrectInputInScriptException {
        String strHeight;
        double height;
        while (true) {
            try {
                Console.println("Введите рост:");
                Console.print(App.PS2);
                strHeight = userScanner.nextLine().trim();
                if (fileMode) Console.println(strHeight);
                if (strHeight.equals("")) throw new MustBeNotEmptyException();
                height = Double.parseDouble(strHeight);
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Рост не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            }catch (MustBeNotEmptyException exception) {
                Console.printerror("Рост не может быть пустым!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Рост должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return height;
    }



    /**
     * Asks a user the marine's category.
     *
     * @return Marine's category.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public AstartesCategory askCategory() throws IncorrectInputInScriptException {
        String strCategory;
        AstartesCategory category;
        while (true) {
            try {
                Console.println("Список категорий - " + AstartesCategory.nameList());
                Console.println("Введите категорию:");
                Console.print(App.PS2);
                strCategory = userScanner.nextLine().trim();
                if (strCategory.equals("")) throw new MustBeNotEmptyException();
                if (fileMode) Console.println(strCategory);
                category = AstartesCategory.valueOf(strCategory.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Категория не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Категория не может быть пустой!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalArgumentException exception) {
                Console.printerror("Категории нет в списке!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return category;
    }

    /**
     * Asks a user the marine's weapon type.
     *
     * @return Marine's weapon type.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Weapon askWeaponType() throws IncorrectInputInScriptException {
        String strWeaponType;
        Weapon weaponType;
        while (true) {
            try {
                Console.println("Список оружия  - " + Weapon.nameList());
                Console.println("Введите оружие:");
                Console.print(App.PS2);
                strWeaponType = userScanner.nextLine().trim();
                if (strWeaponType.equals("")) throw new MustBeNotEmptyException();
                if (fileMode) Console.println(strWeaponType);
                weaponType = Weapon.valueOf(strWeaponType.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Оружие не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Оружие не может быть пустым!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalArgumentException exception) {
                Console.printerror("Оружия нет в списке!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return weaponType;
    }


    /**
     * Asks a user the marine chapter's name.
     *
     * @return Chapter's name.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public String askChapterName() throws IncorrectInputInScriptException {
        String chapterName;
        while (true) {
            try {
                Console.println("Введите имя подразделения:");
                Console.print(App.PS2);
                chapterName = userScanner.nextLine().trim();
                if (fileMode) Console.println(chapterName);
                if (chapterName.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Имя подразделения не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Имя подразделения не может быть пустым!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return chapterName;
    }


    public String askParentLegion() throws IncorrectInputInScriptException {
        String parentLegion;
        while (true) {
            try {
                Console.println("Введите родительский легион:");
                Console.print(App.PS2);
                parentLegion = userScanner.nextLine().trim();
                if (fileMode) Console.println(parentLegion);
                if (parentLegion.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Родительский легион не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Родительский легион не может быть пустым!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return parentLegion;
    }

    /**
     * Asks a user the marine's chapter.
     * @return Marine's chapter.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Chapter askChapter() throws IncorrectInputInScriptException {
        String name;
        String parentLegion;
        name = askChapterName();
        parentLegion = askParentLegion();
        return new Chapter(name,parentLegion);
    }
    /**
     * Asks a user a question.
     * @return Answer (true/false).
     * @param question A question.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public boolean askQuestion(String question) throws IncorrectInputInScriptException {
        String finalQuestion = question + " (+/-):";
        String answer;
        while (true) {
            try {
                Console.println(finalQuestion);
                Console.print(App.PS2);
                answer = userScanner.nextLine().trim();
                if (fileMode) Console.println(answer);
                if (!answer.equals("+") && !answer.equals("-")) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Ответ не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Ответ должен быть представлен знаками '+' или '-'!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return answer.equals("+");
    }

    @Override
    public String toString() {
        return "MarineAsker (вспомогательный класс для запросов пользователю)";
    }
}
