package dsow.dsowtask;

public class Task {
    private String id;
    private String name;
    private int deadline;
    private boolean isDone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Task(String id, String name, int deadline) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
    }
    public Task(){
        this.id=null;
        this.name=null;
        this.deadline=0;
    }
}
