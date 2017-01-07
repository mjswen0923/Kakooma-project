
import java.util.*;

public class MultiplicationSet extends NumberSet
{
    public MultiplicationSet(int dimension) {
        super(dimension);
    }
    
    //Precondition: answer >= 6 && answer <= maximum and answer cannot be a prime number.
    public int[] initiateSet(int num, int answer, int minimum)    {
        if (num <= 2)
            return null;
        
        final int maximum = (int)Math.pow(2 * num - 2, 2);
        int[] list = new int[num];
        
        //Create an ArrayList that contains available numbers.
        ArrayList<Integer> availableList = new ArrayList<Integer>();
        for (int i = minimum; i <= maximum; i++)
            availableList.add(i);
        ArrayList<Integer> unavailableList = new ArrayList<Integer>();
        
        //Select one of the multipliers.
        int multiplier = (int)(Math.random() * (2 * num - 2 - minimum + 1)) + minimum;
        list[0] = removeElement(multiplier, availableList);
        unavailableList.add(list[0]);
        
        //Select the other multiplier.
        int other = availableList.get((int)(Math.random() * (maximum / multiplier - minimum - 1)));
        list[1] = removeElement(other, availableList);
        unavailableList.add(list[0]);
        
        //Select the correct answer.
        answer = multiplier * other;
        list[2] = removeElement(answer, availableList);
        unavailableList.add(list[0]);
        
        int big = Math.max(list[0], list[1]);
        int small = Math.min(list[0], list[1]);
        
        if (big % small == 0)
            unavailableList.add(removeElement(big / small, availableList));
        
        if (big * answer <= maximum)
            unavailableList.add(removeElement(big * answer, availableList));
            
        if (small * answer <= maximum)
            unavailableList.add(removeElement(small * answer, availableList));
        
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
    
    public int[][] initiateNumbers(int num)
    {
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
            int num = removeElement(value * list[i], availableList);
            if (num != -1)
                unavailableList.add(num);
            
            if (Math.min(value, list[i]) != 0 && Math.max(value, list[i]) % Math.min(value, list[i]) == 0)   {
                unavailableList.add(removeElement(Math.max(value, list[i]) / Math.min(value, list[i]), availableList));
            }
        }
    }
    
    //Return all the divisors except 1 and itself.
    public static ArrayList<Integer> divisors(int num)   {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 2; i <= num / 2; i++)
            if (num % i == 0)
                list.add(i);
        return list;
    }
        
    public static void main(String[] args)  {
        System.out.println();
        for (int k = 0; k < 200; k++)    {
            MultiplicationSet adbadb = new MultiplicationSet(5);
            for (int[] i : adbadb.getNumbers()) {
                for (int j : i)
                    System.out.print(j + " ");
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }
}
