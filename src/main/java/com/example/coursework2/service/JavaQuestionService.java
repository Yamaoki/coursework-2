package com.example.coursework2.service;

import com.example.coursework2.Question;
import com.example.coursework2.exception.NotCorrectQuestionException;
import com.example.coursework2.exception.QuestionAlreadyAddedException;
import com.example.coursework2.exception.QuestionNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final List<Question> questionList;

    public JavaQuestionService() {
        this.questionList = new ArrayList<>();
    }

    @Override
    public Question add(String question, String answer) {

        Question q;

        if (!question.equals(answer)) {
            q = new Question(question,answer);
        } else {
            throw new NotCorrectQuestionException();
        }

        if (!questionList.contains(q)){
            questionList.add(q);
            return q;
        } else {
            throw new QuestionAlreadyAddedException();
        }
    }
    @Override
    public Question remove(String question, String answer) {

        Question q = new Question(question,answer);

        if (questionList.contains(q)) {
            questionList.remove(q);
            return q;
        } else {
            throw new QuestionNotFoundException();
        }
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questionList);
    }

    @Override
    public Question getRandomQuestion() {

        Random random = new Random();
        return questionList.get(random.nextInt(questionList.size()));
    }
    @Override
    public int getSize(){
        return questionList.size();
    }
}
