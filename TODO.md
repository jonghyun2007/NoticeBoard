# TODO

## Backend
- [x] JWT httpOnly 쿠키 방식으로 변경
- [x] Spring Security 적용
- [x] GlobalExceptionHandler 도입 (에러 메세지를 알아야 프론트에서 대처하기 수월)
- [x] BCrypt 암호화 적용
- [ ] 게시판 CRUD 구현
  - [x] 엔티티 설계 (InteractionBoard, InteractionBoardComment)
  - [x] Repository 구현
  - [ ] DTO 설계 (Request/Response/Detail)
  - [ ] Service 구현 (Board, Comment 분리)
  - [ ] Controller 구현
  - [ ] 게시글 작성/수정/삭제 시 본인 여부 검증

## Frontend
- [x] 로그인 토큰 관리 (아마도 cookie?)
- [x] 토큰 기반으로 로그인 세션 라우팅 처리
- [ ] 게시판 페이지 구현
  - [ ] 게시글 목록 페이지 (/board)
  - [ ] 게시글 상세 페이지 (/board/[id])
  - [ ] 게시글 작성 페이지 (/board/new)
  - [ ] 댓글 작성/삭제 UI
  - [ ] 로그인 안 한 사용자 접근 차단 (미들웨어)