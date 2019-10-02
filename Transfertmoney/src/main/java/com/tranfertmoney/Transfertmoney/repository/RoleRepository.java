package com.tranfertmoney.Transfertmoney.repository;

import com.tranfertmoney.Transfertmoney.model.Role;
import com.tranfertmoney.Transfertmoney.model.RoleNom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByNom(RoleNom roleNom);
}