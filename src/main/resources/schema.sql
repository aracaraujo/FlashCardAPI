CREATE TABLE IF NOT EXISTS true_false_flashcards(
    id BIGINT not null AUTO_INCREMENT,
    question varchar(100) not null,
    answer boolean not null,
    user_id BIGINT not null,
    date_creation DATE,
    last_modified DATE,
    PRIMARY key ( id )
);

CREATE TABLE IF NOT EXISTS definition_flashcards(
    id BIGINT not null AUTO_INCREMENT,
    question varchar(100) not null,
    answer varchar(100) not null,
    user_id BIGINT not null,
    date_creation DATE,
    last_modified DATE,
    PRIMARY key ( id )
);

CREATE TABLE IF NOT EXISTS multiple_choice_flashcards(
    id BIGINT not null AUTO_INCREMENT,
    question varchar(100) not null,
    option_one varchar(100) not null,
    option_two varchar(100) not null,
    option_three varchar(100) not null,
    option_four varchar(100) not null,
    answer varchar(100) not null,
    user_id BIGINT not null,
    date_creation DATE,
    last_modified DATE,
    PRIMARY key ( id )
);