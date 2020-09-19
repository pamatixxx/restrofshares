package io.sudarykov.liqubasefirs;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PersonRepository extends CrudRepository<Person , Integer> {

    @Query("SELECT name  FROM Person p WHERE p.name like %:personName%")
    String findByName(String personName);
}
