package actionClass;

import java.util.HashMap;

import org.apache.struts2.StrutsTestCase;
import org.apache.struts2.util.StrutsTestCaseHelper;
/*import org.demo.example.Login;*/

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.config.providers.XmlConfigurationProvider;

import actionForm.Client_Login;
import daoImpl.Client_Login_DaoImpl;
import junit.framework.TestCase;

public class Client_Login_DaoImmplTest extends StrutsTestCase {

		protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCheckLogin() {
		
	}
	
	protected void setUp() throws Exception {
        super.setUp();
        XmlConfigurationProvider c = new XmlConfigurationProvider("struts.xml");
        configurationManager.addContainerProvider(c);
        configurationManager.reload();
    }
	
	/*Unit test case for verifying DAO implementation with correct user details*/
	public void test_checkLogin_Correct_Details() throws Exception {
		Client_Login login = new Client_Login();
		login.setUserName("mindtree");
        login.setPassword("mindtree");
        login.setBank_id("1234");
        Client_Login_DaoImpl dao = new Client_Login_DaoImpl();
        Client_Login result = dao.checkLogin(login);
       assertEquals("1234", result.getBank_id());
    }
	
	public void test_checkLogin_Incorrect_Details() throws Exception {
		Client_Login login = new Client_Login();
		login.setUserName("mindtree");
        login.setPassword("mindtree");
        login.setBank_id("123");
        Client_Login_DaoImpl dao = new Client_Login_DaoImpl();
        Client_Login result = dao.checkLogin(login);
       assertNotSame("1234", result.getBank_id());
    }
}
