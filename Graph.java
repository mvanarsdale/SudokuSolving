package sudokuSolver;


// Libraries
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//Java program to implement Graph FROM Geeks4Geeks
//with the help of Generics

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
		    	// just return an empty list
		    	return Collections.emptyList(); 

		    // return a copy of neighbors
		    return new ArrayList<>(map.get(s)); 
		}

	 	// I dont think this is needed - code form geeks4geeks
	   public void printNeighbours(T s)
	 {
	     if(!map.containsKey(s)) 
	     return ;
	     System.out.println("The neighbours of "+s+" are");
	     for(T w:map.get(s))
	      System.out.print(w+",");
	 }
	   
	  // gets vertex from specfic vertex in graph - Code from ChatGPT
	  public static Vertex getVertexAt(int row, int col, Map<Vertex, List<Vertex>> map) {
		  // for all vertices
		  for (Vertex v : map.keySet()) {
			  // find vertex with specfic row and column
			  if (v.getRow() == row && v.getCol() == col) {
				  return v; 
		       }
		  }
		   return null; 
		}
	  
	  // gets vertex from specfic vertex in 3D graph - Code from ChatGPT
	  public static Vertex get3DVertexAt(int row, int col, int layer, Map<Vertex, List<Vertex>> map) {
		  // for all vertices
		  for (Vertex v : map.keySet()) {
			  // find vertex with specfic row and column
			  if (v.getRow() == row && v.getCol() == col && v.getLayer() == layer) {
				  return v; 
			  }
		  }
			return null; 
	  }
	
	// Method that clones 2D graphs - Lailani
	public Graph<Vertex> cloneGraph() {
		Graph<Vertex> clonedGraph = new Graph<>();

		Map<Vertex, Vertex> vertexMap = new HashMap<>();

		// Clone all vertices
		for (T originalT : this.map.keySet()) {
			Vertex original = (Vertex) originalT;
		    Vertex copy = new Vertex(original.row, original.col, original.value);
		    vertexMap.put(original, copy);
		    clonedGraph.addVertex(copy);
		}

		// Clone all edges
		for (T originalT : this.map.keySet()) {
			Vertex original = (Vertex) originalT;
		    Vertex copy = vertexMap.get(original);
		    for (T neighborT : this.map.get(original)) {
		    	Vertex neighbor = (Vertex) neighborT;
		        Vertex neighborCopy = vertexMap.get(neighbor);
		        clonedGraph.addEdge(copy, neighborCopy, true);
		    }
		}
		    return clonedGraph;
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
