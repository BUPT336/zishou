package com.marfei.site.dao;

import com.marfei.site.model.Author;
import com.marfei.site.model.CountNote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Litch1
 * @date 2021/5/5 7:36 下午
 */
public interface CountNoteRepository extends JpaRepository<CountNote,String> {
    Page<CountNote> getByAuthorAndType(Author author,String type,Pageable pageable);
}
