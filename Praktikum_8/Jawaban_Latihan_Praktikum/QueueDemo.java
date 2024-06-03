import java.util.Scanner;
import java.util.*;

public class QueueDemo {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        
        MyQueue mq = new MyQueue();
        for(int i = 0; i < 6; i++){
            int inputx = sc.nextInt();
            mq.push(inputx);
        }

        
        System.out.println("TESTING");
        Stack<Integer> stack2 = mq.getStack2();

        for(int i = 0; i < 6; i++){

            int top = stack2.pop();
            
            System.out.println(top);
        }

        sc.close();
    }
}
