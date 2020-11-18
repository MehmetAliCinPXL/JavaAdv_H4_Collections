package be.pxl.ja.streamingservice.model;

import java.util.Objects;

public abstract class Content {
	private String title;
	private Rating maturityRating;
	private String imageUrl;

	public Content(String title, Rating maturityRating) {
		this.title = title;
		this.maturityRating = maturityRating;
	}

	public Rating getMaturityRating() {
		return maturityRating;
	}

	public String getTitle() {
		return title;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	@Override
	public String toString() {
		return title;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()){
			return false;
		}
		Content content = (Content) o;
		if (getTitle () != null ? !getTitle ().equals(content.
				getTitle ()) : content.getTitle () != null) {
			return false;
			 }
		return getMaturityRating () == content.getMaturityRating ();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((maturityRating == null) ? 0 : maturityRating.hashCode());
		return result;
	}

}
