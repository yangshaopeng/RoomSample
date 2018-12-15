# Room
## 1.简介
官方文档介绍：
```
Room provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.
```
Room是提供了覆盖在SQLite之上的抽象层，它能在充分利用SQLite全部功能的时候并流畅的访问数据库。
## 2.导入库
```
implementation 'androidx.room:room-runtime:2.1.0-alpha02'
annotationProcessor 'androidx.room:room-compiler:2.1.0-alpha02'
```
上述方法是在Pre-AndroidX之前的导入方法，[AndroidX的导入方法](https://developer.android.google.cn/topic/libraries/architecture/adding-components#room)。  
Room虽然是Google封装的一个ORM数据库，但还是可以当做第三方框架一样导入。
## 3.Room主要介绍
### 3.1.Database
Database包含数据库的持有者。
作为一个数据库的管理类，必须用注解 @Database 标注，并且满足以下条件：  
- 必须是一个抽象类，并且继承 RoomDatabase。
- 在 Database 的注解内，必须包含一个或者多个和数据库关联的实体类。
- 包含一个或多个有0个参数的抽象方法，这些方法返回与之关联实体的Dao对象。
### 3.2.Entity 
代表数据库关联的一个表
### 3.3.Dao
包含可以访问数据的方法。

## 4.操作方法
整体操作可以分为2步：
- 应用程序通过Room Database来获取与该数据库关联的对象或者Dao对象。
- 应用程序通过Dao对象获取entity，并对其进行增删查改操作。
具体关系如下图所示
![](https://user-gold-cdn.xitu.io/2018/12/16/167b29a3a7649f0e?w=600&h=542&f=png&s=57383)

Room的使用方法就是以上总结，[sample](https://github.com/yangshaopeng/RoomSample)。
