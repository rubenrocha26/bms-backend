package dev.well.bms.persistence.dataModel;

import dev.well.bms.domain.mutation.IMutationFactory;
import dev.well.bms.domain.mutation.Mutation;
import dev.well.bms.domain.mutation.MutationFactoryImpl;
import dev.well.bms.domain.valueObject.Description;
import dev.well.bms.domain.valueObject.MutationId;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MutationDataModelTest {

    @Test
    void shouldCreateMutationDataModel() {
        //arrange
        //act
        MutationDataModel mutationDataModel = new MutationDataModel();
        //assert
        assertNotNull(mutationDataModel);
    }

    @Test
    void shouldCreateMutationDataModelFromDomain() {
        //arrange
        MutationId mutationId = mock(MutationId.class);
        Description description = mock(Description.class);
        Mutation mutation = mock(Mutation.class);
        when(mutation.identity()).thenReturn(mutationId);
        when(mutationId.toString()).thenReturn("mutationId");
        when(mutation.getDescription()).thenReturn(description);
        when(description.toString()).thenReturn("description");
        //act
        MutationDataModel mutationDataModel = new MutationDataModel(mutation);
        //assert
        assertNotNull(mutationDataModel);
    }

    @Test
    void toDomain() {
        //arrange
        IMutationFactory mutationFactory = new MutationFactoryImpl();
        Description description = new Description("Classico");
        Mutation mutation = mutationFactory.createMutation(description);
        MutationDataModel mutationDataModel = new MutationDataModel(mutation);
        //act
        Mutation mutationFromDataBase = MutationDataModel.toDomain(mutationFactory, mutationDataModel);
        //assert
        assertNotNull(mutationFromDataBase);
        assertEquals(mutation, mutationFromDataBase);
    }

    @Test
    void nullDataModelThrowsException() {
        //arrange
        IMutationFactory mutationFactory = new MutationFactoryImpl();
        MutationDataModel mutationDataModel = null;
        //act + assert
        assertThrows(NullPointerException.class,() -> MutationDataModel.toDomain(mutationFactory, mutationDataModel));
    }

    @Test
    void testIterableMutationToDomain() {
        //arrange
        IMutationFactory mutationFactory = new MutationFactoryImpl();
        Description description = new Description("Classico");
        Mutation mutation1 = mutationFactory.createMutation(description);
        MutationDataModel mutationDataModel = new MutationDataModel(mutation1);

        Description description2 = new Description("Parda");
        Mutation mutation2 = mutationFactory.createMutation(description2);
        MutationDataModel mutationDataModel2 = new MutationDataModel(mutation2);
        List<MutationDataModel> listDataModel = new ArrayList<>();
        listDataModel.add(mutationDataModel);
        listDataModel.add(mutationDataModel2);
        //act
        Iterable<Mutation> listMutationsDomain = MutationDataModel.toDomain(mutationFactory, listDataModel);
        //assert
        assertNotNull(listMutationsDomain);
        List<Mutation> mutations = new ArrayList<>();
        listMutationsDomain.forEach(mutations::add);
        assertEquals(2, mutations.size());
        assertTrue(mutations.contains(mutation1));
        assertTrue(mutations.contains(mutation2));
    }
}