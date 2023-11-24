
package Amit_AffiliateMarketer;

import java.io.Serializable;

public class Influencer implements Serializable {
    private String name;
    private String socialMediaID;
    private int followers;
    private String gender;
    private int ageOfInfuence;;

    public Influencer(String name, String socialMediaID, int followers, String gender, int ageOfInfuence) {
        this.name = name;
        this.socialMediaID = socialMediaID;
        this.followers = followers;
        this.gender = gender;
        this.ageOfInfuence = ageOfInfuence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocialMediaID() {
        return socialMediaID;
    }

    public void setSocialMediaID(String socialMediaID) {
        this.socialMediaID = socialMediaID;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAgeOfInfuence() {
        return ageOfInfuence;
    }

    public void setAgeOfInfuence(int ageOfInfuence) {
        this.ageOfInfuence = ageOfInfuence;
    }
    
    
}
