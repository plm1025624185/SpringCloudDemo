SpringCloudDemo
================

# 目录结构

- [1.简介](#introduction)
- [2.项目说明](#project)
	- [2.1.简介](#proIntro)
	- [2.2.模块说明](#module)
		- [2.2.1.服务注册中心](#server)
		- [2.2.2.网关](#gateway)
		- [2.2.3.服务提供者](#worker)
		- [2.2.4.服务消费者](#feign)

<a name="introduction" />

# 1.简介
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;该项目是学习Spirng Cloud所编写的，希望通过该项目一点点完善学到的Spring Cloud知识。

<a name="project" />

# 2.项目说明

<a name="proIntro" />

## 2.1.简介

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;该项目暂时由以下几部分组成。`server`是**服务注册中心**;`worker1`和`worker2`为**工作节点或服务提供者**;`gateway`是**服务网关**;`feign`暂时是**服务消费者**，也可以用来实现**熔断器**，feign本身自带**负载均衡**，多调几次单元测试就可以知道了。

<a name="module" />

## 2.2.模块结构说明

<a name="server" />

### 2.2.1.server服务注册中心

#### 2.2.1.1.项目结构

* com.example.server
		服务启动类所在的包，需要对启动类添加@EnableEurekaServer注解，说明该项目是服务注册中心

<a name="gateway" />

### 2.2.2.gateway网关

#### 2.2.2.1.项目结构

* com.example.gateway
		
		服务启动类所在的包，需要对启动类添加@EnableEurekaClient注解，说明该项目需要注册到服务中心;添加@EnableZuulProxy注解，说明该项目是服务网关。

* com.example.gateway.filter
		
		服务拦截器所在的包。服务网关可以对接口的安全性进行校验，我们可以通过网关进行统一拦截，zuul通过继承过滤器ZuulFilter进行处理。服务是部署在不同的服务器下的，难免会遇到某一个服务挂掉或者请求不到的时候，我们可以通过继承FallbackProvider来对请求不到的服务进行错误处理。

<a name="worker" />

### 2.2.3.worker服务提供者

#### 2.2.3.1.项目结构

* com.example.worker
		
		worker节点启动类所在的包，需要对启动类添加@EnableEurekaClient注解，说明该项目需要注册到服务中心。

* com.example.worker.controller
		
		控制器层，接口提供层


### 2.2.4.feign服务消费者

#### 2.2.4.1.项目结构

* com.example.feign
		
		feign启动类所在的包，添加@EnableFeignClients和@EnableEurekaClient注解，其中@EnableFeignClients指开启声明式http客户端。

* com.example.feign.service
		
		feign消费服务所在的包。@FeignClient注解用于配置调用的服务地址。

* src/test下的com.example.feign.service
		
		对服务消费类进行测试。
