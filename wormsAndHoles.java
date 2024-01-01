package RetakeExam;

import java.lang.reflect.Array;
import java.util.*;

public class ex01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Deque<Integer> wormsStack=new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(wormsStack::push);
        Deque<Integer> holesQueue=new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(holesQueue::offer);
        int wormsStackSize=wormsStack.size();





        int matchesCount=0;

        while (!wormsStack.isEmpty()&&!holesQueue.isEmpty()){
            int lastWorm=wormsStack.peek();
            int firstHole=holesQueue.peek();
            if (lastWorm==firstHole){
                wormsStack.pop();
                holesQueue.poll();
                matchesCount++;

            }else {
                holesQueue.poll();
                int wormToChange=wormsStack.pop();
                wormsStack.push(wormToChange-3);
            }
            if (!wormsStack.isEmpty()){
                if (wormsStack.peek()<=0){
                    wormsStack.pop();
                }
            }



        }
        if (matchesCount>0){
            System.out.printf("Matches: %d%n",matchesCount);
        }else {
            System.out.println("There are no matches.");
        }
        if (wormsStack.isEmpty()){
            if (wormsStackSize==matchesCount){
                System.out.println("Every worm found a suitable hole!");
            }else {
                System.out.println("Worms left: none");
            }
        }else {
            List<Integer> printWorms=new ArrayList<>();
            while (!wormsStack.isEmpty()){
                printWorms.add(wormsStack.pop());
            }
            Collections.reverse(printWorms);
            System.out.print("Worms left: ");
            int remainingWorms = printWorms.size();
            for (Integer worm : printWorms) {
                remainingWorms--;
                System.out.print(worm);
                if (remainingWorms !=0) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        if (holesQueue.isEmpty()){
            System.out.println("Holes left: none");
        }else {
            System.out.print("Holes left: ");
            int remainingHoles = holesQueue.size();
            for (Integer hole : holesQueue) {
                remainingHoles--;
                System.out.print(hole);
                if (remainingHoles != 0) {
                    System.out.print(", ");
                }
            }
        }

    }
}
