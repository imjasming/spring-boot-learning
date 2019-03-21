package com.xiaoming.springbootlearning.repository;

import com.xiaoming.springbootlearning.domain.UmUser;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Xiaoming.
 * Created on 2018/11/22 11:30.
 * Description :This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
 * CRUD refers Create, Read, Update, Delete
 */
public interface UserRepository extends CrudRepository<UmUser, Long> {

    UmUser findByUsername(String username);

    UmUser findUserByUsernameAndPassword(String username, String password);

    UmUser findUserByIdAndAndPassword(Long id, String password);
}
