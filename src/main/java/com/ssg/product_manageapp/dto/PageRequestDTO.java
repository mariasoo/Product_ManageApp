package com.ssg.product_manageapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.Arrays;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Builder.Default // 제약조건 걸기!!!
    @Min(value = 1)  // 페이지 최솟값은 1
    @Positive // 음수 들어가면 안되니까 포지티브
    private int page = 1; // 1페이지부터 시작

    @Builder.Default
    @Min(value = 10) // 페이지 사이즈 10
    @Max(value = 100) //최대 100개까지 조정할 수 있다
    @Positive
    private int size = 10;

    private String link;
    private String[] types;
    private String keyword;
    private boolean finished;
    private LocalDate from;
    private LocalDate to;

    public int getSkip() {
        return (page - 1) * 10;
    }
    // limit에서 사용하는 건너뛰기 (skip) 수를 위해

    public String getLink() {
        if (link == null) {
            StringBuilder builder = new StringBuilder();
            builder.append("page=" + this.page);
            builder.append("&size=" + this.size);
            link = builder.toString();
        }
        return link;
    }
    public boolean checkType(String type) {
        if (types == null || types.length == 0) {
            return false;
        }
        return Arrays.stream(types).anyMatch(type::equals);
    }
}
