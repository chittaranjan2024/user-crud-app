import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import dao.UserDAO;

class UserDAOTest {
	
  UserDAO userDAO=new UserDAO();
	
	@Test
	void selectUser_testcase1() {
		assertNotNull(userDAO.selectUser(1));
	}

	@Test
	void selectAllUser_testcase1() {
		assertTrue(userDAO.selectAllUsers().size()>0);
	}
	
	@Test
	void sdeletelUser_testcase1() {
		assertFalse(userDAO.deleteUser(56));
	}
	
	
}
