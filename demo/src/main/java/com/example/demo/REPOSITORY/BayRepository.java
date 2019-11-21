package com.example.demo.REPOSITORY;

import com.example.demo.MODEL.Bay;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import pt.modal.BayModel;

@Repository
//@Qualifier("BayNewRepository")
public interface BayRepository extends JpaRepository<Bay,Long> {
     Bay findByName(String name);
}

