package ir.dotin.entity;


import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "off_Request_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OffRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offRequest_generator")
    @SequenceGenerator(name = "offRequest_generator", allocationSize = 1, sequenceName = "offRequest_seq")
    @JoinColumn(name = "offRequest_id", nullable = false)
    private Long offRequestID;
    private String offDescription;
    private Date offStartDate;
    private Date offEndDate;


    @ManyToOne(cascade = CascadeType.ALL)
    private Person requesterPerson;
    @ManyToOne(cascade = CascadeType.ALL)
    private Person receiverManagerPerson;

    @ManyToOne(cascade = CascadeType.ALL)
    private SubCategory typeOfRequest;


}

