package org.abbtech.practice.DTO;

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
public class PostDTO {
    @Size(min = 3, max = 20)
    private String title;
    @Size(min = 30, max = 150)
    private String content;
}
