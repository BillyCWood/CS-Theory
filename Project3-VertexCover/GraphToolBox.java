
import java.util.*;

/**
 *
 * @author yaw
 */
public class GraphToolBox {
    // return an array containing the vertex numbers of an optimal VC.



    public static int[] exactVC(Graph inputGraph) {

        Map<String, ArrayList<Integer>> edges = new HashMap<>();
        boolean[] visited = new boolean[inputGraph.getGraph().length];
        for(int i = 0; i < visited.length; i++){
            visited[i] = false;
        }



        int edgeNum = 0;
        for(int i = 0; i < inputGraph.getGraph().length-1; i++){
            for(int j = 0; j < inputGraph.getGraph()[i].length; j++){
                String name = "e"+edgeNum;
                edgeNum++;
                ArrayList<Integer> vertices = new ArrayList<>();
                ArrayList<Integer> check = new ArrayList<>();

                vertices.add(i);
                vertices.add(inputGraph.getGraph()[i][j]);

                check.add(inputGraph.getGraph()[i][j]);
                check.add(i);


                if(edges.containsValue(check)==true){
                    //System.out.println("Duplicate Found");

                }else{edges.put(name,vertices);}
                //edges.put(name,vertices);

            }


        }


        ArrayList<Integer> visitVertex = new ArrayList<>();
        for(Map.Entry e : edges.entrySet()){
            ArrayList pair = (ArrayList) e.getValue();


            int u = (int) pair.get(0);
            int v = (int) pair.get(1);

            if(visitVertex.contains(u)==false) {


                if (visited[u] == false) {
                    visitVertex.add(u);

                    if (visited[v] == false) {
                        visited[v] = true;
                        visited[u] = true;

                        visitVertex.add(v);
                    }
                }
            }

        }




        int count = 0;
        for(int i = 0; i< visited.length;i++){
            if(visited[i]){count++;}
        }
        int[] cover = new int[count];

        int index = 0;
        for(int i = 0; i < visited.length; i++){
            if(visited[i]){
                cover[index] = i;
                index++;
            }
        }


        return cover;
    }

    // return (in polynomial time) an array containing the vertex numbers of a VC.
    public static int[] inexactVC(Graph inputGraph) {

        int[] vertices = new int[inputGraph.getGraph().length];
        int[] unmarked = new int[inputGraph.getGraph().length];

        for(int i = 0;i < vertices.length;i++){
            if(i == 0){vertices[i] = -1;}else{vertices[i] = i;}
        } //O(n)
        for(int i = 1; i < unmarked.length;i++){
            unmarked[i] = -1;
        }

        //O(n^3)
        for(int i = 1; i < unmarked.length; i++){

            boolean contains = false;
            for (int j = 0; j < inputGraph.getGraph()[i].length; j++){

                for(int k = 0; k < i; k++){
                    if(inputGraph.getGraph()[i][j] == unmarked[k]){
                        contains = true;
                        break;
                    }
                }
                if(contains == true){
                    break;
                }

            }

            if(contains == false){
                unmarked[i] = vertices[i];
                vertices[i] = -1;
            }
        }


        int count = 0;

        for(int i = 0; i<vertices.length;i++){
            if(vertices[i] != -1){count++;}
        }
        int[] markedToReturn = new int[count];

        int index = 0;
        for(int i = 0; i<vertices.length;i++){
            if(vertices[i] != -1){
                markedToReturn[index] = vertices[i];
                index++;
            }
        }

        return markedToReturn;
    }

    // return an array containing the vertex numbers of an optimal IS.
    public static int[] optimalIS(Graph inputGraph) {

        Map<String, ArrayList<Integer>> edges = new HashMap<>();
        boolean[] visited = new boolean[inputGraph.getGraph().length];
        for(int i = 0; i < visited.length; i++){
            visited[i] = false;
        }



        int edgeNum = 0;
        for(int i = 0; i < inputGraph.getGraph().length-1; i++){
            for(int j = 0; j < inputGraph.getGraph()[i].length; j++){
                String name = "e"+edgeNum;
                edgeNum++;
                ArrayList<Integer> vertices = new ArrayList<>();
                ArrayList<Integer> check = new ArrayList<>();

                vertices.add(i);
                vertices.add(inputGraph.getGraph()[i][j]);

                check.add(inputGraph.getGraph()[i][j]);
                check.add(i);


                if(edges.containsValue(check)==true){
                    //System.out.println("Duplicate Found");

                }else{edges.put(name,vertices);}
                //edges.put(name,vertices);

            }


        }


        ArrayList<Integer> visitVertex = new ArrayList<>();
        for(Map.Entry e : edges.entrySet()){
            ArrayList pair = (ArrayList) e.getValue();


            int u = (int) pair.get(0);
            int v = (int) pair.get(1);

            if(visitVertex.contains(u)==false) {


                if (visited[u] == false) {
                    visitVertex.add(u);

                    if (visited[v] == false) {
                        visited[v] = true;
                        visited[u] = true;

                        visitVertex.add(v);
                    }
                }
            }

        }




        int count = 0;
        for(int i = 0; i< visited.length;i++){
            if(visited[i]==false){count++;}
        }
        int[] cover = new int[count];

        int index = 0;
        for(int i = 0; i < visited.length; i++){
            if(visited[i]==false){
                cover[index] = i;
                index++;
            }
        }


        return cover;
    }

    // return (in polynomial time) an array containing the vertex numbers of a IS.
    public static int[] inexactIS(Graph inputGraph) {

        int[] vertices = new int[inputGraph.getGraph().length];
        int[] marked = new int[inputGraph.getGraph().length];

        for(int i = 0;i < vertices.length;i++){
            if(i == 0){vertices[i] = -1;}else{vertices[i] = i;}
        } //O(n)
        for(int i = 1; i <marked.length;i++){
            marked[i] = -1;
        }

        //O(n^2)
        for(int i = 1; i < marked.length; i++){

            boolean contains = false;
            for (int j = 0; j < inputGraph.getGraph()[i].length; j++){

                for(int k = 0; k < i; k++){
                    if(inputGraph.getGraph()[i][j] == marked[k]){
                        contains = true;
                        break;
                    }
                }
                if(contains == true){
                    break;
                }

            }

            if(contains == false){
                marked[i] = vertices[i];
                vertices[i] = -1;
            }
        }


        int count = 0;

        for(int i = 0; i<marked.length;i++){
            if(marked[i] != -1){count++;}
        }
        int[] markedToReturn = new int[count];

        int index = 0;
        for(int i = 0; i<marked.length;i++){
            if(marked[i] != -1){
                markedToReturn[index] = marked[i];
                index++;
            }
        }

        return markedToReturn;
    }
}

