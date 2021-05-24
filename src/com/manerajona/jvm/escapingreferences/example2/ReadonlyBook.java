package com.manerajona.jvm.escapingreferences.example2;

public interface ReadonlyBook {

	int getId();

	String getTitle();

	String getAuthor();

	String toString();

	Price getPrice();

}