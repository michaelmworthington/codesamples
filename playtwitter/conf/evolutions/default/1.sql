# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table status (
  id                        bigint not null,
  message                   varchar(255),
  date_created              timestamp,
  constraint pk_status primary key (id))
;

create sequence status_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists status;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists status_seq;

