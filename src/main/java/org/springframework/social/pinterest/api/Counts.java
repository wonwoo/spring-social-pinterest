package org.springframework.social.pinterest.api;

/**
 * Created by wonwoo on 15. 12. 16..
 */
public class Counts {

	private Integer pins;
	private Integer following;
	private Integer followers;
	private Integer boards;
	private Integer likes;
	private Integer collaborators;

	public Integer getBoards() {
		return boards;
	}

	public Integer getFollowers() {
		return followers;
	}

	public Integer getFollowing() {
		return following;
	}

	public Integer getLikes() {
		return likes;
	}

	public Integer getPins() {
		return pins;
	}

	public Integer getCollaborators() {
		return collaborators;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Counts [pins=");
		builder.append(pins);
		builder.append(", following=");
		builder.append(following);
		builder.append(", followers=");
		builder.append(followers);
		builder.append(", boards=");
		builder.append(boards);
		builder.append(", likes=");
		builder.append(likes);
		builder.append(", collaborators=");
		builder.append(collaborators);
		builder.append("]");
		return builder.toString();
	}
}
