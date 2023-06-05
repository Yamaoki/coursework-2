package com.example.coursework2;

import com.example.coursework2.service.ExaminerServiceImpl;
import com.example.coursework2.service.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.coursework2.base.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionServiceImplMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    @BeforeEach
    public void beforeEach(){
        when(javaQuestionServiceImplMock.getSize()).thenReturn(3);
    }

    @Test
    public void shouldReturnCorrectQuestionList(){
        when(javaQuestionServiceImplMock.getRandomQuestion()).thenReturn(QUESTION_1,QUESTION_2,QUESTION_3);
        assertEquals(QUESTION_LIST,out.getQuestions(3));
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenBadQuestionsAmountRequested() {
        assertThrows(RuntimeException.class,
                () -> out.getQuestions(4)
        );
    }
}
