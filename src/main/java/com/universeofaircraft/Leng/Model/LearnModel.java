package com.universeofaircraft.Leng.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LearnModel {
    private int id;
    private Map<Integer, Integer> data;
    private Set<TermModel> terms;
}
