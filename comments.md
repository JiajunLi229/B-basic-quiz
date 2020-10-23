### 完成度：
* 功能整体上都实现了，但是多个功能都有些边界条件没考虑完善。

__Details:__

- \- 不要用 size() + 1 作为新 user 的 id，用单独的 sequence 字段来生成 id。
- \- 新创建的 user，查询其 educations 时，应该返回 [] 而不是 404。
- \- 返回的 education 中的 id 字段是 userId，README 里有具体要求。
- \- user 不存在时，不应该为其创建 education。

### 测试：
* 没有测试。

__Details:__



### 知识点：
* 对 Spring MVC 相关的 annotations 不熟悉，应用不当。

__Details:__

- \- 用了 @ResponseStatus 和 @RestController 的话，就不需要再用 ResponseEntity.status(HttpStatus.CREATED).body(id) 了。
- \- 用 @RestController 替代 @Controller 和 @ResponseBody 的组合。
- \- 用 @GetMapping、@PostMapping 等代替 @RequestMapping。

### 工程实践：
* clean code 欠缺明显。

__Details:__
+ \+ 小步提交做的非常好。
- \- 两个方法里的重复代码有点多，可以提取一下。
- \- UserMap 命名不好，变量名通常不以大写字母开头。另外，叫 users 即可，不需要总是加 map、list 等后缀。
- \- 通常，会 UserMap 抽象成一个 Repository 来实现，比如 InMemoryUserRepository。
- \- UserService.java:20 建议此处使用 Optional API。
- \- 通常创建成功后返回整个新创建的 resource，而不是仅仅只有 id。
- \- EducationService.java:24 建议此处使用 Optional API。
- \- EducationService.java:34 可以使用 return early pattern。

### 综合：
* 从功能角度看，完成度还不错。但是知识点运用和工程实践方面差距还是很明显。

__Details:__



