package lab5.task4;

public class ThrillerAlbum extends Album{
    public ThrillerAlbum() {}

    @Override
    public void addSong(Song song) {
        if (song.getId() % 2 == 0 && song.getComposer().compareTo("Michael Jackson") == 0) {
            this.getSongs().add(song);
        }

    }
}
