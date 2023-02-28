package ru.velikanov.todolist.repr;

//import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import ru.velikanov.todolist.persist.entity.ToDo;

import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ToDoRepr {

    private long id;

    @NotEmpty
    private String description;

    private String username;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate targetDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ToDoRepr(){

    }

    public ToDoRepr(ToDo toDo){
        this.id = toDo.getId();
        this.description = toDo.getDescription();
        this.targetDate = toDo.getTargetDate();
        this.username = toDo.getUser().getUsername();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }
}
