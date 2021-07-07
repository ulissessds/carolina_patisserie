--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.3

-- Started on 2021-07-05 09:10:59

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
-- TOC entry 211 (class 1259 OID 16557)
-- Name: carrinho_produtos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.carrinho_produtos (
    secao_id integer NOT NULL,
    produto_id integer NOT NULL,
    quantidade integer,
    criado_em date NOT NULL,
    modificado_em date
);


ALTER TABLE public.carrinho_produtos OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16474)
-- Name: categoria_produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categoria_produto (
    categoria_id integer NOT NULL,
    nome character varying NOT NULL,
    descricao character varying NOT NULL,
    criado_em date NOT NULL,
    modificado_em date,
    deletado_em date
);


ALTER TABLE public.categoria_produto OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16412)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    cliente_id integer NOT NULL,
    username character varying NOT NULL,
    senha character varying NOT NULL,
    nome character varying NOT NULL,
    criado_em date NOT NULL,
    modificado_em date
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16461)
-- Name: cliente_endereco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente_endereco (
    endereco_id integer NOT NULL,
    cliente_id integer NOT NULL,
    cidade character varying NOT NULL,
    bairro character varying NOT NULL,
    rua character varying NOT NULL,
    cep character varying NOT NULL,
    complemento character varying
);


ALTER TABLE public.cliente_endereco OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16448)
-- Name: cliente_pagamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente_pagamento (
    pagamento_id integer NOT NULL,
    cliente_id integer NOT NULL,
    tipo_pagamento character varying NOT NULL,
    provedor character varying NOT NULL,
    numero_conta integer NOT NULL,
    expiracao date NOT NULL
);


ALTER TABLE public.cliente_pagamento OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16438)
-- Name: cliente_telefone; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente_telefone (
    telefone_id integer NOT NULL,
    cliente_id integer NOT NULL,
    telefone_numero integer NOT NULL,
    "telefone_DDD" integer NOT NULL
);


ALTER TABLE public.cliente_telefone OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16487)
-- Name: desconto_produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.desconto_produto (
    desconto_id integer NOT NULL,
    desconto numeric NOT NULL,
    ativo boolean NOT NULL,
    criado_em date NOT NULL,
    modificado_em date,
    deletado_em date
);


ALTER TABLE public.desconto_produto OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16482)
-- Name: estoque_produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estoque_produto (
    estoque_id integer NOT NULL,
    quantidade integer NOT NULL,
    criado_em date NOT NULL,
    modificado_em date,
    deletado_em date
);


ALTER TABLE public.estoque_produto OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16518)
-- Name: pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido (
    pedido_id integer NOT NULL,
    cliente_id integer NOT NULL,
    total numeric NOT NULL,
    criado_em date,
    modificado_em date
);


ALTER TABLE public.pedido OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16531)
-- Name: pedido_pagamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido_pagamento (
    pagamento_id integer NOT NULL,
    pedido_id integer NOT NULL,
    preco numeric NOT NULL,
    provedor character varying NOT NULL,
    status character varying NOT NULL,
    criado_em date NOT NULL,
    modificado_em date
);


ALTER TABLE public.pedido_pagamento OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16572)
-- Name: pedido_produtos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido_produtos (
    pedido_id integer NOT NULL,
    produto_id integer NOT NULL,
    quantidade integer,
    criado_em date NOT NULL,
    modificado_em date
);


ALTER TABLE public.pedido_produtos OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16495)
-- Name: produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produto (
    produto_id integer NOT NULL,
    categoria_id integer,
    estoque_id integer,
    desconto_id integer,
    nome character varying NOT NULL,
    descricao character varying NOT NULL,
    preco numeric NOT NULL,
    criado_em date NOT NULL,
    modificado_em date,
    deletado_em date
);


ALTER TABLE public.produto OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16544)
-- Name: secao_compra; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.secao_compra (
    secao_id integer NOT NULL,
    cliente_id integer NOT NULL,
    total numeric NOT NULL,
    criado_em date NOT NULL,
    modificado_em date
);


ALTER TABLE public.secao_compra OWNER TO postgres;

--
-- TOC entry 3085 (class 0 OID 16557)
-- Dependencies: 211
-- Data for Name: carrinho_produtos; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3078 (class 0 OID 16474)
-- Dependencies: 204
-- Data for Name: categoria_produto; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3074 (class 0 OID 16412)
-- Dependencies: 200
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3077 (class 0 OID 16461)
-- Dependencies: 203
-- Data for Name: cliente_endereco; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3076 (class 0 OID 16448)
-- Dependencies: 202
-- Data for Name: cliente_pagamento; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3075 (class 0 OID 16438)
-- Dependencies: 201
-- Data for Name: cliente_telefone; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3080 (class 0 OID 16487)
-- Dependencies: 206
-- Data for Name: desconto_produto; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3079 (class 0 OID 16482)
-- Dependencies: 205
-- Data for Name: estoque_produto; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3082 (class 0 OID 16518)
-- Dependencies: 208
-- Data for Name: pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3083 (class 0 OID 16531)
-- Dependencies: 209
-- Data for Name: pedido_pagamento; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3086 (class 0 OID 16572)
-- Dependencies: 212
-- Data for Name: pedido_produtos; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3081 (class 0 OID 16495)
-- Dependencies: 207
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3084 (class 0 OID 16544)
-- Dependencies: 210
-- Data for Name: secao_compra; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2928 (class 2606 OID 16561)
-- Name: carrinho_produtos carrinho_produtos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carrinho_produtos
    ADD CONSTRAINT carrinho_produtos_pkey PRIMARY KEY (secao_id, produto_id);


