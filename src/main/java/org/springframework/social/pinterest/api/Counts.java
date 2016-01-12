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
	private Integer comments;
	private Integer repins;

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

	public Integer getComments() {
		return comments;
	}

	public Integer getRepins() {
		return repins;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Counts{");
		sb.append("boards=").append(boards);
		sb.append(", pins=").append(pins);
		sb.append(", following=").append(following);
		sb.append(", followers=").append(followers);
		sb.append(", likes=").append(likes);
		sb.append(", collaborators=").append(collaborators);
		sb.append(", comments=").append(comments);
		sb.append(", repins=").append(repins);
		sb.append('}');
		return sb.toString();
	}
}
