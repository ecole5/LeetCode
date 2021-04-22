package TreeDFS;

import java.util.ArrayList;
import java.util.List;

//This techniuqe is basiclly to color the graph.

public class CourseSchedule {

    //First create adjeciny list

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //0 univisted -> need to search recurssivly
        //1 processing -> if you run into this you have a loop
        //2 processed -> cant be any loops
        int[] status = new int[numCourses];

        //Build adjacent matrix
        //[a,b] in order to take a you need to take b first. A is dependent on B.
        // You can draw the directed graph either a->b or b-> a, does not matter
        //choose a->b and build adjaceny table
        //if you choose a->b then in a postorder traversal the correct order is obtianed by simply adding it to a list
        //if you choose b->a then in a postorder traversal the crrect order is the resverse.

        //Generate empty list with an empty list for each node
        List<List<Integer>> adjList = new ArrayList<>(); //note the weird object creation syntax here
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        //Populate lists for nodes that have edges
        for (int[] edge : prerequisites) {
            List<Integer> nodeList = adjList.get(edge[0]);
            nodeList.add(edge[1]); //add edge to adj list
        }


        //Now check every node. We need to initite a dfs on every node in case they are all not connected..
        for (int i = 0; i < numCourses; i++) {

            //true if lop found
            if (dfsCheckLoop(i, status, adjList)) {
                return false; //course cannot be co
            }
        }

        return true; //if no loops found course can be completed


    }


    private boolean dfsCheckLoop(int nodeIndex, int[] status, List<List<Integer>> adjList) {
        if (status[nodeIndex] == 2){ //no loops possible already explored
            return false;
        }
        if (status[nodeIndex] == 1){ //loop dected
            return true;
        }

        //Otherwise we need to explore this recussivly
        status[nodeIndex] = 1; //mark as processing
        for (int adjnode : adjList.get(nodeIndex)){
            if (dfsCheckLoop(adjnode,status,adjList)){
                return true;
            }
        }
        status[nodeIndex] = 2;
        return false;
    }

}
