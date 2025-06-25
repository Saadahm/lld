package FileSystemDesign;

public class File implements FileSystem {
    private String name;
    public File(String name)
    {
        this.name=name;
    }
    public void ls(String indent){
        System.out.println(indent + "📄 " + "File"+name);
    }
    public void ls(){
        ls("");
    }
}
