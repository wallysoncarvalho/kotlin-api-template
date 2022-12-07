create table foobar(
    id serial primary key,
    name varchar(200) not null,
    age smallint not null,
    created_by varchar(100) not null,
    created_at timestamp with time zone not null
);
