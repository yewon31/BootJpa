package com.example.jpa;

import com.example.jpa.entity.Member;
import com.example.jpa.member.repository.MemberRepository;
import com.example.jpa.memo.repository.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPACumtomTest05 {

    @Autowired
    MemoRepository memoRepository; //메모

    @Autowired
    MemberRepository memberRepository; //멤버

//    @Test
//    public void testCode01() {
//        int result = memoRepository.updateTest("구현체를 통해 update", 15L);
//        System.out.println("성공실패:" + result);
//    }

    //Member테이블의 예시데이터 삽입
//    @Test
//    public void testCode02() {
//
//        for( int i = 1; i <= 5; i++) {
//
//            memberRepository.save(
//                    Member.builder()
//                            .id("abc" + i)
//                            .name("admin" + i)
//                            .build()
//                            //sign_date는 JPA대신해서 데이터를 삽입
//            );
//        }
//    }

}
