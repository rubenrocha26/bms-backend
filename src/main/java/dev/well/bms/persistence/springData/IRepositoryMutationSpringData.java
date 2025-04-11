package dev.well.bms.persistence.springData;
import dev.well.bms.persistence.dataModel.MutationDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryMutationSpringData extends JpaRepository<MutationDataModel, String> {
}
