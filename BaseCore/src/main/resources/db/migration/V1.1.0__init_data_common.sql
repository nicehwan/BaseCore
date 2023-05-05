-- 사용자 등록
INSERT INTO CM_USER(USER_SEQ, LOGIN_ID, USER_NM, USER_STAT_CD, USER_TEL_NO, ACUNT_EXP_DT, LOGIN_FAIL_CNT, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ)
VALUES (101, 'admin@abc.co.kr', '어드민', 'ENABLED', '010-1234-5678', NOW() + 365, 0, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_USER(USER_SEQ, LOGIN_ID, USER_NM, USER_STAT_CD, USER_TEL_NO, ACUNT_EXP_DT, LOGIN_FAIL_CNT, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ)
VALUES (102, 'manager@abc.co.kr', '관리자', 'ENABLED', '010-1234-5678', NOW() + 365, 0, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_USER(USER_SEQ, LOGIN_ID, USER_NM, USER_STAT_CD, USER_TEL_NO, ACUNT_EXP_DT, LOGIN_FAIL_CNT, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ)
VALUES (103, 'user01@abc.co.kr', '사용자01', 'ENABLED', '010-1234-5678', NOW() + 365, 0, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_USER(USER_SEQ, LOGIN_ID, USER_NM, USER_STAT_CD, USER_TEL_NO, ACUNT_EXP_DT, LOGIN_FAIL_CNT, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ)
VALUES (104, 'user02@abc.co.kr', '사용자02', 'ENABLED', '010-1234-5678', NOW() + 365, 0, 'N', NOW(), 100, NOW(), 100);

-- 사용자 패스워드
INSERT INTO CM_USER_PWD(USER_PWD_SEQ, USER_SEQ, USER_PWD, PWD_EXP_DT, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ)
VALUES(101, 101, '{bcrypt}$2a$10$ErKoq2mRDOVizhm8MDqRnebaDfqRwU47ixtZM58aEIMbdJX3jjxYy', NOW() + 100, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_USER_PWD(USER_PWD_SEQ, USER_SEQ, USER_PWD, PWD_EXP_DT, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ)
VALUES(102, 102, '{bcrypt}$2a$10$ErKoq2mRDOVizhm8MDqRnebaDfqRwU47ixtZM58aEIMbdJX3jjxYy', NOW() + 100, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_USER_PWD(USER_PWD_SEQ, USER_SEQ, USER_PWD, PWD_EXP_DT, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ)
VALUES(103, 103, '{bcrypt}$2a$10$ErKoq2mRDOVizhm8MDqRnebaDfqRwU47ixtZM58aEIMbdJX3jjxYy', NOW() + 100, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_USER_PWD(USER_PWD_SEQ, USER_SEQ, USER_PWD, PWD_EXP_DT, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ)
VALUES(104, 104, '{bcrypt}$2a$10$ErKoq2mRDOVizhm8MDqRnebaDfqRwU47ixtZM58aEIMbdJX3jjxYy', NOW() + 100, 'N', NOW(), 100, NOW(), 100);

-- 관리자
INSERT INTO CM_ROLE(ROLE_SEQ, ROLE_CD, ROLE_NM, DEF_PAGE, ROLE_DESC, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ)
VALUES(100, 'ROLE_ADMIN', '어드민', '/dashboard/admin', '어드민', 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE(ROLE_SEQ, ROLE_CD, ROLE_NM, DEF_PAGE, ROLE_DESC, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ)
VALUES(101, 'ROLE_MANAGER', '관리자', '/dashboard/manager', '관리자', 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE(ROLE_SEQ, ROLE_CD, ROLE_NM, DEF_PAGE, ROLE_DESC, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ)
VALUES(102, 'ROLE_USER', '사용자', '/dashboard/user', '사용자', 'N', NOW(), 100, NOW(), 100);

-- 역할할당
INSERT INTO CM_USER_ROLE_MAP(ROLE_SEQ, USER_SEQ, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ)
VALUES(100, 101, 1, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_USER_ROLE_MAP(ROLE_SEQ, USER_SEQ, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ)
VALUES(101, 102, 1, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_USER_ROLE_MAP(ROLE_SEQ, USER_SEQ, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ)
VALUES(102, 103, 1, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_USER_ROLE_MAP(ROLE_SEQ, USER_SEQ, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ)
VALUES(102, 104, 1, 'N', NOW(), 100, NOW(), 100);

-- 메뉴 관리
INSERT INTO CM_MENU (MENU_SEQ, UP_MENU_SEQ, MENU_PATH, MENU_NM, MENU_DESC, CM_SCREN_YN, PRNT_YN, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (100, 0,   '/common/login', '로그인', '공통', 'N', 'N', 1, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_MENU (MENU_SEQ, UP_MENU_SEQ, MENU_PATH, MENU_NM, MENU_DESC, CM_SCREN_YN, PRNT_YN, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (110, 0, '/common/join_us', '가입', '가입', 'N', 'N', 2, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_MENU (MENU_SEQ, UP_MENU_SEQ, MENU_PATH, MENU_NM, MENU_DESC, CM_SCREN_YN, PRNT_YN, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (1000, null, '/dashboard', '대시보드', '대시보드', 'Y', 'N', 1, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_MENU (MENU_SEQ, UP_MENU_SEQ, MENU_PATH, MENU_NM, MENU_DESC, CM_SCREN_YN, PRNT_YN, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (7000, null, null, '놀이', '놀이', 'N', 'Y', 7, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_MENU (MENU_SEQ, UP_MENU_SEQ, MENU_PATH, MENU_NM, MENU_DESC, CM_SCREN_YN, PRNT_YN, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (7900, 7000, null, 'WPI', 'WPI', 'N', 'Y', 7, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_MENU (MENU_SEQ, UP_MENU_SEQ, MENU_PATH, MENU_NM, MENU_DESC, CM_SCREN_YN, PRNT_YN, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (7910, 7900, '/play/wpi/test', 'WPI 테스트', 'WPI 테스트', 'N', 'Y', 1, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_MENU (MENU_SEQ, UP_MENU_SEQ, MENU_PATH, MENU_NM, MENU_DESC, CM_SCREN_YN, PRNT_YN, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (7920, 7900, '/play/wpi/result', 'WPI 결과', 'WPI 결과', 'N', 'Y', 2, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_MENU (MENU_SEQ, UP_MENU_SEQ, MENU_PATH, MENU_NM, MENU_DESC, CM_SCREN_YN, PRNT_YN, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (8000, null, null, '사용자', '사용자', 'N', 'Y', 8, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_MENU (MENU_SEQ, UP_MENU_SEQ, MENU_PATH, MENU_NM, MENU_DESC, CM_SCREN_YN, PRNT_YN, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (8010, 8000, '/user/user_info', '사용자 정보', '사용자 정보', 'N', 'Y', 1, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_MENU (MENU_SEQ, UP_MENU_SEQ, MENU_PATH, MENU_NM, MENU_DESC, CM_SCREN_YN, PRNT_YN, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (8020, 8000, '/user/bookmark', '북마크', '북마크', 'N', 'Y', 2, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_MENU (MENU_SEQ, UP_MENU_SEQ, MENU_PATH, MENU_NM, MENU_DESC, CM_SCREN_YN, PRNT_YN, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (8030, 8000, '/user/chg_pwd', '패스워드 변경', '패스워드 변경', 'N', 'Y', 3, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_MENU (MENU_SEQ, UP_MENU_SEQ, MENU_PATH, MENU_NM, MENU_DESC, CM_SCREN_YN, PRNT_YN, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (8040, 8000, '/user/allow_ip', '허용 IP', '허용 IP', 'N', 'Y', 4, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_MENU (MENU_SEQ, UP_MENU_SEQ, MENU_PATH, MENU_NM, MENU_DESC, CM_SCREN_YN, PRNT_YN, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (9000, null, null, '시스템', '시스템', 'N', 'Y', 9, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_MENU (MENU_SEQ, UP_MENU_SEQ, MENU_PATH, MENU_NM, MENU_DESC, CM_SCREN_YN, PRNT_YN, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (9010, 9000, '/system/user_mgt', '사용자 관리', '사용자 관리', 'N', 'Y', 1, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_MENU (MENU_SEQ, UP_MENU_SEQ, MENU_PATH, MENU_NM, MENU_DESC, CM_SCREN_YN, PRNT_YN, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (9020, 9000, '/system/noti_mgt', '공지 관리', '공지 관리', 'N', 'Y', 2, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_MENU (MENU_SEQ, UP_MENU_SEQ, MENU_PATH, MENU_NM, MENU_DESC, CM_SCREN_YN, PRNT_YN, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (9030, 9000, '/system/role_mgt', '역할 관리', '역할 관리', 'N', 'Y', 3, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_MENU (MENU_SEQ, UP_MENU_SEQ, MENU_PATH, MENU_NM, MENU_DESC, CM_SCREN_YN, PRNT_YN, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (9040, 9000, '/system/menu_mgt', '메뉴 관리', '메뉴 관리', 'N', 'Y', 4, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_MENU (MENU_SEQ, UP_MENU_SEQ, MENU_PATH, MENU_NM, MENU_DESC, CM_SCREN_YN, PRNT_YN, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (9050, 9000, '/system/code_mgt', '코드 관리', '코드 관리', 'N', 'Y', 5, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_MENU (MENU_SEQ, UP_MENU_SEQ, MENU_PATH, MENU_NM, MENU_DESC, CM_SCREN_YN, PRNT_YN, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (9060, 9000, '/system/schedule_mgt', '스케줄러 관리', '스케줄러 관리', 'N', 'Y', 6, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_MENU (MENU_SEQ, UP_MENU_SEQ, MENU_PATH, MENU_NM, MENU_DESC, CM_SCREN_YN, PRNT_YN, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (9070, 9000, '/system/env_mgt', '환경 관리', '환경 관리', 'N', 'Y', 7, 'N', NOW(), 100, NOW(), 100);


-- 역할 메뉴 맵핑
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (100, 8010, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (100, 8020, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (100, 8030, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (100, 8040, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (100, 9010, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (100, 9020, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (100, 9030, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (100, 9040, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (100, 9050, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (100, 9060, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (100, 9070, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (101, 8010, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (101, 8020, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (101, 8030, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (101, 8040, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (101, 9010, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (101, 9020, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (101, 9030, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (101, 9040, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (102, 7910, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (102, 7920, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (102, 8010, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (102, 8020, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (102, 8030, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_ROLE_MENU_MAP(ROLE_SEQ, MENU_SEQ, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ) VALUES (102, 8040, 'N', NOW(), 100, NOW(), 100);


-- 그룹코드와 코드상세
-- 그룹코드는 컬럼명이 되며, 코드 상세는 그 컬럼에 들어갈 수 있는 값을 의미
INSERT INTO CM_GRP_CD(GRP_CD, GRP_CD_NM, GRP_CD_DESC, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ)
VALUES ('USER_STAT_CD', '사용자 상태 코드', '사용자 상태 코드', 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_CD_DTL(GRP_CD, CD, CD_NM, CD_DESC, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ)
VALUES ('USER_STAT_CD', 'ENABLED', '로그인가능', '로그인 가능 상태', 1, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_CD_DTL(GRP_CD, CD, CD_NM, CD_DESC, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ)
VALUES ('USER_STAT_CD', 'LOCKED', '로그인잠김', '로그인 잠김 상태', 2, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_CD_DTL(GRP_CD, CD, CD_NM, CD_DESC, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ)
VALUES ('USER_STAT_CD', 'DISABLED', '로그인불가능', '로그인 불가능 상태', 3, 'N', NOW(), 100, NOW(), 100);
INSERT INTO CM_CD_DTL(GRP_CD, CD, CD_NM, CD_DESC, PRNT_ORD, DEL_YN, CRE_DT, CREATOR_SEQ, UPD_DT, UPDATOR_SEQ)
VALUES ('USER_STAT_CD', 'DELETE', '계정삭제', '계정 삭제 상태', 4, 'N', NOW(), 100, NOW(), 100);
