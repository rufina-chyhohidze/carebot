--
--     /*DELIVERY_ID INT,
--     OBSTACLE_TIMESTAMP TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--     DISTANCE DECIMAL(5,2),
--     OBSTACLES INT,
--     DROP_POINT VARCHAR(50),
--     STATUS VARCHAR(50)*/
--
DROP TABLE IF EXISTS OBSTACLE_TABLE;
DROP TABLE IF EXISTS DELIVERY_TABLE;
DROP TABLE IF EXISTS EMPLOYEE_TABLE;
DROP TABLE IF EXISTS item_table CASCADE;
DROP TABLE IF EXISTS item_request_table;
--
-- --     CREATE TABLE DELIVERY_TABLE (
-- --                                     DELIVERY_ID INTEGER CONSTRAINT DELIVERY_PK PRIMARY KEY,
-- --                                     DELIVERY_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
-- --                                     OBSTACLE_QUANTITY INTEGER DEFAULT 1,
-- --                                     DROP_POINT VARCHAR(50),
-- --                                     STATUS VARCHAR(50)
-- --     );
--
-- --   CREATE TABLE IF NOT EXISTS OBSTACLE_TABLE (
-- --     DELIVERY_ID INTEGER CONSTRAINT DELIVERY_FK REFERENCES DELIVERY_TABLE,
-- --     OBSTACLE_ID INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
-- --     OBSTACLE_TIMESTAMP TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
-- --     OBSTACLE_DISTANCE INTEGER
-- --   );
--
--     CREATE TABLE IF NOT EXISTS OBSTACLE_TABLE (
--                                                   OBSTACLE_ID INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
--         OBSTACLE_TIMESTAMP TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--         OBSTACLE_DISTANCE FLOAT
--         );
--
-- -- INSERT INTO DELIVERY_TABLE(DELIVERY_ID, DROP_POINT, STATUS) VALUES (1, 3, 'STOPPED');
--
-- -- INSERT INTO OBSTACLE_TABLE(obstacle_distance) VALUES (9);
--
-- SELECT OBSTACLE_TIMESTAMP, OBSTACLE_DISTANCE
-- FROM OBSTACLE_TABLE
-- ORDER BY 2 DESC;
DELETE FROM item_table;
INSERT INTO item_table  (id, category, name, price, stock_quantity) VALUES
    (1, 'Tablet', 'Apple iPad Air', 278, 195),
    (2, 'Laptop', 'Dell XPS 13', 2900, 448),
    (3, 'Tablet', 'HP Spectre x360', 185, 395),
    (4, 'Laptop', 'MacBook Pro 16', 648, 360),
    (5, 'Laptop', 'Lenovo Yoga 7i', 872, 158),
    (6, 'Laptop', 'Acer Swift 3', 2900, 241),
    (7, 'Tablet', 'Samsung Galaxy Tab S7', 775, 208),
    (8, 'Laptop', 'Apple MacBook Air', 544, 312),
    (9, 'Tablet', 'Lenovo Tab P11', 8202, 243),
    (10, 'Tablet', 'Acer Iconia Tab 10', 2900, 302),
    (11, 'Tablet', 'Dell Latitude 7320', 2900, 364),
    (12, 'Laptop', 'Lenovo Legion 5', 872, 119),
    (13, 'Tablet', 'MacBook Pro iPad Edition', 787, 128),
    (14, 'Laptop', 'HP Omen 15', 1816, 362),
    (15, 'Tablet', 'Apple iPad Mini', 195, 336),
    (16, 'Laptop', 'Acer Aspire 5', 2782, 366),
    (17, 'Laptop', 'Dell Inspiron 14', 313, 156),
    (18, 'Laptop', 'Samsung Galaxy Book Pro', 2900, 179),
    (19, 'Tablet', 'HP Envy x2', 6887, 441),
    (20, 'Tablet', 'Lenovo Tab M10', 2900, 278),
    (21, 'Laptop', 'Apple MacBook Pro 13', 3189, 299),
    (22, 'Laptop', 'Dell Alienware M15', 9284, 364),
    (23, 'Laptop', 'Lenovo ThinkPad X1 Carbon', 467, 281),
    (24, 'Laptop', 'MacBook Pro 14', 9582, 368),
    (25, 'Laptop', 'HP Elite Dragonfly', 1816, 362),
    (26, 'Tablet', 'Acer Aspire Switch 10', 820, 365),
    (27, 'Laptop', 'Apple MacBook Pro M1', 643, 150),
    (28, 'Tablet', 'Dell Venue 8 Pro', 6295, 180),
    (29, 'Laptop', 'Acer Predator Helios 300', 1712, 210),
    (30, 'Laptop', 'Apple iMac Pro', 7475, 165),
    (31, 'Laptop', 'Lenovo ThinkPad T14', 8237, 214),
    (32, 'Laptop', 'MacBook Pro Retina', 5429, 201),
    (33, 'Laptop', 'Samsung Galaxy Book', 3856, 338),
    (34, 'Laptop', 'Dell Precision 5550', 2900, 361),
    (35, 'Tablet', 'Acer Iconia One 7', 820, 365),
    (36, 'Laptop', 'Apple MacBook Pro 17', 643, 150),
    (37, 'Tablet', 'HP Chromebook x360', 2900, 441),
    (38, 'Tablet', 'HP Pro Slate 12', 2900, 467),
    (39, 'Laptop', 'Dell XPS 17', 815, 326),
    (40, 'Tablet', 'HP TouchPad', 768, 472),
    (41, 'Tablet', 'MacBook Air iPad Edition', 787, 128),
    (42, 'Laptop', 'HP Spectre x360 14', 908, 202),
    (43, 'Laptop', 'Lenovo ThinkPad L14', 286, 310),
    (44, 'Tablet', 'Samsung Galaxy Tab A7', 1855, 102),
    (45, 'Laptop', 'Lenovo ThinkPad P1', 2900, 350),
    (46, 'Laptop', 'MacBook Pro 2024', 2900, 327),
    (47, 'Tablet', 'MacBook Pro Tablet Edition', 362, 209),
    (48, 'Laptop', 'HP ProBook 450', 460, 151),
    (49, 'Tablet', 'HP ElitePad 900', 2237, 149),
    (50, 'Laptop', 'Dell Latitude 7410', 456, 449);

SELECT id, category, name, CONCAT(price, '€') AS price, stock_quantity FROM item_table;



DELETE FROM delivery_table WHERE status = 'PROCESSING';