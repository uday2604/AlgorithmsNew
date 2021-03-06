package random.trees;

import java.util.*;

/**
 * Created by udaythota on 3/13/19.
 */
public class LevelOrderTraversal {

    public List levelOrderTraversal(BinaryTreeNode root) {
        if (root == null)
            return null;
        else {
            List<Integer> outputList = new ArrayList<>();
            Queue<BinaryTreeNode> nodeStoreQueue = new LinkedList<>();
            nodeStoreQueue.offer(root);
            while (!nodeStoreQueue.isEmpty()) {
                BinaryTreeNode temp = nodeStoreQueue.poll();
                outputList.add(temp.data);
                if (temp.llink != null)
                    nodeStoreQueue.offer(temp.llink);
                if (temp.rlink != null)
                    nodeStoreQueue.offer(temp.rlink);
            }
            return outputList;
        }
    }

    public static void printLevelOrderTraversal(random.trees.BinaryTreeNode root) {
        if (root != null) {
            Queue<random.trees.BinaryTreeNode> nodeStoreQueue = new LinkedList<>();
            nodeStoreQueue.offer(root);
            while (!nodeStoreQueue.isEmpty()) {
                random.trees.BinaryTreeNode temp = nodeStoreQueue.poll();
                System.out.print(temp.data + " ");
                if (temp.llink != null)
                    nodeStoreQueue.offer(temp.llink);
                if (temp.rlink != null)
                    nodeStoreQueue.offer(temp.rlink);
            }
        }
    }

    private Stack<Integer> printElementsInReverseOrder(BinaryTreeNode root) {
        if (root == null)
            return null;
        else {
            Stack<Integer> outputStack = new Stack<>();
            Queue<random.trees.BinaryTreeNode> nodeStoreQueue = new LinkedList<>();
            nodeStoreQueue.offer(root);
            while (!nodeStoreQueue.isEmpty()) {
                BinaryTreeNode temp = nodeStoreQueue.poll();
                outputStack.push(temp.data);
                if (temp.llink != null)
                    nodeStoreQueue.offer(temp.llink);
                if (temp.rlink != null)
                    nodeStoreQueue.offer(temp.rlink);
            }
            return outputStack;
        }
    }

    private Stack<Integer> levelOrderTraversalInvertedOrder(BinaryTreeNode root) {
        if (root == null) {
            return null;
        } else {
            Stack<Integer> outputStack = new Stack<>();
            Queue<BinaryTreeNode> nodeStoreQueue = new LinkedList<>();
            nodeStoreQueue.offer(root);
            while (!nodeStoreQueue.isEmpty()) {
                BinaryTreeNode temp = nodeStoreQueue.poll();
                outputStack.push(temp.data);
                if (temp.rlink != null)
                    nodeStoreQueue.offer(temp.rlink);
                if (temp.llink != null)
                    nodeStoreQueue.offer(temp.llink);
            }
            return outputStack;
        }
    }


    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(3);
        BinaryTreeNode node1 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(5);
        BinaryTreeNode node3 = new BinaryTreeNode(6);
        BinaryTreeNode node4 = new BinaryTreeNode(7);
        BinaryTreeNode node5 = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(9);
        BinaryTreeNode node7 = new BinaryTreeNode(10);
        root.llink = node1;
        root.rlink = node2;
        node1.llink = node3;
        node1.rlink = node4;
        node2.llink = node5;
        node4.llink = node6;
        node4.rlink = node7;
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        List<Integer> outputList = levelOrderTraversal.levelOrderTraversal(root);
        System.out.println(outputList);
        Stack outputStack = levelOrderTraversal.printElementsInReverseOrder(root);
        System.out.println(outputStack);
        Stack outputStack2 = levelOrderTraversal.levelOrderTraversalInvertedOrder(root);
        System.out.println("The level order traversal in inverted order is: ");
        while (!outputStack2.isEmpty()) {
            System.out.print(outputStack2.pop() + " ");
        }
    }
}
