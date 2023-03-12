
import java.util.*;

public class Network {
    private List<Node> nodes = new ArrayList<>();

    public void addNode(Node node) {
        nodes.add(node);
    }

    public static int getImportanceOfNode (Node node){
        int numberOfKeys = 0;
        if (node.getClass() == Designer.class){
            Designer designer = (Designer) node;
            Map<Node, String> mapCopy = designer.getRelationships();
            numberOfKeys = mapCopy.keySet().size();
        }
        if (node.getClass() == Programmer.class){
            Programmer programmer = (Programmer) node;
            Map<Node, String> mapCopy = programmer.getRelationships();
            numberOfKeys = mapCopy.keySet().size();
        }
        return numberOfKeys;

    }

    @Override
    public String toString() {
        for(int i = 0; i<nodes.size()-1; i++){
            for(int j = i+1; j<nodes.size(); j++){
                if(getImportanceOfNode(nodes.get(i)) < getImportanceOfNode(nodes.get(j) ) ){
                    Collections.swap(nodes,i,j);
                }
            }
        }
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }



}


