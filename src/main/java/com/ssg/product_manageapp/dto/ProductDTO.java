package com.ssg.product_manageapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long pno;

    @Size(min=1,max=100)
    private String pname;

    @PositiveOrZero
    @Max(1000000)
    private int price;

    @PositiveOrZero
    @Max(99999)
    private int amount;

}
