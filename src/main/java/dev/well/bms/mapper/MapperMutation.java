package dev.well.bms.mapper;

import dev.well.bms.domain.mutation.FactoryMutationImpl;
import dev.well.bms.domain.mutation.IFactoryMutation;
import dev.well.bms.domain.mutation.Mutation;
import dev.well.bms.domain.valueObject.Description;
import dev.well.bms.domain.valueObject.MutationId;
import dev.well.bms.persistence.dataModel.MutationDataModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperMutation {
    private final IFactoryMutation _mutationFactory = new FactoryMutationImpl();

    public MapperMutation(){}

    public Mutation dataModelToDomain (MutationDataModel mutationDataModel){
        MutationId mutationId = new MutationId(mutationDataModel.getMutationId());
        Description description = new Description(mutationDataModel.getDescription());

        return _mutationFactory.createMutation(mutationId, description);
    }

    public Iterable<Mutation> dataModelToDomain (Iterable<MutationDataModel> listMutationDataModel){
        List<Mutation> listMutationDomain = new ArrayList<>();

        listMutationDataModel.forEach(mutationDataModel ->{
            MutationId mutationId = new MutationId(mutationDataModel.getMutationId());
            Description description = new Description(mutationDataModel.getDescription());
            Mutation mutationDomain = _mutationFactory.createMutation(mutationId,description);

            listMutationDomain.add(mutationDomain);

        });

        return listMutationDomain;
    }
}
