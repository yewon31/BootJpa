package com.example.jpa;

import com.example.jpa.entity.Memo;
import com.example.jpa.memo.repository.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class JPAQueryMethodTest03 {

    //쿼리메서드 JPA인터페이스의 메서드 모형을 보고, SQL을 대신 실행시킴 (다양한 select구문 활용)
    //https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testCode01() {

//        Memo m = memoRepository.findByWriterAndText("example10", "sample10");
//        System.out.println(m.toString());

        List<Memo> list = memoRepository.findByMnoLessThan(20L); //20보다 미만
        System.out.println(list.toString());
    }

    //    SELECT * FROM MEMO WHERE MNO = 11;
    @Test
    public void testCode02() {

        Memo m = memoRepository.findByMno(11L);
        System.out.println(m.toString());
    }

    //    SELECT * FROM MEMO WHERE MNO BETWEEN 10 AND 20;
    @Test
    public void testCode03() {

        List<Memo> list = memoRepository.findByMnoBetween(10L, 20L);
        System.out.println(list.toString());
    }
    //    SELECT * FROM MEMO WHERE WRITER LIKE '%10%';
    @Test
    public void testCode04() {

        List<Memo> list = memoRepository.findByWriterLike("%" + 10 + "%");
        System.out.println(list.toString());

    }
    //    SELECT * FROM MEMO WHERE WRITER = 'example1' ORDER BY WRITER DESC;
    @Test
    public void testCode05() {
        List<Memo> list = memoRepository.findByWriterOrderByWriterDesc("example1");
        System.out.println(list.toString());
    }
    //    SELECT * FROM MEMO WHERE MNO IN (10,20,30,40,50);
    @Test
    public void testCode06() {

        List<Memo> list = memoRepository.findByMnoIn( Arrays.asList(10L,20L,30L,40L,50L) );
        System.out.println(list.toString());
    }


    @Test
    public void testCode07() {
        //쿼리메서드 + 페이지 결합
        Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
        List<Memo> list = memoRepository.findByMnoLessThanEqual(50L, pageable);

        for(Memo m : list ) {
            System.out.println(m.toString());
        }


    }





}
