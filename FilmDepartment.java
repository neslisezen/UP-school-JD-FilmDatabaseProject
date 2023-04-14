package section1Project;
import java.util.Arrays;

public class FilmDepartment {
		final static int FILM_NUMBER = 50;
		User user;
		
		Film [] filmList = new Film [FILM_NUMBER];
		
		{
		filmList[0] = new Film("The Pianist" ,"Roman Polanski",
			new String[]{"Adrien Brody","Thomas Kretschmann","Frank Finlay","Emilia Fox"}, 
			"A Polish Jewish musician struggles to survive the destruction of the Warsaw ghetto of World War II.",
			"2002");
		filmList[1] =new Film("The Prestige" ,"Christopher Nolan", 
			new String[]{"Christian Bale","Hugh Jackman","Scarlett Johansson","Michael Caine"}, 
			"After a tragic accident, two stage magicians in 1890s London engage in a battle to create the ultimate illusion while sacrificing everything they have to outwit each other.",
			"2006");
		filmList[2] =new Film("Inglourious Basterds" ,"Quentin Tarantino", 
			new String[] {"Brad Pitt","Diane Kruger","Eli Roth","Christoph Waltz"}, 
			"In Nazi-occupied France during World War II, a plan to assassinate Nazi leaders by a group of Jewish U.S. soldiers coincides with a theatre owner's vengeful plans for the same.",
			"2009");
		filmList[3] =new Film("Joker" ,"Todd Phillips", 
			new String[]{"Joaquin Phoenix","Robert De Niro","Zazie Beetz","Frances Conroy"}, 
			"The rise of Arthur Fleck, from aspiring stand-up comedian and pariah to Gotham's clown prince and leader of the revolution.",
			"2019");
		}
	


int addFilm (String nameOfTheMovie, String directorOfTheMovie, String[] actors, String filmInfo,
		String releaseDate) {
	int index=filmNumber();
	filmList[index] = new Film(nameOfTheMovie,directorOfTheMovie,actors, filmInfo, releaseDate);
	if(filmList[index]!=null) {
		System.out.println("Film is successfully added.\n");
		listFilm(filmList[index]);
		return 1;
	}
	else {
		System.out.println("ERROR!");
		return -1;
	}
}
void listFilm(Film film) {
	System.out.println("********************************"+
			"\nFilm Name: "+film.getNameOfTheMovie()+
			"\nFilm Info: "+ film.getFilmInfo()+
			"\nFilm Id: "+ film.getFilmId()+
			"\nDirector of the Film: "+ film.getDirectorOfTheMovie()+
			"\nFilm Release Date: "+ film.getReleaseDate()+
			"\nActors: ");
			Arrays.stream(film.getActors()).forEach(System.out::println);
			System.out.println("********************************");
			
}
void listFilms() {
	
	for(Film film : filmList) {
		if(film==null)
			break;
		System.out.println("********************************"+
				"\nFilm Name: "+film.getNameOfTheMovie()+
				"\nFilm Info: "+ film.getFilmInfo()+
				"\nFilm Id: "+ film.getFilmId()+
				"\nDirector of the Film: "+ film.getDirectorOfTheMovie()+
				"\nFilm Release Date: "+ film.getReleaseDate()+
				"\nActors: ");
		Arrays.stream(film.getActors()).forEach(System.out::println);
		System.out.println("********************************");
		;
	}}


	int searchFilm(String filmName) {
	int index;
	 
		for(int i=0; i < filmList.length;i++) {
		if(filmName.equalsIgnoreCase(filmList[i].getNameOfTheMovie())) {
			index = i;
			System.out.println("Movie found successfully.");
			listFilm(filmList[index]);	
			return index;
			}
		}
		System.out.println("Movie not found!");
	return -1;
	}

	int deleteFilm(String filmName) {
	int index = searchFilm(filmName);
	if(index != -1) {
		for(int i= index ; i< filmList.length ; i++) {
				filmList[i]=filmList[i+1];
			if(filmList[i]==null)
				break;
}
		System.out.println("Film "+filmName+" is succesfully deleted.");
		return 1;}
	else {
		System.out.println("Film "+filmName+" not found.");
		System.out.println("Make sure that you write the name of the film correctly.\n"
				+ "If you need help search the film first");
		return -1;
}
	
}
	int filmNumber() {
		int number=0;
		for(Film film: filmList) {
			if(film==null)
				break;
			number++;
		}
		return number;
	}
	
}

