package com.example.demo.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Interest;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface InterestRepo extends CrudRepository<Interest, Integer> {


}