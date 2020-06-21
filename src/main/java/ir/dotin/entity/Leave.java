package ir.dotin.entity;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leave_generator")
    @SequenceGenerator(name = "leave_generator", allocationSize = 1, sequenceName = "leave_seq")
    @JoinColumn(name = "Leave_id", nullable = false)
    private Long leaveId;
    private Date date;

    @ManyToMany(cascade = { CascadeType.ALL })
    private List<Person> person;

    private Status Status;


    public enum Status
    {
        Pending, Confirmed, Canceled;
    }
}

