package katas.exercises;

import katas.exercises.movieRental.Movie;
import katas.exercises.movieRental.Rental;

import java.util.ArrayList;
import java.util.List;

/**
 * This source code follows Martin Fowler's book "Refactoring, Improving the Design of Existing Code".
 * When you find you have to add a feature to a program, and the program's code is not
 * structured in a convenient way to add the feature, first refactor the program to make it
 * easy to add the feature, then add the feature.
 *
 * Whenever you do refactoring, you MUST build a solid set of tests for that section of code.
 *
 * The `statement` method prints out a simple text output of a rental statement:
 *
 *      Rental Record for martin
 *        Ran 3.5
 *        Trois Couleurs: Bleu 2.0
 *      Amount owed is 5.5
 *      You earned 2 frequent renter points
 *
 *
 * We want to write an HTML version of the statement method :
 *
 *      <h1>Rental Record for <em>martin</em></h1>
 *      <table>
 *        <tr><td>Ran</td><td>3.5</td></tr>
 *        <tr><td>Trois Couleurs: Bleu</td><td>2.0</td></tr>
 *      </table>
 *      <p>Amount owed is <em>5.5</em></p>
 *      <p>You earned <em>2</em> frequent renter points</p>
 *
 * Carfully think how to refactor this code, and write the corresponding tests under MovieRentalCustomerTest.
 */

public class MovieRentalCustomer {
    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public MovieRentalCustomer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    // Extract common calculations into their own methods
    private double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += calculateAmount(rental);
        }
        return totalAmount;
    }

    private int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                    && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
        }
        return frequentRenterPoints;
    }

    // Original statement method
    public String statement() {
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        // Show figures for each rental
        for (Rental rental : rentals) {
            result.append("\t")
                    .append(rental.getMovie().getTitle())
                    .append("\t")
                    .append(calculateAmount(rental))
                    .append("\n");
        }

        // Add footer lines
        result.append("Amount owed is ")
                .append(getTotalAmount())
                .append("\n");
        result.append("You earned ")
                .append(getFrequentRenterPoints())
                .append(" frequent renter points");

        return result.toString();
    }

    // HTML statement using same calculation methods
    public String htmlStatement() {
        StringBuilder result = new StringBuilder();

        // Header
        result.append("<h1>Rental Record for <em>")
                .append(getName())
                .append("</em></h1>");
        result.append("<table>");

        // Show figures for each rental
        for (Rental rental : rentals) {
            result.append("<tr><td>")
                    .append(rental.getMovie().getTitle())
                    .append("</td><td>")
                    .append(calculateAmount(rental))
                    .append("</td></tr>");
        }

        // Footer
        result.append("</table>");
        result.append("<p>Amount owed is <em>")
                .append(getTotalAmount())
                .append("</em></p>");
        result.append("<p>You earned <em>")
                .append(getFrequentRenterPoints())
                .append("</em> frequent renter points</p>");

        return result.toString();
    }

    private double calculateAmount(Rental rental) {
        double thisAmount = 0;

        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (rental.getDaysRented() > 2)
                    thisAmount += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (rental.getDaysRented() > 3)
                    thisAmount += (rental.getDaysRented() - 3) * 1.5;
                break;
        }

        return thisAmount;
    }
}