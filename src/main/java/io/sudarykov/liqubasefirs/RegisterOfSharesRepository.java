package io.sudarykov.liqubasefirs;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository

public interface RegisterOfSharesRepository extends CrudRepository<RegisterOfShares, String> {


    @Query("SELECT usrpow  FROM RegisterOfShares p")
    String findAll(String usrpow);


    @Query("SELECT  usrpow  FROM RegisterOfShares p ")
    String findFirstBy(String id);
}

