package com.fjd.system.repository;

import com.fjd.system.info.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 负责数据查询的接口
 */
public interface UserRepository extends JpaRepository<UserInfo, Long>, JpaSpecificationExecutor<UserInfo> {


    //删除一条数据方式一：自己写
    @Modifying //表示更新
    @Transactional //表示事务
    @Query("update UserInfo set ustatus = ?2 where uid = ?1") //?1是占位符 第一个参数
    public void deleteUid(int ustatus, int id);

    //删除一条数据方式二：这是jpa提供的
    //public void deleteByUidIn(long[] uid);

    //批量更新数据
    @Modifying
    @Transactional
    @Query("update UserInfo set ustatus = 1 where uid in(?1)")
    public int updates(Collection<Long> ids);

    /**
     * 根据条件查询用户信息
     * jpa自带方式查询
    * */
    @Query("select ui from UserInfo ui where ui.uphone = ?1")
    public List<UserInfo> findUsers1(String phone);

    /**
     * 通过email去查用户信息
     * @param email
     * @return
     */
    //通过传统的sql去查
    @Query(nativeQuery = true, value = "select * from t_user where umail = ?1")
    public List<UserInfo> findUsers2(String email);

    public List<UserInfo> findAllByUtimeBetween(Date t1, Date t2);
}
