
import java.util.Random;
import static java.lang.System.currentTimeMillis;

public class Projeto3AED {
    public static void main(String[] args) {
        /* Code to run the test without print the tree, just the results of big key insertions in all trees */
        testBigArrays();

        /* This is the code to test and see every tree with just 20 samples */
        //testLowArrays();
    }

    /**
     * Tests everything implemented with a larger number of keys and no print of the final arrays just the times.
     */
    private static void testBigArrays() {
        /* ---> Keys Creation <--- */
        int NUM_KEYS = 10000000;                         // number of keys

        int[] keysA = generateKeysA(NUM_KEYS);
        int[] keysA2 = keysA.clone();
        int[] keysA3 = keysA.clone();
        int[] keysB = generateKeysB(NUM_KEYS);
        int[] keysB2 = keysB.clone();
        int[] keysB3 = keysB.clone();
        int[] keysC = generateKeysC(NUM_KEYS);
        int[] keysC2 = keysC.clone();
        int[] keysC3 = keysC.clone();

        char[] letters = {'A', 'B', 'C'};

        /* ---> Testing all the keys in the different trees <--- */
        int[][] KEYS = {keysA};//, keysB, keysC};
        int[][] KEYS2 = {keysA2, keysB2, keysC2};
        int[][] KEYS3 = {keysA3, keysB3, keysC3};
        testInsertionSort(KEYS, letters, false);
        //testHeapSort(KEYS2, letters, false);
        //testQuickSort(KEYS3, letters, false, -1);
    }

    /**
     * Tests everything implemented with a smaller number of keys and prints the final array and times.
     */
    private static void testLowArrays() {
        /* ---> Keys Creation <--- */
        int[] keysA = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] keysA2 = keysA.clone();
        int[] keysA3 = keysA.clone();
        int[] keysB = {20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] keysB2 = keysB.clone();
        int[] keysB3 = keysB.clone();
        int[] keysC = {3, 14, 18, 6, 12, 10, 15, 2, 16, 8, 9, 19, 1, 20, 4, 17, 11, 13, 7, 5};
        int[] keysC2 = keysC.clone();
        int[] keysC3 = keysC.clone();

        char[] letters = {'A', 'B', 'C'};

