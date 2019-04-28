package com.eale.hrsm.dao;

import com.eale.hrsm.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long> {

    List<User> findByUserId(Long id);

    List<User>  findByFatherId(Long parentid);

    Page<User> findByFatherId(Long parentid, Pageable pa);

    //名字模糊查找
    @Query("select u from User u where  (u.userName like %?1% or u.realName like %?1%) and u.fatherId=?2 ")
    Page<User> findbyFatherId(String name, Long parentid, Pageable pa);

    @Query("select u from User u where u.userName=:name")
    User findid(@Param("name") String name);

//    @Query("select tu.pkId from Taskuser tu where tu.taskId.taskId=:taskid and tu.userId.userId=:userid")
//    Long findpkId(@Param("taskid")Long taskid,@Param("userid")Long userid);

    //根据名字找用户
    User findByUserName(String name);

    //根据用户名模糊查找
    @Query("from User u where u.userName like %:name% or u.realName like %:name%")
    Page<User> findbyUserNameLike(@Param("name") String name, Pageable pa);

    //根据真实姓名模糊查找
    Page<User> findByrealNameLike(String name, Pageable pa);


    //根据姓名首拼+查找关键字查找(姓名、电话号码)，并分页
    @Query("from User u where (u.userName like ?1  or u.userTel like ?1 ) ")
    Page<User> findSelectUsers(String baseKey, Pageable pa);

    //根据姓名首拼+查找关键字查找姓名、电话号码)，并分页
    @Query("from User u where u.userName like ?1  or u.userTel like ?1 ")
    Page<User> findUsers(String baseKey, Pageable pa);

    /**
     * 用户管理查询可用用户
     * @param isLock
     * @param pa
     * @return
     */
    Page<User> findByIsLock(Integer isLock, Pageable pa);

    @Query("from User u where u.userName like %?1% or u.realName like %?1% or u.userTel like %?1% or u.role.roleName like %?1%")
    Page<User> findnamelike(String name, Pageable pa);

    @Query("select u from User u where u.role.roleId=?1")
    List<User> findrole(Long lid);

    /*通过（用户名或者电话号码）+密码查找用户*/
    @Query("from User u where (u.userName = ?1 or u.userTel = ?1) and u.password =?2")
    User findOneUser(String userName, String password);





}
