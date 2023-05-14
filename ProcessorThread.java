package homework12.task2;

import java.util.concurrent.atomic.AtomicBoolean;

public class ProcessorThread extends Thread{
    private int number;
    private AtomicBoolean isProcessed = new AtomicBoolean(true);
    private Processor processor;

    public ProcessorThread(Processor processor) {
        this.processor = processor;
    }
    public void process(int number){
        this.number = number;
        isProcessed.set(false);
    }
    public boolean getIsProcessed(){
        return isProcessed.get();
    }

    @Override
    public void run(){
        while(true){
            try {
                sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(isProcessed.get()) continue;

            processor.calculate(number);
            isProcessed.set(true);
        }
    }

}
