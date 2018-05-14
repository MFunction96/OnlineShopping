/*==============================================================*/
/* Table: Dish                                                  */
/*==============================================================*/
create table Dish 
(
   did                  varchar(40)                    not null,
   dname                varchar(256)                   not null,
   dprice               decimal                        not null,
   ddesc                varchar(256)                   not null,
   dimage               varchar(256)                   not null,
   dstatus              integer                        not null,
   constraint PK_DISH primary key clustered (did)
);

/*==============================================================*/
/* Table:  Order                                                */
/*==============================================================*/
create table Order 
(
   oid                  varchar(40)                    not null,
   customid             varchar(40)                    not null,
   ordertime            timestamp                      not null,
   totalprice           decimal                        not null,
   discription          varchar(256)                   not null,
   remark               varchar(256)                   not null,
   ostatus              varchar(10)                    not null,
   constraint PK_ORDER primary key clustered (oid),
   constraint FK_ORDER_REFERENCE_USER foreign key (customid) references User(uid)
);

/*==============================================================*/
/* Table: OrderItem                                             */
/*==============================================================*/
create table OrderItem 
(
   oiid                 varchar(40)                    not null,
   dishid               varchar(40)                    not null,
   ammount              integer                        not null,
   orderid              varchar(40)                    not null,
   constraint PK_ORDERITEM primary key clustered (oiid),
   constraint FK_ORDERITE_REFERENCE_ORDER foreign key (orderid) references Order(oid),
   constraint FK_ORDERITE_REFERENCE_DISH foreign key (dishid) references Dish(did)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User 
(
   uid                  varchar(40)                    not null,
   uname                varchar(256)                   not null,
   upassword            varchar(32)                    not null,
   usex                 varchar(4)                     not null,
   ubirthday            date                           not null,
   uphone               varchar(20)                    not null,
   uaddress             varchar(256)                   not null,
   urole                integer                        not null,
   constraint PK_USER primary key clustered (uid)
);

/*==============================================================*/
/* Table: Commodit                                              */
/*==============================================================*/
create table Commodit 
(
   sid                  varchar(40)                    not null,
   did                  varchar(40)                    not null,
   constraint PK_COMMODIT primary key clustered (sid, did),
   constraint FK_COMMODIT_REFERENCE_STORE foreign key (sid) references store(sid),
   constraint FK_COMMODIT_REFERENCE_DISH foreign key (did) references Dish(did)
);

/*==============================================================*/
/* Table: Sorelation                                            */
/*==============================================================*/
create table Sorelation 
(
   oid                  varchar(40)                    not null,
   sid                  varchar(40)                    not null,
   constraint PK_SORELATION primary key clustered (oid, sid),
   constraint FK_SORELATI_REFERENCE_ORDER foreign key (oid) references Order(oid),
   constraint FK_SORELATI_REFERENCE_STORE foreign key (sid) references store (sid)
);

/*==============================================================*/
/* Table: store                                                 */
/*==============================================================*/
create table tore
(
   sid                  varchar(40)                    not null,
   uid                  varchar(40)                    not null,
   sname                varchar(256)                   not null,
   sphone               varchar(20)                    not null,
   sdesc                varchar(256)                   not null,
   constraint PK_STORE primary key (sid),
   constraint FK_STORE_REFERENCE_USER foreign key (uid) references User (uid)
);