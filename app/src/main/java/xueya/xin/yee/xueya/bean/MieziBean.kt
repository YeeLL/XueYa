package xueya.xin.yee.xueya.bean

data class MieziBean(
        var error :Boolean,
        var results:List<Results>
)

data class Results(
        var _id:String,
        var createdAt:String,
        var desc:String,
        var publishedAt:String,
        var source:String,
        var type :String,
        var url:String,
        var used:Boolean,
        var who:String
)