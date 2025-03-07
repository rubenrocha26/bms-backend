package dev.well.bms.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Entity
@Table(name = "birds")
public class Bird {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "scientific_name")
    private String scientificName;
    @Column(name = "mutation")
    private String mutation;
    @Column(name = "bird_ring", nullable = false, unique = true)
    private String birdRing;
    @Column(name = "date_of_birth")
    private String dateOfBirth;

    //No args constructor
    public Bird() {
    };

    //All args constructor
    public Bird(Long id, String scientificName, String mutation, String birdRing, String dateOfBirth) {
        this.id = id;
        this.scientificName = scientificName;
        this.mutation = mutation;
        this.birdRing = birdRing;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getMutation() {
        return mutation;
    }

    public void setMutation(String mutation) {
        this.mutation = mutation;
    }

    public String getBirdRing() {
        return birdRing;
    }

    public void setBirdRing(String birdRing) {
        this.birdRing = birdRing;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    //Features to be added
    private LocalDate stringToLocalDate (String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use dd-MM-yyyy");
        }
    }

    private String localDateToString (LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(formatter);
    }
}
