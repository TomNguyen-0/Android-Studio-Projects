package com.example.volleyjsonarrayrequest;

/**
 * Created by tom on 8/31/2016.
 */
public class Contact {

    private String Name,Email;

    public Contact(String name, String email)
    {
        this.setName(name);
        this.setEmail(email);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
