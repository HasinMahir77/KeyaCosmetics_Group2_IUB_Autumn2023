
package Amit_AffiliateMarketer;

import HasinMahir.Product;
import java.io.Serializable;

public class ProductReview implements Serializable { 
    
   
    private Product product;
    private String review;

    public ProductReview(Product product, String review) {
        this.product = product;
        this.review = review;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
    
    
    
    
    
}
