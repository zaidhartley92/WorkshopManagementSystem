package com.example.demo.MODEL;

import com.example.demo.DTO.BayDTO;
import com.example.demo.REPOSITORY.BayRepository;
import com.example.demo.SERVICE.BayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;


//import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BayTestClass{


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BayRepository bayRepository;



    @Test
    public void findBayByName() {
        // given
        Bay bay = new Bay("Muhammad amer","323b","Rasool");
        entityManager.persist(bay);
        entityManager.flush();
        // when
        Bay found = bayRepository.findByName(bay.getName());
        // then
        assertEquals(found.getName(),bay.getName());
    }

}
