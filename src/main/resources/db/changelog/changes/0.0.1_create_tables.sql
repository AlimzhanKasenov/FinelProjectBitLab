CREATE TABLE IF NOT EXISTS t_users
(
    id SERIAL PRIMARY KEY NOT NULL,
    email TEXT,
    password TEXT,
    full_name TEXT
);

CREATE TABLE IF NOT EXISTS t_items
(
    id SERIAL PRIMARY KEY NOT NULL,
    name_item TEXT,
    description TEXT,
    price INT DEFAULT 0,
    picture VARCHAR,
    author INT NOT NULL,
    constraint users_author_error
    foreign key (author) references t_users(id)
);

CREATE TABLE IF NOT EXISTS t_role
(
    id SERIAL PRIMARY KEY NOT NULL,
    role TEXT
);

CREATE TABLE IF NOT EXISTS t_users_roles(
    user_id int not null,
    roles_id int not null,
    constraint users_roles_error_1
    foreign key (user_id) references t_users(id),
    constraint users_roles_error_2
    foreign key (roles_id) references t_role(id)
);