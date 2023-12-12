package Classes;

public class Reservation {
    private Date start, finish;
    private Project project;
    public Reservation(Project p, Date s, Date f) {
        project = p;
        start = s;
        finish = f;
    }
    public boolean conflict(Reservation r) {
        return finish.compareTo(r.start) < 0 || r.finish.compareTo(start) < 0;
    }

    public Project getProject() {
        return project;
    }
}