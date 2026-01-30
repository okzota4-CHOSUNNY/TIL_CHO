```java
@RequiredArgsConstructor
1. final이 붙은 필드를 매개변수로 받는 생성자를 자동생성
2. 의존성 주입(DI)를 편하게 해줌

Before vs After비교코드
// Before
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final ReplyRepository replyRepository;
// 아래 부분을 @RequiredArgsConstructor 가 자동으로 생성해줌
public BoardService(BoardRepository boardRepository,
                    UserRepository userRepository,
                    ReplyRepository replyRepository) {
    this.boardRepository = boardRepository;
    this.userRepository = userRepository;
    this.replyRepository = replyRepository;
    }
}

// After
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final ReplyRepository replyRepository;
}
    