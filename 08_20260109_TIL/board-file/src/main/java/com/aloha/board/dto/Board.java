
package com.aloha.board.dto;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Board {
  private Integer no;
  private String id;
  private String title;
  private String writer;
  private String content;
  private Date createdAt;
  private Date updatedAt;

  private List<MultipartFile> files; // 파일 업로드용 필드

  private List<Files> fileList; // 첨부파일 목록

  public Board() {
    this.id = UUID.randomUUID().toString();
  }

}