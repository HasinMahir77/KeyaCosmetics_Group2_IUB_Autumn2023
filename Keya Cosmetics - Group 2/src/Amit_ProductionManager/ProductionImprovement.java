
package Amit_ProductionManager;

import java.io.Serializable;

public class ProductionImprovement implements Serializable{
    private String productName;
    private String improvement;

    public ProductionImprovement(String productName, String improvement) {
        this.productName = productName;
        this.improvement = improvement;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImprovement() {
        return improvement;
    }

    public void setImprovement(String improvement) {
        this.improvement = improvement;
    }
    
    
}
