/**
 * Created by baharsheikhi on 6/6/16.
 * To represent a music editor
 * Assumptions:
 * Once there is already a note at a given note and beat position,
 * there cannot be another one added.
 */

public interface MusicEditorModel<K> {
    /**
     * Gets the representation of the notes in this music.
     * A column of numbers represents the beats.
     * A sequence of columns represents all the notes played in this music.
     * The first line prints out the names of the pitches,
     * more-or-less centered within the five-character column.
     * Each note-head is rendered as an "  X  ", and each note-sustain is
     * rendered as "  |  ". When a note is not played, five spaces are rendered
     * (as "     ")
      * @return a string representation of all the beats and the notes in them
     */
    String getMusicState();

    /**
     * Adds the given Note to the music at the given beat.
     * @param beat the beat where the note should be added
     * @param note the note to be added at the beat
     * Throws an IllegalArgumentException if the beat number is less than 0, or greater than the
     *  number of notes minus one.
     * Throws an IllegalArgumentException if the note is invalid--ie. not played in the piece.
     * Throws an IllegalArgumentException if there is already a note there.
     */
     void addNote(int beat, K note);

    /**
     * Removes the given note from the music at the given beat.
     * @param beat the beat where the note should be removed from
     * @param note the note that should be removed
     *  Throws an IllegalArgumentException if the beat number is less than 0, or greater than the
     *  number of notes minus one.
     *  Throws an IllegalArgumentException if the note is invalid--ie. not played in the piece.
     *  Throws an IllegalArgumentException if there is no note there.
     */
     void removeNote(int beat, K note);

    /**
     * Changes the given note at the given beat to a new note.
      * @param beat the beat where the notes are
     * @param oldNote the beat to be removed
     * @param newNote the beat to replace it with
     * Throws an IllegalArgumentException if the beat number is less than 0, or greater than the
     *  number of notes minus one.
     *  Throws an IllegalArgumentException if either note is invalid--ie. not played in the piece.
     *  Throws an IllegalArgumentException if the old note is not there.
     *  Throws an IllegalArgumentException if there is already a note at the space of the new note.
     *
     */
    void changeNote(int beat, K oldNote, K newNote);

    /**
     * Takes the given musicEditorModel and adds it to the end of this one.
     * @param other the other musicEditorModel to play after this one.
     *  Throws an IllegalArgumentException if the given music is null.
     *  Throws an IllegalArgumentException if the given music has no notes.
     */
    void musicConcat(MusicEditorModel<K> other);

    /**
     * Takes a piece of music and plays it simultaneously to this piece.
      * @param other the music to be played simultaneously.
     *  Throws an IllegalArgumentException if the given music is null.
     *  Throws an IllegalArgumentException if the given music has no notes.
     */
    void mixMusic(MusicEditorModel<K> other);
}