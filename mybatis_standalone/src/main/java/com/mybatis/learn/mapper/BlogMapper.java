/**  
* <p>Title: BlogMapper.java</p>  
* <p>Description: </p>   
* @author dingding  
* @date 2019年10月7日  
*/  
package com.mybatis.learn.mapper;

import com.mybatis.learn.domain.Blog;


/**
 * @author dingding
 *
 */
public interface BlogMapper {
	
	/**
     * 根据主键查询文章
     * @param bid
     * @return
     */
    public Blog selectBlogById(Integer bid);

}
