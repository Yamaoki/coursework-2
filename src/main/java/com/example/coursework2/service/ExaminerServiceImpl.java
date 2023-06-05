package com.example.coursework2.service;

import com.example.coursework2.Question;
import com.example.coursework2.exception.BadQuestionsAmountException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount){

        Question q;
        List<Question> questionList = new ArrayList<>();

        if (amount > javaQuestionService.getSize() || amount <= 0) {
            throw new BadQuestionsAmountException();
        } else {
            while (questionList.size() != amount) {
                q = javaQuestionService.getRandomQuestion();
                if (!questionList.contains(q)) {
                    questionList.add(q);
                }
            }
            return questionList;
        }
    }
}
