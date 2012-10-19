
import java.util.Set;

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
    private Set<Features> children;
    
    Features(String n){
        name = n;
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
}
