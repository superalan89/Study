-- drop table j_member;

CREATE TABLE j_member(
	id			VARCHAR2(30)	PRIMARY KEY,
	name		VARCHAR2(30)	NOT NULL,
	password	VARCHAR2(30)	NOT NULL
);

insert into j_member(id, name, password)
values('ryu','류현진','1234');

select * from j_member;

--drop table j_board;
--drop sequence j_board_seq;

CREATE TABLE j_board(
	no			NUMBER			PRIMARY KEY,
	title		VARCHAR2(100)	NOT NULL,
	name		VARCHAR2(30)	NOT NULL,
	password	VARCHAR2(100)	NOT NULL,
	content		VARCHAR2(4000)	NOT NULL,
	writeday	DATE			DEFAULT SYSDATE,
	readcount	NUMBER			DEFAULT 0
);

CREATE SEQUENCE j_board_seq NOCACHE;

insert into j_board(no, title, name, password, content)
values(j_board_seq.nextval, '난 알아요', '서태지','1234','이 밤이 흐르면');

insert into j_board(no, title, name, password, content)
values(j_board_seq.nextval, '환상속의 그대', '정현철','1234','사람들은 그대의 머리위로...');

insert into j_board(no, title, name, password, content)
values(j_board_seq.nextval, '우리 앞의 생이 끝나갈 때', '신해철','1234','흐른 창문 사이로 하얗게...');

select * from j_board;
