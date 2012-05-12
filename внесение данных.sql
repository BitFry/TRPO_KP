INSERT INTO agency(ID,NAME,
INN,KPP,
ADRESS,
RS,KS,
BANK,BIK,
PHONE,
EMAIL,WEBSITE,
DIRECTOR,CHIEF_ACCOUNTANT) 
  VALUES (1,'Рога и копыта',
  '123576438563','73465934795',
  'ул Ярослава Гашека 41',
  '63478568346','475984795',
  'Русский размер','7854739',
  '567-16-69',
  'emortan@gmail.ru','makeyourgiftru',
  'STALLONE','VAN DAMM');
  
INSERT INTO agency(ID, NAME,
INN,KPP,
ADRESS,
RS,KS,
BANK,BIK,
PHONE,
EMAIL,WEBSITE,
DIRECTOR,CHIEF_ACCOUNTANT) 
  VALUES (2, 'Subway',
  '65834765834','59348759384',
  'ул Ярослава Гашека 42',
  '63478568346','475984795',
  'Русский размер','7854739',
  '567-00-00',
  'subway@rambler.ru','subway.ru',
  'WILLIS','SIGAL');
  
INSERT INTO agency(ID, NAME,
INN,KPP,
ADRESS,
RS,KS,
BANK,BIK,
PHONE,
EMAIL,WEBSITE,
DIRECTOR,CHIEF_ACCOUNTANT) 
  VALUES (3, 'notebookpro',
  '653748658348','57487495675964',
  'ул Ярослава Гашека 43',
  '63478568346','475984795',
  'Русский размер','7854739',
  '560-23-44',
  'notebookpro@rambler.ru','notebookpro.ru',
  'CAIL RIZ','Josev Clarence');
  
INSERT INTO agency(ID, NAME,
INN,KPP,
ADRESS,
RS,KS,
BANK,BIK,
PHONE,
EMAIL,WEBSITE,
DIRECTOR,CHIEF_ACCOUNTANT) 
  VALUES (4, 'Эх прокачу',
  '65784753847','7594875934',
  'ул Седова 11',
  '63478568346','475984795',
  'Русский стандарт','7854739',
  '555-555-555',
  'drive_crazy@rambler.ru','party.ru',
  'NICK CAVE','DAVE MUSTEIN');
  
