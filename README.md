# BankSystem

用户登录  wei,
交易转账,
数据库 shujing,
前台 - ziang

MySQL server version: 5.7.25
  
数据库结构  
user表：  ID(int)  name(varChar) password(varChar) money(decimal)
transaction表 ： ID(int)   date(datetime)   FromUserID(int, FK)   ToUserID(int, FK)   money(decimal)

