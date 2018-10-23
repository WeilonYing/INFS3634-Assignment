package moe.whale.oopbuddy;

/**
 * Chapter
 * JSON wrapper class for defining a chapter's title and the path to the file containing the contents
 * of the chapter.
 */
public class Chapter {
    String title;
    String filename;

    /**
     * Get the title of the chapter
     * @return The title of the chapter
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Get the filename of the chapter
     * @return the filename of the chapter
     */
    public String getFilename() {
        return this.filename;
    }
}
