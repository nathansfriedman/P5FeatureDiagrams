/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nathan
 */
public class ANDMandatory extends AbstractEdge{
    public ANDMandatory(Features p, Features c){
        parent = p;
        child = c;
        p.addChild(child);
        c.setParentEdge(this);
        
    }
}
