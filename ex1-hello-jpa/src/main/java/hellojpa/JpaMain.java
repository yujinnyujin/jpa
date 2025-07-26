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
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

            //전체 회원 조회
            List<Member> result = em.createQuery("select m from Member as m", Member.class).getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }


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
