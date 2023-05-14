package homework12.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class Task2 {
    public static void main(String[] args) {
        ProcessorThread fizzProcessor = new ProcessorThread((number) -> {
            if(number % 3 == 0 && number % 5 != 0) System.out.println("fizz");
        });
        ProcessorThread buzzProcessor = new ProcessorThread((number) -> {
            if(number % 3 != 0 && number % 5 == 0) System.out.println("buzz");
        });
        ProcessorThread fizzBuzzProcessor = new ProcessorThread((number) -> {
            if(number % 3 == 0 && number % 5 == 0) System.out.println("fizzbuzz");
        });
        ProcessorThread defaultProcess = new ProcessorThread((number) -> {
            if(number % 3 != 0 && number % 5 != 0) System.out.println(number);
        });

        List<ProcessorThread> threads = new ArrayList<>();
        threads.add(fizzProcessor);
        threads.add(buzzProcessor);
        threads.add(fizzBuzzProcessor);
        threads.add(defaultProcess);

        for(ProcessorThread thread : threads){
            thread.start();
        }
        for(int i=1;i<=50;i++){
            for(ProcessorThread thread : threads){
                thread.process(i);
            }
            int[]threadsFinished = new int[threads.size()];
            for(int counter : threadsFinished){
                counter = 0;
            }

            while(true){
                for(int j = 0;j< threads.size();j++){
                    if(threads.get(j).getIsProcessed()) threadsFinished[j] = 1;
                }

                boolean allFinished = true;
                for(int counter : threadsFinished){
                    if(counter == 0) allFinished = false;
                }
                if(allFinished) break;
            }
        }
    }
}
