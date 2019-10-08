/**  
* <p>Title: JDBCTest.java</p>  
* <p>Description: </p>   
* @author dingding  
* @date 2019年10月7日  
*/  
package com.mybatis.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mybatis.learn.domain.Blog;

/**
 * @author dingding
 *
 */
public class JDBCTest {
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	String url = "jdbc:mysql://192.168.0.102:3306/gp-mybatis?useUnicode=true&characterEncoding=utf-8&rewriteBatchedStatements=true";
	String user = "root";
	String password = "flzx_3qc";
	
	@Test
	public void testJdbcBatch(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "insert into blog values(?,?,?)";
			ps = conn.prepareStatement(sql);
			for( int i = 3;i < 5;i++){
				ps.setInt(1, i);
				ps.setString(2, String.valueOf(i));
				ps.setInt(3, 1001);
				ps.addBatch();
			}
			ps.executeBatch();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	@Test
	public void testJdbc(){
		
		Blog blog = new Blog();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			String sql = "select bid,name,author_id from blog where bid = 1";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Integer bid = rs.getInt("bid");
				String name = rs.getString("name");
				Integer author_id = rs.getInt("author_id");
				blog.setBid(bid);
				blog.setName(name);
				blog.setAuthorId(author_id);
			}
			System.out.println(blog);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
