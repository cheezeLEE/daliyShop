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


-- 프로젝트 테이블들
-- 회원 테이블
CREATE TABLE USR_INFO(
	usr_no INT NOT NULL,
	usr_id VARCHAR(20) NOT NULL,
	usr_pw VARCHAR(100) NOT NULL,
	usr_name VARCHAR(20) NOT NULL,
	usr_mbl_no VARCHAR(20) NULL,
	usr_addr VARCHAR(50) NULL,
	usr_road VARCHAR(50) NULL,
	usr_postal VARCHAR(10) NULL,
	usr_addr_detail VARCHAR(1000) NULL,
	usr_birth VARCHAR(8) NULL,
	usr_reg_date DATETIME DEFAULT NOW(),
	usr_mod_date DATETIME DEFAULT NOW(),
	usr_rank VARCHAR(10) DEFAULT 'BASIC',
	usr_withdraw_yn CHAR(1) DEFAULT 'N',
	PRIMARY KEY(usr_no)
);

-- 권한 테이블
CREATE TABLE USR_AUTH(
	usr_auth VARCHAR(10) DEFAULT 'MEMBER',
	usr_no INT NOT NULL,
	FOREIGN KEY(usr_no) REFERENCES USR_INFO(usr_no)
);

-- 상품 테이블
CREATE TABLE PRDT_INFO(
	prdt_no INT NOT NULL,
	prdt_name VARCHAR(100) NOT NULL,
	prdt_cate1 VARCHAR(20) NOT NULL,
	prdt_cate2 VARCHAR(20) NULL,
	prdt_price INT NOT NULL,
	prdt_size VARCHAR(10) NULL,
	prdt_color VARCHAR(20) NULL,
	prdt_desc TEXT NOT NULL,
	prdt_inventory INT NOT NULL,
	prdt_reg_date DATETIME DEFAULT NOW(),
	prdt_mod_date DATETIME DEFAULT NOW(),
	prdt_del_yn CHAR(1) DEFAULT 'N',
	PRIMARY KEY(prdt_no)
);

-- 상품 이미지 테이블
CREATE TABLE PRDT_IMG(
	prdt_uuid VARCHAR(20) NOT NULL,
	prdt_route VARCHAR(100) NOT NULL,
	prdt_no INT NOT NULL,
	PRIMARY KEY(prdt_uuid),
	FOREIGN KEY(prdt_no) REFERENCES PRDT_INFO(prdt_no)
);

-- 주문 테이블
CREATE TABLE ORDER_INFO(
	order_no INT NOT NULL,
	usr_no INT NOT NULL,
	prdt_no INT NOT NULL,
	order_addr VARCHAR(50) NULL,
	order_road VARCHAR(50) NULL,
	order_postal VARCHAR(10) NOT NULL,
	order_addr_detail VARCHAR(100) NOT NULL,
	order_date DATETIME DEFAULT NOW(),
	order_price INT NOT NULL,
	order_count INT NOT NULL,
	order_delivery_fee INT NOT NULL,
	order_delivery_status VARCHAR(10) NOT NULL,
	order_receiver_mbl_no VARCHAR(20) NOT NULL,
	order_cancel_yn CHAR(1) NOT NULL,
	PRIMARY KEY(order_no, usr_no, prdt_no),
	FOREIGN KEY(usr_no) REFERENCES USR_INFO(usr_no),
	FOREIGN KEY(prdt_no) REFERENCES PRDT_INFO(prdt_no)
);

-- 찜 테이블
CREATE TABLE WISH_INFO(
	usr_no INT NOT NULL,
	prdt_no INT NOT NULL,
	PRIMARY KEY(usr_no, prdt_no),
	FOREIGN KEY(usr_no) REFERENCES USR_INFO(usr_no),
	FOREIGN KEY(prdt_no) REFERENCES PRDT_INFO(prdt_no)
);

-- 장바구니 테이블
CREATE TABLE CART_INFO(
	usr_no INT NOT NULL,
	prdt_no INT NOT NULL,
	cart_prdt_count INT NOT NULL,
	PRIMARY KEY(usr_no, prdt_no),
	FOREIGN KEY(usr_no) REFERENCES USR_INFO(usr_no),
	FOREIGN KEY(prdt_no) REFERENCES PRDT_INFO(prdt_no)
);

-- 일대일문의 테이블
CREATE TABLE INQUIRY_INFO(
	inquiry_no INT NOT NULL,
	inquiry_title VARCHAR(100) NOT NULL,
	inquiry_content TEXT NOT NULL,
	inquiry_writer VARCHAR(20) NOT NULL,
	inquiry_reg_date DATETIME DEFAULT NOW(),
	inquiry_mod_date DATETIME DEFAULT NOW(),
	inquiry_del_yn CHAR(1) NOT NULL,
	reply_no INT NULL,
	PRIMARY KEY(inquiry_no),
	FOREIGN KEY(reply_no) REFERENCES INQUIRY_INFO(inquiry_no)
);

-- 일대일문의 이미지 테이블
CREATE TABLE INQUIRY_IMG(
	inquiry_uuid VARCHAR(20) NOT NULL,
	inquiry_route VARCHAR(200) NOT NULL,
	inquiry_no INT NOT NULL,
	PRIMARY KEY(inquiry_uuid),
	FOREIGN KEY(inquiry_no) REFERENCES INQUIRY_INFO(inquiry_no)
);

-- 공지사항 테이블
CREATE TABLE NOTICE_INFO(
	notice_no INT NOT NULL,
	notice_title VARCHAR(100) NOT NULL,
	notice_content TEXT NOT NULL,
	notice_writer VARCHAR(20) NOT NULL,
	notice_reg_date DATETIME DEFAULT NOW(),
	notice_mod_date DATETIME DEFAULT NOW(),
	notice_del_yn CHAR(1) NOT NULL,
	PRIMARY KEY(notice_no)
);

-- FAQ 테이블
CREATE TABLE FAQ_INFO(
	faq_no INT NOT NULL,
	faq_title VARCHAR(100) NOT NULL,
	faq_content TEXT NOT NULL,
	faq_writer VARCHAR(20) NOT NULL,
	faq_reg_date DATETIME DEFAULT NOW(),
	faq_mod_date DATETIME DEFAULT NOW(),
	faq_del_yn CHAR(1) NOT NULL,
	PRIMARY KEY(faq_no)
);

-- 공통코드 테이블
CREATE TABLE COM_CODE(
	com_code VARCHAR(20) NOT NULL,
	com_desc VARCHAR(100) NOT NULL,
	com_use_yn CHAR(1) NOT NULL,
	com_value VARCHAR(20) NULL,
	PRIMARY KEY(com_code)
);

