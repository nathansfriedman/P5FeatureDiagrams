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
        Features Car = createCar();
        Features GraphLibrary = createGraphLibrary();
        boolean isEXValid = validateTree(EX);
        boolean isCarValid = validateTree(Car);
        boolean isGraphLibraryValid = validateTree(GraphLibrary);
        System.out.println("EX tree is " + isEXValid);
        System.out.println("Car tree is " + isCarValid);
        System.out.println("GraphLibrary tree is " + isGraphLibraryValid);
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
    
    static boolean validateTree(Features node){
        if (node.isTerminal())
            return true;
        else {
            
        }            
        return false;
    }
}