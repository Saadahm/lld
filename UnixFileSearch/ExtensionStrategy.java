package UnixFileSearch;

public class ExtensionStrategy implements SearchStrategy{
    @Override
    public boolean matches(String filePath, int size, String args){
       String temp=filePath;
       StringBuilder s= new StringBuilder();
       int id=temp.length()-1;
       while(temp.length()>0 && temp.charAt(id)!='.'){
           s.append(temp.charAt(id));
           id--;

       }
        s.append('.');
       s.reverse();
       return s.toString().equals(args);
    }
}
