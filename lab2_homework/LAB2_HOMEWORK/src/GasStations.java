public class GasStations extends Locations {
    private int gas_price;
    public GasStations(String name, float x, float y) {
        super(name, x, y);
        this.gas_price= gas_price;
    }
    @Override
    public String toString()  {
        return "GAS STATION:" + getName()  + " " + "coordinates: x=" + getX() + " and y="  + getY();
    }

}
