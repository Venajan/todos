package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void shouldFindQueryInSimpleTaskTrue() {
        Task simpleTask = new SimpleTask(1, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInSimpleTaskFalse() {
        Task simpleTask = new SimpleTask(1, "Позвонить родителям");

        boolean expected = false;
        boolean actual = simpleTask.matches("позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInEpicTrue() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Мясо", "Масло"};
        Task epic = new Epic(31, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Хлеб");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInEpicFalse() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Мясо", "Масло"};
        Task epic = new Epic(31, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("яйца");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInMeetingTrue() {
        Task meeting = new Meeting(
                17,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("версии");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInMeetingFalse() {
        Task meeting = new Meeting(
                17,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("во");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInTaskFalse() {
        Task task = new Task(31);

        boolean expected = false;
        boolean actual = task.matches("Молоко");

        Assertions.assertEquals(expected, actual);
    }

}
