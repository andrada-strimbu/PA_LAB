public class Airports extends Locations{

    private int nr_terminals;
    public Airports(String name, float x, float y, int nr_terminals ) {
        super(name, x, y);
        this.nr_terminals=nr_terminals;
    }
    @Override
    public String toString()  {
        return "AIRPORT:" + getName()  + " " + "coordinates: x=" + getX() + " and y="  + getY();
    }
}
