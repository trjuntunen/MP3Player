import javazoom.jl.decoder.JavaLayerException;
import java.io.FileNotFoundException;
import javazoom.jl.player.Player;
import java.io.FileInputStream;

public class Controls {

	private Player player;
	private boolean isPlaying;

	public void playSong(Song song) {
		try {
			player = new Player(new FileInputStream(song.getFilePath()));
		} catch(JavaLayerException | FileNotFoundException playerException) {
			System.out.println(playerException.getMessage());
		}
		Thread thread = new Thread() {
			public void run() {
				try {
					isPlaying = true;
					player.play();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
	}

	public boolean getIsPlaying() {
		return this.isPlaying;
	}

	public Player getPlayer() {
		return this.player;
	}

}