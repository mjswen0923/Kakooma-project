 import java.util.*;

public abstract class NumberSet {
    private int dimension;
    private int[] answers;
    private int[][] numbers;
    
    public NumberSet(int dimension) {
        this.dimension = dimension;
        answers = new int[dimension + 1];
        numbers = initiateNumbers(dimension);
    }
    
    //Initiate a set of integers with num elements, the answer answer,
    //and all integers in the set are greater or equal to minimum.
    public abstract int[] initiateSet(int num, int answer, int minimum);
    
    //Gives a valid set of numbers for Kakooma.
    public abstract int[][] initiateNumbers(int num);
    
    //Removes instances that can cause confusion in the availableList, and add them to the unavailableList.
    public abstract void removeInstances(int value, int[] list, ArrayList<Integer> availableList, ArrayList<Integer> unavailableList);
    
    //Shuffle a list.
    public static void shuffle(int[] list)  {
        
        final int length = list.length;
        
        for (int i = 0; i < length; i++)    {
            int j = (int)(Math.random() * length);
            
            int temp = list[j];
            list[j] = list[i];
            list[i] = temp;
        }
    }
    
    //Remove an element of the ArrayList and return its value, known its value.
    //If the value is not in the list, return -1.
    //Precondition: No integers in list have the same value and none of the elements are null.
    public static int removeElement(int value, ArrayList<Integer> list)  {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            // Value is in list.get(low)..list.get(high) or not present.
            int mid = low + (high - low) / 2;
            if (value < list.get(mid)) high = mid - 1;
            else if (value > list.get(mid)) low = mid + 1;
            else return list.remove(mid);
        }
        return -1;
    }
    
    public int[][] getNumbers()   {
        return numbers;
    }
    
    public void setAnswer(int index, int value) {
        answers[index] = value;
    }
    
    public int[] getAnswers()   {
        return answers;
    }
    
    //Print elements of an ArrayList.
    public static void printElements(ArrayList<Integer> list)   {
        for (int i : list)
            System.out.print(i + " ");
        System.out.println();
    }
}
