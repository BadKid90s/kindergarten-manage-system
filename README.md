<h1 style="text-align: center"> 幼儿园管理系统</h1>


![系统架构图](https://github.com/BadKid90s/kindergarten-manage-system/blob/main/architecture-diagram.png)






## 项目简介
一个基于 Spring Boot、 JWT、Spring Security、MybatisPlus、Vue 、Gradle 的前后端分离的管理系统
### 后端技术
- Spring Boot
- Spring Security
- MybatisPlus
- JWT
- Gradle
- JDK 1.8
### 前端技术
- Vue
- Element
- Webpack
- Banble
- Axios
#### 开发
**安装依赖**
```
npm install
```
**启动项目**
```
npm run dev
```
#### 打包项目
```
npm run build
```
## 主要特性
- 使用最新技术栈，社区资源丰富。
- 对一些常用地前端组件封装：表格数据请求、数据字典等
- 前后端统一异常拦截处理，统一输出异常，避免繁琐的判断
- 支持运维管理，可方便地对远程服务器的应用进行部署与管理

####  系统功能
- 用户管理：提供用户的相关配置
- 角色管理：对权限与菜单进行分配，可根据部门设置角色的数据权限
- 菜单管理：已实现菜单动态路由，后端可配置化，支持多级菜单
- 字典管理：可维护常用一些固定的数据，如：状态，性别等


