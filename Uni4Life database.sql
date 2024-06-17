use uni4life;
create table users(
	id int auto_increment not null,
    userName varchar(20) not null,
    email varchar(50) not null,
    userPassword varchar(30) not null,
    balance decimal(10,2) default 0,
    privacity varchar(3),
    constraint pk_users primary key(id,userName),
    constraint chk_privacity check(privacity in('pri','pub'))
);

create table content(
	id int auto_increment not null,
    userId int not null, 
    contentName varchar(50) not null,
    publishDate date not null,
    contentDescription varchar(2000),
    contentType varchar(8),
    price decimal(10,2) default 0,
    author varchar(20) not null,
    constraint pk_content primary key(id),
    constraint fk_users foreign key(userId,author) references users(id,userName)
);
