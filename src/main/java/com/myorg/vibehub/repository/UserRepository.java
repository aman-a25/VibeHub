package com.myorg.vibehub.repository;
import com.myorg.vibehub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    // We do not have to define methods for most of the CRUD operation
    // Because those methods are given to us by JPA repository Those are predefined methods by JPA Repository

    // But there are some situations when we actually need to create our own methods
    // In those situation we use custom Finder methods

    //Custom Finder methods

    //Here the reason why we are only receiving a single entity of user
    // is because in entity model of User we have defined that username is also a unique entity
    // Otherwise we can receive list of user
    User findByuserName (String username);

}
