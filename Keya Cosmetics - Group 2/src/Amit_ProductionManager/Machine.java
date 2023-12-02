
package Amit_ProductionManager;

import java.io.Serializable;


public class Machine implements Serializable {
    private String name;
    private String modelno;
    private int cost;

    public Machine(String name, String modelno, int cost) {
        this.name = name;
        this.modelno = modelno;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelno() {
        return modelno;
    }

    public void setModelno(String modelno) {
        this.modelno = modelno;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
    
    
}
