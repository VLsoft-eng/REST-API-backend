
create table IF NOT EXISTS users
(

    id            bigserial not null,
    phone         bigint    not null unique,
    birthday      date,
    enabled       boolean   not null,
    email         varchar   not null unique,
    password      varchar,
    first_name    varchar,
    last_name     varchar,
    paternal      varchar,
    creation_date timestamp,
    update_date   timestamp,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS wallets (
    id BIGSERIAL PRIMARY KEY,
    balance BIGINT,
    user_id BIGINT UNIQUE,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);

create table IF NOT EXISTS sessions
(
    value           varchar(255),
    user_id         bigint references users (id),
    active          boolean not null,
    expiration_time timestamp,
    primary key (value)
);

CREATE TABLE IF NOT EXISTS transfers (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    amount BIGINT NOT NULL,
    creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    transfer_type VARCHAR(255) NOT NULL,
    sender_wallet_id BIGINT,
    receiver_wallet_id BIGINT,
    receiver_phone_number VARCHAR(255),
    CONSTRAINT fk_sender_wallet FOREIGN KEY (sender_wallet_id) REFERENCES wallets (id),
    CONSTRAINT fk_receiver_wallet FOREIGN KEY (receiver_wallet_id) REFERENCES wallets (id)
);

CREATE TABLE IF NOT EXISTS invoice (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    cost BIGINT NOT NULL,
    sender_id BIGINT NOT NULL,
    receiver_id BIGINT NOT NULL,
    invoice_status VARCHAR(255) NOT NULL,
    comment VARCHAR(255),
    CONSTRAINT fk_sender FOREIGN KEY (sender_id) REFERENCES users (id),
    CONSTRAINT fk_receiver FOREIGN KEY (receiver_id) REFERENCES users (id)
);


