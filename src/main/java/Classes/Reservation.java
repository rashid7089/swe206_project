package Classes;

public class Reservation {
    private Date day;
    private Project project;
    public Reservation(Project p, Date d) {
        project = p;
         day = d;
    }
    public boolean conflict(Reservation r) {
        return day.compareTo(r.day) == 0;
    }

    public Project getProject() {
        return project;
    }

    @Override
    public String toString() {
        return project.getName() + '\n' + day.toString();
    }
}