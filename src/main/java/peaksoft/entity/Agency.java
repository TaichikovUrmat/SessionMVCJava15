package peaksoft.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agencies")
@Getter @Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Agency {
    @Id
            @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "agency_gen")
            @SequenceGenerator(name = "agency_gen",sequenceName = "agency_seq",allocationSize = 1)

    Long id;
    @NotEmpty
    String name;
    String country;
    String phoneNumber;
    String imageLink;
    @NotEmpty
    String email;


    @OneToMany(mappedBy = "agency",cascade = CascadeType.PERSIST)
    List<House> house = new ArrayList<>();








}
