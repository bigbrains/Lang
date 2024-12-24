package com.universeofaircraft.Leng.Entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "set_of_terms")
public class Set {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @NotEmpty
    private String name;

    private boolean isDraft;

    @OneToMany(mappedBy="set")
    private java.util.Set<Term> terms;

    @Transient
    private int lastPersistedId;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
}
