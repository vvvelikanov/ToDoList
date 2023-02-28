package ru.velikanov.todolist.persist.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.velikanov.todolist.persist.entity.ToDo;
import ru.velikanov.todolist.repr.ToDoRepr;

import java.util.List;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo,Long> {

    @Query("select new ru.velikanov.todolist.repr.ToDoRepr(t) from ToDo t " +
            "where t.user.id = :userId")
    List<ToDoRepr> findToDosByUserId(@Param("userId") Long userId);
}
