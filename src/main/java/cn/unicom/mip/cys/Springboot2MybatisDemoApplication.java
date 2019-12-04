package cn.unicom.mip.cys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Description: 项目启动类
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("cn.unicom.mip.cys.mapper") //指定要扫描的Mapper类的包的路径
public class Springboot2MybatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2MybatisDemoApplication.class, args);
        System.out.println("程序正在运行...");
    }

}
