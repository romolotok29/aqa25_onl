package models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@EqualsAndHashCode
@ToString
public class UserBuilder {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String postalCode;
}
