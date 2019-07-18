-- DROP SCHEMA work_flow;

CREATE SCHEMA work_flow AUTHORIZATION postgres;

-- Drop table

-- DROP TABLE work_flow.postgres_rolevo;

CREATE TABLE work_flow.postgres_rolevo (
	role_id int4 NOT NULL,
	role_name varchar NOT NULL,
	CONSTRAINT postgres_rolevo_pk PRIMARY KEY (role_id)
);


-- Drop table

-- DROP TABLE work_flow.postgres_statusvo;

CREATE TABLE work_flow.postgres_statusvo (
	status_id int4 NOT NULL,
	status_name varchar NOT NULL,
	CONSTRAINT postgres_statusvo_pk PRIMARY KEY (status_id)
);


-- Drop table

-- DROP TABLE work_flow.postgres_teamvo;

CREATE TABLE work_flow.postgres_teamvo (
	team_id int4 NOT NULL,
	team_name varchar NOT NULL,
	CONSTRAINT postgres_teamvo_pk PRIMARY KEY (team_id)
);

-- Drop table

-- DROP TABLE work_flow.postgres_uservo;

CREATE TABLE work_flow.postgres_uservo (
	user_id int4 NOT NULL,
	user_name varchar NOT NULL,
	"password" varchar NOT NULL,
	role_id int4 NOT NULL,
	team_id int4 NOT NULL,
	CONSTRAINT postgres_uservo_pk PRIMARY KEY (user_id),
	CONSTRAINT postgres_uservo_fk FOREIGN KEY (role_id) REFERENCES work_flow.postgres_rolevo(role_id) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT postgres_uservo_fk_3 FOREIGN KEY (team_id) REFERENCES work_flow.postgres_teamvo(team_id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- Drop table

-- DROP TABLE work_flow.task;

CREATE TABLE work_flow.task (
	task_id int4 NOT NULL,
	task_name varchar NULL,
	task_owner int4 NOT NULL,
	status_id int4 NOT NULL,
	"userName" int4 NULL,
	user_id int8 NULL,
	CONSTRAINT task_pk PRIMARY KEY (task_id),
	CONSTRAINT task_fk FOREIGN KEY (status_id) REFERENCES work_flow.postgres_statusvo(status_id) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT task_fk_1 FOREIGN KEY (task_owner) REFERENCES work_flow.postgres_uservo(user_id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- Drop table

-- DROP TABLE work_flow.assigned_task;

CREATE TABLE work_flow.assigned_task (
	task_id int4 NOT NULL,
	assigned_user int4 NOT NULL,
	id int4 NOT NULL,
	CONSTRAINT assigned_task_pk PRIMARY KEY (id),
	CONSTRAINT assigned_task_fk FOREIGN KEY (task_id) REFERENCES work_flow.task(task_id) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT assigned_task_fk_1 FOREIGN KEY (assigned_user) REFERENCES work_flow.postgres_uservo(user_id) ON UPDATE CASCADE ON DELETE CASCADE
);

