package TreeDFS;


import helper.TreeNode;

import java.util.*;

public class AllNodesDistanceKinBinaryTree {

    //Convert tree as undirected graph
    //Adj verticies are two children and one parent
    //Use DFS to generate map of child to parent
    //Then use BFS to find k levels away

    //O(2N) time
    //O(2N) space


    //Places to store results
    List<Integer> result = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {


        //First get each childs parents as they are one of the adj verticies
        Map<TreeNode,TreeNode> childParentMap = new HashMap<>();
        parentMapHelper(root,childParentMap);


        //Now BFS keeping track of levels and stopping if at greater level


        //Get the ball rolling by adding target
        Deque<TreeNode> nextToVisit = new LinkedList<>();
        int distanceAway = -1; //once we visit target we are zero away
        nextToVisit.add(target);


        //Need to prevent loops by looking at marked
        Set<TreeNode> seen = new HashSet<>();

        //Keep going as long as queue is not empty and
        while(!nextToVisit.isEmpty() && distanceAway < K) { //distance == K once we have already visited that level
            distanceAway++;
            int levelSize = nextToVisit.size();


            //Visit all nodes on level k away from target. When we visit
            for (int i = 0; i < levelSize; i++) {
                TreeNode visiting = nextToVisit.remove();
                seen.add(visiting);

                if (distanceAway == K) {
                    result.add(visiting.val);
                }


                //Adj verticies are left and right children and parent
                if (visiting.left != null && !seen.contains(visiting.left)) {
                    nextToVisit.add(visiting.left);
                }
                if (visiting.right != null && !seen.contains(visiting.right)) {
                    nextToVisit.add(visiting.right);
                }

                //Should always have parent unless we are visiting root
                TreeNode parent = childParentMap.get(visiting);
                if (parent != null && !seen.contains(parent)){
                    nextToVisit.add(parent);
                }
            }
        }

        return result;

    }

    private void parentMapHelper(TreeNode root, Map<TreeNode,TreeNode> childParentMap) {

        //Tree is non empty so no need to check root

        if (root.left != null) {
            childParentMap.put(root.left, root); //child is key parent is value
            parentMapHelper(root.left,childParentMap);

        }
        if (root.right != null) {
            childParentMap.put(root.right, root);
            parentMapHelper(root.right,childParentMap);
        }
    }




}
