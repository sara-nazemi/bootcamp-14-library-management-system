package org.library.model;

public class Book extends BaseModel<Integer> {

    private String title;
    private String author;
    private Integer publicationYear;

    private Book() {
    }

    private Book(BookBuilder bookBuilder) {
        super(bookBuilder.id);
        this.title = bookBuilder.title;
        this.author = bookBuilder.author;
        this.publicationYear = bookBuilder.publicationYear;
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

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }

    public static class BookBuilder {
        private Integer id;
        private String title;
        private String author;
        private Integer publicationYear;


        public BookBuilder setId(Integer id) {
            this.id = id;
            return this;
        }

        public BookBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder setPublicationYear(Integer publicationYear) {
            this.publicationYear = publicationYear;
            return this;

        }

        public Book build() {
            return new Book(this);
        }
    }
}
