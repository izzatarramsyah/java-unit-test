-- --
-- -- PostgreSQL database dump
-- --

-- -- Dumped from database version 15.0
-- -- Dumped by pg_dump version 15.0

-- -- Started on 2023-05-05 15:21:40

-- SET statement_timeout = 0;
-- SET lock_timeout = 0;
-- SET idle_in_transaction_session_timeout = 0;
-- SET client_encoding = 'UTF8';
-- SET standard_conforming_strings = on;
-- SELECT pg_catalog.set_config('search_path', '', false);
-- SET check_function_bodies = false;
-- SET xmloption = content;
-- SET client_min_messages = warning;
-- SET row_security = off;

-- --
-- -- TOC entry 3328 (class 1262 OID 5)
-- -- Name: postgres; Type: DATABASE; Schema: -; Owner: postgres
-- --

-- CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Indonesian_Indonesia.1252';


-- ALTER DATABASE postgres OWNER TO postgres;

-- \connect postgres

-- SET statement_timeout = 0;
-- SET lock_timeout = 0;
-- SET idle_in_transaction_session_timeout = 0;
-- SET client_encoding = 'UTF8';
-- SET standard_conforming_strings = on;
-- SELECT pg_catalog.set_config('search_path', '', false);
-- SET check_function_bodies = false;
-- SET xmloption = content;
-- SET client_min_messages = warning;
-- SET row_security = off;

-- --
-- -- TOC entry 3329 (class 0 OID 0)
-- -- Dependencies: 3328
-- -- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: postgres
-- --

-- COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 7 (class 2615 OID 16398)
-- Name: dev; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA dev;


ALTER SCHEMA dev OWNER TO postgres;

--
-- TOC entry 218 (class 1255 OID 16409)
-- Name: seq_user_function(); Type: FUNCTION; Schema: dev; Owner: postgres
--

CREATE FUNCTION dev.seq_user_function() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
   BEGIN
       select nextval('DEV.SEQ_USER') into NEW.id;
       RETURN NEW;
   END;
$$;


ALTER FUNCTION dev.seq_user_function() OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 216 (class 1259 OID 16399)
-- Name: tbl_users; Type: TABLE; Schema: dev; Owner: postgres
--

CREATE TABLE dev.tbl_users (
    id integer NOT NULL,
    username character varying(20),
    password character varying(50),
    fullname character varying(20),
    address character varying(20),
    email character varying(20),
    phone_no character varying(15),
    status character varying(10),
    last_activity timestamp without time zone,
    created_dtm timestamp without time zone,
    created_by character varying(20),
    lastupd_dtm timestamp without time zone,
    lastupd_by character varying(20)
);


ALTER TABLE dev.tbl_users OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16408)
-- Name: seq_user; Type: SEQUENCE; Schema: dev; Owner: postgres
--

CREATE SEQUENCE dev.seq_user
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999
    CACHE 1;


ALTER TABLE dev.seq_user OWNER TO postgres;

--
-- TOC entry 3330 (class 0 OID 0)
-- Dependencies: 217
-- Name: seq_user; Type: SEQUENCE OWNED BY; Schema: dev; Owner: postgres
--

ALTER SEQUENCE dev.seq_user OWNED BY dev.tbl_users.id;


-- --
-- -- TOC entry 3321 (class 0 OID 16399)
-- -- Dependencies: 216
-- -- Data for Name: tbl_users; Type: TABLE DATA; Schema: dev; Owner: postgres
-- --

-- COPY dev.tbl_users (id, username, password, fullname, address, email, phone_no, status, last_activity, created_dtm, created_by, lastupd_dtm, lastupd_by) FROM stdin;
-- 1	testing	ov8I2qwjhBhQ6O3ivvjRHw==	testing	testing	testing@gmail.com	087812341234	ACTIVE	\N	2023-05-05 10:48:14.577	SYSTEM	\N	\N
-- 2	\N	testing	testing	testing	testing@gmail.com	testing	\N	\N	\N	\N	\N	\N
-- 3	testing	ov8I2qwjhBhQ6O3ivvjRHw==	testing	testing	testing@gmail.com	testing	ACTIVE	\N	2023-05-05 14:08:09.839	SYSTEM	\N	\N
-- 4	testing	ov8I2qwjhBhQ6O3ivvjRHw==	testing	\N	testing@gmail.com	\N	ACTIVE	\N	2023-05-05 14:15:18.398	SYSTEM	\N	\N
-- 5	\N	testing	testing	testing	testing@gmail.com	testing	\N	\N	\N	\N	\N	\N
-- 6	testing	ov8I2qwjhBhQ6O3ivvjRHw==	testing	testing	testing@gmail.com	testing	ACTIVE	\N	2023-05-05 14:15:19.259	SYSTEM	\N	\N
-- \.


--
-- TOC entry 3331 (class 0 OID 0)
-- Dependencies: 217
-- Name: seq_user; Type: SEQUENCE SET; Schema: dev; Owner: postgres
--

SELECT pg_catalog.setval('dev.seq_user', 6, true);


--
-- TOC entry 3177 (class 2606 OID 16403)
-- Name: tbl_users tbl_users_pkey; Type: CONSTRAINT; Schema: dev; Owner: postgres
--

ALTER TABLE ONLY dev.tbl_users ADD CONSTRAINT tbl_users_pkey PRIMARY KEY (id);


--
-- TOC entry 3178 (class 2620 OID 16410)
-- Name: tbl_users trg_user; Type: TRIGGER; Schema: dev; Owner: postgres
--

CREATE TRIGGER trg_user BEFORE INSERT ON dev.tbl_users FOR EACH ROW EXECUTE FUNCTION dev.seq_user_function();


-- Completed on 2023-05-05 15:21:41

--
-- PostgreSQL database dump complete
--

