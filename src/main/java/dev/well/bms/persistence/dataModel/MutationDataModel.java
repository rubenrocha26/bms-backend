package dev.well.bms.persistence.dataModel;
import dev.well.bms.domain.mutation.Mutation;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

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

    public String getMutationId() {
        return this._mutationId;
    }

    public String getDescription() {
        return this._description;
    }
}
