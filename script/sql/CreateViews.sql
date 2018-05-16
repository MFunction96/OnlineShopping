Create View OrderItem as
SELECT
indentitem.in_id AS In_id,
indentitem.it_id AS It_id,
indentitem.di_id AS Di_id,
dish.di_image AS Di_image,
dish.di_name AS Di_name,
indentitem.it_ammount AS It_ammount,
indentitem.it_totalprice AS It_totalprice
FROM
indentitem
INNER JOIN dish ON indentitem.di_id = dish.di_id;


Create View DishOrder as
SELECT
indent.in_id AS In_id,
indent.customerid AS Customerid,
account.ac_name AS Ac_name,
indent.in_totalprice AS In_totalprice,
indent.in_diesc AS In_desc,
indent.in_remark AS In_remark,
indent.in_status AS In_status,
account.ac_phone AS Ac_phone,
account.ac_address AS Ac_address,
indent.in_ordertime AS In_ordertime
FROM
indent
INNER JOIN account ON indent.customerid = account.ac_id;
