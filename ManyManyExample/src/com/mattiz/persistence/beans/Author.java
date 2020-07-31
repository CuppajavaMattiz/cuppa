package com.mattiz.persistence.beans;
// Generated 18 Jan, 2014 6:01:04 AM by Hibernate Tools 3.2.2.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Author generated by hbm2java
 */
public class Author  implements java.io.Serializable {


     private int authorId;
     private Set books = new HashSet(0);
     private String name;

    public Author() {
    }

    public Author(Set books, String name) {
       this.books = books;
       this.name = name;
    }
   
    public int getAuthorId() {
        return this.authorId;
    }
    
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
    public Set getBooks() {
        return this.books;
    }
    
    public void setBooks(Set books) {
        this.books = books;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }




}

