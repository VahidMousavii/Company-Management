package ir.dotin.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "person_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_generator")
    @SequenceGenerator(name = "person_generator", allocationSize = 1, sequenceName = "person_seq")
    @JoinColumn(name = "person_id", nullable = false)
    private Long personID;
    private String personFamily;
    private String personName;
    private String phone;
    private String nationalCode;
    private String personnelCode;
    private Boolean active;

    //yek person mitavanad chandin email daryaft shode dashte bashad
    //va yek email mitavanad be chand nafar ersal shavad(ersale gorohi be chandin nafar)
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "person_received_Emails",
            joinColumns = {@JoinColumn(name = "Person_ID")},
            inverseJoinColumns = {@JoinColumn(name = "email_id")})
    private List<Email> receivedPersonEmails;

    //email 1 sender darad va har nafar mitavanad chand email ersal konad
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "senderPerson", fetch = FetchType.LAZY)
    private List<Email> sentEmails;

    //yek nafar mitavanad chandin darkhaste morakhasi dashte bashad
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requesterPerson", fetch = FetchType.LAZY)
    private List<OffRequest> offRequestList;

    //yek nafar(directManager) mitavanad chandin darkhaste morakhsi baraye taid dashte bashad
    // vali yek darkhaste morakhasi nemitavanad baraye chand nafar baraye taid ersal shavad
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receiverManagerPerson", fetch = FetchType.LAZY)
    private List<OffRequest> offRequestReceivedList;

    @ManyToOne
    @JoinColumn(name = "person_directManager_id")
    private Person directManager;
    //Self-Join
    @OneToMany(mappedBy = "directManager", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Person> employees;

    @ManyToOne(cascade = CascadeType.ALL)
    private SubCategory roleSubCategory;

    public Person(Long personID) {
        this.personID = personID;
    }
}

