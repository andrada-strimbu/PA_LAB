
public class Locations {
    /**
     * clasa Location implementeaza datele unei locatii
     * @param obj= obiect de tip locatie
     * functia booleana equals care verifica daca locatia este deja in array
     */
    private String name;
    private float x;
    private  float y;

    public Locations(String name, float x, float y){
        this.name=name;
        this.x=x;
        this.y=y;
    }
    public float getX(){
        return  x;
    }
    public float getY(){
        return y;
    }
    public String getName(){
        return name;
    }
    public void  setName(String name){
        this.name=name;

    }
    @Override
    public String toString()  {
        return "Location:" + getName()  + " " + "coordinates: x=" + getX() + " and y="  + getY();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Locations)) {
            return false;
        }
        Locations l = (Locations) obj;
         return x == l.x && y == l.y;


    }

}