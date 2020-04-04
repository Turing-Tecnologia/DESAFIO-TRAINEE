package io.github.lucasnr.turingtodo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.github.lucasnr.turingtodo.model.Task;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class TaskDTO {

    private Integer id;
    @NotEmpty
    @NotNull
    private String title;
    private String text;
    private LocalDateTime datetime;
    private boolean done;

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.text = task.getText();
        this.datetime = task.getDateTime();
        this.done = task.isDone();
    }

    public Task build() {
        Task task = new Task();
        task.setTitle(this.title);
        task.setText(this.text);
        task.setDateTime(this.datetime);
        return task;
    }
}
