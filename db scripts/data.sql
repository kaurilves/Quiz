insert into quizdb.quiz (NAME) values('Jeopardy');

insert into quizdb.topics (NAME) values('Politics');
insert into quizdb.topics (NAME) values('Nature');
insert into quizdb.topics (NAME) values('Tech');
insert into quizdb.topics (NAME) values('Varia');

insert into quizdb.questions (NAME, DIFFICULTY_RANK, TOPICS_ID) values('Who is prime minister of Estonia?', 3, 1);
insert into quizdb.questions (NAME, DIFFICULTY_RANK, TOPICS_ID) values('Who is biggest mammal on earth?', 2, 2);
insert into quizdb.questions (NAME, DIFFICULTY_RANK, TOPICS_ID) values('What is the biggest sea on earth', 1, 2);
insert into quizdb.questions (NAME, DIFFICULTY_RANK, TOPICS_ID) values('Who of them is or have been president of Latvia', 3, 1);
insert into quizdb.questions (NAME, DIFFICULTY_RANK, TOPICS_ID) values('What company owns of Intellij', 2, 3);
insert into quizdb.questions (NAME, DIFFICULTY_RANK, TOPICS_ID) values('How is potato in Estonian language?', 2, 4);

insert into quizdb.response (NAME, IS_CORRECT, QUESTIONS_ID) values('Kaja Kallas', true, 1);
insert into quizdb.response (NAME, IS_CORRECT, QUESTIONS_ID) values('Andrus Ansip', false, 1);
insert into quizdb.response (NAME, IS_CORRECT, QUESTIONS_ID) values('Edgar Savisaar', true, 1);
insert into quizdb.response (NAME, IS_CORRECT, QUESTIONS_ID) values('Elephant', false, 2);
insert into quizdb.response (NAME, IS_CORRECT, QUESTIONS_ID) values('Rhino', false, 2);
insert into quizdb.response (NAME, IS_CORRECT, QUESTIONS_ID) values('Blue Whale', true, 2);
insert into quizdb.response (NAME, IS_CORRECT, QUESTIONS_ID) values('Atlantic Ocean', false, 3);
insert into quizdb.response (NAME, IS_CORRECT, QUESTIONS_ID) values('Pacific Ocean', true, 3);
insert into quizdb.response (NAME, IS_CORRECT, QUESTIONS_ID) values('Egils Levits', true, 4);
insert into quizdb.response (NAME, IS_CORRECT, QUESTIONS_ID) values('Valdis Zatlers', true, 4);
insert into quizdb.response (NAME, IS_CORRECT, QUESTIONS_ID) values('Ieva Kupče', false, 4);
insert into quizdb.response (NAME, IS_CORRECT, QUESTIONS_ID) values('Oracle', false, 5);
insert into quizdb.response (NAME, IS_CORRECT, QUESTIONS_ID) values('Microsoft', false, 5);
insert into quizdb.response (NAME, IS_CORRECT, QUESTIONS_ID) values('JetBrains', true, 5);
insert into quizdb.response (NAME, IS_CORRECT, QUESTIONS_ID) values('Porgand', false, 2);
insert into quizdb.response (NAME, IS_CORRECT, QUESTIONS_ID) values('Peet', false, 2);
insert into quizdb.response (NAME, IS_CORRECT, QUESTIONS_ID) values('Kapsas', false, 2);
insert into quizdb.response (NAME, IS_CORRECT, QUESTIONS_ID) values('Kartul', true, 2);

insert into quizdb.questions_in_quizzes (QUESTIONS_ID, QUIZ_ID) values(1,1);
insert into quizdb.questions_in_quizzes (QUESTIONS_ID, QUIZ_ID) values(2,1);
insert into quizdb.questions_in_quizzes (QUESTIONS_ID, QUIZ_ID) values(3,1);
insert into quizdb.questions_in_quizzes (QUESTIONS_ID, QUIZ_ID) values(4,1);
insert into quizdb.questions_in_quizzes (QUESTIONS_ID, QUIZ_ID) values(5,1);
insert into quizdb.questions_in_quizzes (QUESTIONS_ID, QUIZ_ID) values(6,1);
insert into quizdb.questions_in_quizzes (QUESTIONS_ID, QUIZ_ID) values(7,1);



