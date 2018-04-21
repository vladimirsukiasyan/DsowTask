package dsow.dsowtask.Model;

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Task {
    private String name;
    private int deadline;
    private boolean isDone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Task(String name, int deadline) {
        this.name = name;
        this.deadline = deadline;
    }
    public Task(){
        this.name=null;
        this.deadline=0;
    }
}
