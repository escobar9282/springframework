create table if not exists repair_order
(
    id bigint not null unique ,
    first_name varchar(255),
    last_name varchar(255),
    car_production_date varchar(255),
    make_of_car varchar(255),
    model varchar(255),
    is_car_premium boolean,
    owner_id bigint,
    primary key (id),
    foreign key (owner_id) references owner(id)
);

create table if not exists car_parts_to_repair
(
  id bigint not null unique ,
  part_name varchar(255),
  number_of_parts int4,
  summary_price float,
  repair_order_id bigint,
  primary key (id),
  foreign key (repair_order_id) references repair_order(id)
);