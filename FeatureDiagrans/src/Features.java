
import java.util.HashSet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nathan
 */
public class Features {
    public String name;
    public AbstractEdge edgeToParent;
    private HashSet<Features> children;
    
    Features(String n){
        name = n;
        children = new HashSet();
    }
    
    public void setParentEdge(AbstractEdge ae){
        edgeToParent = ae;
    }
    
    public void addChild (Features child){
        children.add(child);
    }
    
    public boolean isTerminal(){
        return children.isEmpty();
    }
    
    public HashSet<Features> getChildren() {
        return children;
    }
    
    public boolean hasCompatibleChildren() {
        boolean isAND = false;
        boolean isOR = false;
        boolean isXOR = false;
        for (Features child : children) {
            AbstractEdge edge = child.edgeToParent;
            if (!edge.parent.equals(this)) {
                System.out.println("ERROR: Child lists incorrect parent!");
                return false;
            }
            Class<?> edgeClass = edge.getClass();
            String edgeType = edgeClass.getSimpleName();
            switch (edgeType) {
                case "ANDMandatory":
                case "ANDOptional" : 
                    if (isOR)       { System.out.println("AND edge found after OR at node " + child.name);
                                      return false; }
                    else if (isXOR) { System.out.println("AND edge found after XOR at node " + child.name);
                                      return false; }
                    else            { isAND = true; }
                    break;
                case "OR" :
                    if (isAND)      { System.out.println("OR edge found after AND at node " + child.name);
                                      return false; }
                    else if (isXOR) { System.out.println("OR edge found after XOR at node " + child.name);
                                      return false; }
                    else            { isOR = true; }
                    break;
                case "XOR" :
                    if (isAND)     { System.out.println("XOR edge found after AND at node " + child.name);
                                     return false; }
                    else if (isOR) { System.out.println("XOR edge found after OR at node " + child.name);
                                     return false; }
                    else           { isXOR = true; }
                    break;
                default :
                    System.out.println("Unexpected Edge type!");
                    System.exit(1);
            }
        }
        return true;
    }
}
