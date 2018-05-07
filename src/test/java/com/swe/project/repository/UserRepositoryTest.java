package com.swe.project.repository;

import com.swe.project.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import  org.junit.Assert;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private  UserRepository userRepository;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findByUsername() throws Exception {
        User user = new User("Abdo");
        testEntityManager.persist(user);
        testEntityManager.flush();

        User found = userRepository.findByUsername("Abdo");
        assert (found.username.equals(user.username));
    }

    @Test
    public void findByEmail() throws Exception {
    }

    @Test
    public void existsByEmail() throws Exception {
    }

    @Test
    public void existsByUsername() throws Exception {
    }

}