package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
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

    //==비지니스 로직==//

    //stack 증가
    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }

    public void  removeStock(int quantity){
        int restStock = this.stockQuantity = quantity;
        if(restStock < 0 ){
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
