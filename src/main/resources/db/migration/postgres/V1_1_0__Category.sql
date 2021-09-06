CREATE TABLE IF NOT EXISTS category(
    uuid UUID DEFAULT gen_random_uuid(),
    name VARCHAR (100) NOT NULL,
    parent_uuid UUID,
    PRIMARY KEY (uuid),
    FOREIGN KEY (parent_uuid)
        REFERENCES category(uuid));

-- Manufacturing
WITH manufacturing AS (
    INSERT INTO category (name) VALUES ('Manufacturing') RETURNING uuid)
INSERT INTO category (name, parent_uuid)
VALUES ('Construction materials', (SELECT uuid FROM manufacturing)),
       ('Electronics and Optics', (SELECT uuid FROM manufacturing)),
       ('Food and Beverage', (SELECT uuid FROM manufacturing)),
       ('Furniture', (SELECT uuid FROM manufacturing)),
       ('Machinery', (SELECT uuid FROM manufacturing)),
       ('Metalworking', (SELECT uuid FROM manufacturing)),
       ('Plastic and Rubber', (SELECT uuid FROM manufacturing)),
       ('Printing', (SELECT uuid FROM manufacturing)),
       ('Textile and Clothing', (SELECT uuid FROM manufacturing)),
       ('Wood', (SELECT uuid FROM manufacturing));

WITH food AS (
    SELECT uuid FROM category where name='Food and Beverage')
INSERT INTO category (name, parent_uuid)
VALUES ('Bakery & confectionery products', (SELECT uuid FROM food)),
       ('Beverages', (SELECT uuid FROM food)),
       ('Fish & fish products', (SELECT uuid FROM food)),
       ('Meat & meat products', (SELECT uuid FROM food)),
       ('Milk & dairy products', (SELECT uuid FROM food)),
       ('Other', (SELECT uuid FROM food)),
       ('Sweets & snack food', (SELECT uuid FROM food));

WITH furniture AS (
    SELECT uuid FROM category where name='Furniture')
INSERT INTO category (name, parent_uuid)
VALUES ('Bathroom/sauna', (SELECT uuid FROM furniture)),
       ('Bedroom', (SELECT uuid FROM furniture)),
       ('Kitchen', (SELECT uuid FROM furniture)),
       ('Living room', (SELECT uuid FROM furniture)),
       ('Other (Furniture)', (SELECT uuid FROM furniture)),
       ('Outdoor', (SELECT uuid FROM furniture)),
       ('Project furniture', (SELECT uuid FROM furniture));


WITH machinery AS (
    SELECT uuid FROM category where name='Machinery')
INSERT INTO category (name, parent_uuid)
VALUES ('Machinery components', (SELECT uuid FROM machinery)),
       ('Machinery equipment/tools', (SELECT uuid FROM machinery)),
       ('Manufacture of machinery', (SELECT uuid FROM machinery)),
       ('Maritime', (SELECT uuid FROM machinery)),
       ('Metal structures', (SELECT uuid FROM machinery)),
       ('Outdoor', (SELECT uuid FROM machinery)),
       ('Repair and maintenance service', (SELECT uuid FROM machinery));


WITH maritime AS (
    SELECT uuid FROM category where name='Maritime')
INSERT INTO category (name, parent_uuid)
VALUES ('Aluminium and steel workboats', (SELECT uuid FROM maritime)),
       ('Boat/Yacht building', (SELECT uuid FROM maritime)),
       ('Ship repair and conversion', (SELECT uuid FROM maritime));


WITH metalworking AS (
    SELECT uuid FROM category where name='Metalworking')
INSERT INTO category (name, parent_uuid)
VALUES ('Construction of metal structures', (SELECT uuid FROM metalworking)),
       ('Houses and buildings', (SELECT uuid FROM metalworking)),
       ('Metal products', (SELECT uuid FROM metalworking)),
       ('Metal works', (SELECT uuid FROM metalworking));

