package LibraryCatalogue;

import java.util.HashMap;
import java.util.Map;

public class LibraryCatalogue {
    Map<String, Book> bookCollection = new HashMap<String, Book>();
    int currentDay = 0;
    int lengthOfCheckOutPeriod = 7;
    double initialLateFee = 5.00;
    double feePerDayLate = 10.00;

    public LibraryCatalogue (Map<String, Book> collection){
        this.bookCollection = collection;
    }

    public LibraryCatalogue(Map<String,Book> collection, int lengthOfCheckOutPeriod,
                            double initialLateFee, double feePerDayLate){
        this.bookCollection = collection;
        this.lengthOfCheckOutPeriod = lengthOfCheckOutPeriod;
        this.initialLateFee = initialLateFee;
        this.feePerDayLate = feePerDayLate;
    }

    public Map<String, Book> getBookCollection() {
        return this.bookCollection;
    }
    public Book getBook(String bookTitle){
        return getBookCollection().get(bookTitle);
    }
    public int getCurrentDay() {
        return this.currentDay;
    }
    public int getLengthOfCheckOutPeriod() {
        return this.lengthOfCheckOutPeriod;
    }
    public double getInitialLateFee() {
        return this.initialLateFee;
    }
    public double getFeePerDayLate() {
        return feePerDayLate;
    }

    public void nextDay(){
        currentDay++;
    }
    public void setDay(int day){
        currentDay = day;
    }

    public void checkOutBook(String title){
        Book book = getBook(title);
        if ( book.getIsCheckedOut() ){
            sorryBookAlreadyCheckOut(book);
        } else {
            book.setIsCheckedOut(true, currentDay);
            System.out.println("You just checked out " + title + ". It is due on day " +
                    (getCurrentDay() + getLengthOfCheckOutPeriod() + "."));;
        }
    }
    public void returnBook(String title){
        Book book = getBook(title);
        int daysLate = currentDay - (book.getDayCheckedOut() + getLengthOfCheckOutPeriod());
        if ( daysLate > 0 ){
            System.out.println("You owe the library $" + (getInitialLateFee()+daysLate*getFeePerDayLate()+
                    " because your book is " + daysLate + "days overdue."));;
        } else {
            System.out.println("Book Returned. Thank you");;
        }
        book.setIsCheckedOut(false, -1);
    }
    public void sorryBookAlreadyCheckOut(Book book){}

    public static void main(String[] args) {

    }
}
