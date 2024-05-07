package org.abbtech.practice.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.abbtech.practice.Entity.User;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    @Getter
    private String title;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 100)
    private String content;
    private User user;
}
