package section1Project;

public class UserAdministration {
	
	final static int USER_NUMBER=100;
	
	
	User [] userList=new User[USER_NUMBER]; 
	{
	userList[0]=new User("neslisezen","nesli123","neslihansezen9@gmail.com");
	userList[1]=new User("akinkaldiroglu","ayvalikspor123","akin@javaturk.org");
	userList[2]=new User("asimkilic","asim123","asimkilic@gmail.com");
	userList[3]=new User("ahmetgultekin","ahmetahmet3","ahmetgultekin@gmail.com");
	}
	int userNumber() {
		int number=0;
		for(User user: userList) {
			if(user==null)
				break;
			number++;
		}
		return number;
	}
	
	int addUser (String userName, String userPassword, String userEmail) {
		int index=userNumber();
		userList[index] = new User(userName,userPassword,userEmail);
		if(userList[index]!=null) {
			System.out.println("User is successfully created.\n"
					+ "User "+userList[index].getUserName()+" Welcome!");
			return index;
		}
		else {
			System.out.println("ERROR!");
			return -1;
		}
	}
	int userRegister(String username,String password) {
		int index=searchUser(username);
		if(index!=-1) {
			if(password.equals(userList[index].getUserPassword())) {
				System.out.println("Login successful!\n"
						+ "Welcome "+userList[index].getUserName()
						+"! \n");
				return index;
			}
			else {
				System.out.println("Wrong password!");
			return -1;
			}
		}
		else {
			System.out.println("Wrong username!");
			return -2;
			}
		
	}
	
	int deleteUser(String username) {
	
		int index = searchUser(username);
		if(index != -1) {
		for(int i= index ; i< userList.length ; i++) {
			userList[i]=userList[i+1];
			if(userList[i]==null)
				break;
		}
		System.out.println("User "+username+" is succesfully deleted.");
		return 1;}
		else {
			System.out.println("User "+username+" not found.");
			System.out.println("Make sure that you write your username correctly.");
			return 0;
	}}
	
	int searchUser(String username) {
		int index;
		 
			for(int i=0; i < userList.length;i++) {
				if(userList[i]==null)
					return -1;
			if(username.equalsIgnoreCase(userList[i].getUserName())) {
				index = i;
				System.out.println("User found successfully.");
					return index;
				}
			}
			System.out.println("User not found!");
			return -1;
			
		}
	User searchUserReturnUser(String username) {
		int index;
		 
			for(int i=0; i < userList.length;i++) {
				if(userList[i]==null)
					return null;
			if(username.equalsIgnoreCase(userList[i].getUserName())) {
				index = i;
					return userList[index];
				}
			}
		return null;
		}

	void listUser(User user) {
		System.out.println("********************************"+
				"\nUser Name: "+user.getUserName()+
				"\nUser Id: "+ user.getUserId()+
				"\nUser E-mail: "+ user.getUserEmail()+
				"\n********************************");
	}
	
	void listUsers () {
		for(User user : userList) {
			if(user==null)
				break;
			System.out.println("********************************"+
					"\nUser Name: "+user.getUserName()+
					"\nUser Id: "+ user.getUserId()+
					"\n********************************");
		}
		
	}
}