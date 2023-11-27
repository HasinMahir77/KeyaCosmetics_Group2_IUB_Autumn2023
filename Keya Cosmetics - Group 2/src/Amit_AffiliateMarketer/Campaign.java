
package Amit_AffiliateMarketer;

import java.io.Serializable;
import java.time.LocalDate;

public class Campaign implements Serializable {
    private String productName;
    private String influencerName;
    private LocalDate durationStarts;
    private LocalDate durationEnds;
    private String description;
    private Integer budget;

    public Campaign(String productName, String influencerName, LocalDate durationStarts, LocalDate durationEnds, String description, Integer budget) {
        this.productName = productName;
        this.influencerName = influencerName;
        this.durationStarts = durationStarts;
        this.durationEnds = durationEnds;
        this.description = description;
        this.budget = budget;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getInfluencerName() {
        return influencerName;
    }

    public void setInfluencerName(String influencerName) {
        this.influencerName = influencerName;
    }

    public LocalDate getDurationStarts() {
        return durationStarts;
    }

    public void setDurationStarts(LocalDate durationStarts) {
        this.durationStarts = durationStarts;
    }

    public LocalDate getDurationEnds() {
        return durationEnds;
    }

    public void setDurationEnds(LocalDate durationEnds) {
        this.durationEnds = durationEnds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }
    
    


    
}
