public class Book {
    private String title;
    private String author;
    private int yearofpublication;
    private int numberofcopies;

    public Book(String title, String author, int yearofpublication, int numberofcopies) {
        this.title = title;
        this.author = author;
        this.yearofpublication = yearofpublication;
        this.numberofcopies = numberofcopies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearofpublication() {
        return yearofpublication;
    }

    public void setYearofpublication(int yearofpublication) {
        this.yearofpublication = yearofpublication;
    }

    public int getNumberofcopies() {
        return numberofcopies;
    }

    public void setNumberofcopies(int numberofcopies) {
        this.numberofcopies = numberofcopies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearofpublication=" + yearofpublication +
                ", numberofcopies=" + numberofcopies +
                '}';
    }

    public void viewinfo(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year of publication: " + yearofpublication);
        System.out.println("Number of copies: " + numberofcopies);
    }
}
