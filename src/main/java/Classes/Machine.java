package Classes;

import java.util.HashMap;
import java.util.ArrayList;

public class Machine {
    public static HashMap<String, Machine> machineList = new HashMap<>();
    private String machineName;
    private ArrayList<Reservation> machineSchedule;

    public Machine(String machineName){
        this.machineName = machineName;
        machineSchedule = new ArrayList<>();
        machineList.put(machineName, this);
    }
    public boolean reserve(Project p, Date s, Date f) {
        Reservation r = new Reservation(p, s, f);
        for(Reservation rs: machineSchedule)
            if(r.conflict(rs))
                return false;

        machineSchedule.add(r);
        p.reserve(this, r);
        return true;
    }

    public ArrayList<Reservation> getMachineSchedule() {
        return machineSchedule;
    }

    public String getMachineName() {
        return machineName;
    }
}