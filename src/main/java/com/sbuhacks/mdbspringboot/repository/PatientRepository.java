package com.sbuhacks.mdbspringboot.repository;

import com.sbuhacks.mdbspringboot.model.PriorityPatient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PatientRepository extends MongoRepository<PriorityPatient, String> {
    @Query("{name:'?0'}")
    PriorityPatient findPatientByName(String name);

    //@Query(value="{category:'?0'}", fields="{'name' : 1, 'id' : 1}")
    //List<PriorityPatient> findAll(String priority);

    public long count();

}
