package org.abbtech.practice.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(nullable = false)
    private String Content;

    @Column(nullable = false)
    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name = "POST_ID", nullable = false)
    private Post post;
}