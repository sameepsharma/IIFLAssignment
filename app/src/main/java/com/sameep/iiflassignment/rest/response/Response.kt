package com.sameep.iiflassignment.rest.response

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Response(

	@field:SerializedName("Response")
	val response: List<ResponseItem?>? = null
) : Parcelable

@Parcelize
data class AboutItem(

	@field:SerializedName("href")
	val href: String? = null
) : Parcelable

@Parcelize
data class Author(

	@field:SerializedName("@id")
	val id: String? = null
) : Parcelable

@Parcelize
data class PrimaryImageOfPage(

	@field:SerializedName("@id")
	val id: String? = null
) : Parcelable

@Parcelize
data class PotentialActionItem(

	@field:SerializedName("@type")
	val type: String? = null,

	@field:SerializedName("target")
	val target: List<String?>? = null
) : Parcelable

@Parcelize
data class Links(

	@field:SerializedName("curies")
	val curies: List<CuriesItem?>? = null,

	@field:SerializedName("replies")
	val replies: List<RepliesItem?>? = null,

	@field:SerializedName("version-history")
	val versionHistory: List<VersionHistoryItem?>? = null,

	@field:SerializedName("author")
	val author: List<AuthorItem?>? = null,

	@field:SerializedName("wp:term")
	val wpTerm: List<WpTermItem?>? = null,

	@field:SerializedName("about")
	val about: List<AboutItem?>? = null,

	@field:SerializedName("self")
	val self: List<SelfItem?>? = null,

	@field:SerializedName("predecessor-version")
	val predecessorVersion: List<PredecessorVersionItem?>? = null,

	@field:SerializedName("collection")
	val collection: List<CollectionItem?>? = null,

	@field:SerializedName("wp:attachment")
	val wpAttachment: List<WpAttachmentItem?>? = null
) : Parcelable

@Parcelize
data class CollectionItem(

	@field:SerializedName("href")
	val href: String? = null
) : Parcelable

@Parcelize
data class Breadcrumb(

	@field:SerializedName("@id")
	val id: String? = null
) : Parcelable

@Parcelize
data class Image(

	@field:SerializedName("contentUrl")
	val contentUrl: String? = null,

	@field:SerializedName("@type")
	val type: String? = null,

	@field:SerializedName("inLanguage")
	val inLanguage: String? = null,

	@field:SerializedName("caption")
	val caption: String? = null,

	@field:SerializedName("@id")
	val id: String? = null,

	@field:SerializedName("url")
	val url: String? = null
) : Parcelable

@Parcelize
data class VersionHistoryItem(

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("href")
	val href: String? = null
) : Parcelable

@Parcelize
data class OgImageItem(

	@field:SerializedName("url")
	val url: String? = null
) : Parcelable

@Parcelize
data class Excerpt(

	@field:SerializedName("rendered")
	val rendered: String? = null,

	@field:SerializedName("protected")
	val jsonMemberProtected: Boolean? = null
) : Parcelable

@Parcelize
data class GraphItem(

	@field:SerializedName("image")
	val image: Image? = null,

	@field:SerializedName("@type")
	val type: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("@id")
	val id: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("itemListElement")
	val itemListElement: List<ItemListElementItem?>? = null,

	@field:SerializedName("datePublished")
	val datePublished: String? = null,

	@field:SerializedName("breadcrumb")
	val breadcrumb: Breadcrumb? = null,

	@field:SerializedName("author")
	val author: Author? = null,

	@field:SerializedName("potentialAction")
	val potentialAction: List<PotentialActionItem?>? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("inLanguage")
	val inLanguage: String? = null,

	@field:SerializedName("dateModified")
	val dateModified: String? = null,

	@field:SerializedName("isPartOf")
	val isPartOf: IsPartOf? = null
) : Parcelable

@Parcelize
data class Robots(

	@field:SerializedName("max-video-preview")
	val maxVideoPreview: String? = null,

	@field:SerializedName("index")
	val index: String? = null,

	@field:SerializedName("follow")
	val follow: String? = null,

	@field:SerializedName("max-image-preview")
	val maxImagePreview: String? = null,

	@field:SerializedName("max-snippet")
	val maxSnippet: String? = null
) : Parcelable

@Parcelize
data class WpAttachmentItem(

	@field:SerializedName("href")
	val href: String? = null
) : Parcelable

@Parcelize
data class IsPartOf(

	@field:SerializedName("@id")
	val id: String? = null
) : Parcelable

@Parcelize
data class Content(

	@field:SerializedName("rendered")
	val rendered: String? = null,

	@field:SerializedName("protected")
	val jsonMemberProtected: Boolean? = null
) : Parcelable

@Parcelize
data class Schema(

	@field:SerializedName("@graph")
	val graph: List<GraphItem?>? = null,

	@field:SerializedName("@context")
	val context: String? = null
) : Parcelable

