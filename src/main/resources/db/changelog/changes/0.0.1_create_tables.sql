CREATE TABLE t_users
(
    id SERIAL PRIMARY KEY NOT NULL,
    email TEXT,
    password TEXT,
    full_name TEXT
);

CREATE TABLE t_items
(
    id SERIAL PRIMARY KEY NOT NULL,
    name_item TEXT,
    description TEXT,
    price INT DEFAULT 0,
    picture VARCHAR,
    author_id INT
);

CREATE TABLE t_role
(
    id SERIAL PRIMARY KEY NOT NULL,
    role TEXT
);

CREATE TABLE t_users_roles
(
    user_id INT NOT NULL,
    roles_id INT NOT NULL
);