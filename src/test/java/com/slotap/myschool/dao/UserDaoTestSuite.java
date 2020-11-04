package com.slotap.myschool.dao;

import com.slotap.myschool.model.User;
import com.slotap.myschool.model.UserRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserDaoTestSuite {
    @Autowired
    private UserDao userDao;

    @Test
    void testUserFindByRole() {
        //Given
        User user = new User("Maryla","Rodowicz","84010111111", "user@gmail.com","ul. Grodzka 1, Kraków", UserRole.TEACHER);
        User user2 = new User("Jacek","Cygan","85010111111", "user1@gmail.com","ul. Nowa 3, Kielce", UserRole.PARENT);
        userDao.save(user);
        userDao.save(user2);

        //When
        List<User> readUser = userDao.findUsersByRole(UserRole.TEACHER);

        //Then
        Assertions.assertEquals(readUser.get(0).getRole(), UserRole.TEACHER);

        //CleanUp
        userDao.delete(user);
        userDao.delete(user2);
    }
}
