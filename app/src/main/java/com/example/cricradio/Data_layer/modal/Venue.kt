package com.example.cricradio.Data_layer.modal


data class ValueInfoResponse(
    val statusCode: Int,
    val responseData: ResponseData2?,
    val requestParams: Map<String, String>?,
    val time: String
)

data class ResponseData2(
    val message: String,
    val result: MatchDetails?
)

data class MatchDetails(
    val _id: String,
    val firstUmpire: String,
    val format: String,
    val key: String,
    val matchReferee: String,
    val related_name: String,
    val season: Season,
    val secoundUmpire: String,
    val start_date: StartDate,
    val status: String,
    val teams: Teams,
    val thirdUmpire: String,
    val toss: Toss,
    val venue: String,
    val venueDetails: VenueDetails,
    val weather: Weather,
    val venueStats: VenueStats
)

data class Season(
    val key: String,
    val name: String
)

data class StartDate(
    val timestamp: Long,
    val iso: String,
    val str: String,
    val sky_check_ts: Long
)



data class Toss(
    val won: String,
    val decision: String,
    val str: String
)

data class VenueDetails(
    val _id: String,
    val knownAs: String,
    val capacity: Int,
    val createdAt: String,
    val cricinfoId: Int,
    val description: String,
    val ends1: String,
    val ends2: String,
    val floodLights: Int,
    val homeTo: String,
    val isDeleted: String?,
    val opened: String?,
    val photo: String,
    val status: String?,
    val timezone: String,
    val updatedAt: String,
    val venueLocation: String,
    val venueScraptitle: String,
    val venue_info: VenueInfo
)

data class VenueInfo(
    val name: String,
    val smallName: String,
    val longName: String,
    val location: String,
    val town: String
)

data class Weather(
    val location: String,
    val condition: Condition,
    val chance_of_rain: Int,
    val temp_c: Double,
    val last_updated: String
)


data class Condition(
    val code: Int,
    val icon: String,
    val text: String
)


data class VenueStats(
    val matchesPlayed: Int,
    val lowestDefended: Int,
    val highestChased: Int,
    val batFirstWins: Int,
    val ballFirstWins: Int,
    val battingFirst: BattingStats,
    val battingSecond: BattingStats
)


data class BattingStats(
    val averageScore: Int,
    val highestScore: Int,
    val lowestScore: Int,
    val paceWickets: Int,
    val spinWickets: Int
)