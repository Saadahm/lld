package UnixFileSearch;

import java.util.*;

public class FileSearch {
    Map<String, Integer>files=new HashMap<>();
    public FileSearch()
    {

    }
    public void addFile(String path, int size)
    {
        files.put(path,size);
    }

    public List<String>search(int criteria, String root, String args)
    {
        SearchStrategy searchStrategy;
        if(criteria==1)
            searchStrategy=new MinSizeStrategy();
        else searchStrategy=new ExtensionStrategy();
        List<String>result= new ArrayList<>();
        for(String file: files.keySet())
        {
            boolean isUnder= startsWith(root, file);
            if(!isUnder)
                continue;
          if(searchStrategy.matches(file, files.get(file), args))
              result.add(file);
        }
        Collections.sort(result);

        return result;

    }

    private boolean startsWith(String root, String under)
    {
        int id=0;
        while(id<root.length()){
            if(under.charAt(id)!=root.charAt(id))
                return false;
            id++;
        }
        return true;
    }
}
