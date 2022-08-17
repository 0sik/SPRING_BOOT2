package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//table하나에 다 넣는 방법
@DiscriminatorColumn(name="dtype") //Album(A),Movie(M),Book(B)중 무엇을 선택했는지 나오는 방법
@Getter @Setter
public abstract class Item {//추상클래스로 만들기 (abstract)
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items",fetch = FetchType.LAZY)
    private List<Category> categoryies = new ArrayList<>();
}
