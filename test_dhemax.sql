PGDMP  4    )                |            electromobility    16.2    16.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16398    electromobility    DATABASE     �   CREATE DATABASE electromobility WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE electromobility;
                postgres    false            �            1259    16402    charge_points    TABLE       CREATE TABLE public.charge_points (
    id bigint NOT NULL,
    status text NOT NULL,
    operator text NOT NULL,
    connections integer NOT NULL,
    latitude text NOT NULL,
    longitude text NOT NULL,
    country text NOT NULL,
    power integer NOT NULL
);
 !   DROP TABLE public.charge_points;
       public         heap    postgres    false            �          0    16402    charge_points 
   TABLE DATA           o   COPY public.charge_points (id, status, operator, connections, latitude, longitude, country, power) FROM stdin;
    public          postgres    false    215   X       P           2606    16408     charge_points charge_points_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.charge_points
    ADD CONSTRAINT charge_points_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.charge_points DROP CONSTRAINT charge_points_pkey;
       public            postgres    false    215            �      x������ � �     