CREATE SEQUENCE IF NOT EXISTS public.books_id_seq;

CREATE TABLE IF NOT EXISTS public.books
(
    id bigint NOT NULL DEFAULT nextval('books_id_seq'::regclass),
    name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    author character varying(25) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT books_pkey PRIMARY KEY (id)
);