create table bonsai (
    id uuid primary key,
    name varchar(100) not null,
    species varchar(100),
    acquisition_date date,
    acquisition_age integer,
    status varchar(25)
);
alter table bonsai add column owner_id uuid, add constraint fk_bonsai_owner foreign key (owner_id) references users(id);

create table owner(id uuid primary key, name varchar(100));
create table watering (
    id uuid primary key,
    date timestamp,
    bonsai_id uuid,
    constraint fk_watering_bonsai foreign key(bonsai_id) references bonsai(id)
);

create table repotting (
                          id uuid primary key,
                          date timestamp,
                          bonsai_id uuid,
                          constraint fk_repotting_bonsai foreign key(bonsai_id) references bonsai(id)
);

create table pruning (
                          id uuid primary key,
                          date timestamp,
                          bonsai_id uuid,
                          constraint fk_pruning_bonsai foreign key(bonsai_id) references bonsai(id)
);

-- create table owner(id uuid primary key, name varchar(100));


create table users(
                      id uuid primary key,
                      username varchar(150) not null,
                      password varchar(200) not null,
                      enabled boolean not null
);
--     name varchar (150) not null unique
create table authorities (
                             id uuid not null,
                             authority varchar(50) not null,
                             constraint fk_authorities_users foreign key(id) references users(id)
);

create unique index ix_auth_username on authorities (username,authority);