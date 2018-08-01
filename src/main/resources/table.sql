DROP SEQUENCE poll_info_seq
DROP SEQUENCE poll_item_seq
DROP SEQUENCE vote_list_seq

------ poll_info_table-------
CREATE TABLE poll_info(
	poll_id NUMBER PRIMARY KEY,
	title VARCHAR(30) NOT NULL,
	start_time DATE DEFAULT SYSDATE,
	end_time DATE,
	all_vote_count NUMBER DEFAULT 0,
	private VARCHAR(2) DEFAULT 'N'
)

------ poll_info_table sequence ------
CREATE SEQUENCE poll_info_seq


------ poll_item_table ------
CREATE TABLE poll_item(
	id NUMBER PRIMARY KEY,
	poll_id NUMBER,
	item VARCHAR(30),
	vote_count NUMBER DEFAULT 0,
	CONSTRAINT fk_poll_item FOREIGN KEY(poll_id)
	REFERENCES POLL_INFO(poll_id)
)

------ poll_item_table sequence ------
CREATE SEQUENCE poll_item_seq


------ vote_list ------
CREATE TABLE vote_list(
	id NUMBER PRIMARY KEY,
	poll_id NUMBER,
	client_ip VARCHAR(30),
	CONSTRAINT fk_vote_list FOREIGN KEY(poll_id)
	REFERENCES POLL_INFO(poll_id)
)

------ vote_list_seq ------
CREATE SEQUENCE vote_list_seq