package be.pxl.ja.streamingservice.model;


import be.pxl.ja.streamingservice.exception.InvalidDateException;

import java.security.AccessControlException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Profile {
	private static final int MAX_RECENTLY_WATCHED_SIZE = 5;
	private static final int MAX_CURRENTLY_WATCHING_SIZE = 3;
	private String name;
	private LocalDate dateOfBirth;
	private Deque<Content> recentlyWatched = new LinkedList<Content>();
	private Deque<Content> currentlyWatching = new LinkedList<Content>(Arrays.asList(new Movie("film4", Rating.LITTLE_KIDS)));

	public static void main(String[] args) {
		Profile mehmet = new Profile("mehmet");
		mehmet.showlist();
		mehmet.startWatching(new Movie("film", Rating.LITTLE_KIDS));
		mehmet.startWatching(new Movie("film2", Rating.LITTLE_KIDS));
		mehmet.startWatching(new Movie("film3", Rating.LITTLE_KIDS));
		mehmet.finishedWatching(new Movie("film4", Rating.LITTLE_KIDS));
		System.out.println("new");
		mehmet.showlist();
	}

	public Profile(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		if (dateOfBirth.isAfter(LocalDate.now())) {
			throw new InvalidDateException(dateOfBirth, "date of birth", "No date of birth in future allowed.");
		}
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		if (dateOfBirth == null) {
			return 0;
		}
		return (int) ChronoUnit.YEARS.between(dateOfBirth, LocalDateTime.now());
	}

	public boolean allowedToWatch(Content content) {
		return content.getMaturityRating().getMinimumAge() <= getAge();
	}

	public void startWatching(Content content){
		if (recentlyWatched.size() < MAX_RECENTLY_WATCHED_SIZE & !recentlyWatched.contains(content)){
			recentlyWatched.addFirst(content);
		}

	}

	public void finishedWatching(Content content){
		startWatching(content);
		currentlyWatching.remove(content);
	}

	public void showlist() {
		System.out.println(recentlyWatched.toString());
		System.out.println(currentlyWatching.toString());
	}
}
