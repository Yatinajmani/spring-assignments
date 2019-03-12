import component.HotDrink;

public class Tea implements HotDrink {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @Override
    public String prepareHotDrink() {
        return getName() + " Prepared";
    }
}
