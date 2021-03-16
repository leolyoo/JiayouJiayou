package leolyoo.jiayoujiayou

const val EXTRA_GIF = "leolyoo.jiayoujiayou.EXTRA_GIF"
const val ERROR = "N/A"

fun loadSentences(stage: Int, part: Int): List<Sentence> {
    when (stage) {
        1 -> when (part) {
            1 -> return mutableListOf(
                Sentence("您喝什么饮料？", "nín hē shénme yǐnliào?", "무슨 음료를 마시겠습니까?"),
                Sentence("我喝橙汁。", "wǒ hē chéngzhī.", "저는 오렌지주스를 마시겠습니다.")
            )
            2 -> return mutableListOf(
                Sentence(
                    "有橙汁，苹果汁和芒果汁。",
                    "yǒu chéngzhī, píngguǒ zhī hé mángguǒ zhī.",
                    "오렌지주스, 사과주스와 망고주스가 있습니다."
                ),
                Sentence("我喝苹果汁。", "wǒ hē píngguǒzhī.", "저는 사과주스를 마시겠습니다.")
            )
        }
//        2 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        3 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        4 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        5 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        6 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        7 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        8 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        9 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        10 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        11 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        12 -> when (part) {
//            1 -> return
//            2 -> return
//        }
    }
    return mutableListOf(Sentence())
}

fun loadWords(stage: Int, part: Int): List<Word> {
    when (stage) {
        1 -> when (part) {
            1 -> return mutableListOf(
                Word("您", "nín", "당신"),
                Word("喝", "hē", "마시다"),
                Word("什么", "shénme", "무엇"),
                Word("饮料", "yǐnliào", "음료"),
                Word("橙汁", "chéngzhī", "오렌지 주스")
            )
            2 -> return mutableListOf(
                Word("有", "Yǒu", "있다"),
                Word("可乐", "kě lè", "콜라"),
                Word("雪碧", "xuě bì", "사이다"),
                Word("矿泉水", "kuàng quán shuǐ", "물"),
                Word("橙汁", "chéng zhī", "오렌지 주스"),
                Word("苹果汁", "píng guǒ zhī", "사과 주스"),
                Word("芒果汁", "mángguǒ zhī", "망고 주스"),
                Word("番茄汁", "fān qié zhī", "토마토 주스"),
                Word("啤酒", "pí jiǔ", "맥주"),
                Word("葡萄酒", "pú táo jiǔ", "와인")

            )
        }
//        2 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        3 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        4 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        5 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        6 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        7 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        8 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        9 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        10 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        11 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        12 -> when (part) {
//            1 -> return
//            2 -> return
//        }
    }
    return mutableListOf(Word())
}