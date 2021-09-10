package creditcard;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Data
public class Address {
    @Id
    public String street;

    @Id
    public int number;

    @OneToMany
    private ArrayList<Person> occupant;

}
