package com.basicquiz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TODO GTB-完成度: * 功能整体上都实现了，但是多个功能都有些边界条件没考虑完善。

//TODO GTB-完成度: - 新创建的 user，查询其 educations 时，应该返回 [] 而不是 404。
//TODO GTB-完成度: - 返回的 education 中的 id 字段是 userId，README 里有具体要求。
//TODO GTB-完成度: - user 不存在时，不应该为其创建 education。

//TODO GTB-知识点: * 对 Spring MVC 相关的 annotations 不熟悉，应用不当。

//TODO GTB-工程实践: * clean code 欠缺明显。

//TODO GTB-工程实践: + 小步提交做的非常好。

//TODO GTB-测试: * 没有测试。

//TODO GTB-综合: * 从功能角度看，完成度还不错。但是知识点运用和工程实践方面差距还是很明显。

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
