package pl.coderslab.homeworks.oop.first;

public class Book {
    private int id;
    private String title;
    private boolean available = true;
    private Author author;
    private Author[] additionalAuthors;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }
    public Book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    public Book(int id, String title, Author author, Author[] additionalAuthors) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.additionalAuthors = additionalAuthors;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public boolean getAvailable(){
        return this.available;
    }
    public void setAvailable(boolean available){
        this.available = available;
    }
    public Author getAuthor(){
        return author;
    }
    public void setAuthor(Author author){
        this.author = author;
    }
    public Author[] getAdditionalAuthors(){
        return additionalAuthors;
    }
    public void setAdditionalAuthors(Author[] additionalAuthors){
        this.additionalAuthors = additionalAuthors;
    }

}
