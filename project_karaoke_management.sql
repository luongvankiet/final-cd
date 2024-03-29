PGDMP     ,    &                w            project_karaoke_management    11.5    11.5                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                       1262    16393    project_karaoke_management    DATABASE     �   CREATE DATABASE project_karaoke_management WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
 *   DROP DATABASE project_karaoke_management;
             postgres    false            �            1259    16435    roles    TABLE     �   CREATE TABLE public.roles (
    role_id integer NOT NULL,
    role_name character varying NOT NULL,
    created_at timestamp without time zone DEFAULT now(),
    updated_at timestamp without time zone DEFAULT now()
);
    DROP TABLE public.roles;
       public         postgres    false            �            1259    16433    roles_role_id_seq    SEQUENCE     �   CREATE SEQUENCE public.roles_role_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.roles_role_id_seq;
       public       postgres    false    199                       0    0    roles_role_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.roles_role_id_seq OWNED BY public.roles.role_id;
            public       postgres    false    198            �            1259    16446 	   user_role    TABLE     ^   CREATE TABLE public.user_role (
    user_id integer NOT NULL,
    role_id integer NOT NULL
);
    DROP TABLE public.user_role;
       public         postgres    false            �            1259    16396    users    TABLE     (  CREATE TABLE public.users (
    id integer NOT NULL,
    username character varying(50) NOT NULL,
    password character varying(255) NOT NULL,
    token character varying(255),
    created_at timestamp without time zone DEFAULT now(),
    updated_at timestamp without time zone DEFAULT now()
);
    DROP TABLE public.users;
       public         postgres    false            �            1259    16394    users_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public       postgres    false    197                       0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
            public       postgres    false    196            �
           2604    16438    roles role_id    DEFAULT     n   ALTER TABLE ONLY public.roles ALTER COLUMN role_id SET DEFAULT nextval('public.roles_role_id_seq'::regclass);
 <   ALTER TABLE public.roles ALTER COLUMN role_id DROP DEFAULT;
       public       postgres    false    198    199    199            �
           2604    16399    users id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    197    196    197                      0    16435    roles 
   TABLE DATA               K   COPY public.roles (role_id, role_name, created_at, updated_at) FROM stdin;
    public       postgres    false    199   �                 0    16446 	   user_role 
   TABLE DATA               5   COPY public.user_role (user_id, role_id) FROM stdin;
    public       postgres    false    200   @                 0    16396    users 
   TABLE DATA               V   COPY public.users (id, username, password, token, created_at, updated_at) FROM stdin;
    public       postgres    false    197   g                  0    0    roles_role_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.roles_role_id_seq', 2, true);
            public       postgres    false    198                        0    0    users_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.users_id_seq', 2, true);
            public       postgres    false    196            �
           2606    16406    users pr_id_users 
   CONSTRAINT     O   ALTER TABLE ONLY public.users
    ADD CONSTRAINT pr_id_users PRIMARY KEY (id);
 ;   ALTER TABLE ONLY public.users DROP CONSTRAINT pr_id_users;
       public         postgres    false    197            �
           2606    16450    user_role role_user_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT role_user_pkey PRIMARY KEY (user_id, role_id);
 B   ALTER TABLE ONLY public.user_role DROP CONSTRAINT role_user_pkey;
       public         postgres    false    200    200            �
           2606    16445    roles roles_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (role_id);
 :   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_pkey;
       public         postgres    false    199            �
           2606    16424    users u_id_users 
   CONSTRAINT     O   ALTER TABLE ONLY public.users
    ADD CONSTRAINT u_id_users UNIQUE (username);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT u_id_users;
       public         postgres    false    197            �
           2606    16466    user_role fk_id_roles    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT fk_id_roles FOREIGN KEY (user_id) REFERENCES public.roles(role_id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 ?   ALTER TABLE ONLY public.user_role DROP CONSTRAINT fk_id_roles;
       public       postgres    false    200    199    2708            �
           2606    16461    user_role fk_id_users    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT fk_id_users FOREIGN KEY (user_id) REFERENCES public.users(id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 ?   ALTER TABLE ONLY public.user_role DROP CONSTRAINT fk_id_users;
       public       postgres    false    2704    197    200               ;   x�3�LL����420��5��5�P04�20�2�г41343�#�e�Y\���F��=... ��;            x�3�4�2�4�2�=... $         Y   x�3�LL����*I7��1��F�����F
F�V&�V��zfff&�x���8K�S�8S"�r��mm!���d��J2������ �(�     