package FileSystemDesignCompositePattern;

public class Main {
    public static void main(String[] args) {
       Directory movieDirectory= new Directory("Movies");
       File file1=new File("Inceptipn");
       movieDirectory.addFile(file1);
        movieDirectory.addFile(file1);
       Directory comedyDirectory = new Directory("Comedy");
       movieDirectory.addFile(comedyDirectory);
        File file2=new File("ComedyMovie1");
        comedyDirectory.addFile(file2);
        movieDirectory.ls();

    }
}
