package lab5.task4;

import java.util.ArrayList;

abstract class Album {
    private final ArrayList<Song> songs = new ArrayList<>();

    public Album() {}

    public Album(ArrayList<Song> songs) {
        this.songs.addAll(songs);
    }

    abstract public void addSong(Song song);

    public void removeSong(Song song) {
        int ind = 0;
        for (Song albumSong: songs) {
            if (albumSong.equals(song)) {
                songs.remove(ind);
                return;
            }
            ind++;
        }
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    @Override
    public String toString() {
        return "Album{" +
                "songs=" + songs +
                '}';
    }
}
