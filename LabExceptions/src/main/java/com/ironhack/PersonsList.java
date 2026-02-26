package com.ironhack;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class PersonsList {
    private final PersonRepository personRepository;

    public PersonsList(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    private List<Person> personsList;

    public Person findByName(String name){
        String[] parts = name.trim().split(" ");
        if(parts.length != 2){
            throw new IllegalArgumentException("Incorrect name format! Format should be: firstName lastName");
        }
        Person foundPerson = null;
        for(Person p : personsList){
            if(Objects.equals(name, p.getName())) {
                foundPerson = p;
                break;
            }
        }
        return foundPerson;
    }

    public Person clone(Person person){
        int idClone = person.getId();
        int newId = idClone + 1;
        String nameClone = person.getName();
        int ageClone = person.getAge();
        String occupationClone = person.getOccupation();

        return new Person(newId, nameClone, ageClone, occupationClone);
    }

    public void infoSaver(Person person) throws IOException {
        if(person == null){
            throw new NullPointerException("Null cannot be saved!");
        }
        try(FileWriter writer = new FileWriter("personInfo.txt", true)){
            writer.write(person.toString());
        }
    }
}
