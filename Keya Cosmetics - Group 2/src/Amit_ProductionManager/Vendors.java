
package Amit_ProductionManager;

import java.io.Serializable;
import java.time.LocalDate;

public class Vendors implements Serializable {
    private String name;
    private LocalDate delivered;
    private int rate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDelivered() {
        return delivered;
    }

    public void setDelivered(LocalDate delivered) {
        this.delivered = delivered;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Vendors(String name, LocalDate delivered, int rate) {
        this.name = name;
        this.delivered = delivered;
        this.rate = rate;
    }
    
}
