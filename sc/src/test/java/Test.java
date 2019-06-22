import com.sun.corba.se.spi.copyobject.CopyobjectDefaults;
import com.test.sc.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {

    private JdbcTemplate jdbcTemplate;
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
    }

    //execute方法
    public void testExecute() {
        jdbcTemplate.execute("create table user1(id int, name varchar(20))");
    }

    // update 方法
    public void testUpdate() {
        String sql = "insert into student(name, sex) values(?,?)";
        jdbcTemplate.update(sql, new Object[]{"张飞", "男"});  // 将值放到数组中
    }

    // update 方法（常用）
    public void testUpdate2() {
        String sql = "update student set sex=? where id=?";
        jdbcTemplate.update(sql, "女", 1);   // 直接写参数，不用放在数组中
    }

    // 批量增删改方法：执行多条 sql
    public void testBatchUpdate() {
        String[] sqls = {
                "insert into student(name, sex) values('关羽', '女')",
                "insert into student(name, sex) values('刘备', '男')",
                "update student set sex='男' where id=1"
        };
        jdbcTemplate.batchUpdate(sqls);
    }

    // 批量增删改方法（常用）：执行一条 sql
    @org.junit.Test
    public void testBatchUpdate2() {
        String sql = "insert into selection(student, course) values(?,?)";
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{1, 1001});
        list.add(new Object[]{1, 1003});
        jdbcTemplate.batchUpdate(sql, list);
    }

    // 查询简单数据项（获取一个）
    @org.junit.Test
    public void testQuerySimple() {
        String sql = "select count(*) from student";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

    // 查询简单数据项（获取多个）
    @org.junit.Test
    public void testQuerySimple2() {
        String sql = "select name from student where sex=?";
        List<String> names = jdbcTemplate.queryForList(sql, String.class, "男");
        System.out.println(names);

    }

    // 查询复杂对象（封装为Map，查询一个）
    @org.junit.Test
    public void testQueryMap1() {
        String sql = "select * from student where id = ?";
        Map<String, Object> stu = jdbcTemplate.queryForMap(sql, 1);
        System.out.println(stu);
    }

    // 查询复杂对象（封装为Map， 查询多个）
    @org.junit.Test
    public void testQueryMap2() {
        String sql = "select * from student";
        List<Map<String, Object>> stus = jdbcTemplate.queryForList(sql);
        System.out.println(stus);
    }

    //查询复杂对象（封装为实体对象，获取一个）
    //映射写法
    @org.junit.Test
    public void testQueryEntity1() {
        final String sql = "select * from student where id=?";
        // 匿名内部类
        Student stu = jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student stu = new Student();
                stu.setId(resultSet.getInt("id"));
                stu.setName(resultSet.getString("name"));
                stu.setSex(resultSet.getString("sex"));
                stu.setBorn(resultSet.getDate("born"));
                return stu;
            }
        }, 3);
        System.out.println(stu);
    }

    // 查询复杂对象（封装为实体对象，查询多个）
    @org.junit.Test
    public void testQueryEntity2() {
        String sql = "select * from student";
        List<Student> stus = jdbcTemplate.query(sql, new StudentRowMapper());
        System.out.println(stus);
    }

    // 构造封装对象类
    private class StudentRowMapper implements RowMapper<Student> {
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student stu = new Student();
            stu.setId(resultSet.getInt("id"));
            stu.setName(resultSet.getString("name"));
            stu.setSex(resultSet.getString("sex"));
            stu.setBorn(resultSet.getDate("born"));
            return stu;
        }
    }

}
