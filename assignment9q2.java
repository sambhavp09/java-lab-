class Book {
    final String isbn = "978-81-12345-67-8";
    String title = "Java Programming";
    String author = "James Gosling";
    double price = 599;

    void display() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
    }
}

public class assignment9q2 {
    public static void main(String[] args) {
        Book b = new Book();
        b.display();
    }
}