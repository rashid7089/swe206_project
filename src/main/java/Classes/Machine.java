package Classes;

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
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

    public static void load() throws FileNotFoundException {
        Scanner in = new Scanner(new File("data/machines.txt"));
        while(in.hasNext()) {
            Machine m = new Machine(in.nextLine());
            int resCount = in.nextInt();
            while(resCount-- > 0) {
                in.nextLine();
                Project p = Project.projects.get(in.nextLine());
                Date start = new Date(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
                Date finish = new Date(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
                m.reserve(p, start, finish);
            }
        }
    }
    @Override
    public String toString(){
        return machineName;
    }
}