package org.springframework.social.pinterest.api;

public class MetaData {

	private Place place;
	private Link link;

	public static class Link {
		private String locale;
		private String title;
		private String site_name;
		private String description;
		private String favicon;

		public String getLocale() {
			return locale;
		}

		public String getTitle() {
			return title;
		}

		public String getSite_name() {
			return site_name;
		}

		public String getDescription() {
			return description;
		}

		public String getFavicon() {
			return favicon;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Link [locale=");
			builder.append(locale);
			builder.append(", title=");
			builder.append(title);
			builder.append(", site_name=");
			builder.append(site_name);
			builder.append(", description=");
			builder.append(description);
			builder.append(", favicon=");
			builder.append(favicon);
			builder.append("]");
			return builder.toString();
		}

	}

	public static class Place {
		private String category;
		private String name;
		private String locality;
		private String country;
		private String region;
		private String longitude;
		private String source_url;
		private String street;
		private String postal_code;
		private String latitude;

		public String getCategory() {
			return category;
		}

		public String getName() {
			return name;
		}

		public String getLocality() {
			return locality;
		}

		public String getCountry() {
			return country;
		}

		public String getRegion() {
			return region;
		}

		public String getLongitude() {
			return longitude;
		}

		public String getSource_url() {
			return source_url;
		}

		public String getStreet() {
			return street;
		}

		public String getPostal_code() {
			return postal_code;
		}

		public String getLatitude() {
			return latitude;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Place [category=");
			builder.append(category);
			builder.append(", name=");
			builder.append(name);
			builder.append(", locality=");
			builder.append(locality);
			builder.append(", country=");
			builder.append(country);
			builder.append(", region=");
			builder.append(region);
			builder.append(", longitude=");
			builder.append(longitude);
			builder.append(", source_url=");
			builder.append(source_url);
			builder.append(", street=");
			builder.append(street);
			builder.append(", postal_code=");
			builder.append(postal_code);
			builder.append(", latitude=");
			builder.append(latitude);
			builder.append("]");
			return builder.toString();
		}
	}

	public Place getPlace() {
		return place;
	}

	public Link getLink() {
		return link;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MetaData [place=");
		builder.append(place);
		builder.append("]");
		return builder.toString();
	}

}
