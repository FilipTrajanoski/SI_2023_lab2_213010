# Втора лабораториска вежба по Софтверско инженерство
## Филип Трајаноски 213010
### Control Flow Graph
![CFG](https://github.com/FilipTrajanoski/SI_2023_lab2_213010/assets/127451559/0358a7a5-29bf-4d86-a50e-d31d12d9b9f2)
### Цикломатска комплексност
Цикломатската комплексност на овој код е 11, истата ја добив преку бројот на региони.
### Тест случаи според критериумот Every Branch
Тест случај 1: 
User(username=”filip123”,password=”lozinka#567”,email=”filip@gmail.com”)
AllUsers = {User(username=”user209”,password=”password$876”,email=”user209@gmail.com”),
User(username=”filip123”,password=”lozinka#567”,email=”filip@gmail.com”)}
- Корисник кој постои во листата на постоечки корисници, со username, валиден password и email. Во password специјалниот знак не е на прво место.

Тест случај 2:
User = null
AllUsers = {User(username=”user209”,password=”password$876”,email=”user209@gmail.com”),
User(username=”filip123”,password=”lozinka#567”,email=”filip@gmail.com”)}
- Корисникот е null.

Тест случај 3:
User(username=null, password=”0123”,email=”randommail”)
AllUsers = {User(username=”user209”,password=”password$876”,email=”user209@gmail.com”),
User(username=”filip123”,password=”lozinka#567”,email=”filip@gmail.com”)}
- Корисникот нема username, password е помал од 8 карактера или password го содржи username, а email ги нема знаците @ и .

Тест случај 4:
User(username=null, password=”01 23”,email=”randommail”)
AllUsers = {User(username=”user209”,password=”password$876”,email=”user209@gmail.com”),
User(username=”filip123”,password=”lozinka#567”,email=”filip@gmail.com”)}
- Корисникот има password којшто содржи празно место.

Тест случај 5:
User(username=null, password=”password0123”,email=”randommail”)
AllUsers = {User(username=”user209”,password=”password$876”,email=”user209@gmail.com”),
User(username=”filip123”,password=”lozinka#567”,email=”filip@gmail.com”)}
- Корисникот има password којшто не содржи специјален карактер.

### Тест случаи според критериумот Multiple Condition
1. T || X || X → user = null, user.password = X, user.email = X
- Корисникот е null, со тоа password и email не постојат и не се важни нивните вредности.
2. F || T || X → user != null, user.password = null, user.email = X
- Корисникот не е null, password е null, а вредноста на email не е важна.
3. F || F || T → user != null, user.password != null, user.email = null
- Корисникот не е null, password не е null, а email е null
4. F || F || F → user != null, user.password != null, user.email != null
- Корисникот не е null, password не е null, email не е null
