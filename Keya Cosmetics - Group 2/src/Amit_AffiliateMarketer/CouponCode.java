
package Amit_AffiliateMarketer;

import java.io.Serializable;

public class CouponCode implements Serializable {
    private String couponCode;
    private int percentage;

    public CouponCode(String couponCode, int percentage) {
        this.couponCode = couponCode;
        this.percentage = percentage;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
    
    
    
}
