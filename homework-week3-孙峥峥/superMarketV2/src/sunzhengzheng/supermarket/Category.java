package sunzhengzheng.supermarket;

public enum Category {
    FOOD(1),
    VIRTUALPRODUCT(3),
    SNACK(5),
    CLOTHES(7),
    ELECTRIC(9);
    int id;
    Category(int id) {
        this.id = id;
    }

}
