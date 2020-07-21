package ir.dotin.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "email_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_generator")
    @SequenceGenerator(name = "email_generator", allocationSize = 1, sequenceName = "email_seq")
    @JoinColumn(name = "email_id", nullable = false)
    private Long emailID;
    @ManyToOne
    private Person senderPerson;

    @ManyToMany(mappedBy = "receivedPersonEmails")
    private List<Person> receiverPersons;
    @Lob
    private byte[] emailAttachment;
    private String emailContent;
    private Date emailDate;
    private String emailSubject;
}
