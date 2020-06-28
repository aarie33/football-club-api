package arie.footballclubapi

import com.google.gson.Gson
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class TeamDetailPresenter(private val view: TeamDetailView,
                          private val apiRepository: ApiRepository,
                          private val gson: Gson) {

    fun getTeamDetail(teamId: String) {
        view.showLoading()
//        doAsync {
//            val data = gson.fromJson(apiRepository
//                    .doRequest(TheSportDBApi.getTeamDetail(teamId)),
//                    TeamResponse::class.java
//            )
//
//            uiThread {
//                view.hideLoading()
//                view.showTeamDetail(data.teams)
//            }
//        }
//        With coroutines
        async(UI){
            val data = bg{
                gson.fromJson(apiRepository
                        .doRequest(TheSportDBApi.getTeamDetail(teamId)),
                        TeamResponse::class.java
                )
            }

            view.showTeamDetail(data.await().teams)
            view.hideLoading()
        }
    }
}