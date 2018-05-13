create table Account
(
	Ac_Id nvarchar(40),
	Ac_Username nvarchar(256) not null,
	Ac_Password nvarchar(32) not null,
	Ac_Email nvarchar(256) not null,
	Ac_Class int not null,
    constraint PK_Account primary key (Ac_Id)
);
create table Item
(
	It_Id nvarchar(40),
    It_Name nvarchar(256) not null,
    It_Price float not null,
    It_Pic nvarchar(512) not null,
    constraint PK_Item primary key (It_Id)
);
create table Store
(
	St_Id nvarchar(40),
    St_Name nvarchar(256) not null,
    Ac_Id nvarchar(40) not null,
    constraint PK_Store primary key (St_Id),
    constraint FK_Account foreign key (Ac_Id) references Account(Ac_Id)
);
create table Commodity
(
	St_Id nvarchar(40),
    It_Id nvarchar(40),
    constraint PK_Commodity primary key (St_Id, It_Id),
    constraint FK_PerStore foreign key (St_Id) references Store(St_Id),
    constraint FK_PerItem foreign key (It_Id) references Item(It_Id)
);
create table Cart
(
	Ac_Id nvarchar(40),
    It_Id nvarchar(40),
    constraint PK_Cart primary key (Ac_Id, It_Id),
    constraint FK_PerCartAccount foreign key (Ac_Id) references Account(Ac_Id),
    constraint FK_PerCartItem foreign key (It_Id) references Item(It_Id)
);
create table Indent
(
	Ac_Id nvarchar(40),
    It_Id nvarchar(40),
    In_Completed timestamp not null,
    constraint PK_Indent primary key (Ac_Id, It_Id),
    constraint FK_PerIndentAccount foreign key (Ac_Id) references Account(Ac_Id),
    constraint FK_PerIndentItem foreign key (It_Id) references Item(It_Id)
);