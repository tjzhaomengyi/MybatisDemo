import com.mikemyzhao.entity.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: zhaomengyi
 * @Date: 2019/8/30 10:48
 * @Description:
 */
public class Test {

    @org.junit.Test
    public void test1() throws IOException {

        //把配置文件加载为流
        InputStream is = Resources.getResourceAsStream("Mybatis.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
//        核心接口
        SqlSession ss = ssf.openSession();

        Book book = ss.selectOne("com.mikemyzhao.entity.selectBook",1);
        System.out.println(book);
        ss.close();
    }
}
