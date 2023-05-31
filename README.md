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
User(username=null, password=”password01 23”,email=”randommail”)
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
### Објаснување на напишаните unit tests
Во сите тест случаи се користи следната листа од постоечки корисници.
List<User> allUsers = new ArrayList<>();
allUsers.add(new User("user209","password$876","user209@gmail.com"));
allUsers.add(new User("filip123","lozinka#567","filip@gmail.com"));

Во тест функцијата testEveryBranch() има 5 assertions.
1. assertFalse(SILab2.function(new User("filip123","lozinka#567","filip@gmail.com"),allUsers));
- Овој асерт го покрива првиот тест случај. Потребно е да врати false, бидејќи корисникот постои во листата.

2. ex = assertThrows(RuntimeException.class, () -> SILab2.function(null,allUsers));
assertTrue(ex.getMessage().contains("Mandatory information missing!"));
- Овие асерти го покриваат вториот тест случај. Со првиот асерт очекуваме функцијата да фрли exception, бидејќи корисникот е null, а потоа со вториот асерт да провериме дали тоа е соодветниот exception.

3. assertFalse(SILab2.function(new User(null,"0123","randommail"),allUsers));
- Овој асерт го покрива третиот тест случај. Очекуваме false, бидејќи лозинката е помала од 8 карактери, а маилот не содржи @ и .

4. assertFalse(SILab2.function(new User(null,"password01 23","randommail"),allUsers));
- Овој асерт го покрива четвртиот тест случај. Очекуваме false, бидејќи лозинката има празно место.

5. assertFalse(SILab2.function(new User(null,"password0123","randommail"),allUsers));
- Овој асерт го покрива петтиот тест случај. Очекуваме false, бидејќи лозинката нема специјален знак.

Во тест функцијата testMultipleCondition() има 4 assertions.
1. ex = assertThrows(RuntimeException.class, () -> SILab2.function(null,allUsers));
assertTrue(ex.getMessage().contains("Mandatory information missing!"));
- Овие асерти го покриваат првиот тест случај. Со првиот асерт очекуваме функцијата да фрли exception, односно условот е true, бидејќи корисникот е null, а со вториот асерт проверуваме дали е соодветниот exception.

2. ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("username",null,"random"),allUsers));
assertTrue(ex.getMessage().contains("Mandatory information missing!"));
- Овие асерти го покриваат вториот тест случај. Со првиот асерт очекуваме функцијата да фрли exception, односно условот е true, бидејќи лозинката е null, а со вториот асерт проверуваме дали е соодветниот exception.

3. ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("username","password",null),allUsers));
assertTrue(ex.getMessage().contains("Mandatory information missing!"));
- Овие асерти го покриваат третиот тест случај. Со првиот асерт очекуваме функцијата да фрли exception, односно условот е true, бидејќи маилот е null, а со вториот асерт проверуваме дали е соодветниот exception.

4. assertFalse(SILab2.function(new User("filip123","lozinka#567","filip@gmail.com"),allUsers));
- Овој асерт го покрива четвртиот тест случај. Очекуваме да не фрли exception, односно условот е false и текот на програмата продолжува понатаму.
