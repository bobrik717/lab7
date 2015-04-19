package javabeans;

public class Client implements Runnable,TaskListener{

    private String name;
    private boolean work;
    
    public Client(String name){
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void start(TaskData ev) {
        System.out.println("Start "+this.name);
        System.out.println(ev.getDate());
        this.work = true;
        synchronized(this){
            notify();
        }
    }
    @Override
    public void stop(TaskData ev) {
        System.out.println("Stop "+this.name);
        System.out.println(ev.getDate());
        this.work = false;
    }   
    @Override
    public void run() {
        try{
            synchronized(this){
                while (!work) wait();
            }
            while (work) {                
                System.out.println("works...");
                Thread.sleep(100);
            }
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println("ends...");
    }
    
}
