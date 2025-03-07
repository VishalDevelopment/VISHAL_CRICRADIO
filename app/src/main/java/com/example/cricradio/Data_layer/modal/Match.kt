package com.example.cricradio.Data_layer.modal


data class MiniMatchResponse(
    val statusCode: Int,
    val responseData: ResponseData?,
    val requestParams: Map<String, String>?,
    val time: String
)

data class ResponseData(
    val message: String,
    val result: MatchResult?
)

data class MatchResult(
    val powerplay: String?,
    val powerplayOver: Int,
    val key: String,
    val status: String,
    val format: String,
    val announcement1: String?,
    val teams: Teams,
    val now: Now,
    val currentBattingOrder: Int,
    val settingObj: SettingObj,
    val lastCommentary: Commentary?,
    val announcement2: String?
)

data class Teams(
    val a: Team,
    val b: Team
)

data class Team(
    val name: String,
    val shortName: String,
    val logo: String,
    val a_1_score: Score?,
    val a_2_score: Score?,
    val b_1_score: Score?,
    val b_2_score: Score?
)

data class Score(
    val runs: Int,
    val overs: String?,
    val wickets: Int,
    val declare: Boolean
)


data class Now(
    val run_rate: String?,
    val req_run_rate: String?,
    val sessionLeft: String?
)

data class SettingObj(
    val currentTeam: String,
    val currentInning: Int
)

data class Commentary(
    val primaryText: String?,
    val secondaryText: String?,
    val tertiaryText: String?,
    val isDone: Boolean
)
