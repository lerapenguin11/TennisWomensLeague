package com.example.tenniswomensleague.business.models

object Constants {

    fun getMatchList() : MutableList<MatchModel> {
        val matchList = mutableListOf<MatchModel>()

        val match1 = MatchModel("US Open. 09.11.22, 12 p.m", "G. Mereza", "O. Fretova", "https://cdn-icons-png.flaticon.com/512/206/206626.png",
            "https://cdn-icons-png.flaticon.com/512/555/555417.png", "G. Mereza", "O. Fretova",
            "G. Mereza", "O. Fretova", 1, 2, 5, 4, "156", "32",
        "6’0’’", "Left-Handed", "James Case", "41", "193", "74.7 %", "30.3 %",
        "70.0 %", "126", "5’7’’", "Right-Handed", "David Ringot", "50",
        "123", "72.2 %", "37.7 %", "66.8 %", "22",
            "https://cdn-icons-png.flaticon.com/512/206/206626.png", "https://cdn-icons-png.flaticon.com/512/555/555417.png")

        matchList.add(match1)

        val match2 = MatchModel("US Open. 10.12.22, 12 p.m", "E. Swatek", "A. Jaber", "https://cdn-icons-png.flaticon.com/512/555/555546.png",
            "https://cdn-icons-png.flaticon.com/512/555/555558.png", "E. Swatek", "A. Jaber",
            "E. Swatek", "A. Jaber", 4, 2, 7, 1, "166", "31",
            "6’0’’", "Left-Handed", "James Case", "41", "193", "74.7 %", "30.3 %",
            "70.0 %", "136", "5’7’’", "Right-Handed", "David Ringot", "56",
            "153", "72.2 %", "37.7 %", "66.8 %", "33",
            "https://cdn-icons-png.flaticon.com/512/555/555546.png", "https://cdn-icons-png.flaticon.com/512/555/555558.png")

        matchList.add(match2)

        val match3 = MatchModel("US Open. 05.01.23, 13 p.m", "U. Karitova", "J. Peterson", "https://cdn-icons-png.flaticon.com/512/555/555561.png",
            "https://cdn-icons-png.flaticon.com/512/555/555557.png", "U. Karitova", "J. Peterson",
            "U. Karitova", "J. Peterson", 6, 2, 0, 1, "166", "31",
            "6’0’’", "Left-Handed", "James Case", "41", "193", "74.7 %", "30.3 %",
            "70.0 %", "136", "5’7’’", "Right-Handed", "David Ringot", "56",
            "153", "72.2 %", "37.7 %", "66.8 %", "33",
            "https://cdn-icons-png.flaticon.com/512/555/555561.png", "https://cdn-icons-png.flaticon.com/512/555/555557.png")

        matchList.add(match3)

        return matchList
    }

    fun getNewsList() : MutableList<NewsModel> {
        val newsList = mutableListOf<NewsModel>()

        val news1 = NewsModel("Ostrava Open first results", "", "https://miracleballmethod.com/wp-content/uploads/2019/05/Screen-Shot-2019-05-21-at-10.06.00-AM-300x198.png")

        newsList.add(news1)

        val news2 = NewsModel("Henderson reaches 99th WTA quatrefinal of career in Hallownd Open", "", "https://avatars.mds.yandex.net/i?id=4399c3798cc48aa07fd1b9a2da596d211e7db2c1_l-10087650-images-thumbs&n=13")

        newsList.add(news2)

        val news3 = NewsModel("Emma Reventon refused the participation in ABC Open due to a wrist injury", "", "http://2.bp.blogspot.com/-EJzl9-UNsbI/WsPQpUkXelI/AAAAAAAAoL4/EWLRPVbkGzYsYE_D6wW31n2N7nNlYJkowCK4BGAYYCw/w1280-h720-p-k-no-nu/How%2Bto%2Bdo%2BKegel%2BExercises%2BVagifirm%2B%257E%2BNatural%2BHerbal%2BVaginal%2B...-771202.jpg")

        newsList.add(news3)

        return newsList
    }
}

