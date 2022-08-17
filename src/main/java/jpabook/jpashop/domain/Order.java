package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter @Setter
public class Order {
    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    //여기의 값이 바뀌면 FK의 값이 변경됨
    private Member member;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="delivery_id")//Fk설정
    private Delivery delivery;

    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)//enum타입을 String으로 설정(ordinal은 쓰지말것,숫자로 정의하는 거라 중간에 추가되면 에러발생
    private OrderStatus status; //주문상태 [ORDER,CANCEL],class가 아닌 enum으로 정의
    //enum 이란 관련이 있는 상수들의 집합,String과 같은 문자열이나 숫자들을 나타내는 기본 자료형의 값을 고정할수 있다.

    //==연관관계 메서드==//
    public void setMember(Member member){
        this.member = member;
    }
    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);
    }
}
