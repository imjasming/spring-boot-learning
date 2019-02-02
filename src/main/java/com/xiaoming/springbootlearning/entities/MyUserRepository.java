package com.xiaoming.springbootlearning.entities;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Xiaoming.
 * Created on 2018/11/22 11:30.
 * Description :This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
 * CRUD refers Create, Read, Update, Delete
 */
public interface MyUserRepository extends CrudRepository<MyUser, Long> {

    MyUser findMyUserByNickNameAndPassword(String nickname, String password);

    MyUser findMyUserByIdAndAndPassword(Long id, String password);
}
