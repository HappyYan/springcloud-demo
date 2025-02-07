# 准备
* IDE: IntelliJ IDEA 2023.2.1 (Community Edition)
* 项目管理工具： Maven， 版本apache-maven-3.8.8。

# 服务注册和发现
* Spring Cloud Netflix Eureka
  * 启动eureka-server（服务注册中心） http://localhost:8761/
  * 启动eureka-client（服务提供者） http://localhost:8081/hello
  * 启动eureka-client-2（服务提供者） http://localhost:8082/hello
  * 服务之间的调用
    * 使用RestTemplate实现  http://localhost:8081/call/another-service 
      * @LoadBalanced 将RestTemplate增强为一个支持负载均衡的客户端工具。具体来说，它会与 Spring Cloud LoadBalancer（或 Ribbon，如果是旧版本）集成，使得客户端能够根据服务名称从 Eureka Server 获取服务实例列表，并自动选择一个实例进行调用。
    * 使用Feign Client实现 http://localhost:8081/call/another-service?useFeign=true
      * Feign 的接口定义方式（通过 @FeignClient 注解）已经隐含了服务发现和负载均衡的逻辑。
  * 

# 配置中心
* Spring Cloud Config

# 熔断器 
* Hystrix
  * 启动eureka-server（服务注册中心） http://localhost:8761/
  * 启动eureka-client-2（服务提供者） http://localhost:8082/hello
  * 启动hystrix（服务提供者），
    访问 http://localhost:8083/hello 随机失败，可以观察到熔断器的触发和恢复。
* Hystrix Dashboard
  * 访问 http://localhost:8084/hystrix ，输入流地址 http://localhost:8083/actuator/hystrix.stream 查看实时监控数据。
  * 通过 Turbine 查看监控数据。

* 
# 监控
* Spring Boot Actuator
