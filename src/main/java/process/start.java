package process;

public class start {
    public static void main(String[] args) {
        Thread1 thread1=new Thread1();
        while (true){
            try {
                thread1.run();
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
