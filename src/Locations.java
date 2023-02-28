public class Locations {

    private String name;
    private float x;
    private  float y;
    private EnumLocation type;

    public  Locations(String name,float x, float y,EnumLocation type){

        this.name=name;
        this.x=x;
        this.y=y;
        this.type=type;

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

    public EnumLocation getType() {
        return type;
    }

    public void setType(EnumLocation type) {
        this.type = type;
    }

    @Override
    public String toString()  {
        return "Location:" + getName() + " " + "Type:" + getType() + " " + "coordinates: x=" + getX() + " and y="  + getY();
    }
}