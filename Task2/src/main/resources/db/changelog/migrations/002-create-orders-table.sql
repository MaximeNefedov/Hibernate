create table orders
(
    id serial primary key,
    date date not null,
    customer_id int not null,
    product_name varchar(255) not null,
    amount int check (amount > 0) not null,
    foreign key (customer_id) references customers(id)
);

create index index_name on orders (customer_id);