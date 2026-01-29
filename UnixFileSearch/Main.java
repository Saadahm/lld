package UnixFileSearch;

public class Main {
    public static void main(String[] args) {
        FileSearch s = new FileSearch();

        s.addFile("/data/pics/photoA.jpg", 4);
        s.addFile("/data/pics/movie.mp4", 12);
        s.addFile("/work/docs/readme.md", 1);
        s.addFile("/work/docs/report.xml", 7);

        // overwrite
        s.addFile("/data/pics/photoA.jpg", 9);

        System.out.println(s.search(1, "/data", "8"));
        // ["/data/pics/movie.mp4", "/data/pics/photoA.jpg"]

        System.out.println(s.search(2, "/work", ".xml"));
        // ["/work/docs/report.xml"]
    }
}
