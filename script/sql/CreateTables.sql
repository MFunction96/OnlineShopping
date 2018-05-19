/*==============================================================*/
/* Table: Account                                               */
/*==============================================================*/
create table Account
(
   ac_id                nvarchar(40)                    not null,
   ac_name              nvarchar(256)                   not null,
   ac_password          nvarchar(32)                    not null,
   ac_sex               nvarchar(4)                     not null,
   ac_birthday          date                           not null,
   ac_phone             nvarchar(20)                    not null,
   ac_address           nvarchar(256)                   not null,
   ac_role              integer                        not null,
   constraint PK_ACCOUNT primary key clustered (ac_id)
  );

/*==============================================================*/
/* Table: Dish                                                  */
/*==============================================================*/
create table Dish
(
   di_id                nvarchar(40)                    not null,
   di_name              nvarchar(256)                   not null,
   di_price             decimal                        not null,
   di_desc              nvarchar(256)                   not null,
   di_image             nvarchar(256)                   not null,
   di_status            integer                        not null,
   constraint PK_DISH primary key clustered (di_id)
);

/*==============================================================*/
/* Table: Indent                                                */
/*==============================================================*/
create table Indent
(
   in_id                nvarchar(40)                    not null,
   customerid           nvarchar(40)                    not null,
   in_ordertime         timestamp                      not null,
   in_totalprice        decimal                        not null,
   in_diesc             nvarchar(256)                   not null,
   in_remark            nvarchar(256)                   not null,
   in_status            nvarchar(10)                    not null,
   constraint PK_INDENT primary key clustered (in_id),
   constraint FK_INDENT_REFERENCE_ACCOUNT foreign key (customerid) references Account (ac_id)
);

/*==============================================================*/
/* Table: IndentItem                                            */
/*==============================================================*/
create table IndentItem
(
   it_id                nvarchar(40)                    not null,
   di_id                nvarchar(40)                    not null,
   it_ammount           integer                        not null,
   it_totalprice        decimal                        not null,
   in_id                nvarchar(40)                    not null,
   constraint PK_INDENTITEM primary key clustered (it_id),
constraint FK_INDENTIT_REFERENCE_INDENT foreign key (in_id) references Indent (in_id) on delete cascade,
constraint FK_INDENTIT_REFERENCE_DISH foreign key (di_id) references Dish (di_id)
);

/*==============================================================*/
/* Table: Store                                                 */
/*==============================================================*/
create table Store
(
   st_id                nvarchar(40)                    not null,
   ac_id                nvarchar(40)                    not null,
   st_name              nvarchar(256)                   not null,
   st_phone             nvarchar(20)                    not null,
   st_desc              nvarchar(256)                   not null,
   constraint PK_STORE primary key (st_id),
constraint FK_STORE_REFERENCE_ACCOUNT foreign key (ac_id) references Account (ac_id) on delete cascade
);

/*==============================================================*/
/* Table: Commodit                                              */
/*==============================================================*/
create table Commodit
(
   st_id                nvarchar(40)                    not null,
   di_id                nvarchar(40)                    not null,
   constraint PK_COMMODIT primary key clustered (st_id, di_id),
constraint FK_COMMODIT_REFERENCE_STORE foreign key (st_id) references Store (st_id) on delete cascade,
constraint FK_COMMODIT_REFERENCE_DISH foreign key (di_id) references Dish (di_id) on delete cascade
);


