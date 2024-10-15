package vn.iostar.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Category.class)
public abstract class Category_ {

	public static final String IMAGES = "images";
	public static final String QUERY_CATEGORY_FIND_ALL = "Category.findAll";
	public static final String CATEGORYNAME = "categoryname";
	public static final String VIDEOS = "videos";
	public static final String CATEGORY_ID = "categoryId";
	public static final String STATUS = "status";

	
	/**
	 * @see vn.iostar.entity.Category#images
	 **/
	public static volatile SingularAttribute<Category, String> images;
	
	/**
	 * @see vn.iostar.entity.Category#categoryname
	 **/
	public static volatile SingularAttribute<Category, String> categoryname;
	
	/**
	 * @see vn.iostar.entity.Category#videos
	 **/
	public static volatile ListAttribute<Category, Video> videos;
	
	/**
	 * @see vn.iostar.entity.Category
	 **/
	public static volatile EntityType<Category> class_;
	
	/**
	 * @see vn.iostar.entity.Category#categoryId
	 **/
	public static volatile SingularAttribute<Category, Integer> categoryId;
	
	/**
	 * @see vn.iostar.entity.Category#status
	 **/
	public static volatile SingularAttribute<Category, Integer> status;

}

