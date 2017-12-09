/*
Class that keeps track of an ArrayList of Song
objects. Recursively looks through folders
and finds all mp3 files and adds them to songList.

Author: Teddy Juntunen
*/

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

public class SongList {

	private ArrayList<Song> songList;

	public SongList(String directory) {
		this.songList = new ArrayList<Song>();
		buildFileList(directory);
	}

	// initializes mp3Files ArrayList and calls method to add all java files
	public void buildFileList(String directory) {
		File directoryFile = new File(directory);
		buildFileList(directoryFile);
	}

	// helper method to recusively find all java files
	public void buildFileList(File file) {
		File[] allFilesInDirectory = file.listFiles();
		if(file.isFile()) {
			int lastIndex = file.getName().lastIndexOf('.');
			String fileType = file.getName().substring(lastIndex + 1);
			if(fileType.equals("mp3")) {
				readData(file);
			}
		} else {
			for(File f: allFilesInDirectory) {
				try {
					buildFileList(f);
				} catch(NullPointerException npe) {
					
				}
			}
		}
	}

	// checks if metadata is not blank, and adds to songList
	private void addSongToList(String title, String artist, String filePath) {
		if(title != "" && artist != "" && filePath != "") {
			songList.add(new Song(title, artist, filePath));
		}
	}

	// reads in the song metatdata and passes it on to addSongToList() method
	private void readData(File file) {
		try {
			AudioFile f = AudioFileIO.read(new File(file.getAbsolutePath()));
			Tag tag;
			tag = f.getTag();
			String title = tag.getFirst(FieldKey.TITLE);
			String artist = tag.getFirst(FieldKey.ARTIST);
			addSongToList(title, artist, file.getAbsolutePath());
		} catch(CannotReadException | IOException | TagException | ReadOnlyFileException | InvalidAudioFrameException exc) {
			return;
		}
	}

	public ArrayList<Song> getSongList() {
		return this.songList;
	}
}