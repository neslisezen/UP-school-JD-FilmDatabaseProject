package section1Project;
import java.util.*;

public class MainMenu {
	Scanner input = new Scanner(System.in);
	static FilmDepartment filmManager = new FilmDepartment();
	static UserAdministration userManager = new UserAdministration();
	public static void main(String[] args) {
	int choice=0;
	String welcomeMessage = """
	*****************************************
	🦄Welcome to the Nesli's Film Database🦄 
	*****************************************""";
	System.out.println(welcomeMessage);
	
	do {
		if (choice !=1)
		choice = generalMenu(filmManager,userManager);
		
		if (choice ==1) 
			choice = userMenu(filmManager,userManager);
	}
	while (choice!=5 && choice!=9);
	
	String goodbyeMessage = """
			**********************************************
			🦄Nesli's Film Database wish you a good day🦄 
					🌈See you later🌈
			**********************************************""";
	System.out.println(goodbyeMessage);
	}
	
	public static int generalMenu (FilmDepartment filmManager,UserAdministration userManager) {
		
		Scanner input = new Scanner(System.in);
		String username,password,email;
		int choice;
		String menu="""
				Menu🌈
				1: User login
				2: User register
				3: List Users
				4: Help
				5: Exit
				Your choice: """;
		here: do {
			
			System.out.print(menu);
			choice = input.nextInt();
			
			switch (choice) {
			case 1 -> {
				
				System.out.print("Please write your username to login: ");
				username = input.next();
				System.out.print("Please write your password: ");
				password = input.next();
				int result = userManager.userRegister(username, password);			
				if(result < 0) {
					System.out.println("Try again!");
				continue here;
				}
				else {
					filmManager.user = userManager.userList[result];
					return 1;
				}
					
				
			}
			case 2 -> {
				System.out.print("Please write your username to register: ");
				username = input.next();
				System.out.print("Please write your password: ");
				password = input.next();
				System.out.print("Please write your E-mail: ");
				email = input.next();
				int result = userManager.addUser(username, password,email);	
				if(result!= -1) {
					filmManager.user = userManager.userList[result];
					return 1;
				}
				else
					continue here;
			}
			case 3->{
				userManager.listUsers();
			}
			case 4 ->{
				System.out.println("***************HELP*************");
				System.out.println("User login is necessary to search Film and add Film."
						+ "\nPlease login in your account or register yourself.\n"
						+"Username is the combination of your first and last name. For example: neslisezen"
						+"\nYou can also search for usernames. Please choose \"List Users\". ");
				System.out.println("********************************");
				continue here;
			}
			case 5 ->{
				return 5;
			}
		}}
		
		while(true);
		
		
	}
	
	public static int userMenu(FilmDepartment filmManager,UserAdministration userManager) {
		Scanner input = new Scanner(System.in);
		String name;
		int choice;
		String userMenu ="""
				User Menu💎
				1: Search Film 
				2: List All Films
				3: Add Film
				4: Remove Film
				5: User Details
				6: Search User
				7: Log out
				8: Delete User
				9: Exit
				Your Choice: """;
				
		here: do {
			
			System.out.print(userMenu);
			choice = input.nextInt();
			
			switch (choice) {
			case 1 -> {
				
				System.out.print("Please write the name of the movie you want to search: ");
				name = input.next();
				int result = filmManager.searchFilm(name);
				if(result==-1) {
					continue here;
				}
			}
			case 2 -> {
				filmManager.listFilms();
			}
			case 3->{
				String actors[] = new String[4];
				System.out.print("Please write the name of the movie you want to add: ");
				name = input.next();
				System.out.print("Please write the director of the movie you want to add: ");
				String director = input.next();
				System.out.print("Please write the 4 actors of this movie. First one: ");
				String first = input.next();
				actors[0] =first;
				System.out.print("Second actor you want to write: ");
				String second=input.next();
				actors[1] = second;
				System.out.print("Third actor you want to write: ");
				String third=input.next();
				actors[2] = second;
				System.out.print("Fourth actor you want to write: ");
				String fourth=input.next();
				actors[3] = second;
				System.out.print("Please write the information about the movie: ");
				String info = input.next();
				System.out.print("Please write the release date of the movie: ");
				String date = input.next();
				int result = filmManager.addFilm(name, director,actors, info, date);
				if(result==-1)
					continue here;
			}
			case 4 ->{
				System.out.print("Please write the name of the movie you want to delete: ");
				name = input.next();
				int result = filmManager.deleteFilm(name);
				if(result==-1)
					continue here;
			}
			case 5 ->{
				userManager.listUser(filmManager.user);
			}
			case 6 ->{
				System.out.print("Please write the name of the user you want to search: ");
				name = input.next();
				int result = userManager.searchUser(name);
				if(result==-1)
					continue here;
				}
			case 7 ->{
				System.out.println("Log out ist successful!");
				System.out.println("See you next time "+ filmManager.user.getUserName());
				return 0;
			}
			case 8 ->{ //delete user
				System.out.print("Do you really want to delete your account? \nWrite 1 for YES, 2 for NO : ");
				choice= input.nextInt();
				if(choice==1) {
					choice = userManager.deleteUser(filmManager.user.getUserName());
						if(choice==1) {
							filmManager.user = null;
						}
					return -1;
				}
				else 
					continue here;
			}
			case 9 ->{
				return 9;
			}
		}}
		
		while(true);
			
	}
	
	}
	
