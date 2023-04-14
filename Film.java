package section1Project;

import java.util.Random;

public class Film{
	private final String nameOfTheMovie;
	private final String filmId;
	private final String directorOfTheMovie;
	private String [] actors = new String[4];
	private final String filmInfo;
	private final String releaseDate;
	private static Random random = new Random();

	public Film(String nameOfTheMovie, String directorOfTheMovie, String[] actors, String filmInfo,
			String releaseDate) {
		super();
		this.nameOfTheMovie = nameOfTheMovie;
		this.filmId = String.valueOf(random.nextInt(10000));
		this.directorOfTheMovie = directorOfTheMovie;
		
		for (int i = 0; i < 4; i++) {
			this.actors[i] = actors[i];
		}
		this.filmInfo = filmInfo;
		this.releaseDate = releaseDate;
	}
	public String getNameOfTheMovie() {
		return nameOfTheMovie;
	}
	
	public String getFilmId() {
		return filmId;
	}

	public String getDirectorOfTheMovie() {
		return directorOfTheMovie;
	}

	public String[] getActors() {
		return actors;
	}
	
	public String getFilmInfo() {
		return filmInfo;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	

}
