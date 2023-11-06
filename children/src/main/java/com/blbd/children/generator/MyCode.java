//package com.blbd.children.generator;
//
//import com.baomidou.mybatisplus.annotation.DbType;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.config.PackageConfig;
//import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//import com.baomidou.mybatisplus.generator.config.rules.DateType;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//
///**
// * @author sq ♥ovo♥
// * @date 2023/11/1 - 14:01
// */
//public class MyCode {
//    public static void main(String[] args){
//        //构建一个代码生成器对象
//        AutoGenerator mpg = new AutoGenerator();
//
//        //1、全局配置,别导错包
//        GlobalConfig gc = new GlobalConfig();
//
//        String projectPath = System.getProperty("user.dir");    //获取当前项目根目录
//
//        gc.setOutputDir(projectPath+"/children/src/main/java");
//        gc.setAuthor("sq");
//        gc.setOpen(false);  //是否打开资源管理器（文件夹）
//        gc.setFileOverride(false);  //是否覆盖已有文件
//        gc.setServiceName("%sService"); //获取当前目录,%s自动替换为绑定的实体类名
//        gc.setIdType(IdType.ASSIGN_UUID); //主键生成策略
//        gc.setDateType(DateType.ONLY_DATE); //仅仅只是时间，普通的类型
//        gc.setSwagger2(true);   //开启swagger文档   ，swagger-ui.html
//
//        mpg.setGlobalConfig(gc);
//
//        //2、设置数据源
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUsername("mgzm_user");
//        dsc.setPassword("mgzm123456");
//        dsc.setUrl("jdbc:mysql://8.140.242.177:3310/mgzm?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8");
//        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        dsc.setDbType(DbType.MYSQL);    //数据库类型
//
//        mpg.setDataSource(dsc);
//
//
//        //3、包的配置
//        PackageConfig pc = new PackageConfig();
//        pc.setModuleName("children");
//        pc.setParent("com.blbd");
//        pc.setEntity("dao.entity");
//        pc.setMapper("mapper");
//        pc.setService("service");
//        pc.setController("controller");
//
//        mpg.setPackageInfo(pc);
//
//        //4、策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        //设置表名映射，重点要改的地方
//        strategy.setInclude("score_history");
//        //设置包的命名规则，下划线转驼峰命名
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        //列,数据库字段
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        //使用lombok开启编程
//        strategy.setEntityLombokModel(true);
//        //设置restful风格
//        strategy.setRestControllerStyle(true);
//        //下划线命名,如localhost:8080/hello_id_2
//        strategy.setControllerMappingHyphenStyle(true);
//        // 设置表字段的注解，这里加入 @TableField
//        strategy.setEntityTableFieldAnnotationEnable(true);
//        mpg.setStrategy(strategy);
//
//        mpg.execute();  //执行
//    }
//}
