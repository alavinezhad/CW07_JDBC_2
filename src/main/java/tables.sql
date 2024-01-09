CREATE TABLE IF NOT EXISTS public.employees
(
    employee_number SERIAL NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    office_code integer NOT NULL,
    address_id integer NOT NULL UNIQUE,
    PRIMARY KEY (employee_number)
    );

CREATE TABLE IF NOT EXISTS public.employee_address
(
    address_id SERIAL NOT NULL,
    city VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    postal_code integer NOT NULL,
    PRIMARY KEY (address_id)
    );

ALTER TABLE IF EXISTS public."Employee"
    ADD FOREIGN KEY (address_id)
        REFERENCES public.employee_address (address_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID;
/*ALTER TABLE IF EXISTS public.employee_address
    ADD FOREIGN KEY (address_id)
    REFERENCES public.employees (address_id) MATCH SIMPLE
    ON UPDATE NO ACTION
       ON DELETE NO ACTION
        NOT VALID;
*/
INSERT INTO employees (last_name, first_name, office_code, address_id)
VALUES ('alavi', 'hassan', 1, 123);