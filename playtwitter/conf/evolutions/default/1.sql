# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table status (
  id                        bigint not null,
  message                   varchar(255),
  date_created              timestamp,
  constraint pk_status primary key (id))
;

create table user (
  id                        bigint not null,
  username                  varchar(255),
  constraint pk_user primary key (id))
;


create table friends (
  friend_id                      bigint not null,
  user_id                        bigint not null,
  constraint pk_friends primary key (friend_id, user_id))
;
create sequence status_seq;

create sequence user_seq;




alter table friends add constraint fk_friends_user_01 foreign key (friend_id) references user (id) on delete restrict on update restrict;

alter table friends add constraint fk_friends_user_02 foreign key (user_id) references user (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists status;

drop table if exists user;

drop table if exists friends;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists status_seq;

drop sequence if exists user_seq;

