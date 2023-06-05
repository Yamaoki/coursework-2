package com.example.coursework2;

import com.example.coursework2.service.JavaQuestionService;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static com.example.coursework2.base.*;
import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    private final JavaQuestionService out = new JavaQuestionService();

    @Test
    public void shouldReturnCorrectQuestionAfterAdd() {
        Question result = out.add(QUESTION_TEXT_1, ANSWER_TEXT_1);
        assertEquals(QUESTION_1, result);
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenTryingToAddExistQuestion() {
        out.add(QUESTION_TEXT_1, ANSWER_TEXT_1);
        assertThrows(RuntimeException.class,
                () -> out.add(QUESTION_TEXT_1, ANSWER_TEXT_1)
        );
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenTryingToAddNotCorrectQuestion() {
        assertThrows(RuntimeException.class,
                () -> out.add(QUESTION_TEXT_1, QUESTION_TEXT_1)
        );
    }

    @Test
    public void shouldReturnCorrectQuestionAfterRemove() {
        out.add(QUESTION_TEXT_1, ANSWER_TEXT_1);
        Question result = out.remove(QUESTION_TEXT_1, ANSWER_TEXT_1);
        assertEquals(QUESTION_1, result);
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenTryingToRemoveNotExistQuestion() {
        assertThrows(RuntimeException.class,
                () -> out.remove(QUESTION_TEXT_1, ANSWER_TEXT_1)
        );
    }

    @Test
    public void shouldReturnCorrectQuestionList() {

        out.add(QUESTION_TEXT_1, ANSWER_TEXT_1);
        out.add(QUESTION_TEXT_2, ANSWER_TEXT_2);
        out.add(QUESTION_TEXT_3, ANSWER_TEXT_3);

        Collection<Question> result = out.getAll();
        assertIterableEquals(QUESTION_LIST, result);
    }

    @Test
    public void shouldReturnCorrectRandomQuestion() {
        out.add(QUESTION_TEXT_1, ANSWER_TEXT_1);
        out.add(QUESTION_TEXT_2, ANSWER_TEXT_2);
        out.add(QUESTION_TEXT_3, ANSWER_TEXT_3);
        Question q = out.getRandomQuestion();
        boolean result = (q.equals(QUESTION_1) | q.equals(QUESTION_2) | q.equals(QUESTION_3));
        assertTrue(result);
    }
    @Test
    public void shouldReturnCorrectListSize() {
        out.add(QUESTION_TEXT_1, ANSWER_TEXT_1);
        out.add(QUESTION_TEXT_2, ANSWER_TEXT_2);
        out.add(QUESTION_TEXT_3, ANSWER_TEXT_3);
        int result = out.getSize();
        assertEquals(3, result);
    }
}
