/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Naveen Sheoran
 */
public class Book {
    private int isbncode;
    private String Bookname;
    private String Bookdesc;
    private String authorname;
    private int unit;
    
    public Book(){
        
    }

    public Book(int isbncode, String Bookname, String Bookdesc, String authorname, int unit) {
        this.isbncode = isbncode;
        this.Bookname = Bookname;
        this.Bookdesc = Bookdesc;
        this.authorname = authorname;
        this.unit = unit;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getIsbncode() {
        return isbncode;
    }

    public void setIsbncode(int isbncode) {
        this.isbncode = isbncode;
    }

    public String getBookname() {
        return Bookname;
    }

    public void setBookname(String Bookname) {
        this.Bookname = Bookname;
    }

    public String getBookdesc() {
        return Bookdesc;
    }

    public void setBookdesc(String Bookdesc) {
        this.Bookdesc = Bookdesc;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }
    
}
