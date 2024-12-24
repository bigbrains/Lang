package com.universeofaircraft.Leng.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Term {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String term;
    private String definition;
    @ManyToOne
    @JoinColumn(name="set_id", nullable=false)
    private Set set;
}
