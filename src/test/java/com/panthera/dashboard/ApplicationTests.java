package com.panthera.dashboard;

import com.panthera.configuration.Application;
import com.panthera.model.UserInfo;
import com.panthera.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Profile("dev")
public class ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    private UserInfo user;

    @Test
    public void contextLoads() {
    }

    @Before
    public void create() {

    }

}
