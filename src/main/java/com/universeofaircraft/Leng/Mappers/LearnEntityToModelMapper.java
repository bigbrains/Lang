package com.universeofaircraft.Leng.Mappers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.universeofaircraft.Leng.Entites.Learn;
import com.universeofaircraft.Leng.Entites.Term;
import com.universeofaircraft.Leng.Model.LearnModel;
import com.universeofaircraft.Leng.Model.TermModel;

import java.lang.reflect.Type;
import java.util.*;

public class LearnEntityToModelMapper {
    public static LearnModel map(Learn entity) {
        LearnModel model = new LearnModel();
        model.setId(entity.getId());

        Set<TermModel> termModels = new HashSet<>();
        for (Term termEntity : entity.getSet().getTerms()) {
            TermModel termModel = new TermModel();
            termModel.setId(termEntity.getId());
            termModel.setTerm(termEntity.getTerm());
            termModel.setDefinition(termEntity.getDefinition());

            termModels.add(termModel);
        }

        model.setTerms(termModels);

        Type mapType = new TypeToken<HashMap<Integer, Integer>>(){}.getType();
        Gson gson = new GsonBuilder().create();
        HashMap<Integer, Integer> data = gson.fromJson(entity.getData(), mapType);
        model.setData(data);

        return model;
    }
}
