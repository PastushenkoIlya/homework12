package homework12.task1;

public class Task1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                while(true) {
                    try {
                        sleep(5000);
                        System.out.println("Пройшло 5 секунд");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread thread5sec = new Thread(){
            @Override
            public void run(){
                int counter = 1;
                while(true){
                    try {
                        sleep(1000);
                        System.out.println(counter);
                        counter++;
                        
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        thread1.start();
        thread5sec.start();
    }
}