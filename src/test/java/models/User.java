package models;

import lombok.*;

@Getter
@Setter
@ToString(exclude = {"password", "username"})
@EqualsAndHashCode(exclude = {"password", "username"})
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String postalCode;
}