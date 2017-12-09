/*
Song object which stores title, artist, and
filepath information with getter methods. Contructor
must not have null for any paramater.

Author: Teddy Juntunen
*/

public class Song {

	// Data members
	private String title;
	private String artist;
	private String filePath;

	// constructor. no chance for parameters to be null
	public Song(String title, String artist, String filePath) {
		this.title = title;
		this.artist = artist;
		this.filePath = filePath;
	}

	// Getters
	public String getTitle() {
		return this.title;
	}

	public String getArtist() {
		return this.artist;
	}

	public String getFilePath() {
		return this.filePath;
	}

	// string representation of Song object
	public String toString() {
		return this.title + " - " + this.artist;
	}

}