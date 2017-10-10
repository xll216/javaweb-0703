package com.lanou.crm.base;

import com.lanou.crm.hr.service.DepartmentService;
import com.lanou.crm.hr.service.PostService;
import com.lanou.crm.hr.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.ParameterizedType;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class BaseAction<T> extends ActionSupport implements ServletResponseAware, ServletRequestAware, ModelDriven<T> {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private Class classt;
    private T t;

    @Qualifier("staffService")
    @Autowired
    private StaffService staffService;

    @Qualifier("departmentService")
    @Autowired
    private DepartmentService departmentService;

    @Qualifier("postService")
    @Autowired
    private PostService postService;

    public BaseAction() {
        // 这个构造函数的设计和之前的泛型Dao扩展是一样的，BaseAction是要用来被别的Action来继承的，所以这个就可以得到BaseAction中的泛型的类类型。
        try {
            ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
            this.classt = (Class) type.getActualTypeArguments()[0];
            // 直接创建一个T对象，比如如果传入的是Department这里就会创建一个Department
            this.t = (T) this.classt.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获得当前页
    private int pageNum = 1;

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageNum() {
        return pageNum;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpSession getSession() {
        return request.getSession();
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public StaffService getStaffService() {
        return staffService;
    }

    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    //4 提供公共方法，方便操作
    // 4.1 给 context赋值
    public void put(String key, Object value) {
        ActionContext.getContext().put(key, value);
    }

    // 4.2 给session赋值
    public void sessionPut(String key, Object value) {
        ActionContext.getContext().getSession().put(key, value);
    }

    // 4.3 给session赋值
    public void applicationPut(String key, Object value) {
        ActionContext.getContext().getApplication().put(key, value);
    }

    // 4.4 给 root 值栈设置
    public void set(String key, Object value) {
        ActionContext.getContext().getValueStack().set(key, value);
    }

    // 4.5 给 root值栈 压栈
    public void push(Object o) {
        ActionContext.getContext().getValueStack().push(o);
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        request = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        response = httpServletResponse;
    }

    @Override
    public T getModel() {
        return t;
    }
}
