package jpabook.jpashop.domain;


import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable //Address클래스를 값타입 객체를 엔티티로 승격하여도 되지만,값타입의 엔티티 승격은 식별자(id)와 지속적인 추적이 필요한 경우에 진행해야한다.예제에서의 주소는 잘 변하지 않는 데이터로 간주하여 값타입으로 설계하였다.
@Getter //참고: 값 타입은 변경 불가능하게 설계해야 한다.
// @Setter 를 제거하고, 생성자에서 값을 모두 초기화해서 변경 불가능한 클래스를 만들자
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() {
    }
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
