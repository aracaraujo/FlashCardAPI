-- USER 0
INSERT IGNORE INTO true_false_flashcards (question, answer, user_id, date_creation, last_modified) VALUES ('Is the world flat?', false, 0, "2024-07-25", "2024-07-25");
INSERT IGNORE INTO true_false_flashcards (question, answer, user_id, date_creation, last_modified) VALUES ('The CPU is responsible for executing instructions for the computer', true, 0, "2024-07-25", "2024-07-25");
INSERT IGNORE INTO definition_flashcards (question, answer, user_id, date_creation, last_modified) VALUES ('What is the definition of an object?', 'Is an instance of a class', 0, "2024-07-25", "2024-07-25");
INSERT IGNORE INTO definition_flashcards (question, answer, user_id, date_creation, last_modified) VALUES ('What is computer science?', 'The study of computers and computing, including their theoretical and algorithmic foundations, hardware and software, and their uses for processing information', 0, "2024-07-25", "2024-07-25");
INSERT IGNORE INTO multiple_choice_flashcards (question, option_one, option_two, option_three, option_four, answer, user_id, date_creation, last_modified)
       VALUES (
           'Which data structure is used for implementing recursion?',
           'Stack',
           'Queue',
           'List',
           'Array',
           1, 0, "2024-07-25", "2024-07-25");
INSERT IGNORE INTO multiple_choice_flashcards (question, option_one, option_two, option_three, option_four, answer, user_id, date_creation, last_modified)
       VALUES (
           'The data structure required for Breadth First Traversal on a graph is?',
           'Array',
           'Stack',
           'Tree',
           'Queue',
           4, 0, "2024-07-25", "2024-07-25");


-- USER 1
INSERT IGNORE INTO true_false_flashcards (question, answer, user_id, date_creation, last_modified) VALUES ('Does earth rotates around the sun?', true, 1, "2024-07-25", "2024-07-25");
INSERT IGNORE INTO true_false_flashcards (question, answer, user_id, date_creation, last_modified) VALUES ('A SD card is an output device', false, 1, "2024-07-25", "2024-07-25");
INSERT IGNORE INTO definition_flashcards (question, answer, user_id, date_creation, last_modified) VALUES ('What is OOB?', 'Object Oriented Programming', 1, "2024-07-25", "2024-07-25");
INSERT IGNORE INTO definition_flashcards (question, answer, user_id, date_creation, last_modified) VALUES ('What is a microprocessor??', 'An integrated circuit having all the functionality of a central processing unit of a PC', 1, "2024-07-25", "2024-07-25");
INSERT IGNORE INTO multiple_choice_flashcards (question, option_one, option_two, option_three, option_four, answer, user_id, date_creation, last_modified)
       VALUES (
           'What is an operating system?',
           'Interface between the hardware and application programs',
           'Collection of programs that manages hardware resources',
           'System service provider to the application programs',
           'All of the mentioned',
           4, 1, "2024-07-25", "2024-07-25");
INSERT IGNORE INTO multiple_choice_flashcards (question, option_one, option_two, option_three, option_four, answer, user_id, date_creation, last_modified)
       VALUES (
           'For real time operating systems, interrupt latency should be ____________',
           'Zero',
           'Minimal',
           'Maximum',
           'Dependent on the scheduling',
           4, 1, "2024-07-25", "2024-07-25");