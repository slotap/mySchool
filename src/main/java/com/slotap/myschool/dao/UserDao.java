package com.slotap.myschool.dao;

import com.slotap.myschool.model.User;
import com.slotap.myschool.model.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
interface UserDao extends CrudRepository<User,Long> {
    List<User> findUsersByRole(UserRole roleValue);
}
