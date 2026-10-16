# 我的 Java 学习仓库

南邮信安大一，目标：AI 应用工程师

## 阶段清单
- [x] 阶段0：环境搭建 + Git 入门（已完成第一个 HelloWorld ✅）
- [x] 阶段1：Java 基础语法（变量/类型/Scanner/if/for/方法/数组/Random/&&/while ✅）
- [x] 阶段2：面向对象 + 数据结构 🚧 进行中（类与对象、构造方法、ArrayList、封装private/this、继承extends/super、重写@Override、多态 已拿下；接口/异常待学）
- [ ] 阶段3：Spring Boot 后端
- [ ] 阶段4：AI 应用项目（跑酷游戏工具 / AIGC 小产品）

## 已掌握技能
`变量与类型` `Scanner输入` `if/for/while` `方法与return` `数组` `Random` `类与对象` `构造方法` `ArrayList` `封装private/this` `继承extends` `super` `重写@Override` `多态` `两层循环嵌套` `Scanner键盘输入` `boolean开关量`

## 代码备份
全部课程代码在 [code/](./code/) 目录：Day01~Day11 课件 + 作业 + 默写练习，含封装版跑酷游戏、继承多态实验、PhaseA/B 思维训练实战。

## 记录
- 2026-10-05：创建仓库，配好 Git，写下第一个 HelloWorld.java 🚀
- 2026-10-06：Day1~2 变量、Scanner、if/for、方法，跑通第一个交互程序
- 2026-10-07：Day3~4 数组与 Random，做出第一个排行榜小游戏
- 2026-10-09：Day5~6 逻辑运算与 while 生存循环，Java 基础语法全部通关 🎉
- 2026-10-10：Day7 类与对象、构造方法——正式进入面向对象，独立写出 Obstacle 障碍类
- 2026-10-11：Day8 玩家+障碍协作的综合跑酷游戏（还能默写出整局！）；Day9 ArrayList 动态列表 💪
- 2026-10-12：Day10 封装（private 锁数据 + this 区分撞名 + getter/hurt/addScore 正门方法），把 Day9 跑酷游戏升级成标准 Java 封装写法 🔒
- 2026-10-13：Day11 继承与多态（extends 白拿父类字段 / super 交数据给父类 / @Override 重写 / 父类类型 ArrayList 装各种子类统一调用）🧬
  - 产出：`Day11_Inheritance`（课堂版）、`Day11_Inheritance_Encapsulated`（父类 private+getter 封装版）、`Day11_Homework`（Barrier/Wall/Trap 随机抽调 appear）、`Day11_Lab`（6 个可运行实验，含故意写坏看报错）
- 2026-10-13：Day12 起**转轨"编程思维"训练** 🧠 —— 不再按语法推进，改成需求驱动：先写中文步骤再写 Java，脚手架逐档递减，围绕校园跑酷游戏主线项目练拆解
- 2026-10-16：Day12 思维训练实战《跑酷闯关》完整收工 🏃 —— **自己独立完成两层循环嵌套**（外层 3 关 × 内层 8 步）、难度递增 `(g+1)` 倍率、关间回血带 800 上限、死亡双 break 提前退出、三类障碍计数统计
  - 产出：`PhaseA.java`
  - 踩过并记住的坑：循环变量从 0 开始（"第几关"要 +1）、`if(...);` 分号空语句、单文件编译通过≠能运行（要全量编译）、编译失败时跑的是旧字节码、血量/伤害数值要算期望否则必死
- 2026-10-16：PhaseB 第一敲《猜数字》🎯 —— 引入此前未学的 `Scanner` 键盘输入 + `boolean` 开关量，独立完成"Random 想数 + for 10次 + if/else if 判大小 + break 提前退出 + 计数器 + win 标记区分猜中/没猜中"。逻辑分支两路均验证通过（猜中打印"对了"且不打印答案；没猜中打印"正确答案是X"）
  - 产出：`PhaseB.java`
  - 顺手修了 PhaseA 一个真 bug：护盾免疫判断没区分"伤害/回血"，导致捡盾期间抽到药水不回血；加 `mob.damage > 0` 条件后药水正常生效（对比实验：护盾激活+药水，旧逻辑血卡100、新逻辑回血到160）
