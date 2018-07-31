# Jwt-SpringSecurity
A simple demo for Spring Security with Mybatis .

er-map

中文文档

how to use
First off all , plz start the project .

We view users are personal user and company user .

personal user
We use phone number to verify personal user , and the auth path is auth/personal , the refresh path is refresh/personal .

auth
personal user get their token by phone and password , like the pic below :

personal_login

after login success , personal user will get the role as 'PERSONAL'.

use
First of all , you need set Authorization in request header , which's value is : "Bearer " + ${token} . (plz pay attention to the blank space)

They can only do the things which under 'PERSONAL' role's permission .

like :

personal_coming

company user
Here we get our big user .

For Company User , we make three types Role : BOSS , MANAGER and EMPLOYEE . (Of cause , you can add any roles else if you like )

Company User can create sub-accounts which is no limited in numbers , and choice appropriate roles for thire sub-accounts .

auth
Every types of company user's account get their token by : auth/company.

simply like :

get_boss_token

or a manager :

manager_login

use
First of all , you need set Authorization in request header , which's value is : "Bearer " + ${token} . (plz pay attention to the blank space)

Now it is very simple to use .

A boss role account can get the boss greeting by :
boss_coming

A manager role account can get the manager greeting by :
mager_coming

But a manager can not get boss's greeting , because boss greeting path ask for boss's permission :
mager_want_boss_greeting
