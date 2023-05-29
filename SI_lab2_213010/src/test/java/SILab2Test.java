import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    void testEveryBranch(){
        RuntimeException ex;
        List<User> allUsers = new ArrayList<>();
        allUsers.add(new User("user209","password$876","user209@gmail.com"));
        allUsers.add(new User("filip123","lozinka#567","filip@gmail.com"));

        assertFalse(SILab2.function(new User("filip123","lozinka#567","filip@gmail.com"),allUsers));
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null,allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        assertFalse(SILab2.function(new User(null,"0123","randommail"),allUsers));
        assertFalse(SILab2.function(new User(null,"01 23","randommail"),allUsers));
        assertFalse(SILab2.function(new User(null,"password0123","randommail"),allUsers));
    }

    @Test
    void testMultipleCondition(){
//        Multiple Condition
//        1. T||X||X → user = null, user.password = X, user.email = X
//        2. F||T||X → user != null, user.password = null, user.email = X
//        3. F||F||T → user != null, user.password != null, user.email = null
//        4. F||F||F → user != null, user.password != null, user.email != null
        List<User> allUsers = new ArrayList<>();
        allUsers.add(new User("user209","password$876","user209@gmail.com"));
        allUsers.add(new User("filip123","lozinka#567","filip@gmail.com"));
        RuntimeException ex;

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null,allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("username",null,"random"),allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("username","password",null),allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        assertFalse(SILab2.function(new User("filip123","lozinka#567","filip@gmail.com"),allUsers));
    }
}
