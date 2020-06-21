package ir.dotin.entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_generator")
    @SequenceGenerator(name = "email_generator", allocationSize = 1, sequenceName = "email_seq")
    @JoinColumn(name = "Email_id", nullable = false)
    private Long emailId;
    private Long senderPersonId;
    @ManyToMany(mappedBy = "pEmails")
    private List<Person> senderPerson;


}
