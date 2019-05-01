package com.mhalab.eve;

import com.mhalab.eve.model.Person;
import com.mhalab.eve.model.Task;
import com.mhalab.eve.model.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void saveTask() {
        Person owner = new Person("Michał", "Hauzer");
        entityManager.persistAndFlush(owner);

        Task task = new Task("Write an article", owner);
        entityManager.persistAndFlush(task);

        assertThat(task.getId()).isNotNull();
    }

    @Test
    public void deleteTasks() {
        Person owner = new Person("Michał", "Hauzer");
        entityManager.persistAndFlush(owner);

        Task task = new Task("Write an article", owner);
        entityManager.persistAndFlush(task);

        task = new Task("Play a game", owner);
        entityManager.persistAndFlush(task);

        taskRepository.deleteAll();

        assertThat(taskRepository.findAll()).isEmpty();

    }
}
