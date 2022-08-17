package jpabook.jpashop.domain;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name ="member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;
    @OneToMany(mappedBy = "member")//주인이 아니고 연관관계의 거울(order테이블에 있는 member필드에 의해 매핑이됨)
    //여기 값을 넣는다고 해서 FK의 값이 바뀌지 않음
    private List<Order> orders = new ArrayList<>();
}
