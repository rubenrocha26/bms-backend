package dev.well.bms.persistence.dataModel;
import dev.well.bms.domain.mutation.IMutationFactory;
import dev.well.bms.domain.mutation.Mutation;
import dev.well.bms.domain.valueObject.Description;
import dev.well.bms.domain.valueObject.MutationId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MUTATION")
public class MutationDataModel {
    @Id
    private String _mutationId;
    private String _description;
    @Version
    private Long _version;

    public MutationDataModel() {}

    public MutationDataModel(Mutation mutation) {
        this._mutationId = mutation.identity().toString();

        this._description = mutation.getDescription().toString();

    }

    static public Mutation toDomain (IMutationFactory mutationFactory, MutationDataModel mutationDataModel){
        MutationId mutationId = new MutationId(mutationDataModel._mutationId);
        Description description = new Description(mutationDataModel._description);

        return mutationFactory.createMutation(mutationId, description);
    }

    static public Iterable<Mutation> toDomain (IMutationFactory mutationFactory, Iterable<MutationDataModel> listMutationDataModel){
        List<Mutation> listMutationDomain = new ArrayList<>();

        listMutationDataModel.forEach(mutationDataModel ->{
            Mutation mutationDomain = toDomain(mutationFactory, mutationDataModel);

            listMutationDomain.add(mutationDomain);

        });

        return listMutationDomain;
    }
}
