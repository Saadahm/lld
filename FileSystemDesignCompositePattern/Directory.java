package FileSystemDesignCompositePattern;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{
    private String name;
    private List<FileSystem>fileSystemList;
    public Directory(String name){
        this.name=name;
        this.fileSystemList=new ArrayList<>();
    }
    public void addFile(FileSystem fileSystem)
    {
    fileSystemList.add(fileSystem);
    }
    public void ls(String indent)
    {
        System.out.println(indent + "📁 " + name + "Directory"+"/");
        for(FileSystem fileSystem:fileSystemList){
            fileSystem.ls(indent +" ");
        }
    }
    public void ls(){
        ls("");
    }
}
