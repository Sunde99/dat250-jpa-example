package creditcard;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Data
public class Person {
    @Id
    public String name;

    @ManyToMany
    private ArrayList<Address> addresses;

    @OneToMany
    private ArrayList<Creditcard> cards;

    @ManyToMany
    private ArrayList<Bank> bank;
}
