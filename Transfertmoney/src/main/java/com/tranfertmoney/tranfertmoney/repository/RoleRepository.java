package com.tranfertmoney.tranfertmoney.repository;

import com.tranfertmoney.tranfertmoney.model.Role;
import com.tranfertmoney.tranfertmoney.model.RoleNom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByNom(RoleNom roleNom);
}
