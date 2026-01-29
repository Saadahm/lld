package UnixFileSearch;

public interface SearchStrategy {
    boolean matches(String filePath, int size, String args);
}
