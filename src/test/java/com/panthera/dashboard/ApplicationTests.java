package com.panthera.dashboard;

import com.panthera.configuration.Application;
import com.panthera.model.UserInfo;
import com.panthera.repository.UserRepository;
import static org.assertj.core.api.Assertions.assertThat;
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
        UserInfo userInfoD = new UserInfo();
        userInfoD.setFirstName("Mahesh");
        userInfoD.setLastName("Patel");
        userInfoD.setEmail("patelmahesh1618@gmail.com");
        // user = userRepository.save(userInfoD);

        assertThat(user.getCreatedBy())
                .isNotNull();

        assertThat(user.getLastModifiedBy())
                .isNotNull();

        assertThat(user.getCreatedBy())
                .isEqualTo("Mahesh");

        assertThat(user.getLastModifiedBy())
                .isEqualTo("Mahesh");
    }

}
