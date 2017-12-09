import javax.swing.JFrame;
import javax.swing.JList;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.util.Collections;

public class UserInterface {

	private JFrame frame;
	private JList list;
	private String[] data;
	private ArrayList<Song> songs;
	private Controls controls;
	private JPanel panel;
	private JScrollPane scrollPane;

	public UserInterface(ArrayList<Song> songList) {
		// initialize data members
		controls = new Controls();
		panel = new JPanel();
		scrollPane = new JScrollPane();
		this.songs = songList;
		data = new String[songList.size()];
		this.songs = songs;

		// setup data array and frame
		Collections.sort(songs, new SortByTitle());
		addToSongArrayFrom(songs);
		setupFrame();
	}

	private void addToSongArrayFrom(ArrayList<Song> songs) {
		int indexCount = 0;
		for(int i = 0; i < songs.size(); i++) {
			data[indexCount] = (songs.get(indexCount).getTitle() + " - " + songs.get(indexCount++).getArtist());
		}
	}

	public void setupFrame() {
		frame = new JFrame("Teddy's MP3 Player");
		list = new JList(data);
		panel.add(list);
		scrollPane.setViewportView(list);
		panel.add(scrollPane);
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		addEventListener();
	}

	private void addEventListener() {
		list.addMouseListener(new MouseAdapter() {
    		@Override
	    	public void mouseClicked(MouseEvent evt) {
	        	if (evt.getClickCount() == 2) {
		           	int index = list.getSelectedIndex();
		           	if(controls.getIsPlaying()) {
		           		controls.getPlayer().close();
		           	}
		           	controls.playSong(songs.get(index));
	        	}
	    	}
		});
	}
}