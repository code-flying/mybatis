/**  
 * <p>Title: Blog.java</p>  
 * <p>Description: </p>   
 * @author dingding  
 * @date 2019年10月7日  
 */
package com.mybatis.learn.domain;

/**
 * @author dingding
 *
 */
public class Blog {

	private Integer bid;// 文章ID
	private String name; // 文章标题
	private Integer authorId; // 文章作者ID

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	@Override
	public String toString() {
		return "Blog [bid=" + bid + ", name=" + name + ", authorId=" + authorId
				+ "]";
	}

}
