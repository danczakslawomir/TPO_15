INSERT INTO
    App_user (firstName, lastName, email, password)
VALUES
    -- smith@gmail.com / 1111
    ('John', 'Smith', 'smith@gmail.com', '{bcrypt}$2a$10$Z53wu32Yz2l6ww4VgkQe9uikPx8061/.ERQS6GjK48m/5Lqou5dfG'),
    -- alex@pja.edu.pl / 2222
    ('Alex', 'King', 'alex@pja.edu.pl', '{MD5}{rT4wBLjXEvWpB8F0MgvLUDt8v36HSZoTWcDiusl7jh4=}fda9321dca602a2bb6c42955a315a3fa'),
    -- sj@my.com / 2222
    ('Stephen', 'Jones', 'sj@my.com', '{noop}2222');

INSERT INTO
    UserRole (name, description)
VALUES
    ('ADMIN', 'Administrative privileges'),
    ('USER', 'Regular user privileges');

INSERT INTO
    App_user_roles (User_id, roles_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 2),
    (3, 2);
