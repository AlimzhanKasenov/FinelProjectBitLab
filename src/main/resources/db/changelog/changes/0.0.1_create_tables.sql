CREATE TABLE t_users
(
    Id SERIAL PRIMARY KEY NOT NULL,
    email TEXT,
    password TEXT,
    fullName TEXT,
    role INT DEFAULT 1
);

CREATE TABLE t_items
(
    Id SERIAL PRIMARY KEY NOT NULL,
    nameItem TEXT,
    description TEXT,
    price INT DEFAULT 0,
    picture VARCHAR
);

CREATE TABLE t_role
(
    Id SERIAL PRIMARY KEY NOT NULL,
    role TEXT
);