--
-- TOC entry 2914 (class 2606 OID 16481)
-- Name: categoria_produto categoria_produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria_produto
    ADD CONSTRAINT categoria_produto_pkey PRIMARY KEY (categoria_id);


--
-- TOC entry 2912 (class 2606 OID 16468)
-- Name: cliente_endereco cliente_endereco_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente_endereco
    ADD CONSTRAINT cliente_endereco_pkey PRIMARY KEY (endereco_id);


--
-- TOC entry 2910 (class 2606 OID 16455)
-- Name: cliente_pagamento cliente_pagamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente_pagamento
    ADD CONSTRAINT cliente_pagamento_pkey PRIMARY KEY (pagamento_id);


--
-- TOC entry 2906 (class 2606 OID 16419)
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (cliente_id);


--
-- TOC entry 2908 (class 2606 OID 16442)
-- Name: cliente_telefone cliente_telefone_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente_telefone
    ADD CONSTRAINT cliente_telefone_pkey PRIMARY KEY (telefone_id);


--
-- TOC entry 2918 (class 2606 OID 16494)
-- Name: desconto_produto desconto_produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.desconto_produto
    ADD CONSTRAINT desconto_produto_pkey PRIMARY KEY (desconto_id);


--
-- TOC entry 2916 (class 2606 OID 16486)
-- Name: estoque_produto estoque_produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estoque_produto
    ADD CONSTRAINT estoque_produto_pkey PRIMARY KEY (estoque_id);


--
-- TOC entry 2924 (class 2606 OID 16538)
-- Name: pedido_pagamento pedido_pagamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_pagamento
    ADD CONSTRAINT pedido_pagamento_pkey PRIMARY KEY (pagamento_id);


--
-- TOC entry 2922 (class 2606 OID 16525)
-- Name: pedido pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (pedido_id);


--
-- TOC entry 2930 (class 2606 OID 16576)
-- Name: pedido_produtos pedido_produtos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_produtos
    ADD CONSTRAINT pedido_produtos_pkey PRIMARY KEY (pedido_id, produto_id);


--
-- TOC entry 2920 (class 2606 OID 16502)
-- Name: produto produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (produto_id);


--
-- TOC entry 2926 (class 2606 OID 16551)
-- Name: secao_compra secao_compra_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secao_compra
    ADD CONSTRAINT secao_compra_pkey PRIMARY KEY (secao_id);


--
-- TOC entry 2941 (class 2606 OID 16567)
-- Name: carrinho_produtos carrinho_produto_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carrinho_produtos
    ADD CONSTRAINT carrinho_produto_id_fk FOREIGN KEY (produto_id) REFERENCES public.produto(produto_id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2940 (class 2606 OID 16562)
-- Name: carrinho_produtos carrinho_secao_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carrinho_produtos
    ADD CONSTRAINT carrinho_secao_id_fk FOREIGN KEY (secao_id) REFERENCES public.secao_compra(secao_id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2934 (class 2606 OID 16503)
-- Name: produto categoria_produto_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT categoria_produto_id_fk FOREIGN KEY (categoria_id) REFERENCES public.categoria_produto(categoria_id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2933 (class 2606 OID 16469)
-- Name: cliente_endereco cliente_endereco_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente_endereco
    ADD CONSTRAINT cliente_endereco_id_fk FOREIGN KEY (cliente_id) REFERENCES public.cliente(cliente_id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2932 (class 2606 OID 16456)
-- Name: cliente_pagamento cliente_pagamento_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente_pagamento
    ADD CONSTRAINT cliente_pagamento_id_fk FOREIGN KEY (cliente_id) REFERENCES public.cliente(cliente_id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2937 (class 2606 OID 16526)
-- Name: pedido cliente_pedido_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT cliente_pedido_id_fk FOREIGN KEY (cliente_id) REFERENCES public.cliente(cliente_id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2939 (class 2606 OID 16552)
-- Name: secao_compra cliente_secao_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secao_compra
    ADD CONSTRAINT cliente_secao_id_fk FOREIGN KEY (cliente_id) REFERENCES public.cliente(cliente_id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2931 (class 2606 OID 16443)
-- Name: cliente_telefone cliente_telefone_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente_telefone
    ADD CONSTRAINT cliente_telefone_id_fk FOREIGN KEY (cliente_id) REFERENCES public.cliente(cliente_id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2936 (class 2606 OID 16513)
-- Name: produto desconto_produto_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT desconto_produto_id_fk FOREIGN KEY (desconto_id) REFERENCES public.desconto_produto(desconto_id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2935 (class 2606 OID 16508)
-- Name: produto estoque_produto_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT estoque_produto_id_fk FOREIGN KEY (estoque_id) REFERENCES public.estoque_produto(estoque_id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2938 (class 2606 OID 16539)
-- Name: pedido_pagamento pedido_pagamento_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_pagamento
    ADD CONSTRAINT pedido_pagamento_id_fk FOREIGN KEY (pedido_id) REFERENCES public.pedido(pedido_id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2942 (class 2606 OID 16577)
-- Name: pedido_produtos pedidoprodutos_pedido_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_produtos
    ADD CONSTRAINT pedidoprodutos_pedido_id_fk FOREIGN KEY (pedido_id) REFERENCES public.pedido(pedido_id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2943 (class 2606 OID 16582)
-- Name: pedido_produtos pedidoprodutos_produto_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_produtos
    ADD CONSTRAINT pedidoprodutos_produto_id_fk FOREIGN KEY (produto_id) REFERENCES public.produto(produto_id) ON UPDATE CASCADE ON DELETE RESTRICT;


-- Completed on 2021-07-05 09:11:00

--
-- PostgreSQL database dump complete
--

