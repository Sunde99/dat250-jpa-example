package creditcard;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;

@Entity
@Data
public class Bank {
    @Id
    public String name;

    @OneToMany
    private ArrayList<Creditcard> cards;

    @ManyToMany
    private ArrayList<Person> customers;
}
