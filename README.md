# WeChat-Sell

>   以SpringBoot+JPA和微信特性为核心技术栈，实现了买家端在微信平台上下单，支付到卖家端接单的一个商品购买的完整流程，采用的是前后端分离，前端采用Vue实现，后端使用SpringBoot开发，这里主要讲后端实现。这个项目写下来，对项目开发的一些流程以及遇到的问题有基本解决方法有一个大致的理解。（微信授权可以是个人账号，但是微信支付必须要有企业资质的账号）


### 内容包括：

- 项目展示
- 配置介绍
- 前期准备
- 买家商品与订单
- 微信授权登录
- 模板消息推送
- 微信支付与退款
- 卖家订单



## 项目描述：

分为卖家端（管理商品，订单）和买家端（点餐付款）
买家端通过登录点餐并加入购物车，扫码付款
卖端通过扫码登录后台管理界面，可以看到展示上架的商品类别，订单详情以及可以下架新增商品。

## 表结构
``` 表结构
product_category(category_id,类目名字，类目编号，创建时间，修改时间)  index ：主键id，类目编号(唯一约束)
product_info(product_id,商品名字,商品价格,商品库存,描述,小图,商品状态,类目编号)
order_master(order_id,买家名字,电话,地址,微信openid,订单总金额,订单状态,支付状态)  index:主键id,微信openid
order_detail(detail_id,order_id,product_id,商品名称,当前价格,数量,小图)  index:主键id,订单id； 外键引用订单
    主表id，一对多关系
seller_info(id,username,password,微信openid) comment 卖家信息表
```

## 统一返回对象，统一异常处理
``` 
定义统一返回ResultVO对象,对后端返回数据做统一处理：
ResultVO(Code,Msg,Data)
public static ResultVO success(Object object)
public static ResultVO success()
public static ResultVO error(Integer code,String msg)

抛出异常时，如创建订单成功或失败，要返回给前端一个统一的结果，实现一个异常处理类SellerExceptionHandler中，对抛出的
SellException统一处理
@ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }
``` 

## 微信网页授权
获取



## 访问页面
``` 
项目的前后端是完全分离的，买家端前端的代码在另一个路径上。
修改nginx的配置文件，让nginx可以找到前端代码。在nginx根目录下的conf目录下有一个nginx.conf文件，它就是我们要修改的配置文件，
server {
        listen       80;
        server_name  localhost;

        #charset koi8-r;

        #access_log  logs/host.access.log  main;

        location / {
            root   F:\vuejs-project\dist; #前端资源路径
            index  index.html index.htm;
        }
		location /sell/ {
			proxy_pass http://127.0.0.1:8080/sell/;
		}
双击nginx.exe启动nginx服务器，如果已启动过，命令行进入nginx的根目录，输入nginx -s reload重启nginx服务器。
浏览器访问：http://127.0.0.1/#/order/，这是会出现空白界面，按F2打开浏览器的开发者工具，在浏览器的控制台输入
document.cookie='abc123' 向该域名下添加cookie。再次访问：http://127.0.0.1，这时就可以访问到前端界面了。
``` 

## 手机访问微信公众号访问
```
对于手机端微信公众号内访问，还要使用到内网穿透工具，由于微信里不能直接访问ip地址，还要购买域名，还涉及到挺复杂的微信调试。
这里就不再介绍。可以使用postman这个工具模拟微信点餐下单。访问接口参见controller包下以Buyer开头的类。
如果想查看微信端的访问效果，可以在微信客户端访问这个链接：http://sell.springboot.cn/
```

## 前端代码运行方式
``` 
#安装依赖包
npm install

#运行项目 
npm run dev  

#打包
npm run build

#最后部署dist文件到nginx/iis/apache  推荐使用nginx 
``` 

## 项目配置说明
-  前端项目配置  打开前端项目的 `config/index.js` 里面 `build` 节点下的 `sellUrl`  `openidUrl`  `wechatPayUrl`   配置的自己的项目地址
- 后端项目配置 打开后端项目的的 `src/main/resources/application.yml`  ，请将里面的mysql ,redis配置为自己的地址，微信配置见下表

| 配置项  | 说明 |
| ------------- | ------------- |
| mpAppId  |微信公众号AppId  |
| mpAppSecret  | 微信公众号AppSecret |
| openAppId  | 微信开放平台AppId |
|  openAppSecret |  微信开放平台AppSecret|
|  mchId | 微信支付Id |
| mchKey  |  微信支付密钥|
|keyPath   |微信支付文件路径  |
|   notifyUrl|  微信支付异步回调地址|
| templateId  |微信模板消息Id  |


## 微信账号说明
- 微信公众号认证需要企业资质，个人无法申请。但是个人可以申请微信测试号，在本项目中，微信测试号可以用于微信授权登陆，微信模板消息发送。
- 微信支付和微信退款必须要企业认证的公众号，所以如果自己个人想做微信支付和微信退款，只能用公司的公众号或者去买。
- 微信开放平台账号也必须是企业认证的，个人没法注册，在本项目中，微信开放平台的账号主要用于扫码登陆，如果你没有微信开放平台的账号，你可以fork项目，然后自己开发一个账号密码登陆也可以。
- 我项目中的各种微信账号是自己的测试号 ，请使用自己的。
- 如果谁有微信开放平台的账号借我一用，非常感谢，只是测试微信扫描登陆的，不做其他任何事情

## 项目部署说明
- 按照上面的 项目配置说明 将项目配置好，，前端和后端都需
- 将打包后的前端代码部署好，个人使用Nginx , 我在Nginx设置如下代理

      location /sell/ {
            proxy_pass http://127.0.0.1:8080/;
        }
- 用Maven将java项目打包成jar  用java -jar启动项目即可




## 项目展示
! [](http://pdqnpb4k0.bkt.clouddn.com/4)
! [](http://pdqnpb4k0.bkt.clouddn.com/6)



