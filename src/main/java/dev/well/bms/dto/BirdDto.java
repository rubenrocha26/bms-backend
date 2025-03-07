package dev.well.bms.dto;

public class BirdDto {

    private Long id;
    private String scientificName;
    private String mutation;
    private String birdRing;
    private String dateOfBirth;

    //No args constructor
    public BirdDto (){}

    //All args constructor
    public BirdDto (Long id, String scientificName, String mutation, String birdRing, String dateOfBirth) {
        this.id = id;
        this.scientificName = scientificName;
        this.mutation = mutation;
        this.birdRing = birdRing;
        this.dateOfBirth = dateOfBirth;
    }

    //Getters
    public Long getId(){
        return this.id;
    }

    public String getScientificName(){
        return this.scientificName;
    }

    public String getMutation(){
        return this.mutation;
    }

    public String getBirdRing(){
        return this.birdRing;
    }

    public String getDateOfBirth(){
        return this.dateOfBirth;
    }

    //Setters
    public void setId (Long id){
        this.id = id;
    }

    public void setScientificName (String scientificName){
        this.scientificName = scientificName;
    }

    public void setMutation (String mutation){
        this.mutation = mutation;
    }

    public void setBirdRing (String birdRing){
        this.birdRing = birdRing;
    }

    public void setDateOfBirth (String dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

}
