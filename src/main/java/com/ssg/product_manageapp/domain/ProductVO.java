package com.ssg.product_manageapp.domain;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {
    private Long pno;
    private String pname;
    private int price;
    private int amount;
}
