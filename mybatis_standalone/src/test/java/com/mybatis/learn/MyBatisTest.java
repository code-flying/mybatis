/**  
* <p>Title: MyBatisTest.java</p>  
* <p>Description: </p>   
* @author dingding  
* @date 2019年10月7日  
*/  
package com.mybatis.learn;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis.learn.domain.Blog;
import com.mybatis.learn.mapper.BlogMapper;

/**
 * @author dingding
 *
 */
public class MyBatisTest {
	
	/**
     * 使用MyBatis API方式
     * ibatis 原生方式
     * @throws IOException
     */
	@Test
	public void testStatement() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Blog blog = session.selectOne("com.mybatis.learn.mapper.BlogMapper.selectBlogById", 1);
			System.out.println(blog);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	/**
     * 通过 SqlSession.getMapper(XXXMapper.class)  接口方式
     * @throws IOException
     */
	@Test
	public void testSelect() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
		Blog blog = blogMapper.selectBlogById(1);
		System.out.println(blog);
		
		if(sqlSession != null){
			sqlSession.close();
		}
		
	}

}
