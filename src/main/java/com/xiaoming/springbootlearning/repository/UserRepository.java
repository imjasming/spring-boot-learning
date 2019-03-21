package com.xiaoming.springbootlearning.repository;

import com.xiaoming.springbootlearning.domain.XmsUser;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Xiaoming.
 * Created on 2018/11/22 11:30.
 * Description :This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
 * CRUD refers Create, Read, Update, Delete
 */
public interface UserRepository extends CrudRepository<XmsUser, Long> {

    XmsUser findByUsername(String username);

    XmsUser findUserByUsernameAndPassword(String username, String password);

    XmsUser findUserByIdAndAndPassword(Long id, String password);
}
