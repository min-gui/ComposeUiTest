package com.mingui.composetest.utils

data class RandomUser(
    val name: String = "개발하는 민구이ð",
    val description: String = "오늘도 빡 코딩 !!",
    val profileImage: String = "https://randomuser.me/api/portraits/women/19.jpg"
)

object DummyDataProvider {
    val userList = List<RandomUser>(200){ RandomUser()}
}