import java.util.ArrayDeque;
import java.util.Deque;

public class stack{



public static void main(String args[])
{

Deque<Integer> stack = new ArrayDeque<Integer>();
Deque<Integer> stack2 = new ArrayDeque<Integer>();

for (int i =0 ; i<3000; i++)
{

stack.add(i);

}

long startTime = System.currentTimeMillis();

for (int i = 0; i<100000; i++)
{
stack.isEmpty();

}

long endTime = System.currentTimeMillis();

System.out.println("That took " + (endTime - startTime) + " milliseconds");

long startTime2 = System.currentTimeMillis();

for (int i = 0; i<100000; i++)
{
stack2.isEmpty();

}

long endTime2 = System.currentTimeMillis();

System.out.println("That took " + (endTime2 - startTime2) + " milliseconds");





}



}
