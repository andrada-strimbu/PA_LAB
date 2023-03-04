
import java.util.ArrayList;
public class Problem {
    /**
     * clasa Problem contine mai multe locatii si drumuri implementate cu ajutor a doua liste
     */

    private ArrayList<Locations> locations = new ArrayList<Locations>();
    private ArrayList<Roads> roads = new ArrayList<Roads>();
    public ArrayList<Locations> getLocations() {
        return locations;
    }

    public void setLocations(Locations l) {
        for(int i = 0 ; i<locations.size() ; i++){
            if(l.equals(locations.get(i)))
            {
                System.out.println("Error:Invalid locations");
                return;
            }

        }
        locations.add(l);
    }


    public void setRoads(Roads r) {
        for (int i = 0; i< roads.size(); i ++ ){
            if(r.equals(roads.get(i))){
                System.out.println("Erro:Invalid  roads");
                return;
            }
        }
        roads.add(r);
    }
    public void validateProblemInstace(){
        if(!(roads.isEmpty())&& locations.size()>=2){
            System.out.println("Valid instance");
        }
        else System.out.println("");
    }
    @Override
    public String toString() {
        return "Problem{" + "locations=" + locations + ", roads=" + roads + '}';
    }
}