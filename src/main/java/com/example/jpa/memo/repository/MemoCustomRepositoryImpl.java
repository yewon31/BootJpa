package com.example.jpa.memo.repository;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class MemoCustomRepositoryImpl implements MemoCustomRepository {

    @PersistenceContext //엔티티 매니저를 주입을 받을 때 사용하는 어노테이션
    private EntityManager entityManager;

    @Override
    @Transactional //update구문이므로
    public int updateTest(String writer, long mno) {
        //기존에 인터페이스를 통해서 처리하던 JPQL구문을 직접 작성이 가능합니다.

        String sql = "update Memo m set m.writer = :a where m.mno = :b"; //JPQL

        Query query = entityManager.createQuery(sql);
        query.setParameter("a", writer); //a파라미터에 writer를 채움
        query.setParameter("b", mno);

        int result = query.executeUpdate(); //insert, update, delete구문을 실행할 때 사용

        return result;
    }
}
