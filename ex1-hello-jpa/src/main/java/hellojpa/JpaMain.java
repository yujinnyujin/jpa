package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Member member = new Member();
            member.setId(2L);
            member.setUsername("B");
            member.setRoleType(RoleType.ADMIN);

            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
        finally {
            em.close();
        }
        emf.close();
    }
}

//EntityManagerFactory는 DB당 하나만 생성해서 애플리케이션 전체에서 공유
//EntityManager는 쓰레드간에 절대 공유해선 안 됨
//JPA의 모든 데이터 변경은 트랜잭션 안에서 실행해야 함
