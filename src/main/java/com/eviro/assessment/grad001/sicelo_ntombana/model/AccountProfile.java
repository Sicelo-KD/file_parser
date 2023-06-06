package com.eviro.assessment.grad001.sicelo_ntombana.model;

import java.net.URI;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.jetbrains.annotations.NotNull;

@Entity(name="profiles")
public class AccountProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotNull
    String AccountHolderName;
    @NotNull
    String AccountHolderSurname;
    @NotNull
    URI httpImageLink;

     public AccountProfile(@NotNull String name, @NotNull String surname, @NotNull URI link){
        this.AccountHolderName = name;
        this.AccountHolderSurname = surname;
        this.httpImageLink = link;

     }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccountHolderName(@NotNull String accountHolderName) {
        AccountHolderName = accountHolderName;
    }

    @NotNull
    public String getAccountHolderName() {
        return AccountHolderName;
    }

    @NotNull
    public String getAccountHolderSurname() {
        return AccountHolderSurname;
    }

    public void setAccountHolderSurname(@NotNull String accountHolderSurname) {
        AccountHolderSurname = accountHolderSurname;
    }

    public void setHttpImageLink(@NotNull URI httpImageLink) {
        this.httpImageLink = httpImageLink;
    }

    @NotNull
    public URI getHttpImageLink() {
        return httpImageLink;
    }
}
