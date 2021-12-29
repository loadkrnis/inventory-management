package jpabook.jpashop;

import lombok.Getter;
import lombok.Setter;

public class Hello {
    public Hello(String data) {
        this.data = data;
    }

    @Getter
    @Setter
    private String data;
}
