package LibraryCatalogue;

public class Book {
    String title;
    int pageCount;
    int ISBN;
    boolean isCheckedOut;
    int dayCheckedOut = -1;

    public Book (String bookTitle, int bookPageCount, int bookISBN) {
        this.title = bookTitle;
        this.pageCount = bookPageCount;
        this.ISBN = bookISBN;
        isCheckedOut = false;
    }

    public String getTitle() {
        return this.title;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public int getISBN() {
        return this.ISBN;
    }

    public boolean isCheckedOut() {
        return this.isCheckedOut;
    }

    public void setIsCheckedOut(boolean newIscheckedOut, int currentDayCheckedOut) {
        this.isCheckedOut = newIscheckedOut;
        setDayCheckedOut(currentDayCheckedOut);
    }

    public int getDayCheckedOut() {
        return this.dayCheckedOut;
    }

    private void setDayCheckedOut(int day) {
        this.dayCheckedOut = day;
    }
}
