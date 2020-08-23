package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//객체와 레파지토리를 매핑 한다 -> JPA
@Entity
public class Member {

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;//db가 알아서 생성 -> identity

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
