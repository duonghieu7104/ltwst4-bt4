package vn.iostar.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Video.class)
public abstract class Video_ {

	public static final String QUERY_VIDEO_FIND_ALL = "Video.findAll";
	public static final String ACTIVE = "active";
	public static final String DESCRIPTION = "description";
	public static final String VIDEO_ID = "videoId";
	public static final String CATEGORIES = "categories";
	public static final String TITLE = "title";
	public static final String POSTER = "poster";
	public static final String VIEWS = "views";

	
	/**
	 * @see vn.iostar.entity.Video#active
	 **/
	public static volatile SingularAttribute<Video, Boolean> active;
	
	/**
	 * @see vn.iostar.entity.Video#description
	 **/
	public static volatile SingularAttribute<Video, String> description;
	
	/**
	 * @see vn.iostar.entity.Video#videoId
	 **/
	public static volatile SingularAttribute<Video, String> videoId;
	
	/**
	 * @see vn.iostar.entity.Video#categories
	 **/
	public static volatile SingularAttribute<Video, Category> categories;
	
	/**
	 * @see vn.iostar.entity.Video#title
	 **/
	public static volatile SingularAttribute<Video, String> title;
	
	/**
	 * @see vn.iostar.entity.Video
	 **/
	public static volatile EntityType<Video> class_;
	
	/**
	 * @see vn.iostar.entity.Video#poster
	 **/
	public static volatile SingularAttribute<Video, String> poster;
	
	/**
	 * @see vn.iostar.entity.Video#views
	 **/
	public static volatile SingularAttribute<Video, Integer> views;

}

