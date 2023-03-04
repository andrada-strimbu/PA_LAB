public class Cities  extends Locations{
    private int population;
    public Cities(String name, float x, float y) {
        super(name, x, y);
        this.population = population;
    }
    @Override
    public String toString()  {
        return "CITY:" + getName()  + " " + "coordinates: x=" + getX() + " and y="  + getY();
    }
}
