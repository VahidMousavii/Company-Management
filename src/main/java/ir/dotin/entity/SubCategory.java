package ir.dotin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "sub_category_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sub_category_generator")
    @SequenceGenerator(name = "sub_category_generator", allocationSize = 1, sequenceName = "sub_category_seq")
    @JoinColumn(name = "Sub_category_id", nullable = false)
    private Long subCategoryID;

    private String subCategoryName;
    private String subCategoryFarsiName;


    @ManyToOne(cascade = CascadeType.ALL)
    private Category mainCategory;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeOfRequest", fetch = FetchType.LAZY)
    private List<OffRequest> offRequestList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleSubCategory", fetch = FetchType.LAZY)
    private List<Person> personList;

}