@Parcelize
data class Target(

	@field:SerializedName("@type")
	val type: String? = null,

	@field:SerializedName("urlTemplate")
	val urlTemplate: String? = null
) : Parcelable

@Parcelize
data class TwitterMisc(

	@field:SerializedName("Written by")
	val writtenBy: String? = null,

	@field:SerializedName("Est. reading time")
	val estReadingTime: String? = null
) : Parcelable

@Parcelize
data class WpTermItem(

	@field:SerializedName("taxonomy")
	val taxonomy: String? = null,

	@field:SerializedName("href")
	val href: String? = null,

	@field:SerializedName("embeddable")
	val embeddable: Boolean? = null
) : Parcelable

@Parcelize
data class RepliesItem(

	@field:SerializedName("href")
	val href: String? = null,

	@field:SerializedName("embeddable")
	val embeddable: Boolean? = null
) : Parcelable

@Parcelize
@Entity(tableName = "articles_table")
data class ResponseItem(

	@field:SerializedName("date")
	var date: String? = null,

	@field:SerializedName("content")
	var content: Content? = null,

	@field:SerializedName("template")
	var template: String? = null,

	@field:SerializedName("link")
	var link: String? = null,

	@field:SerializedName("type")
	var type: String? = null,

	@field:SerializedName("title")
	var title: Title? = null,

	@field:SerializedName("featured_media")
	var featuredMedia: Int? = null,

	@field:SerializedName("modified")
	var modified: String? = null,

	@field:SerializedName("id")
	@PrimaryKey(autoGenerate = true)
	var id: Int? = null,

	@field:SerializedName("categories")
	@Ignore
	var categories: List<Int?>? = null,

	@field:SerializedName("date_gmt")
	var dateGmt: String? = null,

	@field:SerializedName("slug")
	var slug: String? = null,

	@field:SerializedName("modified_gmt")
	var modifiedGmt: String? = null,

	@field:SerializedName("author")
	var author: Int? = null,

	@field:SerializedName("format")
	var format: String? = null,

	@field:SerializedName("comment_status")
	var commentStatus: String? = null,

	@field:SerializedName("yoast_head")
	var yoastHead: String? = null,

	@field:SerializedName("ping_status")
	var pingStatus: String? = null,

	@field:SerializedName("sticky")
	var sticky: Boolean? = null,

	@field:SerializedName("guid")
	@Ignore
	var guid: Guid? = null,

	@field:SerializedName("excerpt")
	var excerpt: Excerpt? = null,

	@field:SerializedName("status")
	var status: String? = null
) : Parcelable

@Parcelize
data class YoastHeadJson(

	@field:SerializedName("schema")
	val schema: Schema? = null,

	@field:SerializedName("og_site_name")
	val ogSiteName: String? = null,

	@field:SerializedName("twitter_card")
	val twitterCard: String? = null,

	@field:SerializedName("og_title")
	val ogTitle: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("og_type")
	val ogType: String? = null,

	@field:SerializedName("og_locale")
	val ogLocale: String? = null,

	@field:SerializedName("og_url")
	val ogUrl: String? = null,

	@field:SerializedName("canonical")
	val canonical: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("article_published_time")
	val articlePublishedTime: String? = null,

	@field:SerializedName("og_description")
	val ogDescription: String? = null,

	@field:SerializedName("robots")
	val robots: Robots? = null,

	@field:SerializedName("twitter_misc")
	val twitterMisc: TwitterMisc? = null,

	@field:SerializedName("article_modified_time")
	val articleModifiedTime: String? = null,

	@field:SerializedName("og_image")
	val ogImage: List<OgImageItem?>? = null
) : Parcelable

@Parcelize
data class AuthorItem(

	@field:SerializedName("href")
	val href: String? = null,

	@field:SerializedName("embeddable")
	val embeddable: Boolean? = null
) : Parcelable

@Parcelize
data class Title(

	@field:SerializedName("rendered")
	val rendered: String? = null
) : Parcelable

@Parcelize
data class SelfItem(

	@field:SerializedName("href")
	val href: String? = null
) : Parcelable

@Parcelize
data class CuriesItem(

	@field:SerializedName("templated")
	val templated: Boolean? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("href")
	val href: String? = null
) : Parcelable

@Parcelize
data class PredecessorVersionItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("href")
	val href: String? = null
) : Parcelable

@Parcelize
data class ItemListElementItem(

	@field:SerializedName("@type")
	val type: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("position")
	val position: Int? = null,

	@field:SerializedName("item")
	val item: String? = null
) : Parcelable

@Parcelize
data class Guid(

	@field:SerializedName("rendered")
	val rendered: String? = null
) : Parcelable
