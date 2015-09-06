package models.common

import play.api.libs.json.Json
import play.api.data._
import play.api.data.Forms._

case class ImageDetails (
      name: String,
      `type`: String,
      size: String
    )
	    
case class Image(
	imageId: String,
	imageDesc: Option[String],
	imageUri: String,
	isPrimary: Option[Boolean],
	source: Option[String]//,
	//details: ImageDetails 
	)
	
case class Zoner(
	zonerId: String,
	zonerDesc: String
	)
	
case class SubZoner(
	subZonerId: String,
	subZonerDesc: String
	)
	
case class Translation(
	translationId: String,
	en_US: String,
	cmn_TWN: Option[String],
	ja_JP: Option[String],
  cmn_CHN:Option[String]
	)
	
case class DayOut(
	dayOutId: String,
	`type`: String,
	dayOutDesc: String,//Translation,
	shortName: String,
	defaultDuration: Option[String],
    workingHours: Option[HoursOfOperation],
	tips: Option[String],//Option[Translation],
	ccyId: Option[String],
	amount: Option[String],
	isHourlyCharged: Boolean,
	zoners: List[Zoner],
	subZoners: Option[List[SubZoner]],
	address: Option[Address],
	latLng: Option[Location],
	images: Option[List[Image]],
    reviews:Option[List[Review]],
    ranking:Option[Int],
  deepLink:Option[String],
  displayName:Option[String]//Transslation
	)
	
case class Day(
	dayId: String,
	dayDesc: String,
	dayShortName: String,
	dayOut: List[DayOut]
	)
	
	
case class Template(
	templateId: String,
	templateDesc: String,//Translation,
	shortName: String,
	images: Image,
	status: String,
	duration: String,
	zoners: List[Zoner],
	days: List[Day]
	)
  
  case class Article(
  	articleId: String,
  	shortName: String,
  	articleType:String,
  	displayName:String, //Translation
  	articleDesc: Option[String],//Translation,
  	images: Option[Image],
  	status: String,
  	articleType1s:Option[List[ArticleType_1]],
  	articleType2s:Option[List[ArticleType_2]],
  	templates:Option[List[Template]],
  	zoners: Option[List[Zoner]],
  	subZoners: Option[List[SubZoner]],
  	reviews:Option[List[Review]],
  	ranking:Option[Int],
  	locations: Option[List[String]]
  
  )
  
  case class ArticleType_1(
      articleType1Name: String,
      displayName:String, //Translation
      images: Image,
      writeUp: String,//Translation
      locations: Option[List[String]] 
      )
  
  case class ArticleType_2(
      articleType2Name: String,
      displayName:String, //Translation
      poi:DayOut,
      writeUp: Option[String],//Translation
      locations: Option[List[String]]
      )
      
      
case class HoursOfOperation(
  openingHour: Option[String],
  closingHour: Option[String],
  remark:Option[String] //This is for any exceptional days adjustment
  )

case class Review(
  review: String,
  user: Option[String],
  date: Option[String] 
  )
  
  case class Location(
  lat: BigDecimal,
  lng: BigDecimal 
  )
  
  case class Address(
  addressLine1: Option[String],
  addressLine2: Option[String],
  city: Option[String],
  state: Option[String],
  zip: Option[String],
  phoneNumber: Option[String],
  email: Option[String],
  siteAddress: Option[String]
  )

object JsonFormats {
  implicit val address = Json.format[Address]
  implicit val latLng = Json.format[Location]
  implicit val translationFormat = Json.format[Translation]
  implicit val reviews = Json.format[Review]
  implicit val hoursOfOperation = Json.format[HoursOfOperation]
  implicit val imageDetailsFormat = Json.format[ImageDetails]
  implicit val imageFormat = Json.format[Image]
  implicit val zonerFormat = Json.format[Zoner]
  implicit val subZonerFormat = Json.format[SubZoner]
  implicit val dayOutFormat = Json.format[DayOut]
  implicit val dayFormat = Json.format[Day]
  implicit val templateFormat = Json.format[Template]
  implicit val articleType_1Format = Json.format[ArticleType_1]
  implicit val articleType_2Format = Json.format[ArticleType_2]
  implicit val articleFormat = Json.format[Article]
}
