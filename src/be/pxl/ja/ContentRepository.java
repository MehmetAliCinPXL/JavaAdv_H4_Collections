package be.pxl.ja;

import be.pxl.ja.streamingservice.model.Content;
import be.pxl.ja.streamingservice.model.Documentary;
import be.pxl.ja.streamingservice.model.Movie;
import be.pxl.ja.streamingservice.model.Rating;
import be.pxl.ja.streamingservice.model.TVShow;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContentRepository {

	public List<Content> getContentList() {
		List<Content> contentList = new ArrayList<>();
		Movie theIncredibles = new Movie("The Incredibles", Rating.LITTLE_KIDS);
		theIncredibles.setReleaseDate(LocalDate.of(2004, 10, 27));
		theIncredibles.setImageUrl("the_incredibles.jpeg");
		contentList.add(theIncredibles);

		Documentary planetEarth = new Documentary("Planet Earth", Rating.LITTLE_KIDS);
		planetEarth.setReleaseDate(LocalDate.of(2006, 3, 5));
		planetEarth.setImageUrl("planet_earth.jpeg");
		contentList.add(planetEarth);

		Movie jackRyan = new Movie("Jack Ryan: Shadow Recruit", Rating.TEENS);
		jackRyan.setReleaseDate(LocalDate.of(2004, 10, 27));
		jackRyan.setImageUrl("jack_ryan.jpeg");
		contentList.add(jackRyan);

		Movie mi = new Movie("Mission Impossible: Fall Out", Rating.TEENS);
		contentList.add(mi);

		Movie ironFist = new Movie("Iron Fist", Rating.MATURE);
		ironFist.setReleaseDate(LocalDate.of(2004, 10, 27));
		ironFist.setImageUrl("iron_fist.jpeg");
		contentList.add(ironFist);

		TVShow eigenKweek = new TVShow("Eigen kweek", Rating.TEENS, 3);
		eigenKweek.setImageUrl("eigen_kweek.jpeg");
		contentList.add(eigenKweek);

		return contentList;
	}

	public Set<Content> getContentSet(){
		Set<Content> contents = new HashSet <Content>(getContentList());
		return contents;
	}


	public static void main(String[] args) {
		Set<Content> list1 = new HashSet<>(new ContentRepository().getContentSet());
		System.out.println(list1.toString());
		if(!list1.contains(new Movie("Mission Impossible: Fall Out", Rating.TEENS))){
			list1.add(new Movie("Mission Impossible: Fall Out", Rating.TEENS));
		}
		System.out.println(list1.toString());
	}
}
