package com.sbuhacks.mdbspringboot;

import com.sbuhacks.mdbspringboot.model.PriorityPatient;
import com.sbuhacks.mdbspringboot.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class MdbSpringBootApplication implements CommandLineRunner {

    @Autowired
    PatientRepository priorityPatientRepo;

    public static void main(String[] args) {
        SpringApplication.run(MdbSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("-----CREATE GROCERY ITEMS-----\n");

        createPriorityPatients();

        System.out.println("\n-----SHOW ALL GROCERY ITEMS-----\n");

        showAllPriorityPatients();

        System.out.println("\n-----GET ITEM BY NAME-----\n");

        getPriorityPatientByName("Jiwoo Kim");

        //System.out.println("\n-----GET ITEMS BY CATEGORY-----\n");

        //getPriorityPatientsByPriority("1");

        System.out.println("\n-----DELETE A GROCERY ITEM-----\n");

        deletePriorityPatient("Jiwoo Kim");

        System.out.println("\n-----FINAL COUNT OF GROCERY ITEMS-----\n");

        System.out.println("\n-----THANK YOU-----");

    }

    void createPriorityPatients() {
        System.out.println("Data creation started...");
        priorityPatientRepo.save(new PriorityPatient("1", "Jiwoo Kim", 1));
        priorityPatientRepo.save(new PriorityPatient("2", "Jacob James", 4));
        priorityPatientRepo.save(new PriorityPatient("3", "Emily Rose", 5));
        priorityPatientRepo.save(new PriorityPatient("4", "Jackie Chan", 7));
        priorityPatientRepo.save(new PriorityPatient("5", "John Wick", 9));
        System.out.println("Data creation complete...");
    }

    // READ
    // 1. Show all the data
    public void showAllPriorityPatients() {
        priorityPatientRepo.findAll().forEach(patient -> System.out.println(getPriorityPatientDetails(patient)));
    }

    // 2. Get item by name
    public void getPriorityPatientByName(String name) {
        System.out.println("Getting patient by name: " + name);
        PriorityPatient patient = priorityPatientRepo.findPatientByName(name);
        System.out.println(getPriorityPatientDetails(patient));
    }

    // 3. Get name and quantity of a all items of a particular category
    //public void getPriorityPatientsByPriority(String priority) {
    //    System.out.println("Getting patients for the priority " + priority);
    //    List<PriorityPatient> list = priorityPatientRepo.findAll(priority);

    //    list.forEach(item -> System.out.println("Name: " + item.getName() + ", Quantity: " + item.getQuantity()));
    //}

    // 4. Get count of documents in the collection
    //public void findCountOfPriorityPatients() {
    //    long count = priorityPatientRepo.count();
    //    System.out.println("Number of documents in the collection: " + count);
    //}

    // Print details in readable form

    public String getPriorityPatientDetails(PriorityPatient patient) {

        System.out.println(
                "ID: " + patient.getId() +
                        ", \nName: " + patient.getName() +
                        ", \nPriority: " + patient.getPriority()
        );

        return "";
    }

    // DELETE
    public void deletePriorityPatient(String id) {
        priorityPatientRepo.deleteById(id);
        System.out.println("Patient with id " + id + " deleted...");
    }
}