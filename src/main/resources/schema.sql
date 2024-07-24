CREATE TABLE IF NOT EXISTS true_or_false_flashcards(
        id BIGINT not null AUTO_INCREMENT,
        question varchar(100) not null,
        answer boolean not null,
        PRIMARY key ( id )
);