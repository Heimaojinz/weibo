#项目使用框架：基于Socket和HTTP的Web 

1.通过socket实现TCP通信。

2.实现了HTTP报文的接受、解析、生成、返回。

3.采用MVC架构，控制层、显示层、数据层分离，代码易于扩展，可扩展性强。

M层：自有基于 Java 的ORM。ORM基类实现了增容改查逻辑的，封装层对象继承自ORM基类，生成SQL数据库的增数改查功能

V层：模板默认为Jinja2，实现了对Jinja2的接口支持

C层：实现了URI路径到信息功能的映射，信息传达功能

本项目为该框架的试验项目。

实现了基本的用户注册，登录。
个人主页，微博和评论的增加改查功能。
使用服务端会话实现状态保持。
密码加盐哈希存储

运行环境
IDE

本地测试，测试前请自行修改 配置本地 SQL
<<<<<<< 头
详细
主页

注册示例

登录示例

登录页

登录示例
 
微博个人主页

微博增改查
权限控制（微博仅博主改改，评论：博主可创作，评论者可改改）
