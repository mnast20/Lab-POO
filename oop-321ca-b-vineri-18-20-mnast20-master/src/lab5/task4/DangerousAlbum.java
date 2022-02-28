package lab5.task4;

public class DangerousAlbum extends Album{
    public DangerousAlbum() {}

    @Override
    public void addSong(Song song) {
        int id = song.getId();
        for (int i = 2; i <= id / 2; i++) {
            if (id % i == 0) {
                return;
            }
        }
        if (id != 1 && id != 0) {
            this.getSongs().add(song);
        }
    }
}
