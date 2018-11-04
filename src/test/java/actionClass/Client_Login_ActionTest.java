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

public class Client_Login_ActionTest extends StrutsTestCase {

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
	
	/*Unit test case for verifying null check for user name, password or bank id (all three fields are blank)*/
	public void testLoginSubmitAll() throws Exception {
		Client_Login login = new Client_Login();
		Client_Login_Action cla = new Client_Login_Action();
		login.setUserName("");
        login.setPassword("");
        login.setBank_id("");
		cla.setLogin(login);
        String temp = cla.checkLogin();
        assertEquals("error", temp);
    }
	
	/*Unit test case for verifying null check for user name*/
	public void testLoginSubmitUserName() throws Exception {
		Client_Login login = new Client_Login();
		Client_Login_Action cla = new Client_Login_Action();
		login.setUserName("");
        login.setPassword("mindtree");
        login.setBank_id("1234");
		cla.setLogin(login);
        String temp = cla.checkLogin();
        assertEquals("error", temp);
    }
	
	/*Unit test case for verifying null check for password*/
	public void testLoginSubmitPassword() throws Exception {
		Client_Login login = new Client_Login();
		Client_Login_Action cla = new Client_Login_Action();
		login.setUserName("mindtree");
        login.setPassword("");
        login.setBank_id("1234");
		cla.setLogin(login);
        String temp = cla.checkLogin();
        assertEquals("error", temp);
    }

	/*Unit test case for verifying null check for bank id*/
	public void testLoginSubmitBankID() throws Exception {
		Client_Login login = new Client_Login();
		Client_Login_Action cla = new Client_Login_Action();
		login.setUserName("mindtree");
        login.setPassword("mindtree");
        login.setBank_id("");
		cla.setLogin(login);
        String temp = cla.checkLogin();
        assertEquals("error", temp);
    }
	/*Test case for successfulll login*/
	public void testsuccessLoginSubmit() throws Exception {
		Client_Login login = new Client_Login();
		Client_Login_Action cla = new Client_Login_Action();
		Client_Login_DaoImpl loginDAO = new Client_Login_DaoImpl();
		
		//correct credentials
		login.setUserName("mindtree");
        login.setPassword("mindtree");
        login.setBank_id("1234");
		cla.setLogin(login);
		cla.setSession(new HashMap<String, Object>());
        cla.setLoginDAO(loginDAO);
        String result = cla.execute();
        String temp = cla.checkLogin();
        assertEquals("success", temp);
       
       //Incorrect credentials
       login.setUserName("mindtree");
	   login.setPassword("gfgddf");
	   login.setBank_id("1234");
	   cla.setLogin(login);
	   cla.setSession(new HashMap<String, Object>());
	   cla.setLoginDAO(loginDAO);
	   result = cla.execute();
	   temp = cla.checkLogin();
       assertEquals("error", temp);
    }
}
