if exists(select 1 from sys.sysforeignkey where role='FK_ORDER_REFERENCE_USER') then
    alter table Order
       delete foreign key FK_ORDER_REFERENCE_USER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ORDERITE_REFERENCE_ORDER') then
    alter table OrderItem
       delete foreign key FK_ORDERITE_REFERENCE_ORDER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ORDERITE_REFERENCE_DISH') then
    alter table OrderItem
       delete foreign key FK_ORDERITE_REFERENCE_DISH
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_COMMODIT_REFERENCE_STORE') then
    alter table Commodit
       delete foreign key FK_COMMODIT_REFERENCE_STORE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_COMMODIT_REFERENCE_DISH') then
    alter table Commodit
       delete foreign key FK_COMMODIT_REFERENCE_DISH
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_SORELATI_REFERENCE_ORDER') then
    alter table Sorelation
       delete foreign key FK_SORELATI_REFERENCE_ORDER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_SORELATI_REFERENCE_STORE') then
    alter table Sorelation
       delete foreign key FK_SORELATI_REFERENCE_STORE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_STORE_REFERENCE_USER') then
    alter table Store
       delete foreign key FK_STORE_REFERENCE_USER
