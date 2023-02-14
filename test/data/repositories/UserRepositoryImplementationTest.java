package data.repositories;

import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplementationTest {

    private UserRepository userRepository;

    private User user;

    @BeforeEach

    public void setUp(){
        userRepository = new UserRepositoryImplementation();
        user = new User("a", "b", " c", " d");
//        user.setFirstName("a");
//        user.setLastName("Tee");
//        user.setUserName("b");
//        user.setPassword("c");
    }

    @Test

    public void saveOneUserConfirmThatCountIsOneTest(){


        userRepository.save(user);
        assertEquals(1, userRepository.count());
    }

    @Test


    public void saveOneUserConfirmThatIdOfTheUserIsOneTest(){
        User savedUser = userRepository.save(user);

        assertEquals(1, savedUser.getId());
    }


    @DisplayName("Update User Test")
    @Test


    public void saveTwosUserConfirmThatIdOfTheUserIsStillOneTest(){
        User savedUser = userRepository.save(user);

        assertEquals(1, savedUser.getId());

        savedUser.setLastName("Tee");
        userRepository.save(savedUser);
        assertEquals(1, userRepository.count());
    }

    @Test


    public void saveOneUserAndFindByIdTest(){
        User savedUser = userRepository.save(user);

        assertEquals(1, savedUser.getId());

       User foundUser = userRepository.findById(1);

        assertEquals(foundUser, savedUser);
    }

    @Test


    public void saveOneUserDeleteUserAndConfirmThatItIsDeletedTest(){
        User savedUser = userRepository.save(user);

        assertEquals(1, userRepository.count());

        userRepository.delete(1);

        System.out.println(userRepository.findById(1));



        assertEquals(0, userRepository.count());
    }
@Test
    public void saveMultipleUserDeleteAllUsersAndConfirmThatTheyAreDeletedTest(){

        userRepository.save(user);

    user = new User("cc", "g", "r", "e");
    userRepository.save(user);
    user = new User("", "", "", "");
    userRepository.save(user);


        assertEquals(3, userRepository.count());

        userRepository.deleteAll();


        assertEquals(0, userRepository.count());
    }

}

