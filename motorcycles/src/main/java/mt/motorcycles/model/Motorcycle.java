package mt.motorcycles.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Motorcycle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // id cannot be null and changed
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String type;
    private int capacity;
    private int productionYear;
    private String imageURl;

}
