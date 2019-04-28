package com.eale.hrsm.service;

import com.eale.hrsm.bean.SystemMenu;
import com.eale.hrsm.bean.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface SystemMenuService {

    /**
     * 查询所有菜单
     * @return
     */
    List<SystemMenu> findall();

    /**
     * 查找所有父级
     * 		Iterable<SystemMenu> oneMenuAll=iDao.findByParentIdOrderBySortId(0L);
     * //		查找所有子级
     * 		Iterable<SystemMenu> twoMenuAll=iDao.findByParentIdNotOrderBySortId(0L);
     * @param req
     */
    void findAllMenuSys(HttpServletRequest req);

    /**
     * 根据名字查询菜单
     * @param name
     * @return
     */
    List<SystemMenu> findByMenuNameLike(String name);

    /**
     * 1,上移下移按钮先改变其他的排序值
     * @param sortId
     * @param arithNum
     * @param parentId
     * @return
     */
    int changeSortId(Integer sortId, Integer arithNum, Long parentId);

    /**
     * 2,上移下移按钮先改变自己的排序值
     * @param sortId
     * @param arithNum
     * @param menuId
     * @return
     */
    int changeSortId2(Integer sortId, Integer arithNum, Long menuId);

    /**
     * 根据用户查询
     * List<Rolemenu> oneMenuAll=rdao.findbyparentxianall(0L, user.getRole().getRoleId(), true,true);
     * 		List<Rolemenu> twoMenuAll=rdao.findbyparentsxian(0L, user.getRole().getRoleId(), true,true);
     * @param req
     * @param user
     */
    void findMenuSys(HttpServletRequest req, User user);

    /**
     * 查找一级菜单
     * @param l
     * @return
     */
    List<SystemMenu> findByParentIdOrderBySortId(long l);

    /**
     *
     * 根据Id查询
     * @param getId
     * @return
     */
    SystemMenu findById(Long getId);

    /**
     * 新增与修改
     * @param menu
     */
    void save(SystemMenu menu);

    /**
     * 根据Id删除
     * @param menuId
     * @return
     */
    int deleteThis(Long menuId);
}
