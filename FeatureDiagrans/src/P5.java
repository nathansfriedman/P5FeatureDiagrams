
import java.util.HashSet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nathan
 */
public class P5 {
    public static void main(String[] Args){
        Features EX = createEX();
        boolean isEXValid = validateTree(EX, new HashSet<Features>());
        System.out.println("EX tree is " + isEXValid);
        System.out.println();
        
        Features Car = createCar();
        boolean isCarValid = validateTree(Car, new HashSet<Features>());
        System.out.println("Car tree is " + isCarValid);
        System.out.println();
        
        Features GraphLibrary = createGraphLibrary();
        boolean isGraphLibraryValid = validateTree(GraphLibrary, new HashSet<Features>());
        System.out.println("GraphLibrary tree is " + isGraphLibraryValid);
        System.out.println();
        
        Features MixedEdgeType = createMixedEdgeType();
        boolean isMixedEdgeTypeValid = validateTree(MixedEdgeType, new HashSet<Features>());
        System.out.println("MixedEdgeType tree is " + isMixedEdgeTypeValid);
        System.out.println();
        
        Features Cyclical = createCyclical();
        boolean isCyclicalValid = validateTree(Cyclical, new HashSet<Features>());
        System.out.println("Cyclical tree is " + isCyclicalValid);
    }
    
    static Features createEX(){
        Features root = new Features("EX");
        Features directX = new Features("directX");
        Features API = new Features("API");
        Features base = new Features("base");
        Features get = new Features("get");
        Features put = new Features("put");
        ANDOptional edge1 = new ANDOptional(root, directX);
        ANDOptional edge2 = new ANDOptional(root, API);
        ANDMandatory edge3 = new ANDMandatory(root, base);
        OR edge4 = new OR(API, get);
        OR edge5 = new OR(API, put);
        return root;
    }
    
    static Features createCar(){
        Features root = new Features("Car");
        Features Cruise = new Features("Cruise");
        Features Engine = new Features("Engine");
        Features Transmission = new Features("Transmission");
        Features CarBody = new Features("CarBody");
        Features Gasoline = new Features("Gasoline");
        Features Electric = new Features("Electric");
        Features Manual = new Features("Manual");
        Features Automatic = new Features("Automatic");
        ANDOptional edge1 = new ANDOptional(root, Cruise);
        ANDMandatory edge2 = new ANDMandatory(root, Engine);
        ANDMandatory edge3 = new ANDMandatory(root, Transmission);
        ANDMandatory edge4 = new ANDMandatory(root, CarBody);
        OR edge5 = new OR(Engine, Gasoline);
        OR edge6 = new OR(Engine, Electric);
        XOR edge7 = new XOR(Transmission, Manual);
        XOR edge8 = new XOR(Transmission, Automatic);
        return root;
    }
    
    static Features createGraphLibrary(){
        Features root = new Features("GraphLibrary");
        Features EdgeType = new Features("EdgeType");
        Features Search = new Features("Search");
        Features Weighted = new Features("Weighted");
        Features Algorithm = new Features("Algorithm");
        Features Directed = new Features("Directed");
        Features Undirected = new Features("Undirected");
        Features BFS = new Features("BFS");
        Features DFS = new Features("DFS");
        Features Cycle = new Features("Cycle");
        Features ShortestPath = new Features("ShortestPath");
        Features MST = new Features("MST");
        Features Transpose = new Features("Transpose");
        Features Prim = new Features("Prim");
        Features Kruskal = new Features("Kruskal");
        ANDMandatory edge1 = new ANDMandatory(root, EdgeType);
        ANDOptional edge2 = new ANDOptional(root, Search);
        ANDOptional edge3 = new ANDOptional(root, Weighted);
        ANDMandatory edge4 = new ANDMandatory(root, Algorithm);
        XOR edge5 = new XOR(EdgeType, Directed);
        XOR edge6 = new XOR(EdgeType, Undirected);
        XOR edge7 = new XOR(Search, BFS);
        XOR edge8 = new XOR(Search, DFS);
        OR edge9 = new OR(Algorithm, Cycle);
        OR edge10 = new OR(Algorithm, ShortestPath);
        OR edge11 = new OR(Algorithm, MST);
        OR edge12 = new OR(Algorithm, Transpose);
        OR edge13 = new OR(MST, Prim);
        OR edge14 = new OR(MST, Kruskal);
        return root;
    }    
    
    static Features createMixedEdgeType(){
        Features root = new Features("Root");
        Features child1 = new Features("Child1");
        Features child2 = new Features("Child2");
        ANDMandatory edge1 = new ANDMandatory(root, child1);
        XOR edge2 = new XOR(root, child2);
        return root;
    }    
    
    static Features createCyclical(){
        Features root = new Features("Root");
        Features child1 = new Features("Child1");
        ANDMandatory edge1 = new ANDMandatory(root, child1);
        ANDOptional edge2 = new ANDOptional(child1, root);
        return root;
    }   
        
    static boolean validateTree(Features node, HashSet<Features> nodeList) {
        if (nodeList.contains(node)) {
            System.out.println("Invalid: Tree is cyclical");
            return false;
        }
        nodeList.add(node);
        if (node.isTerminal()) {
            return true;
        }
        if (!node.hasCompatibleChildren()) {
            return false;
        }
        for (Features child : node.getChildren()) {
            if (!validateTree(child, nodeList)) {
                return false;
            }
        }
        return true;
    }
    
}
