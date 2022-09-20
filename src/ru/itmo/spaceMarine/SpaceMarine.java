package ru.itmo.spaceMarine;

import java.util.Date;

public class SpaceMarine implements Comparable<SpaceMarine> {
    private Integer id;
    private String name;
    private Coordinates coordinates;
    private java.util.Date creationDate;
    private Long health;
    private double height;
    private AstartesCategory category;
    private Weapon weaponType;
    private Chapter chapter;

    public SpaceMarine(int id, String name, Coordinates coordinates, Date creationDate, Long health, double height,
                       AstartesCategory category, Weapon weaponType, Chapter chapter) {
        this.id = Math.toIntExact(id);
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.health = health;
        this.height = height;
        this.category = category;
        this.weaponType = weaponType;
        this.chapter = chapter;
    }




    /**
     * @return ID of the marine.
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return Name of the marine.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Coordinates of the marine.
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @return Creation date of the marine.
     */
    public Date getCreationDate() {
        Date creationDate = new Date();
        return creationDate;
    }
    /**
     * @return Health of the marine.
     */
    public Long getHealth() {
        return health;
    }

    /**
     * @return Height of the marine.
     */
    public double getHeight() {
        return height;
    }


    /**
     * @return Category of the marine.
     */
    public AstartesCategory getCategory() {
        return category;
    }

    /**
     * @return Weapon type of the marine.
     */
    public Weapon getWeaponType() {
        return weaponType;
    }

    /**
     * @return Chapter of the marine.
     */
    public Chapter getChapter  () {
        return chapter;
    }

    @Override
    public int compareTo(SpaceMarine marineObj) {
        return id.compareTo(marineObj.getId());
    }

    @Override
    public String toString() {
        String info = "";
        info += "Солдат №" + id;
        info += (" (добавлен " + creationDate + ")");
        info += "\n Имя: " + name;
        info += "\n Местоположение: " + coordinates;
        info += "\n Здоровье: " + health;
        info += "\n Высота: " + height;
        info += "\n Категория: " + category;
        info += "\n Оружие: " + weaponType;
        info += "\n Подразделение: " + chapter.getChapterName() +"  "+ chapter.getParentLegion()  ;
        return info;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + coordinates.hashCode() + category.hashCode() + weaponType.hashCode() +
                chapter.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof SpaceMarine) {
            SpaceMarine marineObj = (SpaceMarine) obj;
            return name.equals(marineObj.getName()) && coordinates.equals(marineObj.getCoordinates()) &&
                    (health == marineObj.getHealth()) && (height == marineObj.getHeight()) && (category == marineObj.getCategory()) &&
                    (weaponType == marineObj.getWeaponType()) && chapter.equals(marineObj.getChapter());
        }
        return false;
    }
}

