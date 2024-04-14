--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: model_teste; Type: TABLE; Schema: public; Owner: money
--

CREATE TABLE public.model_teste (
    id bigint NOT NULL,
    desconto_orcamento numeric(38,2),
    icms_estados character varying(255),
    qtd_itens numeric(38,2),
    valor_icms numeric(38,2),
    valor_orcamento numeric(38,2),
    CONSTRAINT model_teste_icms_estados_check CHECK (((icms_estados)::text = ANY ((ARRAY['ICMS_MG'::character varying, 'ICMS_SP'::character varying, 'ICMS_RJ'::character varying])::text[])))
);


ALTER TABLE public.model_teste OWNER TO money;

--
-- Name: model_teste_id_seq; Type: SEQUENCE; Schema: public; Owner: money
--

CREATE SEQUENCE public.model_teste_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.model_teste_id_seq OWNER TO money;

--
-- Name: model_teste_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: money
--

ALTER SEQUENCE public.model_teste_id_seq OWNED BY public.model_teste.id;


--
-- Name: orcamento; Type: TABLE; Schema: public; Owner: money
--

CREATE TABLE public.orcamento (
    id bigint NOT NULL,
    icms_estados character varying(50),
    valor_orcamento numeric(38,2) NOT NULL,
    valor_icms numeric(38,2),
    usuario_id bigint,
    qtd_itens numeric(38,2),
    desconto_orcamento numeric(38,2)
);


ALTER TABLE public.orcamento OWNER TO money;

--
-- Name: orcamento_id_seq; Type: SEQUENCE; Schema: public; Owner: money
--

CREATE SEQUENCE public.orcamento_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.orcamento_id_seq OWNER TO money;

--
-- Name: orcamento_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: money
--

ALTER SEQUENCE public.orcamento_id_seq OWNED BY public.orcamento.id;


--
-- Name: usuario; Type: TABLE; Schema: public; Owner: money
--

CREATE TABLE public.usuario (
    id bigint NOT NULL,
    nome_usuario character varying NOT NULL
);


ALTER TABLE public.usuario OWNER TO money;

--
-- Name: usuario_id_seq; Type: SEQUENCE; Schema: public; Owner: money
--

CREATE SEQUENCE public.usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.usuario_id_seq OWNER TO money;

--
-- Name: usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: money
--

ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;


--
-- Name: model_teste id; Type: DEFAULT; Schema: public; Owner: money
--

ALTER TABLE ONLY public.model_teste ALTER COLUMN id SET DEFAULT nextval('public.model_teste_id_seq'::regclass);


--
-- Name: orcamento id; Type: DEFAULT; Schema: public; Owner: money
--

ALTER TABLE ONLY public.orcamento ALTER COLUMN id SET DEFAULT nextval('public.orcamento_id_seq'::regclass);


--
-- Name: usuario id; Type: DEFAULT; Schema: public; Owner: money
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);


--
-- Data for Name: model_teste; Type: TABLE DATA; Schema: public; Owner: money
--

COPY public.model_teste (id, desconto_orcamento, icms_estados, qtd_itens, valor_icms, valor_orcamento) FROM stdin;
\.


--
-- Data for Name: orcamento; Type: TABLE DATA; Schema: public; Owner: money
--

COPY public.orcamento (id, icms_estados, valor_orcamento, valor_icms, usuario_id, qtd_itens, desconto_orcamento) FROM stdin;
1	ICMS_MG	1000.00	300.00	2	1.00	700.00
\.


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: money
--

COPY public.usuario (id, nome_usuario) FROM stdin;
2	Nome do Usuário
\.


--
-- Name: model_teste_id_seq; Type: SEQUENCE SET; Schema: public; Owner: money
--

SELECT pg_catalog.setval('public.model_teste_id_seq', 1, false);


--
-- Name: orcamento_id_seq; Type: SEQUENCE SET; Schema: public; Owner: money
--

SELECT pg_catalog.setval('public.orcamento_id_seq', 2, true);


--
-- Name: usuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: money
--

SELECT pg_catalog.setval('public.usuario_id_seq', 2, true);


--
-- Name: model_teste model_teste_pkey; Type: CONSTRAINT; Schema: public; Owner: money
--

ALTER TABLE ONLY public.model_teste
    ADD CONSTRAINT model_teste_pkey PRIMARY KEY (id);


--
-- Name: orcamento orcamento_pkey; Type: CONSTRAINT; Schema: public; Owner: money
--

ALTER TABLE ONLY public.orcamento
    ADD CONSTRAINT orcamento_pkey PRIMARY KEY (id);


--
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: money
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


--
-- Name: orcamento orcamento_usuario_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: money
--

ALTER TABLE ONLY public.orcamento
    ADD CONSTRAINT orcamento_usuario_id_fkey FOREIGN KEY (usuario_id) REFERENCES public.usuario(id);


--
-- PostgreSQL database dump complete
--

