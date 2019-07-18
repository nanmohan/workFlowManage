INSERT INTO work_flow.postgres_rolevo
(role_id, role_name)
VALUES(101, 'ADMIN');
INSERT INTO work_flow.postgres_rolevo
(role_id, role_name)
VALUES(102, 'MANAGER');
INSERT INTO work_flow.postgres_rolevo
(role_id, role_name)
VALUES(103, 'TECHIE');

INSERT INTO work_flow.postgres_statusvo
(status_id, status_name)
VALUES(1, 'NEW');
INSERT INTO work_flow.postgres_statusvo
(status_id, status_name)
VALUES(2, 'ASSIGNED');
INSERT INTO work_flow.postgres_statusvo
(status_id, status_name)
VALUES(3, 'COMPLETED');
INSERT INTO work_flow.postgres_statusvo
(status_id, status_name)
VALUES(4, 'CLOSED');

INSERT INTO work_flow.postgres_teamvo
(team_id, team_name)
VALUES(51, 'GT_01');
INSERT INTO work_flow.postgres_teamvo
(team_id, team_name)
VALUES(52, 'GT_02');

INSERT INTO work_flow.postgres_uservo
(user_id, user_name, "password", role_id, team_id)
VALUES(1001, 'RAM', 'password', 102, 51);
INSERT INTO work_flow.postgres_uservo
(user_id, user_name, "password", role_id, team_id)
VALUES(1003, 'BINU', 'password', 102, 51);
INSERT INTO work_flow.postgres_uservo
(user_id, user_name, "password", role_id, team_id)
VALUES(1004, 'CHANDU', 'password', 102, 51);
INSERT INTO work_flow.postgres_uservo
(user_id, user_name, "password", role_id, team_id)
VALUES(1005, 'DEVI', 'password', 102, 51);
INSERT INTO work_flow.postgres_uservo
(user_id, user_name, "password", role_id, team_id)
VALUES(1002, 'AK', 'password', 103, 51);

INSERT INTO work_flow.task
(task_id, task_name, task_owner, status_id, "userName", user_id)
VALUES(500, 'BOM00500', 1001, 1, NULL, NULL);
INSERT INTO work_flow.task
(task_id, task_name, task_owner, status_id, "userName", user_id)
VALUES(501, 'BOM00501', 1001, 1, NULL, NULL);
INSERT INTO work_flow.task
(task_id, task_name, task_owner, status_id, "userName", user_id)
VALUES(502, 'BOM00502', 1001, 1, NULL, NULL);
INSERT INTO work_flow.task
(task_id, task_name, task_owner, status_id, "userName", user_id)
VALUES(503, 'BOM00503', 1001, 1, NULL, NULL);
INSERT INTO work_flow.task
(task_id, task_name, task_owner, status_id, "userName", user_id)
VALUES(504, 'BOM00504', 1001, 2, 1002, NULL);


INSERT INTO work_flow.assigned_task
(task_id, assigned_user, id)
VALUES(504, 1002, 1);
