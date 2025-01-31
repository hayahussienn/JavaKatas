package katas.exercises;

import katas.exercises.movieRental.Rental;
import katas.exercises.movieRental.Movie;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieRentalCustomerTest {

    @Test
    public void testStatementTextFormat() {
        MovieRentalCustomer customer = new MovieRentalCustomer("Bob");
        customer.addRental(new Rental(new Movie("Jaws", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Golden Eye", Movie.REGULAR), 3));
        customer.addRental(new Rental(new Movie("Short New", Movie.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie("Long New", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Bambi", Movie.CHILDRENS), 3));
        customer.addRental(new Rental(new Movie("Toy Story", Movie.CHILDRENS), 4));

        String expected = "" +
                "Rental Record for Bob\n" +
                "\tJaws\t2.0\n" +
                "\tGolden Eye\t3.5\n" +
                "\tShort New\t3.0\n" +
                "\tLong New\t6.0\n" +
                "\tBambi\t1.5\n" +
                "\tToy Story\t3.0\n" +
                "Amount owed is 19.0\n" +
                "You earned 7 frequent renter points";

        assertEquals(expected, customer.statement());
    }
    @Test
    public void testStatementHtmlFormat() {
        MovieRentalCustomer customer = new MovieRentalCustomer("Bob");
        customer.addRental(new Rental(new Movie("Jaws", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Golden Eye", Movie.REGULAR), 3));
        customer.addRental(new Rental(new Movie("Short New", Movie.NEW_RELEASE), 1));

        String expectedHtml = "" +
                "<h1>Rental Record for <em>Bob</em></h1>" +
                "<table>" +
                "<tr><td>Jaws</td><td>2.0</td></tr>" +
                "<tr><td>Golden Eye</td><td>3.5</td></tr>" +
                "<tr><td>Short New</td><td>3.0</td></tr>" +
                "</table>" +
                "<p>Amount owed is <em>8.5</em></p>" +
                "<p>You earned <em>3</em> frequent renter points</p>";

        assertEquals(expectedHtml, customer.htmlStatement() );
    }

    @Test
    public void testChildrenMovie() {
        MovieRentalCustomer customer = new MovieRentalCustomer("Martin");

        // Base price for children's movie
        Movie movie1 = new Movie("Lion King", Movie.CHILDRENS);
        customer.addRental(new Rental(movie1, 3)); // 3 days
        String statement1 = customer.htmlStatement() ;
        assertTrue(statement1.contains(">1.5<"));

        // Extra price for children's movie
        Movie movie2 = new Movie("Frozen", Movie.CHILDRENS);
        customer.addRental(new Rental(movie2, 5)); // 5 days
        String statement2 = customer.htmlStatement() ;
        assertTrue(statement2.contains(">4.5<"));
    }

    @Test
    public void testRegularMovie() {
        MovieRentalCustomer customer = new MovieRentalCustomer("John");
        Movie movie = new Movie("Matrix", Movie.REGULAR);

        // Base price test (2 days)
        customer.addRental(new Rental(movie, 2));
        assertTrue(customer.htmlStatement().contains(">2.0<"));

        // Extended period test (4 days: base price + 2 days extra)
        customer = new MovieRentalCustomer("John");
        customer.addRental(new Rental(movie, 4));
        assertTrue(customer.htmlStatement().contains(">5.0<")); // 2 + (2 * 1.5)
    }

    @Test
    public void testNewReleaseMovie() {
        MovieRentalCustomer customer = new MovieRentalCustomer("John");
        Movie movie = new Movie("Avengers", Movie.NEW_RELEASE);

        // Single day test
        customer.addRental(new Rental(movie, 1));
        assertTrue(customer.htmlStatement().contains(">3.0<")); // 3 * 1

        // Multiple days test
        customer = new MovieRentalCustomer("John");
        customer.addRental(new Rental(movie, 3));
        assertTrue(customer.htmlStatement().contains(">9.0<")); // 3 * 3
    }

    @Test
    public void testMixedMovieTypes() {
        MovieRentalCustomer customer = new MovieRentalCustomer("Martin");
        Movie regular = new Movie("Matrix", Movie.REGULAR);
        Movie newRelease = new Movie("Dune", Movie.NEW_RELEASE);
        Movie children = new Movie("Toy Story", Movie.CHILDRENS);

        customer.addRental(new Rental(regular, 4));
        customer.addRental(new Rental(newRelease, 3));
        customer.addRental(new Rental(children, 5));

        String statement = customer.htmlStatement();
        assertTrue(statement.contains("Amount owed is <em>18.5</em>"));
        assertTrue(statement.contains("earned <em>4</em> frequent"));
    }

    @Test
    public void testEmptyRental() {
        MovieRentalCustomer customer = new MovieRentalCustomer("Martin");

        String statement = customer.htmlStatement();
        assertTrue(statement.contains("<table></table>"));
        assertTrue(statement.contains("Amount owed is <em>0.0</em>"));
        assertTrue(statement.contains("earned <em>0</em> frequent"));
    }

    @Test
    public void testDuplicateMovieRentals() {
        MovieRentalCustomer customer = new MovieRentalCustomer("John");
        Movie movie = new Movie("Matrix", Movie.REGULAR);

        customer.addRental(new Rental(movie, 2));
        customer.addRental(new Rental(movie, 3));

        String statement = customer.htmlStatement() ;
        assertTrue(statement.contains("Amount owed is <em>5.5</em>")); // 2.0 + 3.5
        assertTrue(statement.contains("earned <em>2</em> frequent"));
    }

    @Test
    public void testSpecialCharsInNameAndTitle() {
        MovieRentalCustomer customer = new MovieRentalCustomer("O'Connor & Sons");
        Movie movie = new Movie("Star Wars: The Empire Strikes Back & Return of the Jedi", Movie.REGULAR);
        customer.addRental(new Rental(movie, 3));  // 3 days

        String statement = customer.htmlStatement();
        assertTrue(statement.contains("<em>O'Connor & Sons</em>"));
        assertTrue(statement.contains(">Star Wars: The Empire Strikes Back & Return of the Jedi<"));
    }

    @Test
    public void testMultipleNewReleasePoints() {
        MovieRentalCustomer customer = new MovieRentalCustomer("Martin");
        Movie movie1 = new Movie("New Movie 1", Movie.NEW_RELEASE);
        Movie movie2 = new Movie("New Movie 2", Movie.NEW_RELEASE);

        customer.addRental(new Rental(movie1, 2));
        customer.addRental(new Rental(movie2, 1));

        String statement = customer.htmlStatement();
        assertTrue(statement.contains("earned <em>3</em> frequent"));
    }


    @Test
    public void testZeroDayRental() {
        MovieRentalCustomer customer = new MovieRentalCustomer("John");
        Movie movie = new Movie("Test Movie", Movie.REGULAR);
        customer.addRental(new Rental(movie, 0));

        String statement = customer.htmlStatement() ;
        assertTrue(statement.contains(">2.0<")); // Should still charge base price
        assertTrue(statement.contains("earned <em>1</em> frequent")); // Should still get base points
    }

    @Test
    public void testLongRentalPeriod() {
        MovieRentalCustomer customer = new MovieRentalCustomer("John");

        // Regular movie with long period
        Movie regularMovie = new Movie("Matrix", Movie.REGULAR);
        customer.addRental(new Rental(regularMovie, 30));

        // Children's movie with long period
        Movie childrenMovie = new Movie("Frozen", Movie.CHILDRENS);
        customer.addRental(new Rental(childrenMovie, 30));

        String statement = customer.htmlStatement();
        double expectedRegularAmount = 2 + (28 * 1.5); // Base + extra days
        double expectedChildrenAmount = 1.5 + (27 * 1.5); // Base + extra days
        double totalExpected = expectedRegularAmount + expectedChildrenAmount;

        assertTrue(statement.contains("Amount owed is <em>" + totalExpected + "</em>"));
        assertTrue(statement.contains("earned <em>2</em> frequent"));
    }


}