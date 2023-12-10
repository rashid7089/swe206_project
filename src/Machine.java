import java.sql.Date;
import java.util.ArrayList;

public class Machine {
    
    private String machineName;
    private ArrayList<Date> machineSchedule;

    public Machine(String machineName, ArrayList<Date> machineSchedule){
        this.machineName = machineName;
        this.machineSchedule = machineSchedule;

    }
}
