/*
Class that implements comparator to compare two
song objects by their title. used to sort the song list
by title

Author: Teddy Juntunen
*/

import java.util.Comparator;

public class SortByTitle implements Comparator<Song> {

	// compare 2 song objects by their title
	public int compare(Song first, Song second) {
		return first.getTitle().compareTo(second.getTitle());
	}

}