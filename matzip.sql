-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- user Table Create SQL
CREATE TABLE matzip.user
(
    `user_id`    INT            NOT NULL    AUTO_INCREMENT COMMENT 'user_id', 
    `user_name`  VARCHAR(45)    NOT NULL    COMMENT 'user_name', 
    `password`   VARCHAR(45)    NOT NULL    COMMENT 'password', 
    `phone`      VARCHAR(45)    NOT NULL    COMMENT 'phone', 
    `email`      VARCHAR(45)    NOT NULL    COMMENT 'email', 
    PRIMARY KEY (user_id)
);



-- user Table Create SQL
CREATE TABLE matzip.restaurant
(
    `rest_id`     INT             NOT NULL    AUTO_INCREMENT COMMENT 'rest_id', 
    `rest_name`   VARCHAR(45)     NOT NULL    COMMENT 'rest_name', 
    `address`     VARCHAR(300)    NOT NULL    COMMENT 'address', 
    `body`        VARCHAR(300)    NOT NULL    COMMENT 'body', 
    `genre`       VARCHAR(45)     NOT NULL    COMMENT 'genre', 
    `phone`       VARCHAR(45)     NOT NULL    COMMENT 'phone', 
    `start_time`  VARCHAR(45)             NOT NULL    COMMENT 'start_time', 
    `end_time`    VARCHAR(45)            NOT NULL    COMMENT 'end_time', 
    `rating`      INT             NOT NULL    COMMENT 'rating', 
    PRIMARY KEY (rest_id)
);

ALTER TABLE matzip.restaurant COMMENT 'restaurant';


-- user Table Create SQL
CREATE TABLE matzip.role
(
    `role`     VARCHAR(45)    NOT NULL    COMMENT 'role', 
    `role_id`  INT             NOT NULL    AUTO_INCREMENT    COMMENT 'role_id',
    PRIMARY KEY (role_id)
);

ALTER TABLE matzip.role COMMENT 'role';

INSERT INTO `role` ( `role`)
VALUES
	('ADMIN'),
    ('USER');


-- user Table Create SQL
CREATE TABLE matzip.comment
(
    `comment_id`    INT             NOT NULL    AUTO_INCREMENT COMMENT 'comment_id', 
    `title`         VARCHAR(300)    NOT NULL    COMMENT 'title', 
    `body`          VARCHAR(300)    NOT NULL    COMMENT 'body', 
    `date_created`  DATETIME        NOT NULL    COMMENT 'date_created', 
    `user_id`       INT             NOT NULL    COMMENT 'user_id', 
    `rest_id`        INT             NOT NULL,
    `score`         INT             NOT NULL    COMMENT 'score', 
    PRIMARY KEY (comment_id)
    
);

ALTER TABLE matzip.comment COMMENT 'comment';

ALTER TABLE matzip.comment
    ADD CONSTRAINT FK_comment_user_id_user_user_id FOREIGN KEY (user_id)
        REFERENCES matzip.user (user_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE matzip.comment
    ADD CONSTRAINT FK_comment_rest_id_restaurant_rest_id FOREIGN KEY (rest_id)
        REFERENCES matzip.restaurant (rest_id) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- user Table Create SQL
CREATE TABLE matzip.user_role
(
    `user_id`  INT    NOT NULL    COMMENT 'user_id', 
    `role_id`  INT    NOT NULL    COMMENT 'role_id', 
    PRIMARY KEY (user_id, role_id)
);

ALTER TABLE matzip.user_role COMMENT 'user_role';

ALTER TABLE matzip.user_role
    ADD CONSTRAINT FK_user_role_user_id_user_user_id FOREIGN KEY (user_id)
        REFERENCES matzip.user (user_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE matzip.user_role
    ADD CONSTRAINT FK_user_role_role_id_role_role_id FOREIGN KEY (role_id)
        REFERENCES matzip.role (role_id) ON DELETE RESTRICT ON UPDATE RESTRICT;




-- user Table Create SQL
/*CREATE TABLE matzip.rest_comment
(
    `comment_id`  INT    NOT NULL    COMMENT 'comment_id', 
    `rest_id`     INT    NOT NULL    COMMENT 'rest_id', 
    PRIMARY KEY (comment_id, rest_id)
);

ALTER TABLE matzip.rest_comment COMMENT 'rest_comment';

ALTER TABLE matzip.rest_comment
    ADD CONSTRAINT FK_rest_comment_comment_id_comment_comment_id FOREIGN KEY (comment_id)
        REFERENCES matzip.comment (comment_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE matzip.rest_comment
    ADD CONSTRAINT FK_rest_comment_rest_id_restaurant_rest_id FOREIGN KEY (rest_id)
        REFERENCES matzip.restaurant (rest_id) ON DELETE RESTRICT ON UPDATE RESTRICT;*/


-- INSERT VALUE("","","","");


