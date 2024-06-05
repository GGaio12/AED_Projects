import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.round;
import static java.lang.System.currentTimeMillis;

public class Projeto2AED {
    public static void main(String[] args) {
        /* Code to run the test without print the tree, just the results of big key insertions in all trees */
        //testBigInsert();

        /* This is the code to test and see every tree with just 20 samples */
        testLowInsert();
    }

    /**
     * Tests everything that was implemented.
     */
    private static void testBigInsert() {
        /* ---> Keys Creation <--- */
        int NUM_KEYS = 10000;                         // number of keys
        int NUM_REP_A = (int) round(0.01 * NUM_KEYS);  // %1 repetition
        int NUM_REP_B = (int) round(0.01 * NUM_KEYS);  // %1 repetition
        int NUM_REP_C = (int) round(0.01 * NUM_KEYS);  // %1 repetition
        int NUM_REP_D = (int) round(0.9 * NUM_KEYS);   // %90 repetition

        int[] keysA = generateKeysA(NUM_KEYS, NUM_REP_A);
        int[] keysB = generateKeysB(NUM_KEYS, NUM_REP_B);
        int[] keysC = generateKeysCD(NUM_KEYS, NUM_REP_C);
        int[] keysD = generateKeysCD(NUM_KEYS, NUM_REP_D);

        /* ---> Testing all the keys in the different trees <--- */
        int[][] KEYS = {keysA, keysB, keysC, keysD};
        char[] letters = {'A', 'B', 'C', 'D'};
        testInsertBT(KEYS, letters, false);
        testInsertBST(KEYS, letters, false);
        testInsertAVLT(KEYS, letters, false);
        testInsertRBT(KEYS, letters, false);
    }

    private static void testLowInsert() {
        /* ---> Keys Creation <--- */
        int[] keysA = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 11, 12, 13, 14, 15, 15, 16, 17, 18};  // 1% repetition
        int[] keysB = {18, 17, 16, 15, 15, 14, 13, 12, 11, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};  // 1% repetition
        int[] keysC = {3, 14, 18, 6, 12, 10, 15, 2, 16, 8, 9, 10, 1, 15, 4, 17, 11, 13, 7, 5};  // 1% repetition
        int[] keysD = {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1};            // 90% repetition

