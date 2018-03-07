/**
 * 
 */
package tk.licer;

import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * @author licer
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-*.xml", "classpath:dispatcher-servlet.xml" })

//------------如果加入以下代码，所有继承该类的测试类都会遵循该配置，也可以不加，在测试类的方法上///控制事务，参见下一个实例    
//这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！
//这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"），同时指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！ 
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TestBase extends AbstractTransactionalJUnit4SpringContextTests {

	public <T> T getBean(Class<T> type) {
		return applicationContext.getBean(type);
	}

	public Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}

	protected ApplicationContext getContext() {
		return applicationContext;
	}

}
