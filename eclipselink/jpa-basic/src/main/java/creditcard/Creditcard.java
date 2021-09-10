package creditcard;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Creditcard {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int number;
    private int balance;
    private int limit;

    @ManyToOne
    private Person owner;

    @OneToOne
    private Pincode code;

    @ManyToOne
    private Bank bank;


}
