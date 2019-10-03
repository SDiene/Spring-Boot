package com.tranfertmoney.tranfertmoney.repository;

import com.tranfertmoney.tranfertmoney.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;


@Repository
// finbBy est la mais ce qui suit doit etre un attribut qui se trouve dans la classe
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    //@Query("SELECT u FROM User  WHERE u.login IS NULL") // Requette IPQL
    //public List<User> USERS();
}