# EasyExcel Demo



## 代码说明

* controller-packapge：用于测试，不涉及业务

* domain-package:  对应个sheet页建立的模型

  ① DataType  【类型声明(TRDP)】Sheet页关联的枚举类

  ② ScriptType  【脚本类型】 Sheet页关联的枚举类

  ③ AlgoTag     【算法标签】 Sheet 页关联的枚举类

  ④ AlgoInnerConfigSheet 对应【算法主机内配置】Sheet页

  ⑤ AlgoOut2OutSheet  对应【算法对外输出配置】Sheet页

* listener-package  每个Sheet页对象业务处理
  
  注： DataType、ScriptType、AlgoTag并没有通过创建对象的方式来读取，而是通过 Map<Integer,String>的方式将每个单元格的内容读出来，然后通过业务逻辑和相应的枚举类关联起来。这里就涉及到动态创建枚举类内容的技术，在 DynamicEnumUtils.java中实现

* converter-package:  自定义的Java类型和表格类型转换

* mock-package:  用于生产假数据，供导出功能使用

* strategy-package:  自定义合并单元格的策略

## 注意点

① 其中【算法主机内配置】和【算法对外输出配置】两个Sheet页都涉及到复杂表头，对于跨多行多列的表头，通过： 
@ExcelProperty(value = { "xx", "xx" }, index = xx)的方式指定一下即可。

② 对于单元格的合并策略，由于也比较复杂，所以 EasyExcel 提供的OnceAbsoluteMergeStrategy 和 LoopMergeStrategy 两个策略无法满足需求。
合并的时候，合并方法是重复执行的，这就会导致刚刚合并完的单元格在下一次合并的时候又要被执行一次合并，就会出错。所以需要注意合并时候的逻辑处理。

③ 导出的 Excel 文件是在项目路径/target/templates文件夹下





## 参考资料

* [EasyExcel使用说明-语雀](https://www.yuque.com/easyexcel/doc/easyexcel)

* [EasyExcel-GitHub](https://github.com/alibaba/easyexcel)

* [自定义合并策略](https://blog.csdn.net/Aeve_imp/article/details/104910080/)
(https://blog.csdn.net/u010425898/article/details/106692567)


* [复杂表头的处理](https://www.jianshu.com/p/3a64ade57bf2)

* [Java动态生成枚举类](https://blog.csdn.net/qq_30038111/article/details/80816286)

