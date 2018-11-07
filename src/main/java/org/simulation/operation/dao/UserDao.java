package org.simulation.operation.dao;


import static org.simulation.operation.common.UserConstants.USERTABLE;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.simulation.operation.domain.User;


public interface UserDao {

	// 根据登录名和密码查询员工
	@Select("select * from "+USERTABLE+" where login_name = #{loginName} and login_password = #{loginPassword}")
	User selectByLoginnameAndPassword(
			@Param("loginName") String loginName,
			@Param("loginPassword") String loginPassword);
    // 根据id查询用户
    @Select("select * from " + USERTABLE + " where id = #{id}")
    User selectById(String id);

    // 根据id删除用户
    @Delete(" delete from " + USERTABLE + " where id = #{id} ")
    void deleteById(String id);



   

}
