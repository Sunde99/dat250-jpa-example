package creditcard;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Data
public class Person {
    @Id
    public String name;

    @ManyToOne
    private Address address;

    @OneToMany
    private ArrayList<Creditcard> cards;

    @ManyToMany
    private ArrayList<Bank> bank;
}
