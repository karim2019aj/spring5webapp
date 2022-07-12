package guru.springframework.spring5webapp.BootStrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author auth1 = new Author("abdelkarim", "ajekal");
        Author auth2 = new Author("Tonny", "Robens");
        Book ab = new Book("Learn to control emotions","IE123456789");
        ab.getAuthors().add(auth1);
        auth1.getBooks().add(ab);
        Publisher pub = new Publisher();
        pub.setName("SGB");
        pub.setCity("Gorgia");
        pub.setState("CA");

        ab.setPublisher(pub);
        pub.getBooks().add(ab);
        publisherRepository.save(pub);


        authorRepository.save(auth1);
        authorRepository.save(auth2);
        bookRepository.save(ab);


        System.out.println("Started in Bootstrap");
        System.out.println("number of books : "+ bookRepository.count());
        System.out.println("number of publishers : "+ publisherRepository.count());
        //System.out.println("Publisher number of books : "+ pub.getBooks().size());


    }
}
