package test;

import com.lanou.crm.career_planning.domain.Student;
import com.lanou.crm.education.domain.Classes;
import com.lanou.crm.education.domain.CourseType;
import com.lanou.crm.hr.dao.DepartmentDao;
import com.lanou.crm.hr.dao.PostDao;
import com.lanou.crm.hr.dao.StaffDao;
import com.lanou.crm.hr.domain.Department;
import com.lanou.crm.hr.domain.Post;
import com.lanou.crm.hr.domain.Staff;
import com.lanou.crm.hr.service.StaffService;
import com.lanou.crm.hr.web.action.StaffAction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class MainTest {

    private ApplicationContext context;
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext(
                new String[]{"spring_config/applicationContext.xml", "spring_config/hr.xml",
                        "spring_config/career_planning.xml", "spring_config/education.xml",
                        "spring_config/graduate.xml", "spring_config/refer.xml"});
        sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    @After
    public void close() {
        transaction.commit();
        session.close();
        sessionFactory.close();
        ((ClassPathXmlApplicationContext) context).close();
    }

    @Test
    public void testStudent() {
        Student Student = new Student();
        Student.setName("孙广浩");
        Student.setTelephone("13840940863");
        Student.setIdentity("230227199302010138");
        Student.setQq("378196893");
        Student.setGender("男");
        Student.setMustTuition(16800);
        Student.setActualTuition(16800);
        Student.setEmail("xx@163.com");
        Student.setSchool("哈尔滨理工大学");
        Student.setEducation("本科");
        Student.setProfessional("信息管理与信息系统");
        Student.setIdentityAddress("大连");
        Student.setAddress("大连");
        Student.setRemark("无");
        Student.setHomeTelephone("13940974003");
        Student.setHomeContact("肖女士");
        Student.setStatus("1");

        session.save(Student);

    }

    @Test
    public void addDepartment() {
        /*部门*/
        Department department = new Department();
        department.setDepName("职规部");

        /*职务*/
        Post post1 = new Post();
        post1.setPostName("班主任");

        Post post2 = new Post();
        post2.setPostName("职规主管");

        /*职务加入到对应的部门*/
        department.getPostSet().add(post1);
        department.getPostSet().add(post2);

        /*员工*/
        Staff staff = new Staff();
        staff.setStaffName("欣姐");
        staff.setGender("女");
        staff.setLoginName("xin");
        staff.setLoginPwd("123");
        staff.setOnDutyDate(new Date());

        Staff staff1 = new Staff();
        staff1.setStaffName("湃湃");
        staff1.setGender("女");
        staff1.setLoginName("paipai");
        staff1.setLoginPwd("123");
        staff1.setOnDutyDate(new Date());

        Staff staff2 = new Staff();
        staff2.setStaffName("马琳");
        staff2.setGender("女");
        staff2.setLoginName("malin");
        staff2.setLoginPwd("123");
        staff2.setOnDutyDate(new Date());

        post1.getStaffSet().add(staff);
        post1.getStaffSet().add(staff1);

        post2.getStaffSet().add(staff2);

        session.save(post1);
        session.save(post2);
        session.save(department);
    }

    /**
     * 添加班级
     **/
    @Test
    public void addClass() {
        CourseType courseType = new CourseType();
        courseType.setCourseName("JavaEE就业班");
        courseType.setCourseCost(18800.00);
        courseType.setTotal(100);
        courseType.setRemark("JavaSE核心编程,JavaWeb开发,JavaEE框架开发,Java企业项目实战,就业指导课");

        CourseType courseType1 = new CourseType();
        courseType1.setCourseName("HTML5就业班");
        courseType1.setCourseCost(19800.00);
        courseType1.setTotal(90);
        courseType1.setRemark("HTML5基础课程,JavaScript基础课程,JavaScript进阶课程,H5全栈开发课程,流行框架-企业项目实战,H5企业工作模拟,就业指导课");

        Classes classes = new Classes();
        classes.setName("J161001期");
        classes.setBeginTime(new Date());
        classes.setEndTime(new Date());
        classes.setTotalCount(12);
        classes.setUpgradeCount(0);
        classes.setChangeCount(0);
        classes.setRunoffCount(0);
        classes.setRemark("暂无");
        classes.setUploadPath("");
        classes.setUploadFileName("JavaEE就业班课程表.xlsx");



    }

    @Test
    public void findAll() {
        DepartmentDao dao = (DepartmentDao) context.getBean("departmentDao");
        List<Department> departments = dao.findAll();
        for (Department d : departments) {
            System.out.println(d);
        }

        System.out.println("-------");

        PostDao postDao = (PostDao) context.getBean("postDao");
        List<Post> posts = postDao.findAll();

        for (Post post : posts) {
            System.out.println(post);
        }


        System.out.println("-------");

        StaffDao staffDao = (StaffDao) context.getBean("staffDao");
        List<Staff> staffs = staffDao.findAll();
        for (Staff staff : staffs) {
            System.out.println(staff);
        }

    }

    @Test
    public void testStaffLogin() {
        StaffService staffService = (StaffService) context.getBean("staffService");
        Staff staff = staffService.login("wudashi", "123");
        System.out.println("-->>" + staff);

    }

    @Test
    public void testAction() {
        StaffAction staffAction = (StaffAction) context.getBean("staffAction");
        staffAction.findAll();
    }
}
