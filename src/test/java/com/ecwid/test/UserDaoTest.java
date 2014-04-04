package com.ecwid.test;

import com.ecwid.project.dao.UserDao;
import com.ecwid.project.init.Initializer;
import com.ecwid.project.init.WebAppConfig;
import com.ecwid.project.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Roman on 16.03.14.
 */

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {Initializer.class,
        WebAppConfig.class})

public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    private User createUser() {
        User user = new User();
        user.setFirstName("Roman");
        user.setLastName("Platonov");
        user.setPhoneNumber("222-22-22");
        return user;
    }


    @Test
    public void testCRUD() throws SQLException {
        User user = createUser();
        userDao.save(user);
        assertEquals(userDao.findById(user.getId()).getFirstName(), "Roman");
        user.setFirstName("A");
        userDao.save(user);
        assertEquals(userDao.findById(user.getId()).getFirstName(), "A");
        userDao.delete(user);
        assertNull(userDao.findById(user.getId()));
    }


    /*@Test
    public void testFindAll() throws SQLException {
        List<User> users = userDao.findAll();
        assertNotNull(users);
        assertFalse(users.isEmpty());
        for (User user : users) {
            assertNotNull(user);
            assertNotNull(user.getId());
        }
    }*/


}
