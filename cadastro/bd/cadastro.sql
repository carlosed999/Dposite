create database cadastro;
use cadastro;
/*// banco de dados para armazenamento das informações/*/
create table usuarios(

id int primary key auto_increment,
nome varchar(50) not null,
sobrenome varchar(50) not null,
email varchar(30) not null unique,
telefone varchar(15) not null,
senha varchar(50) not null,
data_cadastro timestamp default current_timestamp
);

insert into usuarios(email, senha, nome, sobrenome, telefone)
values('carl@gmail.com', md5('carlos'), 'Carlos', 'Eduardo', '(63)99200-0000');