        /* ---> Testing all the keys in the different trees <--- */
        int[][] KEYS = {keysA, keysB, keysC, keysD};
        char[] letters = {'A', 'B', 'C', 'D'};
        testInsertBT(KEYS, letters, true);
        testInsertBST(KEYS, letters, true);
        testInsertAVLT(KEYS, letters, true);
        testInsertRBT(KEYS, letters, true);
    }

    /**
     * Tests the insertion in a Binary Tree.
     * @param keys Array with all the arrays of keys to test.
     * @param letters Array with the characters to identify each array in keys.
     * @param printMode Decides whether to print or not, true prints the tree, false, don't print.
     */
    private static void testInsertBT(int[][] keys, char[] letters, boolean printMode) {
        System.out.println("--------- TESTING BINARY TREE INSERTIONS TIMES ---------");

        /* Initializations */
        BinaryTree BT;
        long time;

        /* Performing the test across all the different key arrays */
        for(int j = 0; j < keys.length; j++) {
            BT = new BinaryTree();
            time = currentTimeMillis();
            for(int i = 0; i < keys[j].length; i++) BT.add(keys[j][i]);
            System.out.printf("Inserting KEYS %s time: %d ms\n", letters[j], currentTimeMillis() - time);
            if(printMode) BT.printTree();
            System.out.println();
        }
    }

    /**
     * Tests the insertion in a Binary Search Tree.
     * @param keys Array with all the arrays of keys to test.
     * @param letters Array with the characters to identify each array in keys.
     * @param printMode Decides whether to print or not, true prints the tree, false, don't print.
     */
    private static void testInsertBST(int[][] keys, char[] letters, boolean printMode) {
        System.out.println("--------- TESTING BINARY SEARCH TREE INSERTIONS TIMES ---------");

        /* Initializations */
        BinarySearchTree BST;
        long time;

        /* Performing the test across all the different key arrays */
        for(int j = 0; j < keys.length; j++) {
            BST = new BinarySearchTree();
            time = currentTimeMillis();
            for(int i = 0; i < keys[j].length; i++) BST.add(keys[j][i]);
            System.out.printf("Inserting KEYS %s time: %d ms\n", letters[j], currentTimeMillis() - time);
            if(printMode) BST.printTree();
            System.out.println();
        }
    }

    /**
     * Tests the insertion in an AVL Tree.
     * @param keys Array with all the arrays of keys to test.
     * @param letters Array with the characters to identify each array in keys.
     * @param printMode Decides whether to print or not, true prints the tree, false, don't print.
     */
    private static void testInsertAVLT(int[][] keys, char[] letters, boolean printMode) {
        System.out.println("--------- TESTING AVL TREE INSERTIONS TIMES ---------");

        /* Initializations */
        AVLTree AVLT;
        long time;

        /* Performing the test across all the different key arrays */
        for(int j = 0; j < keys.length; j++) {
            AVLT = new AVLTree();
            time = currentTimeMillis();
            for(int i = 0; i < keys[j].length; i++) AVLT.add(keys[j][i]);
            System.out.printf("Inserting KEYS %s time: %d ms    With: %d rotations\n", letters[j], currentTimeMillis() - time, AVLT.getRotCount());
            if(printMode) AVLT.printTree();
            System.out.println();
        }
    }

    /**
     * Tests the insertion in an RB Tree.
     * @param keys Array with all the arrays of keys to test.
     * @param letters Array with the characters to identify each array in keys.
     * @param printMode Decides whether to print or not, true prints the tree, false, don't print.
     */
    private static void testInsertRBT(int[][] keys, char[] letters, boolean printMode) {
        System.out.println("--------- TESTING RB TREE INSERTIONS TIMES ---------");

        /* Initializations */
        RBTree RBT;
        long time;

        /* Performing the test across all the different key arrays */
        for(int j = 0; j < keys.length; j++) {
            RBT = new RBTree();
            time = currentTimeMillis();
            for(int i = 0; i < keys[j].length; i++) RBT.add(keys[j][i]);
            System.out.printf("Inserting KEYS %s time: %d ms    With: %d rotations\n", letters[j], currentTimeMillis() - time, RBT.getRotCount());
            if(printMode) RBT.printTree();
            System.out.println();
        }
    }

    /**
     * Generates the keys to the group A.
     * @param numKeys Number of keys to generate.
     * @param numReps Number of repeated keys in the array.
     * @return Array with the generated keys
     */
    private static int[] generateKeysA(int numKeys, int numReps) {
        int[] keys = new int[numKeys];

        /* Creates the array with ascending integers that are not repetitions */
        for(int i = 0; i < numKeys - numReps; i++) keys[i] = i;

        /* Adding to the array of keys, the repeated keys */
        int[] reps = giveReps(keys, numReps);
        System.arraycopy(reps, 0, keys, numKeys - numReps, numReps);

        /* Sorting again */
        Arrays.sort(keys);

        return keys;
    }

    /**
     * Generates the keys to the group B.
     * @param numKeys Number of keys to generate.
     * @param numReps Number of repeated keys in the array.
     * @return Array with the generated keys
     */
    private static int[] generateKeysB(int numKeys, int numReps) {
        int[] keys = new int[numKeys];

        /* Creates the array with descending integers that are not repetitions */
        for(int i = 0; i < numKeys - numReps; i++) keys[i] = numKeys - i;

        /* Adding to the array of keys, the repeated keys */
        int[] reps = giveReps(keys, numReps);
        System.arraycopy(reps, 0, keys, numKeys - numReps, numReps);

        /* Sorting again in descending order */
        Arrays.sort(keys);
        reverse(keys);

        return keys;
    }

    /**
     * Generates the keys to the groups C and D.
     * @param numKeys Number of keys to generate.
     * @param numReps Number of repeated keys in the array.
     * @return Array with the generated keys
     */
    private static int[] generateKeysCD(int numKeys, int numReps) {
        int[] keys = new int[numKeys];

        /* Creates the array with ascending integers that are not repetitions */
        for(int i = 0; i < numKeys - numReps; i++) keys[i] = i;

        /* Adding to the array of keys, the repeated keys */
        int[] reps = giveReps(keys, numReps);
        System.arraycopy(reps, 0, keys, numKeys - numReps, numReps);

        /* Shuffling the array of keys to put it to a random order */
        shuffleArray(keys);

        return keys;
    }

    /**
     * Returns an array with some repeated random numbers of the original array.
     * @param keys Original array.
     * @param numReps Number of repetitions.
     * @return Array with repeated random numbers of the original array.
     */
    private static int[] giveReps(int[] keys, int numReps) {
        Random rand = new Random();

        /* Array that will contain the repeated number to add to the array */
        int[] reps = new int[numReps];

        /* Picking a random index of the array and adding to the reps array */
        int index;
        for(int i = 0; i < numReps; i++) {
            index = rand.nextInt(keys.length);
            reps[i] = keys[index];
        }
        return reps;
    }

    /**
     * Reverse the array, making the last element, the first, and the first element, the last and so on.
     * @param keys Array to reverse.
     */
    private static void reverse(int[] keys) {
        /* Starting 2 pointers, one to the start and one to the end */
        int left = 0;
        int right = keys.length - 1;

        /* Going through the array with the 2 pointers and reversing it */
        int temp;
        while(left < right) {
            temp = keys[left];
            keys[left] = keys[right];
            keys[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * Shuffles an array.
     * @param keys Array to shuffle
     */
    private static void shuffleArray(int[] keys) {
        /* Initializations */
        Random rand = new Random();
        int index;
        int temp;

        /* Changing the element in i with an element in a random position  */
        for(int i = 0; i < keys.length; i++) {
            index = rand.nextInt(keys.length);
            temp = keys[index];
            keys[index] = keys[i];
            keys[i] = temp;
        }
    }
}

/**
 * Implements Binary Tree.
 */
class BinaryTree {

    /**
     * Implements a node of the Binary Tree.
     */
    private static class BinNode {
        /*
         * ----------------------------------------------------------------
         *                            Attributes
         * ----------------------------------------------------------------
         */

        /**
         * Value of the node.
         */
        private final int value;

        /**
         * Left child node of the node.
         */
        private BinNode leftChild;

        /**
         * Right child node of the node.
         */
        private BinNode rightChild;


        /*
         * ----------------------------------------------------------------
         *                            Constructor
         * ----------------------------------------------------------------
         */

        /**
         * Creates a new Binary node.
         * @param value Value of the new node.
         */
        public BinNode(int value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }


        /*
         * ----------------------------------------------------------------
         *                      Get Attributes of node
         * ----------------------------------------------------------------
         */

        /**
         * Gets the value of the current node.
         * @return Value of the current node.
         */
        public int getValue() { return this.value; }

        /**
         * Gets the left child node of the current node.
         * @return Left child node of the current node.
         */
        public BinNode getLeftChild() { return this.leftChild; }

        /**
         * Gets the right child node of the current node.
         * @return right child node of the current node.
         */
        public BinNode getRightChild() { return this.rightChild; }


        /*
         * ----------------------------------------------------------------
         *                    Set new Attributes to node
         * ----------------------------------------------------------------
         */

        /**
         * Sets a new left child node of the current node with a given value.
         * @param value Value of the new left child node.
         */
        public void setLeftChild(int value) { this.leftChild = new BinNode(value); }

        /**
         * Sets a new right child node of the current node with a given value.
         * @param value Value of the new right child node.
         */
        public void setRightChild(int value) { this.rightChild = new BinNode(value); }
    }

    /*
     * ----------------------------------------------------------------
     *                            Attributes
     * ----------------------------------------------------------------
     */

    /**
     * Node correspondent to the root of the tree.
     */
    private BinNode root;


    /*
     * ----------------------------------------------------------------
     *                            Constructor
     * ----------------------------------------------------------------
     */

    /**
     * Creates a new binary tree.
     */
    public BinaryTree() {
        this.root = null;
    }


    /*
     * ----------------------------------------------------------------
     *                           Print Methods
     * ----------------------------------------------------------------
     */

    /**
     * Prints the tree layer by layer.
     */
    public void printTree() {
        /* If the tree doesn't have a root yet don't print anything */
        if (root == null) return;

        /* Otherwise, start a queue to help with the print system and adds the root to it (the first layer) */
        Queue<BinaryTree.BinNode> queue = new LinkedList<>();
        queue.add(root);

        /* Keeps printing until there are no more nodes in the queue */
        while (!queue.isEmpty()) {
            /* Number of nodes that are in queue now */
            int levelSize = queue.size();
            /*
             * Prints all the nodes in queue by order and for each one, adds (in order) their left and right child
             * so the next time in while loop all the children going to be printed;
             * in other words, this loop prints one layer at a time
             */
            for (int i = 0; i < levelSize; i++) {
                /* Pulls the first node of the queue (also, removing it from queue) and prints it */
                BinaryTree.BinNode node = queue.poll();
                assert node != null;
                System.out.print(node.getValue() + " ");

                /* Adds the children of the current node to the queue, first the left, than the right if they exist */
                if (node.getLeftChild() != null) queue.add(node.getLeftChild());
                if (node.getRightChild() != null) queue.add(node.getRightChild());
            }

            /* Prints a line to separate layers */
            System.out.println();
        }
    }


    /*
     * ----------------------------------------------------------------
     *                   Tree manipulation methods
     * ----------------------------------------------------------------
     */

    /**
     * Adds a new node to the tree. If the value already exists,
     * does nothing to the tree.
     * @param value Value of the new node.
     */
    public void add(int value) {
        /* If there is no root yet, creates a new one with the given value */
        if(root == null) root = new BinaryTree.BinNode(value);
        /* Otherwise */
        else {
            /* Starts a queue to help going through the tree layer by layer adding the root to it */
            Queue<BinaryTree.BinNode> queue = new LinkedList<>();
            queue.add(root);

            /* Keep going through the layers one by one until the queue is empty, in other words, until there are no nodes */
            while(!queue.isEmpty()) {
                /*
                 * Pulls the first node of the queue (also, removing it from queue) and verifies its children nodes,
                 * if one of them are in miss, creates a new node there with the given value, otherwise, add the two
                 * children (in order) to the queue to also be analyzed after the parent and their uncles (if they have),
                 * In other words, it goes layer by layer adding all the nodes to the queue until it found the last node
                 * where there is no left or right child. Note: If the value is already in the tree, doesn't add it and just returns.
                 */
                BinaryTree.BinNode node = queue.poll();
                if(node.getValue() == value) return;
                if(node.getLeftChild() == null) {
                    node.setLeftChild(value);
                    return;
                }
                else if(node.getRightChild() == null) {
                    node.setRightChild(value);
                    return;
                }
                else {
                    queue.add(node.getLeftChild());
                    queue.add(node.getRightChild());
                }
            }
        }
    }
}

/**
 * Implements BinarySearchTree.
 */
class BinarySearchTree {
    /**
     * Implements a node of the Binary Search Tree.
     */
    private static class BinNode {
        /*
         * ----------------------------------------------------------------
         *                            Attributes
         * ----------------------------------------------------------------
         */

        /**
         * Value of the node.
         */
        private final int value;

        /**
         * Left child node of the node.
         */
        private BinNode leftChild;

        /**
         * Right child node of the node.
         */
        private BinNode rightChild;


        /*
         * ----------------------------------------------------------------
         *                            Constructor
         * ----------------------------------------------------------------
         */

        /**
         * Creates a new Binary node.
         * @param value Value of the new node.
         */
        public BinNode(int value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }


        /*
         * ----------------------------------------------------------------
         *                      Get Attributes of node
         * ----------------------------------------------------------------
         */

        /**
         * Gets the value of the current node.
         * @return Value of the current node.
         */
        public int getValue() { return this.value; }

        /**
         * Gets the left child node of the current node.
         * @return Left child node of the current node.
         */
        public BinNode getLeftChild() { return this.leftChild; }

        /**
         * Gets the right child node of the current node.
         * @return right child node of the current node.
         */
        public BinNode getRightChild() { return this.rightChild; }


        /*
         * ----------------------------------------------------------------
         *                    Set new Attributes to node
         * ----------------------------------------------------------------
         */

        /**
         * Sets a new left child node of the current node with a given new left child node.
         * @param leftChild New left child node.
         */
        public void setLeftChild(BinNode leftChild) { this.leftChild = leftChild; }

        /**
         * Sets a new right child node of the current node with a given new right child node.
         * @param rightChild New right child node.
         */
        public void setRightChild(BinNode rightChild) { this.rightChild = rightChild; }
    }

    /*
     * ----------------------------------------------------------------
     *                            Attributes
     * ----------------------------------------------------------------
     */

    /**
     * Node correspondent to the root of the tree.
     */
    private BinNode root;


    /*
     * ----------------------------------------------------------------
     *                            Constructor
     * ----------------------------------------------------------------
     */

    /**
     * Creates a new binary search tree.
     */
    public BinarySearchTree() {
        this.root = null;
    }


    /*
     * ----------------------------------------------------------------
     *                           Print Methods
     * ----------------------------------------------------------------
     */

    /**
     * Prints the tree layer by layer.
     */
    public void printTree() {
        /* If the tree doesn't have a root yet don't print anything */
        if (root == null) return;

        /* Otherwise, start a queue to help with the print system and adds the root to it (the first layer) */
        Queue<BinNode> queue = new LinkedList<>();
        queue.add(root);

        /* Keeps printing until there are no more nodes in the queue */
        while (!queue.isEmpty()) {
            /* Number of nodes that are in queue now */
            int levelSize = queue.size();
            /*
             * Prints all the nodes in queue by order and for each one, adds (in order) their left and right child
             * so the next time in while loop all the children going to be printed;
             * in other words, this loop prints one layer at a time
             */
            for (int i = 0; i < levelSize; i++) {
                /* Pulls the first node of the queue (also, removing it from queue) and prints it */
                BinNode node = queue.poll();
                assert node != null;
                System.out.print(node.getValue() + " ");

                /* Adds the children of the current node to the queue, first the left, than the right if they exist */
                if (node.getLeftChild() != null) queue.add(node.getLeftChild());
                if (node.getRightChild() != null) queue.add(node.getRightChild());
            }

            /* Prints a line to separate layers */
            System.out.println();
        }
    }


    /*
     * ----------------------------------------------------------------
     *                   Tree manipulation methods
     * ----------------------------------------------------------------
     */

    /**
     * Adds a new node to the tree. If the value already exists, does nothing to the tree.
     * @param value Value of the new node.
     */
    public void add(int value) {
        /* If the tree doesn't have a root yet, creates a new node attaches it to root and return */
        if(this.root == null) {
            this.root = new BinNode(value);
            return;
        }

        /* Otherwise, start in root and search for the tree were to create the new node if it already exists in the tree return */
        BinNode node = this.root;
        while(true) {
            /* Left case where the value is smaller than the current node */
            if(value < node.getValue()) {
                /* If the node doesn't have a left child yet, creates a new one and return */
                if(node.getLeftChild() == null) {
                    node.setLeftChild(new BinNode(value));
                    return;
                }
                /* Otherwise continues to the left and repeat the process */
                else node = node.getLeftChild();
            }
            /* Right case where the value is bigger than the current node */
            else if(value > node.getValue()) {
                /* If the node doesn't have a right child yet, creates a new one and return */
                if(node.getRightChild() == null) {
                    node.setRightChild(new BinNode(value));
                    return;
                }
                /* Otherwise continues to the right and repeat the process */
                else node = node.getRightChild();
            }
            /* If the value is equal return and do nothing */
            else return;
        }
    }


    /*
     * ---------------------------------------------------------------------------------------------------------------
     * Tree manipulation methods recursively (doesn't work for high trees because consecutive call to the same method)
     * ---------------------------------------------------------------------------------------------------------------
     */

    /**
     * Adds a new node to the tree. If the value already exists, does nothing to the tree.
     * @param value Value of the new node.
     */
    public void addR(int value) { this.root = addRec(this.root, value); }

    /**
     * Adds a new node to the tree recursively. If the value already exists, does nothing to the tree.
     * @param node Node to evaluate and continue recursively.
     * @param value Value of the new node.
     */
    private BinNode addRec(BinNode node, int value) {
        /* In case node doesn't exist, creates and returns a new one */
        if(node == null) return new BinNode(value);

        /* Going recursively through the tree according to the values (bigger right, smaller left) */
        if(value < node.getValue()) node.setLeftChild(addRec(node.getLeftChild(), value));
        else if(value > node.getValue()) node.setRightChild(addRec(node.getRightChild(), value));


        /* If the value neither bigger nor smaller than the current node value, it is equal, in this case we don't add to the tree nothing */
        return node;
    }
}

/**
 * Implements AVL Tree.
 */
class AVLTree {
    /**
     * Implements a node of an AVL Tree.
     */
    private static class AVLNode {
        /*
         * ----------------------------------------------------------------
         *                            Attributes
         * ----------------------------------------------------------------
         */

        /**
         * Value of the node.
         */
        private final int value;

        /**
         * Height of the node.
         */
        private int height;

        /**
         * Left child node of the node.
         */
        private AVLNode leftChild;

        /**
         * Right child node of the node.
         */
        private AVLNode rightChild;


        /*
         * ----------------------------------------------------------------
         *                            Constructor
         * ----------------------------------------------------------------
         */

        /**
         * Creates a new AVL node.
         * @param value Value of the new node.
         */
        public AVLNode(int value) {
            this.value = value;
            this.height = 1;
            this.leftChild = null;
            this.rightChild = null;
        }


        /*
         * ----------------------------------------------------------------
         *                      Get Attributes of node
         * ----------------------------------------------------------------
         */

        /**
         * Gets the value of the current node.
         * @return Value of the current node.
         */
        public int getValue() { return this.value; }

        /**
         * Gets the height of the node.
         * @return The height of the node.
         */
        public int getHeight() { return this.height; }

        /**
         * Gets the left child node of the current node.
         * @return Left child node of the current node.
         */
        public AVLNode getLeftChild() { return this.leftChild; }

        /**
         * Gets the right child node of the current node.
         * @return right child node of the current node.
         */
        public AVLNode getRightChild() { return this.rightChild; }


        /*
         * ----------------------------------------------------------------
         *                    Set new Attributes to node
         * ----------------------------------------------------------------
         */

        /**
         * Sets the height value of the current node to a new given height value.
         * @param height New height value of the node.
         */
        public void setHeight(int height) { this.height = height; }

        /**
         * Sets a new left child node of the current node with the given new node.
         * @param newNode New left child node.
         */
        public void setLeftChild(AVLNode newNode) { this.leftChild = newNode; }

        /**
         * Sets a new right child node of the current node with the given new node.
         * @param newNode New right child node.
         */
        public void setRightChild(AVLNode newNode) { this.rightChild = newNode; }
    }

    /*
     * ----------------------------------------------------------------
     *                            Attributes
     * ----------------------------------------------------------------
     */

    /**
     * Node correspondent to the root of the tree.
     */
    private AVLNode root;

    /**
     * Counter of simple rotations performed.
     */
    private int rotCount;


    /*
     * ----------------------------------------------------------------
     *                            Constructor
     * ----------------------------------------------------------------
     */

    /**
     * Creates a new AVL tree.
     */
    public AVLTree() {
        this.root = null;
        this.rotCount = 0;
    }


    /*
     * ----------------------------------------------------------------
     *                           Print Methods
     * ----------------------------------------------------------------
     */

    /**
     * Prints the tree layer by layer.
     */
    public void printTree() {
        /* If the tree doesn't have a root yet don't print anything */
        if (root == null) return;

        /* Otherwise, start a queue to help with the print system and adds the root to it (the first layer) */
        Queue<AVLTree.AVLNode> queue = new LinkedList<>();
        queue.add(root);

        /* Keeps printing until there are no more nodes in the queue */
        while (!queue.isEmpty()) {
            /* Number of nodes that are in queue now */
            int levelSize = queue.size();
            /*
             * Prints all the nodes in queue by order and for each one, adds (in order) their left and right child
             * so the next time in while loop all the children going to be printed;
             * in other words, this loop prints one layer at a time
             */
            for (int i = 0; i < levelSize; i++) {
                /* Pulls the first node of the queue (also, removing it from queue) and prints it */
                AVLTree.AVLNode node = queue.poll();
                assert node != null;
                System.out.print(node.getValue() + " ");

                /* Adds the children of the current node to the queue, first the left, than the right if they exist */
                if (node.getLeftChild() != null) queue.add(node.getLeftChild());
                if (node.getRightChild() != null) queue.add(node.getRightChild());
            }

            /* Prints a line to separate layers */
            System.out.println();
        }
    }


    /*
     * ----------------------------------------------------------------
     *                   Tree manipulation methods
     * ----------------------------------------------------------------
     */

    /**
     * Adds a new node to the tree just giving the value.
     * @param value Value of the new node.
     */
    public void add(int value) { this.root = addRec(this.root, value); }

    /**
     * Adds a new node to the tree recursively. If the value already exists, does nothing to the tree.
     * @param node Node to start.
     * @param value Value of the new node.
     */
    private AVLNode addRec(AVLNode node, int value) {
        /* If the node doesn't exist yet */
        if(node == null) return new AVLNode(value);

        /*
         * If the value is lesser than the current node value, goes to left, if greater right
         * and if equal just return because there no duplicated values allowed
         */
        if(value < node.getValue()) node.setLeftChild(addRec(node.getLeftChild(), value));
        else if(value > node.getValue()) node.setRightChild(addRec(node.getRightChild(), value));
        else return node;

        /* Actualization of the node height (+1 for the actual node and + the max height of the 2 subtrees) */
        node.setHeight(1 + max(height(node.getLeftChild()), height(node.getRightChild())));

        /* Getting the equilibrium factor of the node */
        int ef = getEF(node);

        /* If the tree isn't balanced */
        if(ef < -1 || ef > 1) {
            /* Case Left-Left: Right rotation */
            if (ef > 1 && value < node.getLeftChild().getValue()) return rightRot(node);
            /* Case Right-Right: Left rotation */
            else if (ef < -1 && value > node.getRightChild().getValue()) return leftRot(node);
            /* Case Left-Right: Right-Left rotation */
            else if (ef > 1 && value > node.getLeftChild().getValue()) {
                /* First performs a left rotation to the left child to make possible to perform a right rotation to the current node */
                node.setLeftChild(leftRot(node.getLeftChild()));
                return rightRot(node);
            }
            /* Case Right-Left: Left-Right rotation */
            else {
                /* First performs a right rotation to the right child to make possible to perform a left rotation to the current node */
                node.setRightChild(rightRot(node.getRightChild()));
                return leftRot(node);
            }
        }

        /* Returning the node balanced */
        return node;
    }

    /**
     * Calculates the Equilibrium Factor of a node.
     * @param node Node to calculate the equilibrium factor.
     * @return Equilibrium Factor of the node.
     */
    private int getEF(AVLNode node) {
        if(node == null) return 0;
        return height(node.getLeftChild()) - height(node.getRightChild());
    }

    /**
     * Gets the height of the given node in the tree.
     * @return height of the node.
     */
    private int height(AVLNode node) {
        if (node == null) return 0;
        return node.getHeight();
    }

    /**
     * Performs a left rotation.
     * @param node Node to start the rotation.
     * @return New node that replaces the old one after the rotation.
     */
    private AVLNode leftRot(AVLNode node) {
        /* Initializing news right child and right-left child */
        AVLNode newNode = node.getRightChild();
        AVLNode rightLeftNode = newNode.getLeftChild();

        /* Rotating the nodes */
        newNode.setLeftChild(node);
        node.setRightChild(rightLeftNode);

        /* Actualization of the nodes heights */
        node.setHeight(max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
        newNode.setHeight(max(height(newNode.getLeftChild()), height(newNode.getRightChild())) + 1);

        /* Incrementing number of rotations */
        this.rotCount++;

        /* Returning the new root node */
        return newNode;
    }

    /**
     * Performs a right rotation.
     * @param node Node to start the rotation.
     * @return New node that replaces the old one after the rotation.
     */
    private AVLNode rightRot(AVLNode node) {
        /* Initializing news left child and left-right child */
        AVLNode newNode = node.getLeftChild();
        AVLNode leftRightNode = newNode.getRightChild();

        /* Rotating the nodes */
        newNode.setRightChild(node);
        node.setLeftChild(leftRightNode);

        /* Actualization of the nodes heights */
        node.setHeight(max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
        newNode.setHeight(max(height(newNode.getLeftChild()), height(newNode.getRightChild())) + 1);

        /* Incrementing number of rotations */
        this.rotCount++;

        /* Returning the new root node */
        return newNode;
    }


    /*
     * ----------------------------------------------------------------
     *                    Get Attributes of the tree
     * ----------------------------------------------------------------
     */

    /**
     * Gets the number of performed rotations so far.
     * @return Number of rotations performed so far.
     */
    public int getRotCount() { return this.rotCount; }
}

/**
 * Implements RB Tree.
 */
class RBTree {
    /**
     * Implements a node of an RB tree.
     */
    private static class RBNode {
        /*
         * ----------------------------------------------------------------
         *                            Attributes
         * ----------------------------------------------------------------
         */

        /**
         * Value of the node.
         */
        private final int value;

        /**
         * True if is a red node, false if black
         */
        private boolean red;

        /**
         * Left child node of the node.
         */
        private RBNode leftChild;

        /**
         * Right child node of the node.
         */
        private RBNode rightChild;

        /**
         * Parent node of the node.
         */
        private RBNode parent;


        /*
         * ----------------------------------------------------------------
         *                            Constructor
         * ----------------------------------------------------------------
         */

        /**
         * Creates a new RB node. By default, start as red.
         * @param value Value of the new node.
         */
        public RBNode(int value) {
            this.value = value;
            this.red = true;
            this.leftChild = null;
            this.rightChild = null;
            this.parent = null;
        }


        /*
         * ----------------------------------------------------------------
         *                      Get Attributes of node
         * ----------------------------------------------------------------
         */

        /**
         * Gets the value of the current node.
         * @return Value of the current node.
         */
        public int getValue() { return this.value; }

        /**
         * Gets the left child node of the current node.
         * @return Left child node of the current node.
         */
        public RBNode getLeftChild() { return this.leftChild; }

        /**
         * Gets the right child node of the current node.
         * @return Right child node of the current node.
         */
        public RBNode getRightChild() { return this.rightChild; }

        /**
         * Gets the parent node of the current node.
         * @return Parent node of the current node.
         */
        public RBNode getParent() { return this.parent; }

        /**
         * Gets information about the color of the node.
         * @return true means the color is red; false means the color is black.
         */
        public boolean isRed() { return this.red; }


        /*
         * ----------------------------------------------------------------
         *                    Set new Attributes to node
         * ----------------------------------------------------------------
         */

        /**
         * Sets a new left child node of the current node with the given new node.
         * @param newNode New left child node.
         */
        public void setLeftChild(RBNode newNode) { this.leftChild = newNode; }

        /**
         * Sets a new right child node of the current node with the given new node.
         * @param newNode New right child node.
         */
        public void setRightChild(RBNode newNode) { this.rightChild = newNode; }

        /**
         * Sets a new parent node of the current node with the given new node.
         * @param parent New parent node.
         */
        public void setParent(RBNode parent) { this.parent = parent; }

        /**
         * Sets the color of the node to red if true and black if false.
         * @param red The node turns red if true and black if false.
         */
        public void setRed(boolean red) { this.red = red; }
    }


    /*
     * ----------------------------------------------------------------
     *                            Attributes
     * ----------------------------------------------------------------
     */

    /**
     * Node correspondent to the root of the tree.
     */
    private RBNode root;

    /**
     * Node corresponding to the leafs of the tree (nodes that don't exist yet).
     */
    private final RBNode nil;

    /**
     * Counter of simple rotations performed.
     */
    private int rotCount;


    /*
     * ----------------------------------------------------------------
     *                            Constructor
     * ----------------------------------------------------------------
     */

    /**
     * Creates a new RED-BLACK tree.
     */
    public RBTree() {
        nil = new RBNode(-1);
        nil.setRed(false);
        this.root = nil;
        this.rotCount = 0;
    }


    /*
     * ----------------------------------------------------------------
     *                           Print Methods
     * ----------------------------------------------------------------
     */

    /**
     * Prints the tree layer by layer.
     */
    public void printTree() {
        /* If the tree doesn't have a root yet don't print anything */
        if (root == nil) return;

        /* Otherwise, start a queue to help with the print system and adds the root to it (the first layer) */
        Queue<RBNode> queue = new LinkedList<>();
        queue.add(root);

        /* Keeps printing until there are no more nodes in the queue */
        while (!queue.isEmpty()) {
            /* Number of nodes that are in queue now */
            int levelSize = queue.size();
            /*
             * Prints all the nodes in queue by order and for each one, adds (in order) their left and right child
             * so the next time in while loop all the children going to be printed;
             * in other words, this loop prints one layer at a time
             */
            for (int i = 0; i < levelSize; i++) {
                /* Pulls the first node of the queue (also, removing it from queue) and prints it */
                RBNode node = queue.poll();
                assert node != null;
                System.out.print(node.getValue() + "(" + (node.isRed() ? "R" : "B") + ")" + " ");

                /* Adds the children of the current node to the queue, first the left, than the right if they exist */
                if (node.getLeftChild() != nil) queue.add(node.getLeftChild());
                if (node.getRightChild() != nil) queue.add(node.getRightChild());
            }

            /* Prints a line to separate layers */
            System.out.println();
        }
    }


    /*
     * ----------------------------------------------------------------
     *                   Tree manipulation methods
     * ----------------------------------------------------------------
     */

    /**
     * Adds a new node to the tree just giving the value.
     * @param value Value of the new node.
     */
    public void add(int value) {
        /*
         * Starts the nodes we will need to reach the leaf were we're going to insert.
         * parentNode is the parent of the node where we're going to insert the new node.
         * node is a pointer used to go through the tree until we reach a leaf node (nil).
         */
        RBNode parentNode = this.nil;
        RBNode node = root;

        /* Goes through the tree starting in the root until reaches one leaf (nil), or return if the value is already in the tree */
        while(node != nil) {
            /* Actualizes the node reference to the parent node */
            parentNode = node;

            /* Tests where to continue, left if value is smaller than the parent, right if bigger (equals return) */
            if(value < node.getValue()) node = node.getLeftChild();
            else if(value > node.getValue()) node = node.getRightChild();
            else return;
        }

        /* Starts the node we're going to insert adding the parent pointer to it */
        RBNode newNode = new RBNode(value);
        newNode.setParent(parentNode);

        /* Now fix the parent pointers to the new node */
        /* If the parentNode is a nil node, it means the node to insert is the root */
        if(parentNode == nil) this.root = newNode;
        /* Otherwise, see if the new node has a value smaller (goes to left child) or bigger (goes to right child) */
        else if(value < parentNode.value) parentNode.setLeftChild(newNode);
        else parentNode.setRightChild(newNode);

        /* Set the initial properties of the new node */
        newNode.setLeftChild(nil);
        newNode.setRightChild(nil);
        newNode.setRed(true);

        /* Verifies the tree from the new node added, correcting all the possible violations of the tree properties */
        verifyTree(newNode);
    }

    /**
     * Checks if the new added node did not make the tree properties became violated.
     * @param node New just added node.
     */
    private void verifyTree(RBNode node) {
        while(node.getParent().isRed()) {
            /*
             * If the parent node is the left child of the grandparent, verifies the uncle (right child of grandparent).
             * If uncle is red, turns parent and uncle black and grandparent comes red (recolor case).
             * Otherwise,
             *     if the node is the right node of its parent, do a left rotation with its parent node,
             *     change the color of the parent to black and grandparent to red and do a right rotation.
             *     otherwise, change the color of the parent to black and grandparent to red and do a right rotation.
             */
            if(node.getParent() == node.getParent().getParent().getLeftChild()) {
                RBNode uncle = node.getParent().getParent().getRightChild();

                /* If uncle is red */
                if(uncle.isRed()) {
                    recolor(node, uncle);

                    /* Next node to evaluate properties in the tree */
                    node = node.getParent().getParent();
                }
                /* Otherwise, we have to do rotations (left-right or just right) */
                else {
                    /* If the node is the right child of its parent, do a left rotation to the parent */
                    if(node == node.getParent().getRightChild()) {
                        node = node.getParent();
                        leftRot(node);
                    }

                    /* Set the color of the parent to black and grandparent to red and do a right rotation to the grandparent */
                    node.getParent().setRed(false);
                    node.getParent().getParent().setRed(true);
                    rightRot(node.getParent().getParent());
                }
            }
            /*
             * Otherwise, the node is the right child of the grandparent, so verifies the uncle (left child of the grandparent).
             * If uncle is red, turns parent and uncle black and grandparent comes red (recolor case).
             * Otherwise,
             *     if the node is the left node of its parent, do a right rotation with its parent node,
             *     change the color of the parent to black and grandparent to red and do a left rotation.
             *     otherwise, change the color of the parent to black and grandparent to red and do a left rotation.
             */
            else {
                RBNode uncle = node.getParent().getParent().getLeftChild();

                /* If uncle is red */
                if(uncle.isRed()) {
                    recolor(node, uncle);

                    /* Next node to evaluate properties in the tree */
                    node = node.getParent().getParent();
                }
                /* Otherwise, we have to do rotations (right-left or just left) */
                else {
                    /* If the node is the left child of its parent, do a right rotation to the parent */
                    if(node == node.getParent().getLeftChild()) {
                        node = node.getParent();
                        rightRot(node);
                    }

                    /* Set the color of the parent to black and grandparent to red and do a left rotation to the grandparent */
                    node.getParent().setRed(false);
                    node.getParent().getParent().setRed(true);
                    leftRot(node.getParent().getParent());
                }
            }
        }

        /* Forces the root to be black */
        this.root.setRed(false);
    }

    /**
     * Recolors the parent node and uncle to black and grandparent to red.
     * @param node Current node.
     * @param uncle Uncle of the current node.
     */
    private void recolor(RBNode node, RBNode uncle) {
        node.getParent().setRed(false);
        uncle.setRed(false);
        node.getParent().getParent().setRed(true);
    }

    /**
     * Performs a left rotation.
     * @param node Node to start the rotation.
     */
    private void leftRot(RBNode node) {
        /* Get a pointer to the right child of the node */
        RBNode rightNode = node.getRightChild();

        /*
         * Set the right child of the node, to the right-left child of the node.
         * If that child isn't a nil node, set the child parent pointer to the node.
         */
        node.setRightChild(rightNode.getLeftChild());
        if(rightNode.getLeftChild() != nil) rightNode.getLeftChild().setParent(node);

        /*
         * Make the older right child changes parents to the grandparent.
         * If that node is a nil node, then it means we reach the root and now the root is the older right child.
         * Otherwise, if the node is the left child of its parent, change the parent left child to the older right child of the current node.
         * Otherwise, it means the node was the parents right child so changes the parent right child to the older right child of the current node.
         */
        rightNode.setParent(node.getParent());
        if(node.getParent() == nil) this.root = rightNode;
        else if(node == node.getParent().getLeftChild()) node.getParent().setLeftChild(rightNode);
        else node.getParent().setRightChild(rightNode);

        /* Finally, ends the swapping making the left child of the older right node be the node and the parent of the node, the older right child */
        rightNode.setLeftChild(node);
        node.setParent(rightNode);

        /* Increment number of rotations */
        this.rotCount++;
    }

    /**
     * Performs a right rotation.
     * @param node Node to start the rotation.
     */
    private void rightRot(RBNode node) {
        /* Get a pointer to the left child of the node */
        RBNode leftNode = node.getLeftChild();

        /*
         * Set the left child of the node, to the left-right child of the node.
         * If that child isn't a nil node, set the child parent pointer to the node.
         */
        node.setLeftChild(leftNode.getRightChild());
        if(leftNode.getRightChild() != nil) leftNode.getRightChild().setParent(node);

        /*
         * Make the older left child changes parents to the grandparent.
         * If that node is a nil node, then it means we reach the root and now the root is the older left child.
         * Otherwise, if the node is the left child of its parent, change the parent left child to the older left child of the current node.
         * Otherwise, it means the node was the parents right child so changes the parent right child to the older left child of the current node.
         */
        leftNode.setParent(node.getParent());
        if(node.getParent() == nil) this.root = leftNode;
        else if(node == node.getParent().getLeftChild()) node.getParent().setLeftChild(leftNode);
        else node.getParent().setRightChild(leftNode);

        /* Finally, ends the swapping making the right child of the older left node be the node and the parent of the node, the older left child */
        leftNode.setRightChild(node);
        node.setParent(leftNode);

        /* Increment number of rotations */
        this.rotCount++;
    }


    /*
     * ----------------------------------------------------------------
     *                    Get Attributes of the tree
     * ----------------------------------------------------------------
     */

    /**
     * Gets the number of performed rotations so far.
     * @return Number of rotations performed so far.
     */
    public int getRotCount() { return this.rotCount; }
}
