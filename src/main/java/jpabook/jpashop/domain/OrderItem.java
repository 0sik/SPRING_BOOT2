package jpabook.jpashop.domain;


import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter @Setter
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")//FK로 저장
    private Item item;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id") //FK로 지정
    private Order order;

    private int orderPrice;//주분 가격
    private int count; //주문 수량
}
