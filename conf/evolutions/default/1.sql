
# --- !Ups

create table users (
  id                        integer auto_increment not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  email_id                  varchar(255),
  password                  varchar(255),
  updated_at                timestamp NOT NULL default current_timestamp on update current_timestamp ,
  created_at                timestamp NOT NULL default '0000-00-00 00:00:00',
  constraint uq_user_email_id unique (email_id),
  constraint pk_user primary key (id),
  index (email_id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

