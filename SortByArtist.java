/*
Class that implements comparator to compare two
song objects by their artist. used to sort the song list
by artist

Author: Teddy Juntunen
*/

import java.util.Comparator;

public class SortByArtist implements Comparator<Song> {

	// // compare 2 song objects by their artist
	public int compare(Song first, Song second) {
		return first.getArtist().compareTo(second.getArtist());
	}

}