import java.util.*;

class Song {
    String id;
    String title;
    String artist;

    public Song(String id, String title, String artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Song song = (Song) obj;
        return id.equals(song.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "'" + title + "' by " + artist;
    }
}

public class Q2_MediaPlayerQueue {
    // LinkedList managing the playback queue efficiently for insertions at both ends
    private LinkedList<Song> playlist = new LinkedList<>();

    // Standard add to back of playlist
    public void addSong(Song song) {
        playlist.add(song);
    }

    // Priority queueing: Add song directly to the front
    public void addSongToFront(Song song) {
        playlist.addFirst(song);
    }

    // Remove duplicate entries efficiently preserving order using LinkedHashSet
    public void removeDuplicates() {
        Set<Song> uniqueSongs = new LinkedHashSet<>(playlist);
        playlist.clear();
        playlist.addAll(uniqueSongs);
        System.out.println("Duplicate entries removed from playlist.");
    }

    // Forward traversal using ListIterator without index-based performance bottlenecks
    public void traverseForward() {
        ListIterator<Song> iterator = playlist.listIterator();
        System.out.println("--- Playing Forward ---");
        while (iterator.hasNext()) {
            System.out.println("Playing: " + iterator.next());
        }
    }

    // Backward traversal using ListIterator
    public void traverseBackward() {
        ListIterator<Song> iterator = playlist.listIterator(playlist.size());
        System.out.println("--- Playing Backward ---");
        while (iterator.hasPrevious()) {
            System.out.println("Playing: " + iterator.previous());
        }
    }

    // Example Test Main
    public static void main(String[] args) {
        MediaPlayerQueue player = new MediaPlayerQueue();
        
        Song s1 = new Song("S01", "Blinding Lights", "The Weeknd");
        Song s2 = new Song("S02", "Starboy", "The Weeknd");
        Song s3 = new Song("S03", "Shape of You", "Ed Sheeran");

        player.addSong(s1);
        player.addSong(s2);
        player.addSong(s1); // Duplicate entry
        player.addSongToFront(s3); // Priority queueing (moved to front)

        player.traverseForward();
        
        System.out.println();
        player.removeDuplicates();
        
        System.out.println();
        player.traverseBackward();
    }
}