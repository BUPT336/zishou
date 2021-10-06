package com.marfei.site.controller;

import com.marfei.site.dao.CountNoteRepository;
import com.marfei.site.model.Author;
import com.marfei.site.model.CountNote;
import com.marfei.site.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

/**
 * @author Litch1
 * @date 2021/5/5 6:31 下午
 */

@RestController
public class CountNoteController {

    @Autowired
    private CountNoteRepository countNoteRepository;
    @PostMapping("/addCountNote")
    public Response addCountNote(String note,String author,String type) {
        try {
            if (author != null && (author.equals("feifei") || author.equals("litch1"))) {
                CountNote countNote = new CountNote();
                countNote.setAuthor(Author.valueOf(author));
                countNote.setNote(note);
                countNote.setType(type);
                countNote.setDate(new Date());
                countNoteRepository.save(countNote);
                return new Response(200, new String("success"));
            } else {
                return new Response(500, new String("not match author"));
            }
        }catch (Exception e){
            return new Response(500, e.getMessage());
        }
    }
    @RequestMapping("/getCountNotes")
    public Response getCountNotes(String author,String type, @RequestParam(defaultValue = "0") int pageNum,@RequestParam(defaultValue = "3") int pageSize) {
        HashMap<String,Object> map = new HashMap<>();
        try {
            Page<CountNote> countNotesPage = null;
            Sort dateSort = Sort.by(Sort.Direction.DESC, "date");
            PageRequest pageRequest = PageRequest.of(pageNum,pageSize,dateSort);
            if (author != null && type != null && (author.equals("feifei") || author.equals("litch1"))) {
                countNotesPage = countNoteRepository.getByAuthorAndType(Author.valueOf(author),type,pageRequest);
            } else {
                countNotesPage = countNoteRepository.findAll(pageRequest);
            }
            map.put("count", countNotesPage.getTotalElements());
            map.put("pageSize", countNotesPage.getTotalPages());
            map.put("countNotes", countNotesPage.get().toArray());
            return new Response(200, map);
        }catch (Exception e){
            return new Response(500, e.getMessage());
        }
    }
}
