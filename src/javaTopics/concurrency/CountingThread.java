package javaTopics.concurrency;

public class CountingThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println(this.getName()+" "+i);

        }
    }
}
