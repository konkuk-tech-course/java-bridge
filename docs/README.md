# 기능 목록 작성

## domain
- [x] BridgeLength
    - [x] 필드, 생성자, getter
    - [x] 다리에 필요한 상수 생성
    - [x] 유효성 검증
- [x] Bridge
    - [x] 필드, 생성자, getter
    - [x] 칸에 관련된 상수 생성 (UP, DOWN)
    - [x] n번째 칸에 대한 시도 결과 boolean 반환
- [x] User
    - [x] 필드, 생성자, getter
    - [x] 유저의 게임 상태 관련 상수 생성
    - [x] 시도 관련 메서드
    - [x] 실패 관련 메서드
    - [x] 재시도 관련 메서드
    - [x] 게임 성공 관련 메서드

## service
- [x] UserService
    - [x] User 생성
- [x] BridgeService
    - [x] BridgeMaker의 makeBridge 구현
    - [x] 다리 생성
- [x] GameService == BridgeGame
    - [x] move 메서드 구현
    - [x] retry 메서드 구현
    - [x] 시도 결과에 관한 enum 생성
    - [x] 주어진 칸까지의 시도 결과를 줄 별 리스트로 반환하는 메서드

## view
- [x] InputView
    - [x] 다리 길이 입력
        - [x] 입력 문구 출력
        - [x] 유효성 검증을 위한 정규표현식 생성
        - [x] 에러메세지 추가
        - [x] 유효성 검증 작성
    - [x] 이동할 칸 입력
        - [x] 입력 문구 출력
        - [x] 입력 옵션 관련 enum 생성
        - [x] 유효성 검증을 위한 정규표현식 생성
        - [x] 에러메세지 추가
        - [x] 유효성 검증 작성
    - [x] 재시도 여부 입력
        - [x] 입력 문구 출력
        - [x] 입력 옵션 관련 enum 생성
        - [x] 유효성 검증을 위한 정규표현식 생성
        - [x] 에러메세지 추가
        - [x] 유효성 검증 작성
- OutputView

## controller
- GameController