drop table if exists calc;

create table if not exists calc
(
    id             bigserial primary key,
    first_number    double precision not null,
    second_number   double precision not null,
    result         double precision not null,
    action         VARCHAR(20)
);
CREATE SEQUENCE if not exists calculations_id_seq START WITH 1 INCREMENT BY 1;