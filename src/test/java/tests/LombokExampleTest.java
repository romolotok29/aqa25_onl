package tests;

import configuration.ReadProperties;
import lombok.val;
import models.User;
import models.UserBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class LombokExampleTest {

    @Test
    public void simpleTest() {
        User user = new User();
        user.setFirstName("Michael");
        user.setLastName("Williams");
        user.setUsername("someUsername");
        user.setPassword("somePassword");
        user.setPostalCode("102030");

        System.out.println(user);
    }

    @Test
    public void equalsAndHashCode() {
        User user1 = new User();
        user1.setFirstName("Michael");
        user1.setLastName("Williams");
        user1.setPostalCode("102030");

        User user2 = new User();
        user2.setFirstName("John");
        user2.setLastName("Doe");
        user2.setPostalCode("103040");

        Assert.assertTrue(user1.equals(user2));
    }

    @Test
    public void builderTest() {
        UserBuilder user = UserBuilder
                .builder()
                .username(ReadProperties.getUsername())
                .password(ReadProperties.getPassword())
                .firstName("Marco")
                .lastName("Fibonacci")
                .postalCode("103040")
                .build();

        UserBuilder user2 = UserBuilder
                .builder()
                .username(ReadProperties.getUsername())
                .password(ReadProperties.getPassword())
                .firstName("Marco")
                .lastName("Fibonacci")
                .postalCode("103040")
                .build();

        System.out.println(user.toString());
        Assert.assertTrue(user.equals(user2));
    }

    @Test
    public void valTest() {
        val list = new ArrayList<String>();
        list.add("Test Value");
        System.out.println(list.get(0));
    }

    @Test
    public void varTest() {
        var list = new ArrayList<String>();
        list.add("Test Value");
        System.out.println(list.get(0));
    }

}
