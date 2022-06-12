package com.progra3.petstore.dao;

import com.progra3.petstore.entities.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetDao extends CrudRepository<Pet, Long> {

}
