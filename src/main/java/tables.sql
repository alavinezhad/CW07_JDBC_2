CREATE TABLE IF NOT EXISTS public.employees
(
    employee_number integer NOT NULL,
    last_name character varying(50) NOT NULL,
    first_name character varying(50) NOT NULL,
    office_code integer NOT NULL,
    address_id integer NOT NULL,
    PRIMARY KEY (employee_number)
    );

CREATE TABLE IF NOT EXISTS public.employee_address
(
    address_id integer NOT NULL,
    city character varying(255) NOT NULL,
    street character varying(255) NOT NULL,
    postal_code integer NOT NULL,
    PRIMARY KEY (address_id)
    );

ALTER TABLE IF EXISTS public.employee_address
    ADD FOREIGN KEY (address_id)
    REFERENCES public.employees (address_id) MATCH SIMPLE
    ON UPDATE NO ACTION
       ON DELETE NO ACTION
        NOT VALID;
