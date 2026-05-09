package com.myorg.vibehub.repository;
import com.myorg.vibehub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    // We do not have to define methods for most of the CRUD operation
    // Because those methods are given to us by JPA repository Those are predefined methods by JPA Repository

    // But there are some situations when we actually need to create our own methods
    // In those situation we use custom Finder methods

    //Custom Finder methods

    // find user by username
//    although userName is in camelcase but we are going to use UserName when we create custom finder method

   // List<User> findByUserName (String username);

    // But as we know that username is a unique entity
    // Hence We know that We're never going to receive More than one user entity

    //User findByUserName (String username);


//    User findByUserName (String username);

    // The previous line was almost correct but
    // it handles exception on repository layer
    // and that is something that we don't need

    Optional<User> findByUserName (String username);

}
