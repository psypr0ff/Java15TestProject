/*
create table summary (
id int,
fio varchar(255),
dob varchar(255),
email varchar(255),
skype varchar(255),
avatar varchar(255),
target varchar(255),
EXPERIENCES varchar(255),
EDUCATIONS varchar(255),
ADDITIONAL_EDUCATIONS varchar(255),
SKILLS varchar(255)
);*/
ALTER table summary alter column id {bigint(19) not null auto_increment};
insert into summary
(
/*ID,*/
FIO,
DOB,
email,
SKYPE,
AVATAR,
TARGET,
EXPERIENCES,
EDUCATIONS,
ADDITIONAL_EDUCATIONS,
SKILLS,
EXAMPLES_CODE
)
values (
/*1,*/
'Александр Сергеевич Мишенькин',
'18.03.1987база',
'm_alex_s@mail.ru;psypr0ff@gmail.com',
'psypr0ff',
'https://pp.userapi.com/c848736/v848736995/9df7f/CmIJNcRDQTo.jpg',
'Глубже изучить язык JAVA',

'АО "ИНТЕЛ А/О": технический консультант;
 АО "АБН АМРО Банк": Специалист IT;
 МБОУ Лицей №16 при УлГТУ г.Димитровграда: Учитель информатики;
 ООО "КС Техника": менеджер',

 'МГИЭТ, Управление качеством;
 УлГТУ, Управление качеством',

 'IT.Place: Автоматизация тестирования-4;
  IT.Place: QA-11;
  IT.Place:  Java. Разработка в тестировании UI',

  'JAVA;
  Delphi:30;
  C++:20;
  PHP:50;
  HTML:40;
  SQL:60',

  'https://github.com/psypr0ff/SimbirsoftSeleleniumAdvancedHomework;
  https://github.com/psypr0ff/simbirsoftAvitoCatFinder;
  https://github.com/psypr0ff/ConsoleDownloader;
  https://github.com/psypr0ff/Java15TestProject'
);
