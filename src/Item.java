public class Item {


    private String name;
    private final String description;


    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }




    @Override
    public String toString() {
        return name + ": " + description;
    }
}
