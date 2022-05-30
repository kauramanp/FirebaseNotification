package com.aman.firebasenotification

data class firebaseDataClass(
    var to: String? = null,
    var data: firebaseDataDataClass? = null
)
data class firebaseDataDataClass(
    var title: String? = null,
    var message: String? = null,

)
