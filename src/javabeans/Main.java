package javabeans;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TaskManager tm = new TaskManager();
        Client cl1 = new Client("Delete ALL");
        Client cl2 = new Client("Add ALL");
        Client cl3 = new Client("Wait ALL");
        
        tm.addTaskListener(cl1);
        tm.addTaskListener(cl2);
        tm.addTaskListener(cl3);
        
        tm.works();
        
        tm.removeTaskListener(cl1);
        tm.removeTaskListener(cl2);
        tm.removeTaskListener(cl3);
    }
}
