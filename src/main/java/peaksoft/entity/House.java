package peaksoft.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import peaksoft.enums.HouseType;

@Entity
@Table(name = "houses")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "house_gen")
    @SequenceGenerator(name = "house_gen",sequenceName = "house_seq",allocationSize = 1,initialValue = 2)

    Long id;

    String address;
    String country;
    int price;
    int room;
    String description;
    @Enumerated(EnumType.STRING)
    HouseType houseType;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Agency agency;









}
