drop database if exists osb;
create database osb;

use osb;


create table gradua (
    graduid 		bigint,
    izena			varchar (50),
    constraint GRAD_PK primary key (graduid));

create table kurtsoa (
	kurtsoid				bigint,
    izena					varchar(20),
    gradua_graduid			bigint,
    constraint KURTS_PK primary key (kurtsoid),
    constraint KURTS_GRADU_FK foreign key (gradua_graduid) references gradua (graduid));

create table role (
	roleid 					bigint,
    type 					tinyint,
    constraint ROLE_PK primary key (roleid));

create table user (
	userid 					bigint,
    izena 					varchar(20),
    abizena 				varchar(20),
    email 					varchar(255),
    password 				varchar(255),
    jaiotze_data			timestamp not null,
    role_roleid				bigint,
    constraint USER_PK primary key (userid),
    constraint USER_ROLE_PK foreign key (role_roleid) references role (roleid));

create table ikaslea (
	ikasleid				bigint unsigned,
    #izena					varchar(15) not null,
    #abizena				varchar(15) not null,
    #email					varchar(50) not null,
    #pasahitza 				varchar(20) not null,
    #jaiotze_data			timestamp not null,
    gradua_graduid			bigint,
    kurtsoa_kurtsoid 		bigint,
    user_userid				bigint,
    constraint IKASLE_PK primary key (ikasleid),
    constraint IKASLE_GRADU_FK foreign key (gradua_graduid) references gradua (graduid),
	constraint IKASLE_KURTSO_FK foreign key (kurtsoa_kurtsoid) references kurtsoa (kurtsoid),
    constraint IKASLE_USER_FK foreign key (user_userid) references user (userid));

create table irakaslea (
	irakasleid				bigint unsigned,
    #izena					varchar(10),
    #abizena				varchar(15),
    #email					varchar(50),
    #pasahitza 				varchar(20),
    #jaiotze_data			timestamp,
	user_userid				bigint,
    constraint IRAKAS_PK primary key (irakasleid),
    constraint IRAKASLE_USER_FK foreign key (user_userid) references user (userid));

create table ikasgaia (
	ikasgaiid					bigint,
    izena 						varchar(50),
    kurtsoa_kurtsoid			bigint,
    irakaslea_irakasleid		bigint unsigned,
    constraint IKASGAI_PK primary key (ikasgaiid),
    constraint IKASGAI_KURTSO_FK foreign key (kurtsoa_kurtsoid) references kurtsoa (kurtsoid),
    constraint IKASGAI_IRAKASLE_FK foreign key (irakaslea_irakasleid) references irakaslea (irakasleid));

create table gaia (
	gaiaid						bigint auto_increment,
    izena						varchar(15),
    ikasgaia_ikasgaiid 			bigint,
    constraint gaia_PK primary key (gaiaid),
    constraint gaia_IKASGAI_FK foreign key (ikasgaia_ikasgaiid) references ikasgaia (ikasgaiid));

create table azterketa (
	azterketaid					bigint unsigned,
    izena						varchar(20) not null,
    ikasgaia_ikasgaiid			bigint,
    constraint AZTERK_PK primary key (azterketaid),
    constraint AZTERK_IKASGAI_FK foreign key (ikasgaia_ikasgaiid) references ikasgaia (ikasgaiid));

create table ebaluaketa (
	ebaluaketaid				bigint,
    nota						double,
    komentarioa					varchar(255),
    ikaslea_ikasleid			bigint unsigned,
    azterketa_azterketaid		bigint unsigned,
    constraint EBALUAKETA_PK primary key (ebaluaketaid),
    constraint EBALUAKETA_IKASLEA_FK foreign key (ikaslea_ikasleid) references ikaslea (ikasleid),
    constraint EBALUAKETA_AZTERKETA_FK foreign key (azterketa_azterketaid) references azterketa (azterketaid));

create table apuntea (
	apunteid					bigint,
    izena						varchar(20),
    ikaslea_ikasleid			bigint unsigned,
    ikasgaia_ikasgaiid			bigint,
    constraint APUNTE_PK primary key (apunteID),
    constraint APUNTE_IKASLE_FK foreign key (ikaslea_ikasleid) references ikaslea (ikasleid),
    constraint APUNTE_IKASGAI_FK foreign key (ikasgaia_ikasgaiid) references ikasgaia (ikasgaiid));

create table balorazioa (
	balorazioid 				bigint,
    balorazioa 					int,
    ikaslea_ikasleid 			bigint unsigned,
    apuntea_apunteid			bigint,
    constraint BALORAZIO_PK primary key (balorazioid),
    constraint BALORAZIO_IKASLE_FK foreign key (ikaslea_ikasleid) references ikaslea (ikasleid),
    constraint BALORAZIO_APUNTE_FK foreign key (apuntea_apunteid) references apuntea (apunteid));

create table artxiboa (	
	artxiboid					bigint auto_increment,
    izena 						varchar(255),
	dokumentua 					mediumblob not null, -- blob pilla 32Mb 
    gaia_gaiaid					bigint,
    apuntea_apunteid			bigint,
    constraint ARTXIBO_PK primary key (artxiboid),
    constraint ARTXIBO_gaia_FK foreign key (gaia_gaiaid) references gaia (gaiaid),
    constraint ARTXIBO_APUNTE_FK foreign key (apuntea_apunteid) references apuntea (apunteid));

-- Eraliozko taulak
create table ikasgaia_ikaslea (
	ikasgaia_ikasgaiid			bigint,
    ikaslea_ikasleid			bigint,
    constraint IKASGAI_IKASLE_PK primary key (ikaslea_ikasleid, ikasgaia_ikasgaiid));
    
create table azterketa_ikaslea (
	ikaslea_ikasleid			bigint,
    azterketa_azterketaid		bigint,
    nota						float,
    komentarioa					varchar(60),
    nota_reku					float,
   constraint azterketa_IKASLE_PK primary key (ikaslea_ikasleid, azterketa_azterketaid));
   
create table kurtsoa_ikaslea (
	ikaslea_ikasleid			bigint,
    kurtsoa_kurtsoid			bigint,
    constraint KURTSO_IKASLE_PK primary key (ikaslea_ikasleid, kurtsoa_kurtsoid));