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
- UserService
- BridgeService
- GameService

## view
- InputView
- OutputView

## controller
- GameController