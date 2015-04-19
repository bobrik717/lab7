package javabeans;

import java.util.ArrayList;
import java.util.Random;

public class TaskManager {
    private ArrayList<TaskListener> list = new ArrayList<TaskListener>();
    
    public void works()throws InterruptedException{
        Random rnd = new Random();
        Thread.sleep(rnd.nextInt(2000));
        this.fireTask(1,"");
        Thread.sleep(rnd.nextInt(4000));
        this.fireTask(2,"");
    }
    
    public synchronized void addTaskListener(TaskListener tl){
        list.add(tl);
    }
    
    public synchronized void removeTaskListener(TaskListener tl){
        list.remove(tl);
    }
    
    private void fireTask(int iventId,String name){
        ArrayList<TaskListener> copy;
        synchronized (this){
            copy = (ArrayList<TaskListener>)list.clone();
        }
        TaskData ev = new TaskData(this, name);
        for(TaskListener tl: copy){
            if(iventId == 1) tl.start(ev); 
            else tl.stop(ev);
        }
    }
}
