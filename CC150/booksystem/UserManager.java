package booksystem;

import java.util.Hashtable;

public class UserManager {
	private Hashtable<Integer, User> users;
	public UserManager() {
		// TODO Auto-generated constructor stub
		users=new Hashtable<>();
	}
	public User addUser(int id,String details,AccountType accountType) {
		if (users.containsKey(id)) {
			return null;
		}
		User User=new User(id,details,accountType);
		users.put(id, User);
		return User;
	}
	public boolean remove(User b){
		return remove(b.getId());
	}
	private boolean remove(int id) {
		// TODO Auto-generated method stub
		if (!users.containsKey(id)) {
			return false;
		}
		users.remove(id);
		return true;
	}
	public User findUser(int id) {
		return users.get(id);
	}
}
