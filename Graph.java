package sudokuSolver;


// Libraries
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/** 
* Class that produces sudoku board solutions using a DLS and BFS approach 
* From Geeks4Geeks with the help of Generics
*/

class Graph<T> {

	 // hashmap that will store edges in the graph
	 Map<T, List<T> > map = new HashMap<>();

	 // funtion to add a new vertex to the graph
	 public void addVertex(T s) {
		 map.put(s, new LinkedList<T>());
	 }

	 // function to add the edge
	 public void addEdge(T source, T destination, boolean bidirectional) {
	     if (!map.containsKey(source))
	         addVertex(source);

	     if (!map.containsKey(destination))
	         addVertex(destination);

	     map.get(source).add(destination);
	     if (bidirectional == true) {
	         map.get(destination).add(source);
	     }
	 }
	 
	 // Method that keeps list of vertex neighbor's from ChatGPT
	 public List<T> neighbours(T s) {
		 if (!map.containsKey(s)) 
			 // just return an empty list
		     return Collections.emptyList(); 

		 // return a copy of neighbors
		 	return new ArrayList<>(map.get(s)); 
		}

	 // gets vertex from specfic vertex in graph - Code from ChatGPT
	 public static Vertex getVertexAt(int row, int col, Map<Vertex, List<Vertex>> map) {
		 // for all vertices
		 for (Vertex v : map.keySet()) {
			 // find vertex with specfic row and column
			 if (v.getRow() == row && v.getCol() == col) {
				 // returns vertex 
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
				 // returns vertex  
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

	}
