import com.itheima.mvc.config.SpringConfig;
import com.itheima.mvc.dao.BookDao;
import com.itheima.mvc.pojo.Book;
import com.itheima.mvc.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BookServiceTest {
  @Autowired
  private BookService bookService;
  @Autowired
  private BookDao bookDao;

  @Test
  public void testsql() {
    List<Book> books = bookService.listAllBooks();
    books.forEach(
            System.out::println);
  }

  @Test
  public void testsql2(){
    Book book=new Book();
    book.setDescription("test");
    book.setName("test");
    book.setType("test");
    System.out.println(bookDao.add(book));
  }
  @Test
  public void testsql3(){
    Book book=new Book();
    book.setDescription("test1");
    book.setName("test1");
    book.setType("test1");
    book.setId(7);
    bookDao.update(book);
    System.out.println(bookDao.selectById(7));
    System.out.println(bookDao.del(7));
  }

}
