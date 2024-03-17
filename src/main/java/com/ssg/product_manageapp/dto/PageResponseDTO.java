package com.ssg.product_manageapp.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {
    private int page; // vo에 담았던 페이지 skip
    private int size; // 전체 사이즈
    private int total; // count에서 가져온 토탈 사이즈 값

    //시작 페이지 번호
    private int start;

    //끝 페이지 번호
    private int end;

    //이전 페이지의 존재 여부 | 1페이지는 이전 페이지가 없겠지 false 버튼 생성해서 페이지 보여줘야
    private boolean prev;

    //다음 페이지의 존재 여부
    private boolean next;

    private List<E> dtoList; // 담아서 보내줄 리스트 타입 지정 제너릭으로 설계

    @Builder(builderMethodName = "All")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total){
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;

        this.end = (int) (Math.ceil(this.page/10.0))*10;
        this.start = this.end - 9;
        int last = (int) (Math.ceil((total/(double)size)));
        this.end = end > last ? last : end;

        this.prev = this.start > 1;
        this.next = total > this.end * this.size;
    }
}
