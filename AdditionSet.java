 
import java.util.*;

public class AdditionSet extends NumberSet {

    public AdditionSet(int dimension) {
        super(dimension);
    }
    
    //Precondition: answer >= 5 && answer <= maximum.
    public int[] initiateSet(int num, int answer, int minimum)    {
        if (num <= 2)
            return null;
        
        final int maximum = num * 5;
        int[] list = new int[num];
        
        //Create an ArrayList that contains available numbers.
        ArrayList<Integer> availableList = new ArrayList<Integer>();
        for (int i = minimum; i <= maximum; i++)
            availableList.add(i);
        ArrayList<Integer> unavailableList = new ArrayList<Integer>();
        
        
        //Select the correct answer.
        list[0] = removeElement(answer, availableList);
        unavailableList.add(list[0]);
        
        //Select one of the addends.
        int addend = (int)(Math.random() * (answer - minimum * 2 + 1)) + minimum;
        while (addend * 2 == answer)
            addend = (int)(Math.random() * (answer - minimum * 2 + 1)) + minimum;
        list[1] = removeElement(addend, availableList);
        unavailableList.add(list[1]);
        
        //Select the other addend.
        list[2] = removeElement(answer - addend, availableList);
        unavailableList.add(list[2]);
        
        int dif = Math.abs(list[1] - list[2]);
        if (dif > 1 && !unavailableList.contains(dif))    {
            removeElement(dif, availableList);
            unavailableList.add(dif);
        }
        
        int sum1 = list[0] + list[1];
        int sum2 = list[0] + list[2];
        if (sum1 <= maximum && !unavailableList.contains(sum1))    {
            removeElement(sum1, availableList);
            unavailableList.add(sum1);
        }
        
        if (sum2 <= maximum && !unavailableList.contains(sum2))    {
            removeElement(sum2, availableList);
            unavailableList.add(sum2);
        }
        
        //Select the other random answers.
        for (int i = 3; i < num; i++)   {
            int index = (int)(Math.random() * availableList.size());
            list[i] = availableList.get(index);
            unavailableList.add(removeElement(list[i], availableList));
            removeInstances(list[i], list, availableList, unavailableList);
        }
        
        shuffle(list);
        
        return list;
    }
    
    public int[][] initiateNumbers(int num) {
        int answer = (int)(Math.random() * (num * 5 - 10)) + 11;
        
        //The array last stands for the last round of Kakooma numbers.
        int[] last = new int[num];
        int[][] nums = new int[num][num];
        
        last = initiateSet(num, answer, 5);
        
        for (int i = 0; i < last.length; i++)
            setAnswer(i, last[i]);
        setAnswer(last.length, answer);
        
        for (int i = 0; i < num; i++)   {
            nums[i] = initiateSet(num, last[i], 2);
        }
        
        return nums;
    }
    
    public void removeInstances(int value, int[] list, ArrayList<Integer> availableList, ArrayList<Integer> unavailableList)  {
        for (int i = 0; i < list.length; i++)   {
            //autoboxing
            int num1 = removeElement(value + list[i], availableList);
            if (num1 != -1)
                unavailableList.add(num1);
            
            int num2 = removeElement(Math.abs(list[i] - value), availableList);
            if (num2 != -1)
                unavailableList.add(num2);
        }
    }
    
    public static void main(String[] args)  {
        System.out.println();
        System.out.println();
        for (int k = 0; k < 5; k++)    {
            AdditionSet adbadb = new AdditionSet(6);
            for (int[] i : adbadb.getNumbers()) {
                for (int j : i) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }
}
