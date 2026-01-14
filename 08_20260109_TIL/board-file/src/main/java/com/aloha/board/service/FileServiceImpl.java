package com.aloha.board.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.aloha.board.dto.Files;
import com.aloha.board.dto.ParentTable;
import com.aloha.board.mapper.FileMapper;

import lombok.Data; // Service에서는 굳이 필요 없지만 에러는 아닙니다.
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Data
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    
    private final FileMapper fileMapper;
    
    @Value("${spring.servlet.multipart.location}")
    private String uploadPath;

    @Override
    public List<Files> list() throws Exception {
        return fileMapper.list(); 
    }

    @Override
    public Files select(Integer no) throws Exception {
        return fileMapper.select(no);
    }

    @Override
    public Files selectById(String id) throws Exception {
        return fileMapper.selectById(id);
    }

    @Override
    public boolean insert(Files board) throws Exception {
        int result = fileMapper.insert(board);
        return result > 0;
    }

    @Override
    public boolean update(Files board) throws Exception {
        int result = fileMapper.update(board);
        return result > 0;
    }

    @Override
    public boolean updateById(Files board) throws Exception {
        int result = fileMapper.updateById(board);
        return result > 0;
    }

    @Override
    public boolean delete(Integer no) throws Exception {
        int result = fileMapper.delete(no);
        return result > 0;
    }

    @Override
    public boolean deleteById(String id) throws Exception {
        int result = fileMapper.deleteById(id);
        return result > 0;
    }

    @Override
    public int upload(List<MultipartFile> files, ParentTable parentTable, Integer parentNo) throws Exception {
        int sortOrder = 0;
        
        // 1. 파일이 null이 아니고 비어있지 않은지 확인
        if( files != null && !files.isEmpty() ) {
            for (MultipartFile file : files) {
                // 빈 파일 건너뛰기
                if(file.isEmpty()) continue;

                String fileName = file.getOriginalFilename(); // 원본파일명
                String path = uploadPath + UUID.randomUUID().toString() + "_" + fileName; // 저장경로 + 저장파일명
                
                // 파일 시스템에 저장
                File realFile = new File(path);
                byte[] fileData = file.getBytes();
                FileCopyUtils.copy(fileData, realFile);

                // DB 저장용 객체 생성
                Files newFile = new Files();
                newFile.setParentNo(parentNo);
                newFile.setParentTable(parentTable.value());
                newFile.setName(fileName);
                newFile.setPath(path);
                newFile.setContentType(file.getContentType());
                newFile.setSortOrder(sortOrder++); // 순서 0부터 증가

                // 첫 번째 파일(순서가 0이었다가 1이 된 경우)만 대표 이미지로 설정
                if( sortOrder == 1 ) {
                    newFile.setIsMain(true);
                } else {
                    newFile.setIsMain(false);
                }
                
                // ★ 중요 수정: insert는 if문 밖에서 실행해야 모든 파일이 저장됩니다.
                fileMapper.insert(newFile);
            }
        }
        
        // ★ 중요 수정: if문 밖에서도 값을 반환해야 합니다.
        return sortOrder;
    }
}