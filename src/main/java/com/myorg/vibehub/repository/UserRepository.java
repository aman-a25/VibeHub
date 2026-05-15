package com.myorg.vibehub.repository;
import com.myorg.vibehub.enums.Gender;
import com.myorg.vibehub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
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
    // and that is something that we don't need Who's recommended

    Optional<User> findByUserName (String username);

    //find by name with like operator

    List<User> findByNameContaining(String name);

    List<User> findByNameContainingAndGender(String name , Gender gender);
    // First of all here we are concatenating two queries
    // basically find object of Us where the name contains the given string and the Gender is as given

    // But there is a important point to be noticed Gender was an enum in our entire project but now we are treating it as string
    // The reason is simply that Hibernate does not understands or works with enums so we have to convert them into String

// JPQL Java persistence Query Language

//    // native sql query
//    @Query(
//            value = "SELECT*FROM users u WHERE u.name LIKE %:name% AND u.gender = :gender",
//            nativeQuery = true
//    )
//    List<User> findByNameAndGender(@Param("name") String name,
//                                   @Param("gender") Gender gender);
//


    // now JPQL query for that exact sql query
        @Query(
            "SELECT u FROM User u WHERE u.name LIKE %:name% AND u.gender = :gender"
    )
    List<User> findByNameAndGender(@Param("name") String name,
                                   @Param("gender") Gender gender);

    // HOMEWORK
    // people who have @gmail.com in the end of there Emailid
        @Query(
                "SELECT q FROM User q WHERE Q.email LIKE %'@gmail.com'"
        )
    List<User> findByEmail();
}

