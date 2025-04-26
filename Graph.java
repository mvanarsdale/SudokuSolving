package sudokuSolver;


import java.util.ArrayList;
import java.util.Collections;

//Java program to implement Graph FROM Geeks4Geeks
//with the help of Generics


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Graph<T> {

	 // hashmap that will store edges in the graph
	 Map<T, List<T> > map = new HashMap<>();

	 // funtion to add a new vertex to the graph
	 public void addVertex(T s)
	 {
	     map.put(s, new LinkedList<T>());
	 }

	 // function to add the edge
	 public void addEdge(T source, T destination,
	                     boolean bidirectional)
	 {

	     if (!map.containsKey(source))
	         addVertex(source);

	     if (!map.containsKey(destination))
	         addVertex(destination);

	     map.get(source).add(destination);
	     if (bidirectional == true) {
	         map.get(destination).add(source);
	     }
	 }

	 // This function gives the count of vertices
	 public void getVertexCount()
	 {
	     System.out.println("The graph has "
	                        + map.keySet().size()
	                        + " vertex");
	 }

	 // This function gives the count of edges
	 public void getEdgesCount(boolean bidirection)
	 {
	     int count = 0;
	     for (T v : map.keySet()) {
	         count += map.get(v).size();
	     }
	     if (bidirection == true) {
	         count = count / 2;
	     }
	     System.out.println("The graph has " + count
	                        + " edges.");
	 }

	 // This function gives whether
	 // a vertex is present or not.
	 public void hasVertex(T s)
	 {
	     if (map.containsKey(s)) {
	         System.out.println("The graph contains " + s
	                            + " as a vertex.");
	     }
	     else {
	         System.out.println("The graph does not contain "
	                            + s + " as a vertex.");
	     }
	 }

	 // This function gives whether an edge is present or
	 // not.
	 public void hasEdge(T s, T d)
	 {
	     if (map.get(s).contains(d)) {
	         System.out.println(
	             "The graph has an edge between " + s
	             + " and " + d + ".");
	     }
	     else {
	         System.out.println(
	             "The graph has no edge between " + s
	             + " and " + d + ".");
	     }
	 }
	 
	 // from ChatGPT
	 public List<T> neighbours(T s) {
		    if (!map.containsKey(s)) 
		        return Collections.emptyList(); // just return an empty list if not found (￣∇￣)

		    return new ArrayList<>(map.get(s)); // return a copy of neighbors so you can use it ✧(｡•̀ᴗ-)✧
		}


	   public void printNeighbours(T s)
	 {
	     if(!map.containsKey(s)) 
	     return ;
	     System.out.println("The neighbours of "+s+" are");
	     for(T w:map.get(s))
	      System.out.print(w+",");
	 }
	   
	  // Code from ChatGPT
	  public static Vertex getVertexAt(int row, int col, Map<Vertex, List<Vertex>> map) {
		  for (Vertex v : map.keySet()) {
			  if (v.getRow() == row && v.getCol() == col) {
				  return v; 
		       }
		  }
		   return null; 
		}


	 // Prints the adjancency list of each vertex.
	 @Override public String toString()
	 {
	     StringBuilder builder = new StringBuilder();

	     for (T v : map.keySet()) {
	         builder.append(v.toString() + ": ");
	         for (T w : map.get(v)) {
	             builder.append(w.toString() + " ");
	         }
	         builder.append("\n");
	     }

	     return (builder.toString());
	 }
	}
