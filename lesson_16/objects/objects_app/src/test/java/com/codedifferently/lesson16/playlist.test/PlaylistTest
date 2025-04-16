package com.codedifferently.lesson16.justinsplaylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.assertThat;
import com.codedifferently.lesson16.JustinsPlaylist.Playlist;

public class playlistTest {

    private playlist playlist;

    @BeforeEach
    public void setUp() {
        playlist = new playlist("Chill Vibes", "Lo-Fi", 120);
    }

    @Test
    public void testGetDetailsReturnsCorrectInfo() {
        String details = playlist.getDetails();
        assertThat(details).isEqualTo("Name: Chill Vibes, Genre: Lo-Fi, Duration: 120");
    }

    @Test
    public void testAddSongSuccessfully() {
        playlist.addSong("Evening Walk");
        assertThatCode(() -> playlist.playAll()).doesNotThrowAnyException();
    }

    @Test
    public void testAddSongThrowsExceptionOnEmptyInput() {
        assertThatThrownBy(() -> Playlist.addSong("   "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Cannot add a null or empty song.");
    }

    @Test
    public void testPlayAllThrowsExceptionWhenNoSongs() {
        assertThatThrownBy(() -> playlist.playAll())
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("No songs in the playlist to play.");
    }

    @Test
    public void testSetAndGetName() {
        playlist.setName("Late Night Beats");
        assertThat(playlist.getName()).isEqualTo("Late Night Beats");
    }
}