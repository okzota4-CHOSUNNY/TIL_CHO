```java
BoardResponseDto.java
@Getter
public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private int viewCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

@Builder
    public BoardResponseDto(Long id, String title, String content, String author, Integer viewCount, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.viewCount = viewCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    // ⭐⭐⭐ 바로 이 메서드가 from()! ⭐⭐⭐
    public static BoardResponseDto from(Board board) {
    // public static: 어디서든 호출 가능한 정적 메서드, 객체 없이 클래스 이름으로 바로 호출 가능
    // BoardResponseDto.from() 형태로 호출
    // BoardResponseDto: 반환 타입, 이 메서드는 BoardResponseDto를 반환
    // from: 메서드 이름
    // (Board board): Board 타입을 board라는 이름으로 매개변수 선언 Entity 객체를 받음
    return BoardResponseDto.builder()
        .id(board.getId())
        .title(board.getTitle())
        .content(board.getContent())
        .author(board.getAuthor())
        .viewCount(board.getViewCount())
        .createdAt(board.getCreatedAt())
        .updatedAt(board.getUpdatedAt())
        .build();
// 위에 public static BoardResponseDto from(Board board)으로 호출해서
// 아래 return BoardResponseDto.builder()... .build(); 까지를 반환해줌
    }
}
```

```java
.from 구동원리
// Service에서 호출
Board savedBoard = boardRepository.save(board);
return BoardResponseDto.from(savedBoard);

// ↓↓↓ 실제 동작 과정 ↓↓↓

// 1단계. BoardResonseDto 클래스의 from() 메서드 호출
public static BoardResponseDto from(Board board) {
    // public static: 어디서든 호출가능한, 클래스메서드,
    // BoardResponseDto: 반환타입, from: 메서드이름,
    // (Board board): Board 타입을 board라는 이름으로 매개변수 선언
    // board = saveBoard (DB에 저장된 Entity 객체)

// 2단계. 빌더 패턴으로 DTO 객체 생성 시작
    return BoardResponseDto.builder()

// 3단계. Entity 객체에서 값 하나씩 꺼내기
        .id(board.getId())
        .title(board.getTitle())
        .content(board.getContent())
        .author(board.getAuthor())
        .viewCount(board.getViewCount())
        .createdAt(board.getCreatedAt())
        .updatedAt(board.getUpdatedAt())
// 4단계. 모든 값 설정 완료 DTO 객체 생성
        .build();
// 5단계. 생성된 BoardResponseDto 객체를 Service에서 Controller로 반환
}
```

```java
.from 실제예시

// Service에서 호출
public BoardResponseDto createdBoard(BoardRequestDto requestDto) {
// 1단계. Entity 객체 생성
    Board board = Board.builder()
        .title("안녕하세요")
        .content("테스트 게시글 입니다.")
        .author("홍길동")
        .build();

// 2단계. Entity 객체를 DB에 저장
    Board savedBoard = boardRepository.save(board);
    // saveBoard 상태:
    // id: 1, title: "안녕하세요", content: "테스트 게시글 입니다.", author: "홍길동, viewCount: 0, createdAt: ~, updatedAt: ~

}