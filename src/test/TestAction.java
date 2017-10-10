package test;

import com.lanou.crm.hr.domain.Department;
import com.lanou.crm.hr.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class TestAction extends ActionSupport {
    @Qualifier("departmentService")
    @Autowired
    private DepartmentService departmentService;

    @Override
    public String execute() throws Exception {
        List<Department> departments = departmentService.findAllDepartment();
        ActionContext.getContext().put("departments", departments);


        return SUCCESS;
    }
}
