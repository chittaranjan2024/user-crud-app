import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.UserDAO;

class UserDAOTest {
	
  UserDAO userDAO=new UserDAO();
	
	@Test
	void selectUser_testcase1() {
		assertNotNull(userDAO.selectUser(1));
	}

	@Test
	void selectUser_testcase2() {
		assertNull(userDAO.selectUser(2));
	}
}
