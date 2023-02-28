package ru.velikanov.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.velikanov.todolist.persist.entity.ToDo;
import ru.velikanov.todolist.persist.entity.User;
import ru.velikanov.todolist.persist.repo.ToDoRepository;
import ru.velikanov.todolist.persist.repo.UserRepository;
import ru.velikanov.todolist.repr.ToDoRepr;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static ru.velikanov.todolist.service.UserService.getCurrentUser;

@Service
@Transactional
public class ToDoService {

    private ToDoRepository toDoRepository;

    private UserRepository userRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository, UserRepository userRepository) {
        this.toDoRepository = toDoRepository;
        this.userRepository = userRepository;
    }

    public Optional<ToDoRepr> findById(Long id){
        return toDoRepository.findById(id)
                .map(ToDoRepr::new);
    }

    public List<ToDoRepr>findTodosByUserId(Long userId){
        return toDoRepository.findToDosByUserId(userId);
    }

    public void save(ToDoRepr toDoRepr){
        Optional<String> currentUser = getCurrentUser();
        if (currentUser.isPresent()){
            Optional<User> optUser = userRepository.getUserByUsername(currentUser.get());
            if (optUser.isPresent()){
                ToDo toDo = new ToDo();
                toDo.setId(toDoRepr.getId());
                toDo.setDescription(toDoRepr.getDescription());
                toDo.setTargetDate(toDoRepr.getTargetDate());
                toDo.setUser(optUser.get());
                toDoRepository.save(toDo);
            }
        }

    }

    public void delete(Long id){
        toDoRepository.findById(id)
                .ifPresent(toDo -> toDoRepository.delete(toDo));
    }
}
