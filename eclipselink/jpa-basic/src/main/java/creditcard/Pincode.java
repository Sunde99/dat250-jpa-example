package creditcard;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Pincode {
    @Id
    private String code;
    private int count;

    @OneToOne
    private Creditcard card;
}
