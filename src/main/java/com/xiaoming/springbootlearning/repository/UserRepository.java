package com.xiaoming.springbootlearning.repository;

import com.xiaoming.springbootlearning.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author Xiaoming.
 * Created on 2018/11/22 11:30.
 * Description :This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
 * CRUD refers Create, Read, Update, Delete
 */
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

    User findUserByUsernameAndPassword(String username, String password);

    User findUserByIdAndAndPassword(Long id, String password);
}
