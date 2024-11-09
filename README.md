![](https://cdn.nlark.com/yuque/0/2024/png/28334026/1731180759849-79f6c0b5-a903-4021-828b-3d6a69a7b254.png)

demo为鱼皮面试鸭拆解功能，可供快速开发进行使用。

为面试鸭宣传一下 [https://www.mianshiya.com](https://www.mianshiya.com/)

---

![](https://cdn.nlark.com/yuque/0/2024/png/28334026/1731180731933-994f361d-215c-4157-b27b-a7e287cc666c.png)

💻demo说明
---

+ 利用分页功能实现 n * 4 样式**卡片**的展示，同时会随着系统窗口的改变而改变。
+ 每张卡片具有**点击跳转**到具体类别的功能（在其他模块实现）



☀️backend-demo-questionCardList-4column
---

传送门🚀[https://github.com/TASProgrammer/backend-demo-questionCardList-4column](https://github.com/TASProgrammer/backend-demo-questionCardList-4column)

#### 🌙SQL
```sql
create database mianshiya;
use mianshiya;

create table if not exists question_bank
(
  id          bigint auto_increment comment 'id' primary key,
  title       varchar(256)                       null comment '标题',
  description text                               null comment '描述',
  picture     varchar(2048)                      null comment '图片',
  userId      bigint                             not null comment '创建用户 id',
  editTime    datetime default CURRENT_TIMESTAMP not null comment '编辑时间',
  createTime  datetime default CURRENT_TIMESTAMP not null comment '创建时间',
  updateTime  datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
  isDelete    tinyint  default 0                 not null comment '是否删除',
  index idx_title (title)
) comment '题库' collate = utf8mb4_unicode_ci;


-- 题库表初始数据
INSERT INTO question_bank (title, description, userId)
VALUES ('JavaScript 基础', '包含 JavaScript 的基础知识题目',1),
       ('CSS 样式', '包含 CSS 相关的样式问题',2),
       ('HTML 基础', 'HTML 标记语言的基本知识', 3),
       ('前端框架', 'React, Vue, Angular 等框架相关的题目', 1),
       ('算法与数据结构', '数据结构和算法题目', 2),
       ('数据库原理', 'SQL 语句和数据库设计', 3),
       ('操作系统', '操作系统的基本概念', 1),
       ('网络协议', 'HTTP, TCP/IP 等网络协议题目',2),
       ('设计模式', '常见设计模式及其应用',3),
       ('编程语言概述', '多种编程语言的基础知识',1),
       ('版本控制', 'Git 和 SVN 的使用',2),
       ('安全与加密', '网络安全和加密技术',3),
       ('云计算', '云服务和架构',1),
       ('微服务架构', '微服务的设计与实现',2),
       ('容器技术', 'Docker 和 Kubernetes 相关知识',3),
       ('DevOps 实践', '持续集成与持续交付',1),
       ('数据分析', '数据分析和可视化',2),
       ('人工智能', '机器学习与深度学习基础',3),
       ('区块链技术', '区块链的基本原理和应用',1),
       ('项目管理', '软件开发项目的管理和执行',2);




```



## ☀️frontend-demo-questionCardList-4column
传送门🚀 [https://github.com/TASProgrammer/frontend-demo-questionCardList-4column](https://github.com/TASProgrammer/frontend-demo-questionCardList-4column)

<font style="color:rgb(59, 59, 59);">First, run the development server:</font>

```bash
npm run dev
# or
yarn dev
# or
pnpm dev
# or
bun dev
```

<font style="color:rgb(59, 59, 59);">Open </font>[<font style="color:rgb(59, 59, 59);">http://localhost:3000</font>](http://localhost:3000/)<font style="color:rgb(59, 59, 59);"> with your browser to see the result.</font>

