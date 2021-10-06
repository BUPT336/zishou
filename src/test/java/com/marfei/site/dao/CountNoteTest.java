package com.marfei.site.dao;

import com.marfei.site.model.Author;
import com.marfei.site.model.CountNote;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Litch1
 * @date 2021/5/5 7:38 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CountNoteTest {
    @Autowired
    private CountNoteRepository countNoteRepository;
    @Test
    public void testAddCountNote(){
        CountNote countNote = new CountNote();
        countNote.setAuthor(Author.litch1);
        countNote.setNote("狒狒是十佳学生");
        countNote.setAuthor(Author.feifei);
        countNote.setNote("狒狒是十佳学生");
        countNoteRepository.save(countNote);
    }
}
