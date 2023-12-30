package com.dajungdagam.dg.domain.entity;

import java.time.*;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Entity
public class TradePost extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne
	@JoinColumn(name = "area_id")
	private Area area;

	@Column(length = 50)
	private String title;

	@Enumerated(EnumType.STRING)
	@Column(name = "post_type")
	private PostType postType;

	@Column(length = 10, name = "trade_area")
	private String tradeArea;
	
	@Column(columnDefinition = "TEXT")
	private String content;

	@Column(columnDefinition = "TIMESTAMP", name = "created_time")
	private LocalDateTime createdTime;

	@Column(columnDefinition = "TIMESTAMP", name = "update_time")
	private LocalDateTime updateTime;

	@Column(columnDefinition = "BIGINT", name = "view_count")
	private Long viewCount;

	@Column(columnDefinition = "BIGINT", name = "wishlist_count")
	private Long wishlistCount;

	@Column(columnDefinition = "TEXT", name = "chat_link")
	private String chatLink;

	@Enumerated(EnumType.STRING)
	@Column(name = "trade_status")
	private TradeStatus tradeStatus;
	
	@Builder
	public TradePost(Long id, User user, Area area, String title, PostType postType,
					 String tradeArea, String content, LocalDateTime createdTime,
					 LocalDateTime updateTime, Long viewCount, Long wishlistCount,
					 String chatLink, TradeStatus tradeStatus) {
		this.id = id;
		this.user = user;
		this.area = area;
		this.title = title;
		this.postType = postType;
		this.tradeArea = tradeArea;
		this.content = content;
		this.createdTime = createdTime;
		this.updateTime = updateTime;
		this.viewCount = viewCount;
		this.wishlistCount = wishlistCount;
		this.chatLink = chatLink;
		this.tradeStatus = tradeStatus;
	}

}