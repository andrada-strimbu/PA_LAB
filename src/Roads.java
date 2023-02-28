public class Roads {
private EnumRoads type;
private  float length;
private int speed;
private Locations a;
private Locations b;
public  Roads(EnumRoads type,Locations a, Locations b){
    this.a =a;
    this.b =b;
    this.length= (float) Math.sqrt((b.getX()-a.getX())*(b.getX()-a.getX())+(b.getY()-a.getY())*(b.getY()-a.getY()));
    this.type=type;
    if(type.toString()=="Highway"){
        speed=130;
    }
    if(type.toString()=="Express"){
        speed=120;
    }
    if(type.toString()=="Country"){
        speed=50;
    }

}

public float getLength(){

    return length;
}
    public int getSpeed(){

        return speed;
    }
    public  EnumRoads getType(){
    return type;
    }
    @Override
    public String toString(){
        return getType().toString() + " road between " + a.getName() + " " + b.getName() + " with speed limit of " + speed;
    }

}
