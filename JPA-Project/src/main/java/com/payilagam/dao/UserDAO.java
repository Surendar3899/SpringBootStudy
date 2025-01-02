package com.payilagam.dao;

import org.springframework.data.repository.CrudRepository;

import com.payilagam.model.User;

public interface UserDAO extends CrudRepository<User, Integer>{

}