        /* ---> Testing all the keys in the different trees <--- */
        int[][] KEYS = {keysA, keysB, keysC};
        int[][] KEYS2 = {keysA2, keysB2, keysC2};
        int[][] KEYS3 = {keysA3, keysB3, keysC3};
        testInsertionSort(KEYS, letters, true);
        testHeapSort(KEYS2, letters, true);
        testQuickSort(KEYS3, letters, true, 0);
    }

    /**
     * Generates the keys to the group A.
     * @param numKeys Number of keys to generate.
     * @return Array with the generated keys
     */
    private static int[] generateKeysA(int numKeys) {
        int[] keys = new int[numKeys];

        /* Creates the array with ascending integers that are not repetitions */
        for(int i = 0; i < numKeys; i++) keys[i] = i;

        return keys;
    }

    /**
     * Generates the keys to the group B.
     * @param numKeys Number of keys to generate.
     * @return Array with the generated keys
     */
    private static int[] generateKeysB(int numKeys) {
        int[] keys = new int[numKeys];

        /* Creates the array with descending integers that are not repetitions */
        for(int i = 0; i < numKeys; i++) keys[i] = numKeys - i;

        return keys;
    }

    /**
     * Generates the keys to the group C.
     * @param numKeys Number of keys to generate.
     * @return Array with the generated keys
     */
    private static int[] generateKeysC(int numKeys) {
        int[] keys = new int[numKeys];

        /* Creates the array with ascending integers that are not repetitions */
        for(int i = 0; i < numKeys; i++) keys[i] = i;

        /* Shuffling the array of keys to put it to a random order */
        shuffleArray(keys);

        return keys;
    }

    /**
     * Shuffles an array.
     * @param keys Array to shuffle.
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


    /*
     * ----------------------------------------------------------------
     *                   Test Sort Algorithms Methods
     * ----------------------------------------------------------------
     */

    /**
     * Tests the Insertion Sort Algorithm.
     * @param keys Array with all the arrays of keys to test.
     * @param letters Array with the characters to identify each array in keys.
     * @param printMode Decides whether to print or not, true prints the tree, false, don't print.
     */
    private static void testInsertionSort(int[][] keys, char[] letters, boolean printMode) {
        System.out.println("--------- TESTING INSERTION SORT TIMES ---------");

        /* Initializations */
        long time;

        /* Performing the test across all the different key arrays */
        for(int i = 0; i < keys.length; i++) {
            if(printMode) {
                System.out.printf("Not Sorted KEYS %s: ", letters[i]);
                printArray(keys[i]);
            }
            time = currentTimeMillis();
            InsertionSort(keys[i]);
            System.out.printf("Sorting KEYS %s time: %d ms\n", letters[i], currentTimeMillis() - time);
            if(printMode) {
                System.out.printf("Sorted KEYS %s: ", letters[i]);
                printArray(keys[i]);
                System.out.println();
            }
        }
    }


    /**
     * Tests the Heap Sort Algorithm.
     * @param keys Array with all the arrays of keys to test.
     * @param letters Array with the characters to identify each array in keys.
     * @param printMode Decides whether to print or not, true prints the tree, false, don't print.
     */
    private static void testHeapSort(int[][] keys, char[] letters, boolean printMode) {
        System.out.println("--------- TESTING HEAP SORT TIMES ---------");

        /* Initializations */
        long time;
        HeapSort heapSort = new HeapSort();

        /* Performing the test across all the different key arrays */
        for(int i = 0; i < keys.length; i++) {
            if(printMode) {
                System.out.printf("Not Sorted KEYS %s: ", letters[i]);
                printArray(keys[i]);
            }
            time = currentTimeMillis();
            heapSort.sort(keys[i]);
            System.out.printf("Sorting KEYS %s time: %d ms\n", letters[i], currentTimeMillis() - time);
            if(printMode) {
                System.out.printf("Sorted KEYS %s: ", letters[i]);
                printArray(keys[i]);
                System.out.println();
            }
        }
    }

    /**
     * Tests the Quick Sort Algorithm.
     * @param keys Array with all the arrays of keys to test.
     * @param letters Array with the characters to identify each array in keys.
     * @param printMode Decides whether to print or not, true prints the tree, false, don't print.
     * @param minElements Minimum number of elements to perform insertion sort. If < 0, do default.
     */
    private static void testQuickSort(int[][] keys, char[] letters, boolean printMode, int minElements) {
        System.out.println("--------- TESTING QUICK SORT TIMES ---------");

        /* Initializations */
        long time;
        QuickSort quickSort;
        if(minElements >= 0) quickSort = new QuickSort(minElements);
        else quickSort = new QuickSort();

        /* Performing the test across all the different key arrays */
        for(int i = 0; i < keys.length; i++) {
            if(printMode) {
                System.out.printf("Not Sorted KEYS %s: ", letters[i]);
                printArray(keys[i]);
            }
            time = currentTimeMillis();
            quickSort.sort(keys[i]);
            System.out.printf("Sorting KEYS %s time: %d ms\n", letters[i], currentTimeMillis() - time);
            if(printMode) {
                System.out.printf("Sorted KEYS %s: ", letters[i]);
                printArray(keys[i]);
                System.out.println();
            }
        }
    }


    /*
     * ----------------------------------------------------------------
     *                         Sort Algorithms
     * ----------------------------------------------------------------
     */

    /**
     * Implements the insertion sort algorithm.
     * @param keys Array to sort.
     */
    private static void InsertionSort(int[] keys) {
        /* Going through the second to last element in array between low and high indexes. */
        for(int i = 1; i < keys.length; i++) {
            /* Saving the current element */
            int element = keys[i];
            int j = i - 1;

            /* Pushing the left elements greater than the current element to the right */
            while(j >= 0 && keys[j] > element) {
                keys[j + 1] = keys[j];
                j--;
            }
            /* Replacing the current element in the correct position */
            keys[j + 1] = element;
        }
    }

    /**
     * Implements the heap sort algorithm.
     */
    private static class HeapSort {
        /**
         * Sorts an array using the heap sort algorithm.
         * @param keys array to sort.
         */
        public void sort(int[] keys) {
            /* Building max heap tree */
            /* Note: keys.length/2 - 1 is the last node in the tree that have children */
            for(int i = ((keys.length/2)-1); i >= 0; i--) heapify(keys, keys.length, i);

            /* Sorting the array */
            for(int i = keys.length - 1; i > 0; i--) {
                /* Swaps the first element to the end of the unsorted part of the array */
                swap(keys, 0, i);

                /* Reorganize the max heap tree */
                heapify(keys, i, 0);
            }
        }

        /**
         * Heapifies a heap tree recursively.
         * @param keys Heap tree array.
         * @param length Length of the heap tree array.
         * @param i The index of the node to verify the heap tree properties and change if needed.
         */
        private void heapify(int[] keys, int length, int i) {
            /* Initializations */
            int biggest = i;
            int left = (2*i) + 1;  // left child of node i
            int right = (2*i) + 2; // right child of node i

            /* Verification of the biggest node in the trio, root and children */
            if(left < length && keys[left] > keys[biggest]) biggest = left;
            if(right < length && keys[right] > keys[biggest]) biggest = right;

            /* If the biggest isn't the root of the subtree */
            if(biggest != i) {
                /* Swaps the root and the biggest to let it right */
                swap(keys, i, biggest);

                /* Recursively heapifies the affected subtree */
                heapify(keys, length, biggest);
            }
        }
    }

    /**
     * Implements the quick sort algorithm.
     */
    private static class QuickSort {
        /**
         * Minimum number of elements to perform insertion sort.
         */
        private int MIN_ELEMENTS = 30;


        /**
         * Default Quicksort algorithm constructor (MIN_ELEMENTS = 30).
         */
        public QuickSort() {}

        /**
         * Quicksort algorithm constructor.
         * @param MIN_ELEMENTS Minimum number of elements to perform insertion sort.
         */
        public QuickSort(int MIN_ELEMENTS) { this.MIN_ELEMENTS = MIN_ELEMENTS; }


        /**
         * Sorts an array with quick sort algorithm.
         * @param keys Array to sort.
         */
        public void sort(int[] keys) { sortRec(keys, 0, keys.length - 1); }

        /**
         * Sorts recursively a part of an array with quick sort algorithm.
         * @param keys Array to sort.
         * @param low Lower index of the array to consider.
         * @param high Higher index of the array to consider.
         */
        private void sortRec(int[] keys, int low, int high) {
            if (low < high) {
                /* If the partition array has few elements (minus then MIN_ELEMENTS) applies insertion sort */
                if (high - low + 1 <= MIN_ELEMENTS) insertSort(keys, low, high);
                /* Otherwise, continue quick sorting partition method */
                else {
                    /* Choosing pivot index */
                    int pivotIndex = getPivotIndex(keys, low, high);

                    /* Puts the pivot at the end of the array partition */
                    swap(keys, pivotIndex, high);

                    /* Sorting array according to pivot and actualization of pivot index */
                    pivotIndex = partition(keys, low, high);

                    /* Recursive sort of left and right array */
                    sortRec(keys, low, pivotIndex - 1);
                    sortRec(keys, pivotIndex + 1, high);
                }
            }
        }

        /**
         * Sorts an array putting all elements lower than pivot to the left and higher to its right
         * and returns the new pivot index.
         * @param keys Array to sort.
         * @param low Lower index of the array to start considering to sort.
         * @param high Higher index of the array to end considering to sort.
         * @return The new pivot index.
         */
        private int partition(int[] keys, int low, int high) {
            int pivot = keys[high];

            /* Initialization of the left index pointer */
            int left = low - 1;

            /* Sorting the array, puts all the elements lower than pivot to left and higher to right of him */
            for(int i = low; i < high; i++) {
                if(keys[i] < pivot) {
                    left++;
                    swap(keys, left, i);
                }
            }

            /* Actualizing the left pointer to the first element higher than pivot */
            left++;

            /* Swap the first element higher than pivot with him */
            swap(keys, left, high);

            /* Return news pivot index */
            return left;
        }

        /**
         * Gets the pivot index from a median of 3 between first, middle
         * and last element of the array, sorting them before.
         * @param keys Array to search a pivot.
         * @param low Lower index of the array to consider.
         * @param high Higher index of the array to consider.
         * @return The pivot index.
         */
        private int getPivotIndex(int[] keys, int low, int high) {
            /* Middle element index of the partition in the array  */
            int mid = low + (high-low)/2;

            /* Sort the first, mid and last element in the partition of the array */
            if(keys[high] < keys[mid]) swap(keys, high, mid);
            if(keys[high] < keys[low]) swap(keys, high, low);
            if(keys[mid] < keys[low]) swap(keys, mid, low);

            /* Takes the middle element as pivot */
            return mid;
        }

        /**
         * Applies insertion sort in a part of an array.
         * @param keys Array to sort.
         * @param low Lower index of the array to consider.
         * @param high Higher index of the array to consider.
         */
        private void insertSort(int[] keys, int low, int high) {
            /* Going through the second to last element in array between low and high indexes. */
            for(int i = low + 1; i <= high; i++) {
                /* Saving the current element */
                int element = keys[i];
                int j = i - 1;

                /* Pushing the left elements greater than the current element to the right */
                while(j >= low && keys[j] > element) {
                    keys[j + 1] = keys[j];
                    j--;
                }
                /* Replacing the current element in the correct position */
                keys[j + 1] = element;
            }
        }
    }


    /*
     * ----------------------------------------------------------------
     *                          Help methods
     * ----------------------------------------------------------------
     */

    /**
     * Swaps two elements in an array.
     * @param keys Array of elements.
     * @param index1 Index of one of the elements to swap with 'index2'.
     * @param index2 Index of the other element to swap with 'index1'.
     */
    private static void swap(int[] keys, int index1, int index2) {
        int temp = keys[index1];
        keys[index1] = keys[index2];
        keys[index2] = temp;
    }

    /**
     * Prints all the elements in the array.
     * @param array Array of elements to print.
     */
    private static void printArray(int[] array) {
        for(int i: array) System.out.printf("%d ", i);
        System.out.println();
    }
}

