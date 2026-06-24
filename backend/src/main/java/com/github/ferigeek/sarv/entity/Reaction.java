package com.github.ferigeek.sarv.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(
        name = "reactions",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"post_id", "user_id"})}
)
public class Reaction {
    public static final short LIKE = 1;
    public static final short DISLIKE = -1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // LIKE = 1, DISLIKE = -1
    @Column(name = "reaction_type", nullable = false)
    private Short reactionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;
}
