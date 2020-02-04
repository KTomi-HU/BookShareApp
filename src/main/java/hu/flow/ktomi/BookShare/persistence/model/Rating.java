package hu.flow.ktomi.BookShare.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer rating;

    @OneToOne
    private User user;

    public Rating(Integer rating, User user) {
        this.rating = rating;
        this.user = user;
    }
}
