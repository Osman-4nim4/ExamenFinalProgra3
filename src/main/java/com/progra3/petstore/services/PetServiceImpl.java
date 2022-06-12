package com.progra3.petstore.services;

import com.progra3.petstore.dao.PetDao;
import com.progra3.petstore.entities.Pet;
import com.progra3.petstore.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService{

    @Autowired
    private PetDao petDao;



    @Override
    public List<Pet> listAll() {

        return(List<Pet>) petDao.findAll();
    }

    @Override
    public Pet findById(Long id) {
        if(!petDao.existsById(id)){
            throw new NotFoundException("Mascota no fue encontrada");
        }
        return petDao.findById(id).orElse(null);
    }

    @Override
    public Pet createPet(Pet pet) {
        return petDao.save(pet);
    }

    @Override
    public Pet updatePet(Long id, Pet pet) {
        if(!petDao.existsById(id)){
            throw new NotFoundException("Mascota no fue encontrada");
        }
        Optional<Pet>actualizarPet= petDao.findById(id);
        actualizarPet.get().setId(id);
        actualizarPet.get().setName(pet.getName());
        actualizarPet.get().setPrice(pet.getPrice());
        actualizarPet.get().setBirthDay(pet.getBirthDay());

        return petDao.save(actualizarPet.get());
    }

    @Override
    public void deletePet(Long id) {
        if(!petDao.existsById(id)){
            throw new NotFoundException("Mascota no fue encontrada");
        }
            petDao.deleteById(id);
    }
}
