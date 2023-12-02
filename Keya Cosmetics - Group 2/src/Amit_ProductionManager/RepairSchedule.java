
package Amit_ProductionManager;

import java.io.Serializable;
import java.time.LocalDate;


public class RepairSchedule implements Serializable{
    private String machineName;
    private LocalDate repairDate;

    public RepairSchedule(String machineName, LocalDate repairDate) {
        this.machineName = machineName;
        this.repairDate = repairDate;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public LocalDate getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(LocalDate repairDate) {
        this.repairDate = repairDate;
    }
    
    
}
