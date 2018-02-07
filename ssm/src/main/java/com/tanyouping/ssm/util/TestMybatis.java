package com.tanyouping.ssm.util;

import com.tanyouping.ssm.mapper.BlogMapper;
import com.tanyouping.ssm.param.BlogQueryParam;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class TestMybatis {

    @Test
    public void mybatis() throws Exception {

        //1：mybatis-config.xml (是mybatis的全局配置文件，名称不固定的)
        //配置了数据源(dataSource)、事务(transactionManager)等mybatis运行环境
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //2：SqlSessionFactory (会话工厂),根据配置文件创建工厂
        //作用：创建会话 (SqlSession)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //3：SqlSession(会话),是一个接口
        //作用：操作数据 (crud)
        //4：Executor(执行器)，是一个接口(基本执行器,缓存执行器)
        //作用：SqlSession内部通过执行器操作数据库
        SqlSession session = sqlSessionFactory.openSession();
        try {

            //5：mapped statement (底层封装对象)
            //作用：对操作数据库存储封装，包括 SQL语句,输入参数、输出结果类型
            BlogMapper blogMapper = session.getMapper(BlogMapper.class);

            BlogQueryParam blogQueryParam = new BlogQueryParam();
            blogQueryParam.setName("h");
            blogMapper.selectBlog(blogQueryParam);



//            session.commit();


        } finally {

            //总结:

//          parameterType：在映射文件中通过parameterType指定输入参数的类型
//          resultType：在映射文件中通过resultType指定输出结果的类型

//          #{}和${}：
//                #{}表示一个占位符号，#{}接收输入参数，类型可以是简单类型，pojo、hashmap。
//                如果接收简单类型，#{}中可以写成value或其它名称。
//                #{}接收pojo对象值，通过OGNL读取对象中的属性值，通过属性.属性.属性...的方式获取对象属性值
//
//                ${}表示一个拼接符号，会引用sql注入，所以不建议使用${}。
//                ${}接收输入参数，类型可以是简单类型，pojo、hashmap。
//                如果接收简单类型，${}中只能写成value。
//                ${}接收pojo对象值，通过OGNL读取对象中的属性值，通过属性.属性.属性...的方式获取对象属性值。

//          selectOne和selectList:
//                selectOne表示查询出一条记录进行映射。如果使用selectOne可以实现使用selectList也可以实现（list中只有一个对象）。
//                selectList表示查询出一个列表（多条记录）进行映射。如果使用selectList查询多条记录，不能使用selectOne。

//            mybatis和hibernate本质区别和应用场景:

//            hibernate：是一个标准ORM框架（对象关系映射）。入门门槛较高的，不需要程序写sql，sql语句自动生成了。
//            对sql语句进行优化、修改比较困难的。
//            应用场景：
//            适用与需求变化不多的中小型项目，比如：后台管理系统，erp、orm、oa。。
//
//            mybatis：专注是sql本身，需要程序员自己编写sql语句，sql修改、优化比较方便。mybatis是一个不完全 的ORM框架，虽然程序员自己写sql，mybatis 也可以实现映射（输入映射、输出映射）。
//            应用场景：
//            适用与需求变化较多的项目，比如：互联网项目。
//
//            企业进行技术选型，以低成本 高回报作为技术选型的原则，根据项目组的技术力量进行选择。


            session.close();
        }

    }
}


