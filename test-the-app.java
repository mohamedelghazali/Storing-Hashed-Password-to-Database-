@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestBeanConfig.class })
public class UserControllerTest {

	@Autowired
	private UserController userController;

	private String password = "password";

	@Test
	public void validateUser_Test_Positive() {
		User user = new User();
		user.setEmail("test@test.com");
		user.setName("test");
		user.setPassword(password);
		userController.save(user);
		ResponseEntity result = userController.getUser(user.getId());
		assertNotNull(result.getBody());
		checkPass(password, user.getPassword());
		assertEquals(result.getStatusCode(), HttpStatus.OK);
	}

	private void checkPass(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword))
			System.out.println("The password matches.");
		else
			System.out.println("The password does not match.");
	}

}
