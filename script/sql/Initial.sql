create database shop;
use shop;
create user 'shopmgr'@'%' identified by '20broKenNIGHT05';
grant all on shop.* to 'shopmgr'@'%';