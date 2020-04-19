package io.github.lucasnr.turingtodo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class TaskUpdateDTO {

    private String text;
    private LocalDateTime datetime;
    private boolean done;
}
