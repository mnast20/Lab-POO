package lab5.task4;

public class BadAlbum extends Album {
    public BadAlbum() {}

    @Override
    public void addSong(Song song) {
        if (song.getName().length() == 3 && checkPalindrome(song.getId())) {
            this.getSongs().add(song);
        }

    }

    public boolean checkPalindrome(int n) {
        int inv = 0;
        int nr = n;
        while (nr > 0) {
            inv = inv * 10 + nr % 10;
            nr = nr / 10;
        }
        return n == inv;
    }
}
