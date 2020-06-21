package ir.dotin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "person_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Person_generator")
    @SequenceGenerator(name = "Person_generator",allocationSize = 1,sequenceName = "person_seq")
    @JoinColumn(name = "Person_ID", nullable = false)
    private Long pID;
    private String pName;
    private String pFamily;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "person")
    private List<Phone> phoneList;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "person_receivedEmails",
            joinColumns = { @JoinColumn(name = "Person_ID") },
            inverseJoinColumns = { @JoinColumn(name = "Email_id") }
    )
    private List<Email> pEmails;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "person_leaves",
            joinColumns = { @JoinColumn(name = "Person_ID") },
            inverseJoinColumns = { @JoinColumn(name = "Leave_id") })
    private List<Leave> leaveList;

    @OneToMany(mappedBy = "directManager",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Person> employees;

    @ManyToOne
    @JoinColumn(name = "person_direct_manager_id")
    private Person directManager;

}
