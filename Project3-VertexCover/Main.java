import java.io.File;
import java.util.Arrays;


public class Main {

    public static void main(String[] args){

        File generated = randomGraph.createGraph(10);
        Graph graph = new Graph("src/graph4.txt");

        System.out.println("Graph of size: " + graph.getGraph().length+"\n");



        long previousTime = System.currentTimeMillis();

        int[] inexactVC = GraphToolBox.inexactVC(graph);
        long currentTime = System.currentTimeMillis();
        double elapsedTime = (currentTime - previousTime) / 1000.0;
        System.out.println("Inexact Vertex Cover: "+Arrays.toString(inexactVC)+"\nSize: "+inexactVC.length+"\nTime: " +elapsedTime);
        previousTime = currentTime;


        int[] inexactIS = GraphToolBox.inexactIS(graph);
        currentTime = System.currentTimeMillis();
        elapsedTime = (currentTime - previousTime) / 1000.0;
        System.out.println("Inexact Independent Set: "+Arrays.toString(inexactIS)+"\nSize: "+inexactIS.length+"\nTime: " +elapsedTime);
        previousTime = currentTime;

        int[] exactVC = GraphToolBox.exactVC(graph);
        currentTime = System.currentTimeMillis();
        elapsedTime = (currentTime - previousTime) / 1000.0;
        System.out.println("Exact Vertex Cover: "+Arrays.toString(exactVC)+"\nSize: "+exactVC.length+"\nTime: " +elapsedTime);
        previousTime = currentTime;

        int[] exactIS = GraphToolBox.optimalIS(graph);
        currentTime = System.currentTimeMillis();
        elapsedTime = (currentTime - previousTime) / 1000.0;
        System.out.println("Exact Independent Set: "+Arrays.toString(exactIS)+"\nSize: "+exactIS.length+"\nTime: " +elapsedTime);

        //System.out.println("Vertex Cover: "+Arrays.toString(GraphToolBox.inexactVC(graph)));

        //GraphToolBox.optimalIS(graph);
        //System.out.println("Independent Set: "+Arrays.toString(GraphToolBox.inexactIS(graph)));


    }


}
