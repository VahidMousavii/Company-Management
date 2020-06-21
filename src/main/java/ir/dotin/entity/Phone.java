package ir.dotin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity(name = "phone_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Phone_generator")
    @SequenceGenerator(name = "Phone_generator", allocationSize = 1, sequenceName = "Phone_seq")
    private Long phoneID;
    private String phoneNumber;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "Person_ID")
    private Person person;

}

