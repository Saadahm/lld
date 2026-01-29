package UnixFileSearch;

public class MinSizeStrategy implements SearchStrategy{
    @Override
    public boolean matches(String filePath, int size, String args){
        int requiredSize=Integer.parseInt(args);
        return size >= requiredSize;

    }
}
