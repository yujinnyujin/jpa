package hellojpa;

import jakarta.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    //아이덴티티 전략에서는 내가 이 아이디에 값을 넣으면 안 돼요
    //그리고 db에 인서트를 해야 된단 말이에요
    //그러면 db에서 null로 인서트 쿼리가 날라오면 그 때 db에서 값을 세팅을 해줍니다
    //이게 문제인 이유는 아이디 값을 알 수 있는 시점이 언제냐면,
    //db에 들어가봐야 id값을 알 수가 있어요
    //예외적으로 em.persist 호출 시점에 바로 db에 insert query를 날려버립니다

    @Column(name = "name", nullable = false)
    private String username;

    public Member() {
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