WITH metalworks AS (
    SELECT uuid FROM category where name='Metal works')
INSERT INTO category (name, parent_uuid)
VALUES ('CNC-machining', (SELECT uuid FROM metalworks)),
       ('Forgings, Fasteners', (SELECT uuid FROM metalworks)),
       ('Gas, Plasma, Laser cutting', (SELECT uuid FROM metalworks)),
       ('MIG, TIG, Aluminum welding', (SELECT uuid FROM metalworks));

WITH plastic AS (
    SELECT uuid FROM category where name='Plastic and Rubber')
INSERT INTO category (name, parent_uuid)
VALUES ('Plastic processing technology', (SELECT uuid FROM plastic)),
       ('Plastic goods', (SELECT uuid FROM plastic)),
       ('Packaging', (SELECT uuid FROM plastic)),
       ('Plastic profiles', (SELECT uuid FROM plastic));

WITH plasticprocessing AS (
    SELECT uuid FROM category where name='Plastic processing technology')
INSERT INTO category (name, parent_uuid)
VALUES ('Blowing', (SELECT uuid FROM plasticprocessing)),
       ('Moulding', (SELECT uuid FROM plasticprocessing)),
       ('Plastics welding and processing', (SELECT uuid FROM plasticprocessing));

WITH printing AS (
    SELECT uuid FROM category where name='Printing')
INSERT INTO category (name, parent_uuid)
VALUES ('Advertising', (SELECT uuid FROM printing)),
       ('Book/Periodicals printing', (SELECT uuid FROM printing)),
       ('Labelling and packaging printing', (SELECT uuid FROM printing));

WITH textile AS (
    SELECT uuid FROM category where name='Textile and Clothing')
INSERT INTO category (name, parent_uuid)
VALUES ('Clothing', (SELECT uuid FROM textile)),
       ('Textile', (SELECT uuid FROM textile));

WITH wood AS (
    SELECT uuid FROM category where name='Wood')
INSERT INTO category (name, parent_uuid)
VALUES ('Other (Wood)', (SELECT uuid FROM wood)),
       ('Wooden building materials', (SELECT uuid FROM wood)),
       ('Wooden houses', (SELECT uuid FROM wood));


-- Others
WITH others AS (
    INSERT INTO category (name) VALUES ('Others') RETURNING uuid)
INSERT INTO category (name, parent_uuid)
VALUES ('Creative industries', (SELECT uuid FROM others)),
       ('Energy technology', (SELECT uuid FROM others)),
       ('Environment', (SELECT uuid FROM others));

-- Service
WITH service AS (
    INSERT INTO category (name) VALUES ('Service') RETURNING uuid)
INSERT INTO category (name, parent_uuid)
VALUES ('Business services', (SELECT uuid FROM service)),
       ('Engineering', (SELECT uuid FROM service)),
       ('Information Technology and Telecommunications', (SELECT uuid FROM service)),
       ('Tourism', (SELECT uuid FROM service)),
       ('Translation services', (SELECT uuid FROM service)),
       ('Transport and Logistics', (SELECT uuid FROM service));

WITH information AS (
    SELECT uuid FROM category where name='Information Technology and Telecommunications')
INSERT INTO category (name, parent_uuid)
VALUES ('Data processing, Web portals, E-marketing', (SELECT uuid FROM information)),
       ('Programming, Consultancy', (SELECT uuid FROM information)),
       ('Software, Hardware', (SELECT uuid FROM information)),
       ('Telecommunications', (SELECT uuid FROM information));

WITH transport AS (
    SELECT uuid FROM category where name='Transport and Logistics')
INSERT INTO category (name, parent_uuid)
VALUES ('Air', (SELECT uuid FROM transport)),
       ('Rail', (SELECT uuid FROM transport)),
       ('Road', (SELECT uuid FROM transport)),
       ('Water', (SELECT uuid FROM transport));