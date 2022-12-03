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
- [ ] BridgeService
    - [ ] BridgeMaker의 makeBridge 구현
    - [ ] 다리 생성
- [ ] GameService == BridgeGame
    - [ ] move 메서드 구현
    - [ ] retry 메서드 구현
    - [ ] 주어진 칸까지의 시도 결과를 줄 별 리스트로 반환하는 메서드

## view
- InputView
- OutputView

## controller
- GameController