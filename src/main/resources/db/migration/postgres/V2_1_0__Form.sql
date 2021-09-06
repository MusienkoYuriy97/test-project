CREATE TABLE IF NOT EXISTS form(
    uuid UUID DEFAULT gen_random_uuid(),
    user_name VARCHAR (20) NOT NULL,
    category_uuid UUID NOT NULL,
    agree_to_terms BOOLEAN,
    PRIMARY KEY (uuid),
    FOREIGN KEY (category_uuid)
        REFERENCES category(uuid));