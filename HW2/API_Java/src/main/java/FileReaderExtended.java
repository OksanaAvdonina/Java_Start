import java.io.*;

public class FileReaderExtended extends FileReader {
    public FileReaderExtended(String file) throws FileNotFoundException {
        super(file);
    }

    public int GetLength(Reader reader) {
        int count = 0;
        try {
            while (reader.read() != -1) {
                count++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}
