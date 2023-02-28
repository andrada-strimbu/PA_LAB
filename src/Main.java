public class Main {

    public static void main(String args[]) {
        Locations c1 = new Locations("Iasi", 5, 40.5F, EnumLocation.Cities);
        Locations c2 = new Locations("Vaslui", 10, 20.5F, EnumLocation.Cities);
        Roads r1= new Roads(EnumRoads.Express, c1, c2);
        System.out.println(r1);}

}