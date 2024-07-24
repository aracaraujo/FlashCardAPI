CREATE TABLE IF NOT EXISTS true_false_flashcards(
        id BIGINT not null AUTO_INCREMENT,
        question varchar(100) not null,
        answer boolean not null,
        user_id BIGINT not null,
        PRIMARY key ( id )
);

CREATE TABLE IF NOT EXISTS definition_flashcards(
        id BIGINT not null AUTO_INCREMENT,
        question varchar(100) not null,
        answer varchar(100) not null,
        user_id BIGINT not null,
        PRIMARY key ( id )
);