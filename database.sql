--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: animals; Type: TABLE; Schema: public; Owner: alanamorosky
--

CREATE TABLE animals (
    id integer NOT NULL,
    name character varying,
    health character varying,
    age character varying,
    status boolean
);


ALTER TABLE animals OWNER TO alanamorosky;

--
-- Name: animals_id_seq; Type: SEQUENCE; Schema: public; Owner: alanamorosky
--

CREATE SEQUENCE animals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE animals_id_seq OWNER TO alanamorosky;

--
-- Name: animals_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: alanamorosky
--

ALTER SEQUENCE animals_id_seq OWNED BY animals.id;


--
-- Name: animals_sightings; Type: TABLE; Schema: public; Owner: alanamorosky
--

CREATE TABLE animals_sightings (
    id integer NOT NULL,
    animal_id integer,
    sighting_id integer
);


ALTER TABLE animals_sightings OWNER TO alanamorosky;

--
-- Name: animals_sightings_id_seq; Type: SEQUENCE; Schema: public; Owner: alanamorosky
--

CREATE SEQUENCE animals_sightings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE animals_sightings_id_seq OWNER TO alanamorosky;

--
-- Name: animals_sightings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: alanamorosky
--

ALTER SEQUENCE animals_sightings_id_seq OWNED BY animals_sightings.id;


--
-- Name: sightings; Type: TABLE; Schema: public; Owner: alanamorosky
--

CREATE TABLE sightings (
    id integer NOT NULL,
    animal_id integer,
    location character varying,
    "time" bigint,
    ranger_name character varying
);


ALTER TABLE sightings OWNER TO alanamorosky;

--
-- Name: sightings_id_seq; Type: SEQUENCE; Schema: public; Owner: alanamorosky
--

CREATE SEQUENCE sightings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sightings_id_seq OWNER TO alanamorosky;

--
-- Name: sightings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: alanamorosky
--

ALTER SEQUENCE sightings_id_seq OWNED BY sightings.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: alanamorosky
--

ALTER TABLE ONLY animals ALTER COLUMN id SET DEFAULT nextval('animals_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: alanamorosky
--

ALTER TABLE ONLY animals_sightings ALTER COLUMN id SET DEFAULT nextval('animals_sightings_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: alanamorosky
--

ALTER TABLE ONLY sightings ALTER COLUMN id SET DEFAULT nextval('sightings_id_seq'::regclass);


--
-- Data for Name: animals; Type: TABLE DATA; Schema: public; Owner: alanamorosky
--

COPY animals (id, name, health, age, status) FROM stdin;
\.


--
-- Name: animals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: alanamorosky
--

SELECT pg_catalog.setval('animals_id_seq', 26, true);


--
-- Data for Name: animals_sightings; Type: TABLE DATA; Schema: public; Owner: alanamorosky
--

COPY animals_sightings (id, animal_id, sighting_id) FROM stdin;
\.


--
-- Name: animals_sightings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: alanamorosky
--

SELECT pg_catalog.setval('animals_sightings_id_seq', 25, true);


--
-- Data for Name: sightings; Type: TABLE DATA; Schema: public; Owner: alanamorosky
--

COPY sightings (id, animal_id, location, "time", ranger_name) FROM stdin;
\.


--
-- Name: sightings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: alanamorosky
--

SELECT pg_catalog.setval('sightings_id_seq', 26, true);


--
-- Name: animals_pkey; Type: CONSTRAINT; Schema: public; Owner: alanamorosky
--

ALTER TABLE ONLY animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);


--
-- Name: animals_sightings_pkey; Type: CONSTRAINT; Schema: public; Owner: alanamorosky
--

ALTER TABLE ONLY animals_sightings
    ADD CONSTRAINT animals_sightings_pkey PRIMARY KEY (id);


--
-- Name: sightings_pkey; Type: CONSTRAINT; Schema: public; Owner: alanamorosky
--

ALTER TABLE ONLY sightings
    ADD CONSTRAINT sightings_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: alanamorosky
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM alanamorosky;
GRANT ALL ON SCHEMA public TO alanamorosky;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

