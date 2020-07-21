package ir.dotin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "category_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_generator")
    @SequenceGenerator(name = "category_generator", allocationSize = 1, sequenceName = "category_seq")
    @JoinColumn(name = "category_id", nullable = false)
    private Long categoryID;

    private String categoryName;
    private String categoryFarsiName;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mainCategory", fetch = FetchType.LAZY)
    private List<SubCategory> subCategories;



}
