import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {

		if(args.length != 1) {
			System.out.println("Usage: java Driver <absolute filepath>");
			System.exit(0);
		}

		SongList songs = new SongList(args[0]);
		ArrayList<Song> songArrayList = songs.getSongList();
		UserInterface gui = new UserInterface(songArrayList);

	}

}