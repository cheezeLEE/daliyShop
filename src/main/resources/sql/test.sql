-- 테이블 생성
CREATE TABLE tbl_test(
	usr_no INT PRIMARY KEY AUTO_INCREMENT,
	usr_id VARCHAR(100) NOT NULL,
	usr_pw VARCHAR(100) NOT NULL,
	usr_name VARCHAR(50) NOT NULL
);

-- Spring Security를 사용하기 위한 roles 컬럼 추가
ALTER TABLE tbl_test ADD roles varchar(10);

-- 테이블 데이터 추가
INSERT INTO tbl_test(usr_id, usr_pw, usr_name, roles)
VALUES('id','pw','name','USER');
