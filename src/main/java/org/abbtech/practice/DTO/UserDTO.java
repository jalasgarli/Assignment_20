package org.abbtech.practice.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotNull
    @NotBlank
    @Size(min = 7, max = 15)
    private String username;

    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 10, max = 15)
    @Pattern(regexp = "^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{10,}$")
    private String password;
}
