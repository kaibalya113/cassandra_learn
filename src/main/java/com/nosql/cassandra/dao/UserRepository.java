package com.nosql.cassandra.dao;

import com.nosql.cassandra.model.User;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CassandraRepository<User, Integer> {

    List<User> getByName(String name);

    List<User> getUserFilterByAge(int age);

    @AllowFiltering
    List<User> getUserFilterByName(String name);

    List<User> findByAge(int age);

    @AllowFiltering
    List<User> findByAgeGreaterThan(int age);
}
