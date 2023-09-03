create table book (
    id int primary key generated by default as identity,
    name varchar(100) not null,
    author varchar(100) not null
);

insert into book (name, author) values ('Black eyes', 'Tim Bob');
insert into book (name, author) values ('Yellow eyes', 'Sam Chinton');
insert into book (name, author) values ('White eyes', 'Vanya Sergeev');