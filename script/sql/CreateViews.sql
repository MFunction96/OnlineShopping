Create  View OrderItem as
  SELECT
    IndentItem.in_id AS In_id,
    IndentItem.it_id AS It_id,
    IndentItem.di_id AS Di_id,
    Dish.di_image AS Di_image,
    Dish.di_name AS Di_name,
    IndentItem.it_ammount AS It_ammount,
    IndentItem.it_totalprice AS It_totalprice
  FROM
    IndentItem
    INNER JOIN Dish ON IndentItem.di_id = Dish.di_id ;


Create View DishOrder as
  SELECT
    Indent.in_id AS In_id,
    Indent.st_id AS St_id,
    Store.st_name AS St_name,
    Indent.customerid AS Customerid,
    Account.ac_name AS Ac_name,
    Indent.in_totalprice AS In_totalprice,
    Indent.in_desc AS In_desc,
    Indent.in_remark AS In_remark,
    Indent.in_status AS In_status,
    Account.ac_phone AS Ac_phone,
    Account.ac_address AS Ac_address,
    Indent.in_ordertime AS In_ordertime
  FROM
Indent
INNER JOIN Account ON Indent.customerid = Account.ac_id
INNER JOIN Store ON Indent.st_id = Store.st_id