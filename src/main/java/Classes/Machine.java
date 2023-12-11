package Classes;

import java.sql.Date;
import java.util.ArrayList;

public class Machine {
    
    private String machineName;
    private ArrayList<Reservation> machineSchedule;

    public Machine(String machineName){
        this.machineName = machineName;
        machineSchedule = new ArrayList<>();
    }
    public boolean reserve(Project p, Date s, Date f) {
        Reservation r = new Reservation(p, s, f);
        for(Reservation rs: machineSchedule)
            if(r.conflict(rs))
                return false;
        machineSchedule.add(r);
        return true;
    }
}
