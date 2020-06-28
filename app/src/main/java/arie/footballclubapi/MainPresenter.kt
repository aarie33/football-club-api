package arie.footballclubapi

import com.google.gson.Gson
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class MainPresenter(private val view: MainView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson) {

    fun getTeamList(league: String?) {
        view.showLoading()
//        doAsync {
//            val data = gson.fromJson(apiRepository
//                    .doRequest(TheSportDBApi.getTeams(league)),
//                    TeamResponse::class.java
//            )
//
//            uiThread {
//                view.hideLoading()
//                view.showTeamList(data.teams)
//            }
//        }
//        With coroutines
        async(UI){
            val data = bg {
                gson.fromJson(apiRepository
                        .doRequest(TheSportDBApi.getTeams(league)),
                        TeamResponse::class.java
                )
            }
            view.showTeamList(data.await().teams)
            view.hideLoading()
        }
    }
}