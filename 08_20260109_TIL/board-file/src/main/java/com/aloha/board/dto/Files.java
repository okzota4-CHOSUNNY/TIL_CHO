package com.aloha.board.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class Files {
    private Integer no;
    private String id;
    private String parentTable;   // 부모 테이블
    private Integer parentNo;     // 부모 번호
    private String name;          // 원본 파일명
    private String path;          // 파일 경로
    private Long size;            // 파일 크기
    private String contentType;   // 파일 타입
    private Integer sortOrder;    // 정렬 순서  (0부터 시작)
    private Boolean isMain;       // 대표 이미지 여부 (썸네일 있는지 없는지)
    private String createdAt;     // 생성일
    private String updatedAt;     // 수정일

public Files() {
    this.id = UUID.randomUUID().toString();
    }
}