INSERT INTO agency(ID, NAME,
INN,KPP,
ADRESS,
RS,KS,
BANK,BIK,
PHONE,
EMAIL,WEBSITE,
DIRECTOR,CHIEF_ACCOUNTANT) 
  VALUES (5, 'Моя уютная контора',
  '34574376473','643875634868',
  'ул Ярослава Гашека 41',
  '63478568346','475984795',
  'Банк траст','7854739',
  '8-800-200-200',
  'ingodwetrust@rambler.ru','oreily.ru',
  'Джек Николсон','Жерар Депардье');
  
  -- select * from department where org_id in (select a.id from agency a where name='Моя уютная контора');
  
  insert into department(ID, ORG_ID, NAME) 
    values(1, 5, 'Подразделение1');
  insert into department(ID, ORG_ID, NAME) 
    values(2, 5, 'Подразделение2');
  insert into department(ID, ORG_ID, NAME) 
    values(3, 5, 'Подразделение3');
  insert into department(ID, ORG_ID, NAME) 
    values(4, 5, 'Подразделение4');
  insert into department(ID, ORG_ID, NAME) 
    values(5, 5, 'Подразделение5');
  insert into department(ID, ORG_ID, NAME) 
    values(6, 5, 'Подразделение6');

  insert into employee(ID, DEP_ID, NAME, POST, SERIES, PNUMBER, ISSUE_DATE, ISSUED_BY)
    values(1, 1, 'Байонетта', 'Сотрудник', '345345345345', '657834658', to_date('10/10/10', 'dd/mm/yy'), 'Милиция');
  insert into employee(ID, DEP_ID, NAME, POST, SERIES, PNUMBER, ISSUE_DATE, ISSUED_BY)
    values(2, 1, 'Рю', 'Сотрудник', '657534534', '658473658', to_date('10/10/10', 'dd/mm/yy'), 'Милиция');
  insert into employee(ID, DEP_ID, NAME, POST, SERIES, PNUMBER, ISSUE_DATE, ISSUED_BY)
    values(3, 1, 'Чуньли', 'Сотрудник', '95734556456', '947694576', to_date('10/10/10', 'dd/mm/yy'), 'Милиция');
  insert into employee(ID, DEP_ID, NAME, POST, SERIES, PNUMBER, ISSUE_DATE, ISSUED_BY)
    values(4, 1, 'Бланка', 'Сотрудник', '6384563495', '32574594759', to_date('10/10/10', 'dd/mm/yy'), 'Милиция');
  insert into employee(ID, DEP_ID, NAME, POST, SERIES, PNUMBER, ISSUE_DATE, ISSUED_BY)
    values(5, 2, 'Зангиев', 'Сотрудник', '6478236439', '923749387', to_date('10/10/10', 'dd/mm/yy'), 'Милиция');
  insert into employee(ID, DEP_ID, NAME, POST, SERIES, PNUMBER, ISSUE_DATE, ISSUED_BY)
    values(6, 2, 'Гайл', 'Сотрудник', '74395703', '78349769569', to_date('10/10/10', 'dd/mm/yy'), 'Милиция');
  insert into employee(ID, DEP_ID, NAME, POST, SERIES, PNUMBER, ISSUE_DATE, ISSUED_BY)
    values(8, 2, 'Дальсим', 'Сотрудник', '75967954', '8459347', to_date('10/10/10', 'dd/mm/yy'), 'Милиция');
  insert into employee(ID, DEP_ID, NAME, POST, SERIES, PNUMBER, ISSUE_DATE, ISSUED_BY)
    values(9, 3, 'Винсант Вега', 'Сотрудник', '6846583468573', '75983475947395', to_date('10/10/10', 'dd/mm/yy'), 'Милиция');
  insert into employee(ID, DEP_ID, NAME, POST, SERIES, PNUMBER, ISSUE_DATE, ISSUED_BY)
    values(10, 3, 'Марселас Уолес', 'Сотрудник', '65843648', '758943798574', to_date('10/10/10', 'dd/mm/yy'), 'Милиция');
  insert into employee(ID, DEP_ID, NAME, POST, SERIES, PNUMBER, ISSUE_DATE, ISSUED_BY)
    values(11, 3, 'Джулс Винфилд', 'Сотрудник', '9293479238', '634756384568', to_date('10/10/10', 'dd/mm/yy'), 'Милиция');
  insert into employee(ID, DEP_ID, NAME, POST, SERIES, PNUMBER, ISSUE_DATE, ISSUED_BY)
    values(12, 4, 'Джон Маклейн', 'Сотрудник', '65348658346', '64378683745683', to_date('10/10/10', 'dd/mm/yy'), 'Милиция');
  insert into employee(ID, DEP_ID, NAME, POST, SERIES, PNUMBER, ISSUE_DATE, ISSUED_BY)
    values(13, 4, 'Чарльз Гродин', 'Сотрудник', '6238746823648', '947687487369', to_date('10/10/10', 'dd/mm/yy'), 'Милиция');
  insert into employee(ID, DEP_ID, NAME, POST, SERIES, PNUMBER, ISSUE_DATE, ISSUED_BY)
    values(14, 4, 'Роберт Де Ниро', 'Сотрудник', '75893457943', '78957439857934', to_date('10/10/10', 'dd/mm/yy'), 'Милиция');
  insert into employee(ID, DEP_ID, NAME, POST, SERIES, PNUMBER, ISSUE_DATE, ISSUED_BY)
    values(15, 5, 'Джек Уолш', 'Сотрудник', '6573687468', '93759301078', to_date('10/10/10', 'dd/mm/yy'), 'Милиция');
    
  --Счета поставщика 1
  insert into BILL(ID, SUP_ID, CLIENT_ID, ISSUE_DATE)
    values(1, 1, 5, to_date('10/11/10', 'dd/mm/yy'));
  insert into BILL(ID, SUP_ID, CLIENT_ID, ISSUE_DATE)
    values(2, 1, 5, to_date('10/12/10', 'dd/mm/yy'));
  insert into BILL(ID, SUP_ID, CLIENT_ID, ISSUE_DATE)
    values(3, 1, 5, to_date('10/3/10', 'dd/mm/yy'));
    
  --Счета поставщика 2  
  insert into BILL(ID, SUP_ID, CLIENT_ID, ISSUE_DATE)
    values(4, 2, 5, to_date('10/4/10', 'dd/mm/yy'));
  insert into BILL(ID, SUP_ID, CLIENT_ID, ISSUE_DATE)
    values(5, 2, 5, to_date('10/5/10', 'dd/mm/yy'));
  
  --Счета поставщика 3
  insert into BILL(ID, SUP_ID, CLIENT_ID, ISSUE_DATE)
    values(6, 3, 5, to_date('10/6/10', 'dd/mm/yy'));
  insert into BILL(ID, SUP_ID, CLIENT_ID, ISSUE_DATE)
    values(7, 3, 5, to_date('10/7/10', 'dd/mm/yy'));
  
  --Счета поставщика 4
  insert into BILL(ID, SUP_ID, CLIENT_ID, ISSUE_DATE)
    values(8, 4, 5, to_date('10/8/10', 'dd/mm/yy'));
  
  --Товары поставщика 1
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(1, 1, 'Жёсткий диск', 'Штука', 3000, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(2, 1, 'Видеокарта', 'Штука', 15000, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(3, 1, 'Монитор', 'Штука', 5000, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(4, 1, 'Корпус', 'Штука', 2000, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(5, 1, 'Сетавая карта', 'Штука', 1500, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(6, 1, 'Оперативная память', 'Штука', 1200, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(7, 1, 'Материнская плата', 'Штука', 2700, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(8, 1, 'ТВ ТЮНЕР', 'Штука', 3400, 0.18, 0.03);
  
  --Товары поставщика 2
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(9, 2, 'Жёсткий диск', 'Штука', 2700, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(10, 2, 'Видеокарта', 'Штука', 6000, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(11, 2, 'Монитор', 'Штука', 3400, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(12, 2, 'Корпус', 'Штука', 3000, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(13, 2, 'Сетавая карта', 'Штука', 2000, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(14, 2, 'Оперативная память', 'Штука', 1200, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(15, 2, 'Материнская плата', 'Штука', 2700, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(16, 2, 'ТВ ТЮНЕР', 'Штука', 3400, 0.18, 0.03);
    
  --Товары поставщика 3
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(17, 3, 'Стиральная машина', 'Штука', 14000, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(18, 3, 'Холодильник', 'Штука', 10000, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(19, 3, 'Утюг', 'Штука', 5000, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(20, 3, 'Кофеварка', 'Штука', 500, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(21, 3, 'Чайник', 'Штука', 700, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(22, 3, 'Фритюрница', 'Штука', 3000, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(23, 3, 'Пылесос', 'Штука', 4000, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(24, 3, 'Сковородка', 'Штука', 500, 0.18, 0.03);
    
  --Товары поставщика 4
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(25, 4, 'Стиральная машина', 'Штука', 10000, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(26, 4, 'Холодильник', 'Штука', 14000, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(27, 4, 'Утюг', 'Штука', 2000, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(28, 4, 'Кофеварка', 'Штука', 300, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(29, 4, 'Чайник', 'Штука', 1000, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(30, 4, 'Фритюрница', 'Штука', 700, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(31, 4, 'Пылесос', 'Штука', 3000, 0.18, 0.03);
  insert into PRODUCT(ID, SUP_ID, NAME, UINT, PRICE, NDS, EXCISE)
    values(32, 4, 'Сковородка', 'Штука', 200, 0.18, 0.03);
  
  insert into PAYMENTORDER(ID, BILL_ID,ORG_ID, PODATE, AMOUNT)
    values(1, 6, 5, to_date('10/11/10', 'dd/mm/yy'), 100000);  
  
  --Строки счёта 6 п/п 1 поставщик 3
  insert into DOCROW(ID, PRODUCT_ID, PO_ID, BILL_ID, COUNT)
    values(1, (select pr.id from product pr where pr.name = 'Чайник' and pr.sup_id = 3) , 1, 6, 10);
  insert into DOCROW(ID, PRODUCT_ID, PO_ID, BILL_ID, COUNT)
    values(2, (select pr.id from product pr where pr.name = 'Стиральная машина' and pr.sup_id = 3) , 1, 6,  2);
  insert into DOCROW(ID, PRODUCT_ID, PO_ID, BILL_ID, COUNT)
    values(3, (select pr.id from product pr where pr.name = 'Холодильник' and pr.sup_id = 3) , 1, 6,  3);
  insert into DOCROW(ID, PRODUCT_ID, PO_ID, BILL_ID, COUNT)
    values(4, (select pr.id from product pr where pr.name = 'Утюг' and pr.sup_id = 3) , 1, 6,  4);
  insert into DOCROW(ID, PRODUCT_ID, PO_ID, BILL_ID, COUNT)
    values(5, (select pr.id from product pr where pr.name = 'Кофеварка' and pr.sup_id = 3) , 1, 6,  5);
  insert into DOCROW(ID, PRODUCT_ID, PO_ID, BILL_ID, COUNT)
    values(6, (select pr.id from product pr where pr.name = 'Фритюрница' and pr.sup_id = 3) , 1, 6,  6);
    
  --Номера строк счёта 6
  insert into BILLROWNUMBER(ID, ROW_ID, ROWNUMBER)
    values(1, 1, 1);
  insert into BILLROWNUMBER(ID, ROW_ID, ROWNUMBER)
    values(2, 2, 2);
  insert into BILLROWNUMBER(ID, ROW_ID, ROWNUMBER)
    values(3, 3, 3);
  insert into BILLROWNUMBER(ID, ROW_ID, ROWNUMBER)
    values(4, 4, 4);
  insert into BILLROWNUMBER(ID, ROW_ID, ROWNUMBER)
    values(5, 5, 5);
  insert into BILLROWNUMBER(ID, ROW_ID, ROWNUMBER)
    values(6, 6, 6);
  --select b.id, w.id, w.bill_id, p.name from bill b,warrantrow w, product p where b.id = w.bill_id and w.product_id = p.id;
  
  --insert into WARRANT(id, empl_id, order_id, issue_date)
    --values(1, 1, 1, to_date('28/4/12', 'dd/mm/yy'));
    
  --update docrow set war_id=1;