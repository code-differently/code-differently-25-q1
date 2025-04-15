package com.codedifferently.lesson16.playlist.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlaylistTest {

    private playlist playlist;

    @BeforeEach
    public void setUp() {
        playlist = new playlist();
    }

    @Test
    public void testAddSongDoesNotThrow() {
        assertThatCode(() -> playlist.addSong("My Favorite Song"))
            .doesNotThrowAnyException();
    }

    @Test
    public void testPlayAllThrowsWhenNoSongs() {
        assertThatThrownBy(() -> playlist.playAll())
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("No songs in the playlist to play.");
    }

    @Test
    public void testPlayAllPlaysSongsWhenNotEmpty() {
        playlist.addSong("Song 1");
        playlist.addSong("Song 2");

        // We're not capturing console output here — just making sure no exceptions are thrown
        assertThatCode(() -> playlist.playAll())
            .doesNotThrowAnyException();
    }
}

}
